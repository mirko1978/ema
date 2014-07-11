package eu.europa.ema.phv.model;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.IchIcsrAck;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * This test load the all the files in data in the folder human icsr-ack
 * and do an unmarshal to {@link eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.IchIcsrAck}.<br/>
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 09/07/2014 $
 * @since 09/07/2014 (creation date)
 */
@RunWith(value = Parameterized.class)
public class AckUnmarshallTest extends XmlUnmarshall {

    public AckUnmarshallTest(Path path) {
        super(path);
    }

    @Parameterized.Parameters
    public static List<Object[]> data() throws IOException {
        return data("src/test/resources/data/human/icsr-ack");
    }

    @BeforeClass
    public static void init() throws JAXBException {
        JAXB_CONTEXT = JAXBContext.newInstance("eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack");
    }

    @Test
    public void unmarshallTest() throws JAXBException, ParserConfigurationException, IOException, SAXException,
            TransformerException {
        IchIcsrAck ack = unmarshall();
        System.out.println("Message : " + ack.getIchIcsrMessageHeader().getMessageNumb());
        System.out.println("Results: " + ack.getAcknowledgment().getReportAcknowledgment().size());
    }

}
