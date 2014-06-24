/**
 * 
 */
package eu.europa.ema.phv.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import eu.europa.ema.phv.common.model.adrhuman.IcsrAckCode;
import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Ichicsrmessageheader;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.MessageIdentifier;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagedate;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagedateformat;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messageformatrelease;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messageformatversion;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagenumb;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagetype;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.ack.Acknowledgment;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.ack.Ichicsrack;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.ack.Messageacknowledgment;

/**
 * Utility for managing the Icsr R2 Ack
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 23 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 */
public class IcsrR2AckUtility {

    public final Messageformatversion ackVersion;

    public final Messageformatrelease ackRelease;

    public final Messagetype ackMsgType;

    public final Messagedateformat ackDateFormat;

    public final MessageIdentifier ackHumanIdentifier;

    public static final SimpleDateFormat ACK_DATE_FORMATTER = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * Create a new instance of the singleton IcsrR2AckUtility
     */
    public IcsrR2AckUtility() {
        ackVersion = new Messageformatversion();
        ackVersion.setvalue("1.1");

        ackRelease = new Messageformatrelease();
        ackRelease.setvalue("1.0");

        ackDateFormat = new Messagedateformat();
        ackDateFormat.setvalue("204");

        ackMsgType = new Messagetype();
        ackMsgType.setvalue("ichicsrack");

        ackHumanIdentifier = new MessageIdentifier();
        ackHumanIdentifier.setvalue("EVHUMAN");
    }

    /**
     * Build a new Message header for ACK
     * @param receivedHeader
     * @param metadata
     * @return
     */
    public Ichicsrmessageheader messageHeader(Ichicsrmessageheader receivedHeader, MessageMetadata metadata) {
        Ichicsrmessageheader header = new Ichicsrmessageheader();

        header.setMessagedateformat(ackDateFormat);
        header.setMessageformatrelease(ackRelease);
        header.setMessageformatversion(ackVersion);
        header.setMessagetype(ackMsgType);
        header.setMessagesenderidentifier(ackHumanIdentifier);

        Messagenumb msgNunb = new Messagenumb();
        msgNunb.setvalue(header.getMessagenumb().getvalue() + "-ACK");
        header.setMessagenumb(msgNunb);

        header.setMessagereceiveridentifier(receivedHeader.getMessagereceiveridentifier());

        header.setMessagedate(messageDate(metadata.getReceived()));
        return header;
    }

    /**
     * Create a Messagedate with the format "204" from the Date
     * @param when
     * @return
     */
    public Messagedate messageDate(Date when) {
        Messagedate msgDate = new Messagedate();
        msgDate.setvalue(ACK_DATE_FORMATTER.format(when));
        return msgDate;
    }

    /**
     * Build a new ack message. Doesn't set the transmission code. Please refer
     * to {@link IcsrAckCode}.<br/>
     * The follow element are not set:
     * <ul>
     * <li>transmissionacknowledgmentcode</li>
     * <li>reportacknowledgment</li>
     * <li>icsrmessagedate can be wrong... to check</li
     * </ul>
     * @param receivedHeader
     * @return
     */
    public Ichicsrack build(Ichicsrmessageheader receivedHeader, MessageMetadata metadata) {
        Ichicsrack icsrAck = new Ichicsrack();
        icsrAck = new Ichicsrack();
        icsrAck.setIchicsrmessageheader(messageHeader(receivedHeader, metadata));

        Acknowledgment ack = new Acknowledgment();
        icsrAck.setAcknowledgment(ack);

        Messageacknowledgment msgAck = new Messageacknowledgment();
        ack.setMessageacknowledgment(msgAck);

        msgAck.setIcsrmessagedateformat(ackDateFormat);
        // TODO: ACK Date maybe is not correct
        msgAck.setIcsrmessagedate(messageDate(new Date()));
        msgAck.setIcsrmessagenumb(receivedHeader.getMessagenumb());
        msgAck.setIcsrmessagereceiveridentifier(ackHumanIdentifier);
        msgAck.setIcsrmessagesenderidentifier(receivedHeader.getMessagesenderidentifier());

        return icsrAck;
    }

}
