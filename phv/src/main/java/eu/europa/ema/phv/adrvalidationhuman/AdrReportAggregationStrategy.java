/**
 *
 */
package eu.europa.ema.phv.adrvalidationhuman;

import eu.europa.ema.phv.adrvalidationhuman.processor.AdrHumanPersistence;
import eu.europa.ema.phv.common.model.adrhuman.IcsrAckCode;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
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

    @Inject
    private AdrHumanPersistence persistence;

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        IchIcsrAck icsrAck;
        IcsrR2ReportValidationResult firstMessage;
        IcsrR2ReportValidationResult currentMessage;
        Integer totalArrived = 0;

        if (oldExchange == null) {
            firstMessage = newExchange.getIn().getBody(IcsrR2ReportValidationResult.class);
            currentMessage = firstMessage;
            // First element to aggregate: validation result contains the original message.
            icsrAck = ackUtility.buildIcsrAck(currentMessage.getMessage().getHeader());
            // Save the results in the first message
            firstMessage.setIcsrAcks(icsrAck);
        }
        else {
            // Nth element in the aggragation: Retrieve from the exchange the aggregate ACK
            // OldExchange is always the first message received
            currentMessage = newExchange.getIn().getBody(IcsrR2ReportValidationResult.class);
            firstMessage = oldExchange.getIn().getHeader(AdrValidationHumanCommon.FIRST_MESSAGE,IcsrR2ReportValidationResult.class);
            icsrAck = firstMessage.getIcsrAcks();
            firstMessage.getMessage().setHeader(firstMessage.getMessage().getHeader());
            totalArrived = oldExchange.getIn().getHeader(Exchange.AGGREGATED_SIZE, Integer.class);
            // TODO: Trick for persistence to fix
            newExchange.getIn().setHeader(AdrValidationHumanCommon.SAVED_ICSR, oldExchange.getIn().getHeader(AdrValidationHumanCommon.SAVED_ICSR));
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Aggregation [{}] called for report {} arrived {}", currentMessage.getMessage().getUniqueId(),
                    currentMessage.getMessage().getReport().getSafetyreportid(), totalArrived);
        }
        totalArrived++;
        // Store the first arrived message in the header for persistence
        newExchange.getIn().setHeader(AdrValidationHumanCommon.FIRST_MESSAGE, firstMessage);
        newExchange.getIn().setHeader(Exchange.AGGREGATED_SIZE, totalArrived);



        try {
            ReportAcknowledgment reportAck = ackUtility.buildReportAck(currentMessage);
            icsrAck.getAcknowledgment().getReportAcknowledgment().add(reportAck);

            if (totalArrived.intValue() == currentMessage.getMessage().getTotal().intValue()) {
                // Last element
                if (icsrAck.getAcknowledgment().getReportAcknowledgment().isEmpty()) {
                    // No error found
                    icsrAck.getAcknowledgment().getMessageacknowledgment()
                            .setTransmissionacknowledgmentcode(IcsrAckCode.OK.getCode());
                }
                else {
                    // Errors
                    IcsrAckCode code = null;
                    // Check if there are ERRORS in the ack list
                    for (ReportAcknowledgment rack : icsrAck.getAcknowledgment().getReportAcknowledgment()) {
                        if (IcsrAckCode.ICSR_ERROR.equals(rack.getReportacknowledgmentcode())) {
                            code = IcsrAckCode.ICSR_ERROR;
                            break;
                        }
                    }
                    // If nothing found... the message is a warning
                    code = code == null ? code = IcsrAckCode.ICSR_WARNING : code;
                    icsrAck.getAcknowledgment().getMessageacknowledgment()
                            .setTransmissionacknowledgmentcode(code.getCode());
                }
            }
            persistence.process(newExchange);
            return newExchange;
        }
        catch (Exception e) {
            LOG.error("FATAL: cannot create ACK ",e);
        }
        return null;
    }
}
