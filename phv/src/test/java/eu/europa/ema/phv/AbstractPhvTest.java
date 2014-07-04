package eu.europa.ema.phv;

import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.util.JmsCamelUrl;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Date;
import java.util.UUID;

/**
 * Junit configuration class
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 01/07/2014 $
 * @since 01/07/2014 (creation date)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/camel-context-test.xml")
@Profile("dev")
public abstract class AbstractPhvTest extends AbstractJUnit4SpringContextTests {

    public static final String START_EP = "direct:start";

    public static final String END_EP = "mock:result";

    @Inject
    protected JmsCamelUrl camelUrl;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Inject
    protected CamelContext context;

    @Produce(uri = START_EP)
    protected ProducerTemplate producerTemplate;

    @EndpointInject(uri = END_EP)
    protected MockEndpoint resultEndpoint;

    @BeforeClass
    public static void springProfile() {
        System.setProperty("spring.profiles.default", "dev");
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.camel.test.junit4.CamelTestSupport#setUp()
     */
    @Before
    public abstract void setUp() throws Exception;

    /**
     * Create a {@link eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message} from a file defined in path
     * @param path path for the ICSR R2 Message
     * @return {@link eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message}
     * @throws JAXBException
     */
    protected  ValidIcsrR2Message createIcsrMessage(String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(IchicsrMessage.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IchicsrMessage icsr = (IchicsrMessage) jaxbUnmarshaller.unmarshal(getClass().getResourceAsStream(path));
        ValidIcsrR2Message message = new ValidIcsrR2Message();
        MessageMetadata metadata = new MessageMetadata();
        metadata.setFileName(path);
        metadata.setReceived(new Date());
        metadata.setUniqueId(UUID.randomUUID());

        message.setIcsr(icsr);
        message.setMetadata(metadata);
        return message;
    }
}


