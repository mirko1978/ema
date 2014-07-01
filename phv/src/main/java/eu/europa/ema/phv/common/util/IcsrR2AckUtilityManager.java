/**
 *
 */
package eu.europa.ema.phv.common.util;

import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReport;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.*;
import eu.europa.ema.phv.common.xmladapter.IcsrR2DateAdapter;
import eu.europa.ema.phv.common.xmladapter.IcsrR2DateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Date;

/**
 * Utility for managing the Icsr R2 Ack
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 * @since 23 Jun 2014 (creation date)
 */
public class IcsrR2AckUtilityManager implements IcsrR2AckUtility {

    private static final Logger LOG = LoggerFactory.getLogger(IcsrR2AckUtility.class);

    @Inject
    private IcsrR2DateAdapter dateAdapter;

    /**
     * Build a new Message header for ACK
     *
     * @param message
     * @return
     */
    private IchIcsrMessageHeader messageHeader(ValidIcsrR2Message message) {
        IchIcsrMessageHeader header = new IchIcsrMessageHeader();

        header.setMessageDateFormat(IcsrR2DateFormat._204.getCode());
        header.setMessageFormatRelease(IcsrR2XmlConstants.ACK_RELEASE);
        header.setMessageFormatVersion(IcsrR2XmlConstants.ACK_VERSION);
        header.setMessageType(IcsrR2XmlConstants.ACK_TYPE);
        header.setMessagesenderidentifier(IcsrR2XmlConstants.EVHUMAN);

        header.setMessageNumb(header.getMessageNumb() + "-ACK");

        header.setMessagereceiveridentifier(message.getIcsr().getSenderid());

        header.setMessageDate(message.getMetadata().getReceived());
        return header;
    }

    @Override
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
        msgAck.setIcsrmessagereceiveridentifier(IcsrR2XmlConstants.EVHUMAN);
        msgAck.setIcsrmessagesenderidentifier(icsr.getSenderid());

        return icsrAck;
    }

    @Override
    public ReportAcknowledgment buildReportAck(IcsrR2ReportValidationResult result)
            throws Exception {
        IcsrR2ReportMessage reportMessage = result.getMessage();
        SafetyReport report = reportMessage.getReport();
        ReportAcknowledgment reportAck = new ReportAcknowledgment();
        try {
            reportAck.setReceiptdate(dateAdapter.unmarshal(report.getReceiptdate()));
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
                    reportMessage.getMessageId(), report.getPkSafetyreport(),
                    reportMessage.getIndex());
            throw e;
        }
        return reportAck;
    }
}
