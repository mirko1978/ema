/**
 *
 */
package eu.europa.ema.phv.messagehandler.enricher;

import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.messagehandler.constants.MessageConstants;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

/**
 * This class enriches the valid incoming ICSR2 message meant for EMA by adding {@link MessageMetadata} and
 * wrapping the message in {@link ValidIcsrR2Message} for onward consumption by Phv Parser and Validator
 *
 * @author Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 11 Jul 2014 $
 * @since 11 Jul 2014 (creation date)
 */
public class MessageEnricher {

    private static final Logger LOG = LoggerFactory.getLogger(MessageEnricher.class);

    /**
     * This method enriches the valid incoming ICSR2 message meant for EMA by adding {@link MessageMetadata} and
     * wrapping the message in {@link ValidIcsrR2Message} for onward consumption by Phv Parser and Validator
     *
     * @param ichicsr
     * @param exchange
     * @return
     */
    public ValidIcsrR2Message enrich(IchicsrMessage ichicsr, Exchange exchange) {
        LOG.info("Populating ValidICSR2 Message - Message Number : " + ichicsr.getMessagenumber());
        ValidIcsrR2Message validMessage = new ValidIcsrR2Message();
        MessageMetadata metadata = new MessageMetadata();
        metadata.setFileName(exchange.getIn().getHeader(MessageConstants.MESSAGE_FILE_NAME).toString());
        metadata.setReceived((Date) exchange.getIn().getHeader(MessageConstants.MESSAGE_RECEIVED_DATE));
        metadata.setUniqueId((UUID) exchange.getIn().getHeader("UUID"));
        metadata.setFileSize((Long) exchange.getIn().getHeader(MessageConstants.MESSAGE_FILE_SIZE));
        validMessage.setMetadata(metadata);
        validMessage.setIcsr(ichicsr);
        return validMessage;
    }

}
