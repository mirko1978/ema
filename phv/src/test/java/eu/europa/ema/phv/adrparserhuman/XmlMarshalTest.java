/**
 * 
 */
package eu.europa.ema.phv.adrparserhuman;


import eu.europa.ema.phv.common.model.DocumentTypeEnum;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.xmladapter.EvDateAdapter;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.assertEquals;


/**
 * TODO Class meaningful description...
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 24 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 24 Jun 2014 $
 */
public class XmlMarshalTest {

    @Test
    public void marshallHeaderTest() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(IchicsrMessage.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IchicsrMessage icsr = (IchicsrMessage) jaxbUnmarshaller.unmarshal(getClass().getResourceAsStream("/data/test.xml"));
        assertEquals("2.1",icsr.getMessageformatversion());
        assertEquals("1.0", icsr.getMessagereleaseversion());
        assertEquals("LCR-EVHUMAN20140327025", icsr.getMessagenumber());
        assertEquals(DocumentTypeEnum.ICHICSR.toNumber(), icsr.getDocumenttype().intValue());
        assertEquals("JNJCH", icsr.getSenderid());
        assertEquals("EVHUMAN", icsr.getReceiverid());
        assertEquals("204", icsr.getMessageDateFormat());
        assertEquals("20140327041528", EvDateAdapter.FORMATTER.get("204").format(icsr.getMessagedate()));
    }
}
