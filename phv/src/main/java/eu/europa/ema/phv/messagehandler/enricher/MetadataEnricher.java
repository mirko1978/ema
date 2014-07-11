/**
 *
 */
package eu.europa.ema.phv.messagehandler.enricher;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.messagehandler.constants.MessageConstants;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * The message enricher for incoming valid safety reports which adds headers such as
 * receiverid, validation result, and validation date
 *
 * @author Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 8 Jul 2014 $
 * @since 8 Jul 2014 (creation date)
 */

public class MetadataEnricher {

    private static final Logger LOG = LoggerFactory.getLogger(MetadataEnricher.class);

    /**
     * Adds headers such as
     * receiverid, validation result, and validation date
     *
     * @param ichicsr
     * @param exchange
     * @return modified ICHICSR message
     */
    public IchicsrMessage enrich(IchicsrMessage ichicsr, Exchange exchange) {
        LOG.info("Message Number : " + ichicsr.getMessagenumber());
        //if gateway is sending authenticated org Id, check in the report and/or populate
        exchange.getIn().setHeader(MessageConstants.MESSAGE_HEADER_RECEIVER, ichicsr.getReceiverid());
        exchange.getIn()
                .setHeader(MessageConstants.MESSAGE_HEADER_VALIDATIONRESULT, MessageConstants.MESSAGE_HEADER_VALID);
        exchange.getIn().setHeader(MessageConstants.MESSAGE_HEADER_VALIDATION_DATE, new Date());
        return ichicsr;
    }

}
