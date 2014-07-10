package eu.europa.ema.phv.common.util;

import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.IchIcsrAck;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.ReportAcknowledgment;

/**
 * Icsr R2 Acknowledge utilities
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 30/06/2014 $
 * @since 30/06/2014 (creation date)
 */
public interface IcsrR2AckUtility {

    /**
     * Build a new ack message. Doesn't set the transmission code. Please refer
     * to {@link eu.europa.ema.phv.common.model.adrhuman.IcsrAckCodeEnum}.<br/>
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
    IchIcsrAck buildIcsrAck(ValidIcsrR2Message message);

    /**
     * Build a new report Ack from the results and the safety report
     *
     * @param result result from the validation
     * @return the new report ack
     * @throws Exception in case {@link eu.europa.ema.phv.common.xmladapter.IcsrR2DateAdapter} cannot create the date
     */
    ReportAcknowledgment buildReportAck(IcsrR2ReportValidationResult result)
            throws Exception;
}
