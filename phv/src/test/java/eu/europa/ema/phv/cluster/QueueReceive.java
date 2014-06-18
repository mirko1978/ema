package eu.europa.ema.phv.cluster;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

public class QueueReceive {
    public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

    public final static String WLS_URL = "t3://localhost:7002,localhost:7003";

    public final static String JMS_FACTORY = "ud_cf";//"jms/phv/connectionFactory";

    public final static String QUEUE = "ud_queue"; //"jms/phv/gateway/human/adr_UDQ_mig";;

    public final static long SLEEP = 500;

    private QueueConnectionFactory qconFactory;

    private QueueConnection qcon;

    private QueueSession qsession;

    private QueueReceiver qreceiver;

    private Queue queue;

    private InitialContext initialContext;

    private SimpleDateFormat format = new SimpleDateFormat("h:mm:ss.SSS");

    public QueueReceive() throws NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
        env.put(Context.PROVIDER_URL, WLS_URL);
        initialContext = new InitialContext(env);
    }

    @Test
    public void receive() throws Exception {
        init();
        readMessages();
        qreceiver.close();
        qsession.close();
        qcon.close();
    }

    private void init() throws NamingException, JMSException {
        qconFactory = (QueueConnectionFactory) initialContext.lookup(JMS_FACTORY);
        qcon = qconFactory.createQueueConnection();
        qsession = qcon.createQueueSession(true, Session.SESSION_TRANSACTED);
        queue = (Queue) initialContext.lookup(QUEUE);
        qreceiver = qsession.createReceiver(queue);
        qcon.start();
    }

    /**
     * Syncrounus read
     * @throws JMSException
     * @throws NamingException
     */
    private void readMessages() throws JMSException, NamingException {
        MessageConsumer consumer = qsession.createConsumer(queue);
        while (true) {
            try {
                Message msg = consumer.receive();
                String msgText;
                if (msg instanceof TextMessage) {
                    msgText = ((TextMessage) msg).getText();
                }
                else {
                    msgText = msg.toString();
                }
                System.out.println(format.format(Calendar.getInstance().getTime()) + " > " + msgText);
                qsession.commit();
                Thread.sleep(SLEEP);
            }
            catch (InterruptedException e) {
            }
            catch (JMSException je) {
                je.printStackTrace();
                qcon = qconFactory.createQueueConnection();
                qsession = qcon.createQueueSession(true, Session.SESSION_TRANSACTED);
                queue = (Queue) initialContext.lookup(QUEUE);
                qreceiver = qsession.createReceiver(queue);
                qcon.start();
                consumer = qsession.createConsumer(queue);
            }
        }
    }
}
