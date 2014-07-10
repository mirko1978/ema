package eu.europa.ema.phv.cluster;

import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.model.XmlUnmarshall;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.jms.*;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.nio.file.Path;
import java.util.*;

/**
 * Send all the valid XML to the weblogic queue
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 03/07/2014 $
 * @since 03/07/2014 (creation date)
 */
@RunWith(value = Parameterized.class)
public class SendAllValidIcsr extends XmlUnmarshall {

    public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

    public final static String WLS_URL = "t3://localhost:7002";

    private QueueConnectionFactory qconFactory;

    private QueueConnection qcon;

    private QueueSession qsession;

    private Queue queue;

    private InitialContext initialContext;

    private Properties properties = new Properties();

    public SendAllValidIcsr(Path path) throws NamingException {
        super(path);
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
        env.put(Context.PROVIDER_URL, WLS_URL);
        initialContext = new InitialContext(env);
    }

    @Parameterized.Parameters
    public static List<Object[]> data() throws IOException {
        List<Object[]> toFilter = data("src/test/resources/data/human/icsr");
        Iterator<Object[]> iterator = toFilter.iterator();
        // Remove invalid messages
        while (iterator.hasNext()) {
            Path path = (Path) iterator.next()[0];
            switch (path.getFileName().toString()) {
            case "unmarshal.01.xml":
            case "unmarshal.04.xml":
                iterator.remove();
            }
        }
        return toFilter;
    }

    @Before
    public void init() throws NamingException, JMSException, IOException, JAXBException {
        JAXB_CONTEXT = JAXBContext.newInstance("eu.europa.ema.phv.common.model.adrhuman.icsrr2");
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

    @Test
    public void sendMessages() throws Exception {
        IchicsrMessage icsr = unmarshall();
        ValidIcsrR2Message icsrR2Message = new ValidIcsrR2Message();
        MessageMetadata metadata = new MessageMetadata();
        metadata.setFileName(path.getFileName().toString());
        metadata.setReceived(new Date());
        icsrR2Message.setIcsr(icsr);
        icsrR2Message.setMetadata(metadata);

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
