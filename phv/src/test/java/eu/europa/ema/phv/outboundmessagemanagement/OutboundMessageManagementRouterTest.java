package eu.europa.ema.phv.outboundmessagemanagement;

import eu.europa.ema.phv.AbstractPhvTest;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.IchIcsrAck;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * TODO: comment
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 03/07/2014 $
 * @since 03/07/2014 (creation date)
 */
public class OutboundMessageManagementRouterTest extends AbstractPhvTest {

    @Inject
    private OutboundMessageManagementRouter router;

    @Override
    public void setUp() throws Exception {
        camelUrl.setOutboundMessage(START_EP);
        camelUrl.setGatewayOutbox(END_EP);
        context.addRoutes(router);
    }

    @Test
    @DirtiesContext
    public void testAck() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(IchIcsrAck.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IchIcsrAck ack = (IchIcsrAck) jaxbUnmarshaller
                .unmarshal(getClass().getResourceAsStream("/data/human/icsr-ack/ack.01.xml"));
        producerTemplate.sendBody(ack);
        resultEndpoint.expectedMessageCount(1);
    }
}
