package eu.europa.ema.phv.cluster;

import org.junit.Test;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

@SuppressWarnings("Convert2Diamond")
public class QueueReceive {
    private final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

    private final static String WLS_URL = "t3://uv1026.emea.eu.int:7827,uv1027.emea.eu.int:7827";

    private final static String JMS_FACTORY = "jms/phv/ConnectionFactory";

    private final static String QUEUE = "jms/phv/parser/human/adr_Queue"; // "jms/phv/gateway/human/adr_UDQ_mig";;

    private final static long SLEEP = 1000;

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
     *
     * @throws JMSException
     * @throws NamingException
     */
    private void readMessages() throws JMSException, NamingException {
        MessageConsumer consumer = qsession.createConsumer(queue);
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                Message msg = consumer.receive(50);
                if (msg != null) {
                    String msgText;
                    if (msg instanceof TextMessage) {
                        msgText = ((TextMessage) msg).getText();
                    }
                    else {
                        msgText = msg.toString();
                    }
                    System.out.println(format.format(Calendar.getInstance().getTime()) + " > " + msgText);
                }
                qsession.commit();
                Thread.sleep(SLEEP);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (JMSException je) {
                je.printStackTrace();
            }
            finally {
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
