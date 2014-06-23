/**
 * 
 */
package eu.europa.ema.phv.adrparserhuman;

import java.util.Date;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Ichicsr;
import eu.europa.ema.phv.common.util.JmsCamelUrl;

/**
 * TTest the ADR parser human router
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 23 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/camel-context-test.xml")
// @ActiveProfiles(profiles = "dev")
public class AdrParserHumanRouterTest extends AbstractJUnit4SpringContextTests {
    @Inject
    private JmsCamelUrl camelUrl;

    @Inject
    private AdrParserHumanRouter router;

    @Inject
    private CamelContext context;

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @BeforeClass
    public static void springProfile() {
        System.setProperty("spring.profiles.active", "dev");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.camel.test.junit4.CamelTestSupport#setUp()
     */
    @Before
    public void setUp() throws Exception {
        camelUrl.setAdrParserHuman("direct:start");
        camelUrl.setAdrValidationHuman("mock:result");
        context.addRoutes(router);
    }

    private ValidIcsrR2Message createMessage(String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Ichicsr.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Ichicsr icsr = (Ichicsr) jaxbUnmarshaller.unmarshal(getClass().getResourceAsStream(path));
        ValidIcsrR2Message message = new ValidIcsrR2Message();
        MessageMetadata metadata = new MessageMetadata();
        metadata.setFileName(path);
        metadata.setReceived(new Date());

        message.setIcsr(icsr);
        message.setMetadata(metadata);
        return message;
    }

    @Test
    @DirtiesContext
    public void singleReportTest() throws JAXBException {
        ValidIcsrR2Message message = createMessage("/data/icsr-single.xml");
        template.sendBodyAndHeader(message, "", null);
        resultEndpoint.setMinimumExpectedMessageCount(1);
    }
    
    @Test
    @DirtiesContext
    public void multipleReportTest() throws JAXBException {
        ValidIcsrR2Message message = createMessage("/data/icsr-multiple.xml");
        template.sendBodyAndHeader(message, "", null);
        resultEndpoint.setMinimumExpectedMessageCount(12);
    }
}
