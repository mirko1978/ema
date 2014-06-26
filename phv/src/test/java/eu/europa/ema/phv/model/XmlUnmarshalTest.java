/**
 *
 */
package eu.europa.ema.phv.model;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This test load the all the files in data that starts with "marshal."
 * and do an unmarshal to {@link eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage}.<br/>
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 24 Jun 2014 $
 * @since 24 Jun 2014 (creation date)
 */
@RunWith(value = Parameterized.class)
public class XmlUnmarshalTest {

    @Parameters
    public static List<Object[]> data() throws IOException {
        Path sources = FileSystems.getDefault().getPath("./src/test/resources/data");
        DirectoryStream<Path> xmlFileStream;
        try {
            xmlFileStream = Files.newDirectoryStream(sources, new DirectoryStream.Filter<Path>() {
                @Override
                public boolean accept(Path entry) throws IOException {
                    return entry.getFileName().toString().startsWith("icsr-single.");
                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        List<Object[]> list = new ArrayList<>();

        for (Path entry : xmlFileStream) {
            list.add(new Object[] { entry });
        }
        return list;
    }

    private Path path;

    public XmlUnmarshalTest(Path path) {
        this.path = path;
    }

    @Test
    public void unmarshallTest() throws JAXBException, ParserConfigurationException, IOException, SAXException,
            TransformerException {
        JAXBContext jaxbContext = JAXBContext.newInstance(IchicsrMessage.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IchicsrMessage icsr = (IchicsrMessage) jaxbUnmarshaller.unmarshal(path.toFile());
        System.out.println("File: " + path);
        System.out.println("Safety reports: " + icsr.getSafetyReports().size());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document documentFromFile = builder.parse(path.toFile());
        Document documentFromObject = builder.newDocument();

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        jaxbMarshaller.marshal(icsr, documentFromObject);

        documentFromFile.normalize();
        documentFromObject.normalize();

        //        print(documentFromFile);
        //        System.out.println();
        //        System.out.println();
        //        print(documentFromObject);
        Diff xmlDiff = new Diff(documentFromFile, documentFromObject);

//        Assert.assertTrue(xmlDiff.similar());
//        Assert.assertTrue(documentFromFile.isEqualNode(documentFromObject));
        if(!xmlDiff.similar()) {
            DetailedDiff myDiff = new DetailedDiff(xmlDiff);
            for (Object tmp : myDiff.getAllDifferences()) {
                Difference difference = (Difference) tmp;
                if(difference.isRecoverable()) {
                    continue;
                }
                System.out.println(difference.isRecoverable());
                System.out.println(difference.getControlNodeDetail().getXpathLocation());

                System.out.println("\tControl: " + difference.getControlNodeDetail().getValue());// +"\t" +difference.getControlNodeDetail().getNode().getTextContent());
                System.out.println("\tTest: " + difference.getTestNodeDetail().getValue());//+"\t"+difference.getTestNodeDetail().getNode().getTextContent());
            }
        }
        Assert.assertTrue(xmlDiff.similar());
    }

    public void print(Node node) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source source = new DOMSource(node);
        Result output = new StreamResult(System.out);
        transformer.transform(source, output);
    }
}
