/**
 *
 */
package eu.europa.ema.phv.adrvalidationhuman;

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
 * TODO Class meaningful description...
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 * @since 13 Jun 2014 (creation date)
 */
public class AdrReportAggregationStrategy implements AggregationStrategy {
    private static final Logger LOG = LoggerFactory.getLogger(AdrReportAggregationStrategy.class);

    private static final String MSG_HEADER = "IcsrR2Message";

    @Inject
    private IcsrR2AckUtility ackUtility;

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        IchIcsrAck icsrAck = oldExchange.getIn().getBody(IchIcsrAck.class);
        IcsrR2ReportValidationResult validationResult = newExchange.getIn().getBody(IcsrR2ReportValidationResult.class);
        final Integer totalArrived = oldExchange.getIn().getHeader(Exchange.AGGREGATED_SIZE, Integer.class);

        IcsrR2ReportMessage report = validationResult.getMessage();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Aggregating results for safety report {}/{} total processed {}",
                    report.getIndex(), report.getTotal(), totalArrived);
        }
        // First element
        if (icsrAck == null) {
            icsrAck = ackUtility.buildIcsrAck(report.getHeader());
            newExchange.getOut().setHeader(MSG_HEADER, validationResult.getMessage().getHeader());
        }
        validationResult.getMessage().setHeader((ValidIcsrR2Message) newExchange.getIn().getHeader(MSG_HEADER));
        try {
            ReportAcknowledgment reportAck = ackUtility.buildReportAck(validationResult);
            icsrAck.getAcknowledgment().getReportAcknowledgment().add(reportAck);

            // Last element
            if (totalArrived.intValue() == report.getTotal().intValue()) {
                if (icsrAck.getAcknowledgment().getReportAcknowledgment().isEmpty()) {
                    icsrAck.getAcknowledgment().getMessageacknowledgment()
                            .setTransmissionacknowledgmentcode(IcsrAckCode.OK.getCode());
                }
                else {
                    IcsrAckCode code = null;
                    for (ReportAcknowledgment rack : icsrAck.getAcknowledgment().getReportAcknowledgment()) {
                        if (IcsrAckCode.ICSR_ERROR.equals(rack.getReportacknowledgmentcode())) {
                            code = IcsrAckCode.ICSR_ERROR;
                            break;
                        }
                    }
                    code = code == null ? code = IcsrAckCode.ICSR_WARNING : code;
                    icsrAck.getAcknowledgment().getMessageacknowledgment()
                            .setTransmissionacknowledgmentcode(code.getCode());
                }
            }
            newExchange.getOut().setBody(icsrAck);
            return newExchange;

        }
        catch (Exception e) {
            LOG.error("FATAL cannot create ACK");
        }
        return null;
    }
}
