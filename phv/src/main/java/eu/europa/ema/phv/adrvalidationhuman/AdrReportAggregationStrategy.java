/**
 * 
 */
package eu.europa.ema.phv.adrvalidationhuman;

import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.ack.Ichicsrack;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.ack.Reportacknowledgment;
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
 * @since 13 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 */
public class AdrReportAggregationStrategy implements AggregationStrategy {
    private static final Logger LOG = LoggerFactory.getLogger(AdrReportAggregationStrategy.class);

    @Inject
    private IcsrR2AckUtility ackUtility;

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        Ichicsrack icsrAck = oldExchange.getIn().getBody(Ichicsrack.class);
        IcsrR2ReportMessage report = newExchange.getIn().getBody(IcsrR2ReportMessage.class);
        final Integer totalArrived = oldExchange.getIn().getHeader(Exchange.AGGREGATED_SIZE, Integer.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Aggregating results for safety report {}/{} total processed {}",
                    new Object[] { report.getIndex(), report.getTotal(), totalArrived });
        }
        if (icsrAck == null) {
            icsrAck = ackUtility.build(report.getHeader().getIchicsrmessageheader(), report.getMetadata());
        }
        Reportacknowledgment reportAck = oldExchange.getIn().getHeader("validation.result", Reportacknowledgment.class);
        if (reportAck != null) {
            icsrAck.getAcknowledgment().getReportacknowledgment().add(reportAck);
        }

        // Last element
        if (totalArrived.intValue() == report.getTotal().intValue()) {
            if(icsrAck.getAcknowledgment().getReportacknowledgment().isEmpty()) {
//                icsrAck.getAcknowledgment().getMessageacknowledgment().setTransmissionacknowledgmentcode(IcsrAckCode.ICSR_WARNING);
            }
        }
        newExchange.getOut().setBody(icsrAck);
        return newExchange;
    }
}
