/**
 *
 */
package eu.europa.ema.phv.model;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * This test load the all the files in data in the folder human icsr
 * and do an unmarshal to {@link eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage}.<br/>
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 24 Jun 2014 $
 * @since 24 Jun 2014 (creation date)
 */
@RunWith(value = Parameterized.class)
public class IcsrUnmarshalTest extends XmlUnmarshall {

    public IcsrUnmarshalTest(Path path) {
        super(path);
    }

    @Parameters
    public static List<Object[]> data() throws IOException {
        return data("src/test/resources/data/human/icsr");
    }

    @BeforeClass
    public static void init() throws JAXBException {
        JAXB_CONTEXT = JAXBContext.newInstance("eu.europa.ema.phv.common.model.adrhuman.icsrr2");
    }

    @Test
    public void unmarshallTest() throws JAXBException, ParserConfigurationException, IOException, SAXException,
            TransformerException {
        IchicsrMessage icsr = unmarshall();
        System.out.println("Message : " + icsr.getMessagenumber());
        System.out.println("Safety reports: " + icsr.getSafetyReports().size());
    }

}
