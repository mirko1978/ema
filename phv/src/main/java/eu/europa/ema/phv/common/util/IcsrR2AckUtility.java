/**
 *
 */
package eu.europa.ema.phv.common.util;

import eu.europa.ema.phv.common.model.adrhuman.IcsrAckCode;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReport;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.*;
import eu.europa.ema.phv.common.xmladapter.IcsrR2DateAdapter;
import eu.europa.ema.phv.common.xmladapter.IcsrR2DateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Utility for managing the Icsr R2 Ack
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 * @since 23 Jun 2014 (creation date)
 */
public class IcsrR2AckUtility {

    public static final String ACK_VERSION = "1.1";

    public static final String ACK_RELEASE = "1.0";

    public static final String EVHUMAN = "EVHUMAN";

    public static final IcsrR2DateAdapter DATE_ADAPTER = new IcsrR2DateAdapter();

    private static final Logger LOG = LoggerFactory.getLogger(IcsrR2AckUtility.class);

    public final String ACK_TYPE = "ichicsrack";

    /**
     * Build a new Message header for ACK
     *
     * @param message
     * @return
     */
    public IchIcsrMessageHeader messageHeader(ValidIcsrR2Message message) {
        IchIcsrMessageHeader header = new IchIcsrMessageHeader();

        header.setMessageDateFormat(IcsrR2DateFormat._204.getCode());
        header.setMessageFormatRelease(ACK_RELEASE);
        header.setMessageFormatVersion(ACK_VERSION);
        header.setMessageType(ACK_TYPE);
        header.setMessagesenderidentifier(EVHUMAN);

        header.setMessageNumb(header.getMessageNumb() + "-ACK");

        header.setMessagereceiveridentifier(message.getIcsr().getSenderid());

        header.setMessageDate(message.getMetadata().getReceived());
        return header;
    }

    /**
     * Build a new ack message. Doesn't set the transmission code. Please refer
     * to {@link IcsrAckCode}.<br/>
     * The follow element are not set:
     * <ul>
     * <li>transmissionacknowledgmentcode</li>
     * <li>reportAcknowledgment</li>
     * <li>icsrmessagedate can be wrong... to check</li
     * </ul>
     *
     * @param message the received message from the queue
     * @return
     */
    public IchIcsrAck buildIcsrAck(ValidIcsrR2Message message) {
        IchIcsrAck icsrAck = new IchIcsrAck();
        icsrAck.setIchIcsrMessageHeader(messageHeader(message));

        Acknowledgment ack = new Acknowledgment();
        icsrAck.setAcknowledgment(ack);

        Messageacknowledgment msgAck = new Messageacknowledgment();
        ack.setMessageacknowledgment(msgAck);

        IchicsrMessage icsr = message.getIcsr();

        msgAck.setIcsrmessagedateformat(IcsrR2DateFormat._204.getCode());
        // TODO: ACK Date maybe is not correct
        msgAck.setIcsrmessagedate(new Date());
        msgAck.setIcsrmessagenumb(icsr.getMessagenumber());
        msgAck.setIcsrmessagereceiveridentifier(EVHUMAN);
        msgAck.setIcsrmessagesenderidentifier(icsr.getSenderid());

        return icsrAck;
    }

    /**
     * Build a new report Ack from the results and the safety report
     *
     * @param result result from the validation
     * @return the new report ack
     * @throws Exception in case {@link eu.europa.ema.phv.common.xmladapter.IcsrR2DateAdapter} cannot create the date
     */
    public ReportAcknowledgment buildReportAck(IcsrR2ReportValidationResult result)
            throws Exception {
        SafetyReport report = result.getMessage().getReport();
        ReportAcknowledgment reportAck = new ReportAcknowledgment();
        try {
            reportAck.setReceiptdate(DATE_ADAPTER.unmarshal(report.getReceiptdate()));
            reportAck.setReceiptdateformat(IcsrR2DateFormat._204.getCode());
            reportAck.setSafetyreportversion(report.getSafetyreportversion());
            reportAck.setSafetyreportid(report.getSafetyreportid());
            reportAck.setAuthoritynumb(report.getAuthoritynumb());
            reportAck.setCompanynumb(report.getCompanynumb());
            reportAck.setErrormessagecomment(result.getErrorMessage());

            reportAck.setReportacknowledgmentcode(result.getAckCode().getCode());
            reportAck.setLocalreportnumb("EU-EC-" + report.getPkSafetyreport());
        }
        catch (Exception e) {
            LOG.error("Error creating the report ack for Message: {} Report {} with index {} ",
                    report.getIchicsrMessage().getMessageid(), report.getPkSafetyreport(),
                    result.getMessage().getIndex());
            throw e;
        }
        return reportAck;
    }
}
