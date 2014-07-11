/**
 *
 */
package eu.europa.ema.phv.adrvalidationhuman;

import eu.europa.ema.phv.common.model.adrhuman.IcsrAckCodeEnum;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.IchIcsrAck;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.ReportAcknowledgment;
import eu.europa.ema.phv.common.util.IcsrR2AckUtility;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Aggregate all the report validation result together. Only the first message contains the representation of the sent ICSR {@link eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message}
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 * @since 13 Jun 2014 (creation date)
 */
public class AdrReportAggregationStrategy implements AggregationStrategy {
    private static final Logger LOG = LoggerFactory.getLogger(AdrReportAggregationStrategy.class);

    @Inject
    private IcsrR2AckUtility ackUtility;

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        IchIcsrAck icsrAck;
        IcsrR2ReportValidationResult newMessage;
        IcsrR2ReportValidationResult oldMessage;
        Integer totalArrived = 0;

        if (oldExchange == null) {
            newMessage = newExchange.getIn().getBody(IcsrR2ReportValidationResult.class);
            oldMessage = newMessage;
            // First element to aggregate: creation of the ACK
            icsrAck = ackUtility.buildIcsrAck(oldMessage.getMessage().getHeader());
        }
        else {
            // Nth element in the aggragation: Retrieve from the exchange the aggregate ACK
            // OldExchange is always the first message received
            newMessage = newExchange.getIn().getBody(IcsrR2ReportValidationResult.class);
            oldMessage = oldExchange.getIn().getBody(IcsrR2ReportValidationResult.class);
            icsrAck = oldMessage.getIcsrAcks();
            totalArrived = oldExchange.getIn().getHeader(Exchange.AGGREGATED_SIZE, Integer.class);
        }
        // Save the results in the new message
        newMessage.setIcsrAcks(icsrAck);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Aggregation [{}] called for report {} arrived {}",
                    oldMessage.getMessage().getHeader().getIcsr().getPkIchicsrmessage(),
                    oldMessage.getMessage().getReport().getSafetyreportid(), totalArrived);
        }
        totalArrived++;
        // Store the total number of arrived message
        newExchange.getIn().setHeader(Exchange.AGGREGATED_SIZE, totalArrived);

        try {
            ReportAcknowledgment reportAck = ackUtility.buildReportAck(newMessage);
            icsrAck.getAcknowledgment().getReportAcknowledgment().add(reportAck);

            if (totalArrived.intValue() == newMessage.getMessage().getTotal().intValue()) {
                // Last element
                if (icsrAck.getAcknowledgment().getReportAcknowledgment().isEmpty()) {
                    // No error found
                    icsrAck.getAcknowledgment().getMessageacknowledgment()
                            .setTransmissionacknowledgmentcode(IcsrAckCodeEnum.OK.getCode());
                }
                else {
                    // Errors
                    IcsrAckCodeEnum code = null;
                    // Check if there are ERRORS in the ack list
                    for (ReportAcknowledgment rack : icsrAck.getAcknowledgment().getReportAcknowledgment()) {
                        if (IcsrAckCodeEnum.ICSR_ERROR.getCode().equals(rack.getReportacknowledgmentcode())) {
                            code = IcsrAckCodeEnum.ICSR_ERROR;
                            break;
                        }
                    }
                    // If nothing found... the message is a warning
                    code = code == null ? IcsrAckCodeEnum.ICSR_WARNING : code;
                    icsrAck.getAcknowledgment().getMessageacknowledgment()
                            .setTransmissionacknowledgmentcode(code.getCode());
                }
            }
            return newExchange;
        }
        catch (Exception e) {
            LOG.error("FATAL: cannot create ACK ", e);
        }
        return null;
    }
}
