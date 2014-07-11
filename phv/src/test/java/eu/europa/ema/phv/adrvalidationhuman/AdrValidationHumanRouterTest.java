package eu.europa.ema.phv.adrvalidationhuman;

import eu.europa.ema.phv.AbstractPhvTest;
import eu.europa.ema.phv.adrparserhuman.ReportSplitter;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Test the Adr Validation Human rout
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 01/07/2014 (creation date)
 */
public class AdrValidationHumanRouterTest extends AbstractPhvTest {

    @Inject
    private AdrValidationHumanRouter router;

    @Inject
    private ReportSplitter splitter;

    @Override
    public void setUp() throws Exception {
        camelUrl.setAdrValidationHuman(START_EP);
        camelUrl.setOutboundMessage(END_EP);
        context.addRoutes(router);
    }

    @Test
    @DirtiesContext
    public void singleSRTest() throws JAXBException {
        ValidIcsrR2Message icsrR2Message = createIcsrMessage("/data/human/icsr/icsr-single.xml");
        sendBody(icsrR2Message);
    }

    @Test
    @DirtiesContext
    public void multipleSRTest() throws JAXBException {
        ValidIcsrR2Message icsrR2Message = createIcsrMessage("/data/human/icsr/icsr-multiple.xml");
        sendBody(icsrR2Message);
    }

    private void sendBody(ValidIcsrR2Message icsrR2Message) {
        List<IcsrR2ReportMessage> messages = splitter.split(icsrR2Message);
        for (IcsrR2ReportMessage msg : messages) {
            producerTemplate.sendBody(msg);
        }
        resultEndpoint.expectedMessageCount(1);
    }
}
