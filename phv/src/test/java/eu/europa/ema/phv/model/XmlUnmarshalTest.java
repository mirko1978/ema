/**
 *
 */
package eu.europa.ema.phv.model;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
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
    public static JAXBContext JAXB_CONTEXT;

    private Path path;

    @Parameters
    public static List<Object[]> data() throws IOException {
        Path sources = FileSystems.getDefault().getPath("./src/test/resources/data");
        DirectoryStream<Path> xmlFileStream;
        try {
            xmlFileStream = Files.newDirectoryStream(sources, new DirectoryStream.Filter<Path>() {
                @Override
                public boolean accept(Path entry) throws IOException {
                    return entry.getFileName().toString().startsWith("unmarshal.");
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

    public XmlUnmarshalTest(Path path) {
        this.path = path;
    }

    @BeforeClass
    public static void init() throws JAXBException {
        //JAXB_CONTEXT = JAXBContext.newInstance("eu.europa.ema.phv.common.model.adrhuman.icsrr2");
        JAXB_CONTEXT = JAXBContext.newInstance(IchicsrMessage.class);
    }

    @Test
    public void unmarshallTest() throws JAXBException, ParserConfigurationException, IOException, SAXException,
            TransformerException {
        System.out.println(JAXB_CONTEXT.getClass());
        Assert.assertEquals("org.eclipse.persistence.jaxb.JAXBContext",JAXB_CONTEXT.getClass().getCanonicalName());
        Unmarshaller jaxbUnmarshaller = JAXB_CONTEXT.createUnmarshaller();
        IchicsrMessage icsr = (IchicsrMessage) jaxbUnmarshaller.unmarshal(path.toFile());
        System.out.println("File: " + path);
        System.out.println("Message : " + icsr.getMessagenumber());
        System.out.println("Safety reports: " + icsr.getSafetyReports().size());
    }

}
