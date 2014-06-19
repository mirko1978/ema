package eu.europa.ema.phv.cluster;

import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

public class QueueSend {
    public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

    public final static String WLS_URL = "t3://localhost:7002,localhost:7003";

    public final static String JMS_FACTORY = "ud_cf";//"jms/phv/connectionFactory";

    public final static String QUEUE = "ud_queue"; //"jms/phv/gateway/human/adr_UDQ_mig";

    public final static int SLEEP = 500;
    
    public final static int TEST_DURATION = (1000 / SLEEP) * 60 * 50;

    private QueueConnectionFactory qconFactory;

    private QueueConnection qcon;

    private QueueSession qsession;

    private QueueSender qsender;

    private Queue queue;

    private TextMessage textMessage;

    private InitialContext initialContext;

    public QueueSend() throws NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
        env.put(Context.PROVIDER_URL, WLS_URL);
        initialContext = new InitialContext(env);
    }

    @Before
    public void init() throws NamingException, JMSException {
        qconFactory = (QueueConnectionFactory) initialContext.lookup(JMS_FACTORY);
        qcon = qconFactory.createQueueConnection();
        qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        queue = (Queue) initialContext.lookup(QUEUE);
        qsender = qsession.createSender(queue);
        textMessage = qsession.createTextMessage();
        qcon.start();
    }

    @Test
    public void sendMessages() throws Exception {
        int counter = 0;
        SimpleDateFormat format = new SimpleDateFormat("h:mm:ss.SSS");
        while (counter < TEST_DURATION) {
            counter++;
            System.out.print("[Msg_Sender] ");
            String msg = String.format("TEST [%d] created at %s", counter, format.format(Calendar.getInstance().getTime()));
            textMessage.setText(msg);
            try {
                qsender.send(textMessage);
                System.out.println(msg);
            }
            catch (JMSException jmse) {
                if (jmse.getCause() instanceof SocketException) {
                    System.out.println("Exception: " + jmse.getMessage());
                    init();
                }
            }
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException e) {
            }
        }
        qsender.close();
        qsession.close();
        qcon.close();
    }

}
