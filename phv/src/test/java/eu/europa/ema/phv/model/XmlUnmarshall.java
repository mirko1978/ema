package eu.europa.ema.phv.model;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import org.junit.Assert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 09/07/2014 $
 * @since 09/07/2014 (creation date)
 */
public class XmlUnmarshall {
    public static JAXBContext JAXB_CONTEXT;

    protected Path path;

    public XmlUnmarshall(Path path) {
        this.path = path;
        System.out.println("File: " + path);
    }

    /**
     * Read all the files from filesPath
     *
     * @param filesPath
     * @return
     * @throws java.io.IOException
     */
    public static List<Object[]> data(final String filesPath) throws IOException {
        Path sources = FileSystems.getDefault().getPath(filesPath);
        DirectoryStream<Path> xmlFileStream;
        try {
            xmlFileStream = Files.newDirectoryStream(sources, new DirectoryStream.Filter<Path>() {
                @Override
                public boolean accept(Path entry) throws IOException {
                    return entry.getFileName().toString().toLowerCase().endsWith(".xml");
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

    @SuppressWarnings("unchecked")
    public<T> T unmarshall() throws JAXBException {
        System.out.println(JAXB_CONTEXT.getClass());
        Assert.assertEquals("org.eclipse.persistence.jaxb.JAXBContext", JAXB_CONTEXT.getClass().getCanonicalName());
        Unmarshaller jaxbUnmarshaller = JAXB_CONTEXT.createUnmarshaller();
        return (T) jaxbUnmarshaller.unmarshal(path.toFile());
    }
}
