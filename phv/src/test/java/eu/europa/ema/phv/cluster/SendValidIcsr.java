package eu.europa.ema.phv.cluster;

import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import org.junit.Before;
import org.junit.Test;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Send a message to the weblogic queue
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 03/07/2014 $
 * @since 03/07/2014 (creation date)
 */
public class SendValidIcsr {
    public final static String VALID_ICSR = "/data/human/icsr/icsr-single.xml";

    public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

    public final static String WLS_URL = "t3://localhost:7002";

    private QueueConnectionFactory qconFactory;

    private QueueConnection qcon;

    private QueueSession qsession;

    private Queue queue;

    private InitialContext initialContext;

    private Properties properties = new Properties();

    public SendValidIcsr() throws NamingException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
        env.put(Context.PROVIDER_URL, WLS_URL);
        initialContext = new InitialContext(env);
    }

    @Before
    public void init() throws NamingException, JMSException, IOException {
        try (InputStream in = getClass().getResourceAsStream("/jms-dev.properties")) {
            properties.load(in);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        qconFactory = (QueueConnectionFactory) initialContext.lookup(properties.getProperty("jms.connection.factory"));
        qcon = qconFactory.createQueueConnection();
        qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        queue = (Queue) initialContext.lookup(properties.getProperty("jms.adr.parser.human"));
    }

    protected ValidIcsrR2Message createIcsrMessage(String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(IchicsrMessage.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IchicsrMessage icsr = (IchicsrMessage) jaxbUnmarshaller.unmarshal(getClass().getResourceAsStream(path));
        ValidIcsrR2Message message = new ValidIcsrR2Message();
        MessageMetadata metadata = new MessageMetadata();
        metadata.setFileName(path);
        metadata.setReceived(new Date());
        message.setIcsr(icsr);
        message.setMetadata(metadata);
        return message;
    }

    @Test
    public void sendMessages() throws Exception {
        ValidIcsrR2Message icsrR2Message = createIcsrMessage(VALID_ICSR);
        QueueSender qsender = qsession.createSender(queue);
        ObjectMessage message = qsession.createObjectMessage();
        qcon.start();
        System.out.print("[Msg_Sender] ");
        message.setObject(icsrR2Message);
        try {
            qsender.send(message);
        }
        catch (JMSException jmse) {
            if (jmse.getCause() instanceof SocketException) {
                System.out.println("Exception: " + jmse.getMessage());
            }
        }
        qsender.close();
        qsession.close();
        qcon.close();
    }

}
