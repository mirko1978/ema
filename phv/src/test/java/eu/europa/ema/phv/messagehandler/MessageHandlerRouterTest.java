package eu.europa.ema.phv.messagehandler;

import eu.europa.ema.phv.AbstractPhvTest;
import eu.europa.ema.phv.common.util.JmsCamelUrl;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.net.URL;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:/camel-context-test.xml")
public class MessageHandlerRouterTest extends AbstractPhvTest {

    @Inject
    private JmsCamelUrl camelUrl;

    @Inject
    private MessageHandlerRouter router;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource(name = "camelContext")
    private CamelContext context;

    @EndpointInject(uri = "mock:outbound")
    protected MockEndpoint outboundEndpoint;

    @EndpointInject(uri = "mock:adrParser")
    protected MockEndpoint adrParserEndpoint;

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;

    @BeforeClass
    public static void springProfile() {
        System.setProperty("spring.profiles.default", "dev");
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        context.stop();
    }

    private void readSingleMessage() throws Exception {
        URL fileURL = this.getClass().getClassLoader().getResource("data");
        camelUrl.setGatewayHumanAdr(fileURL.toString()
                + "?fileName=S2_P_ICHICSR_1r_1.xml&delete=false&initialDelay=5000&consumer.delay=2000");
        camelUrl.setOutboundMessage("mock:outbound");
        camelUrl.setAdrParserHuman("mock:adrParser");
        context.addRoutes(router);
        context.start();
    }

    private void readMultipleReportsMessage() throws Exception {
        camelUrl.setGatewayHumanAdr(
                "file:data?fileName=icsr-multiple.xml&delete=false&consumer.delay=10000&consumer.useFixedDelay=true");
        camelUrl.setOutboundMessage("mock:outbound");
        camelUrl.setAdrParserHuman("mock:adrParser");
        context.addRoutes(router);
        context.start();
    }

    @Test
    @DirtiesContext
    public void testSingleReport() throws Exception {
        readSingleMessage();
        adrParserEndpoint.setMinimumExpectedMessageCount(1);
    }

    //@Test
    @DirtiesContext
    public void testMultipleReports() throws Exception {
        readMultipleReportsMessage();
        adrParserEndpoint.setMinimumExpectedMessageCount(12);
    }

}
