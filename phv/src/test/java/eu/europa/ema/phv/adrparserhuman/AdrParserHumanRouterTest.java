/**
 *
 */
package eu.europa.ema.phv.adrparserhuman;

import eu.europa.ema.phv.AbstractPhvTest;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;

/**
 * TTest the ADR parser human router
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 * @since 23 Jun 2014 (creation date)
 */
public class AdrParserHumanRouterTest extends AbstractPhvTest {

    @Inject
    private AdrParserHumanRouter router;

    @Override
    public void setUp() throws Exception {
        camelUrl.setAdrParserHuman(START_EP);
        camelUrl.setAdrValidationHuman(END_EP);
        context.addRoutes(router);
    }

    @Test
    @DirtiesContext
    public void singleReportTest() throws JAXBException {
        ValidIcsrR2Message message = createIcsrMessage("/data/human/icsr/icsr-single.xml");
        producerTemplate.sendBody(message);
        resultEndpoint.setMinimumExpectedMessageCount(1);
    }

    @Test
    @DirtiesContext
    public void multipleReportTest() throws JAXBException {
        ValidIcsrR2Message message = createIcsrMessage("/data/human/icsr/icsr-multiple.xml");
        producerTemplate.sendBody(message);
        resultEndpoint.setMinimumExpectedMessageCount(12);
    }
}
