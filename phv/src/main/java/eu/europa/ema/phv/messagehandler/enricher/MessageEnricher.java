/**
 * 
 */
package eu.europa.ema.phv.messagehandler.enricher;



import java.util.Date;
import java.util.UUID;

import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.messagehandler.constants.MessageConstants;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author raov
 *
 */
public class MessageEnricher {
	
	private static final Logger LOG = LoggerFactory.getLogger(MessageEnricher.class);

	 public ValidIcsrR2Message enrich(IchicsrMessage ichicsr, Exchange exchange) {
	    	LOG.info("Populating ValidICSR2 Message - Message Number : " + ichicsr.getMessagenumber() );
	    	ValidIcsrR2Message validMessage = new ValidIcsrR2Message();
	    	MessageMetadata metadata = new MessageMetadata();
	    	metadata.setFileName(exchange.getIn().getHeader(MessageConstants.MESSAGE_FILE_NAME).toString());
	    	metadata.setReceived((Date)exchange.getIn().getHeader(MessageConstants.MESSAGE_RECEIVED_DATE));
	    	metadata.setUniqueId((UUID)exchange.getIn().getHeader("UUID"));
	    	metadata.setFileSize((Long)exchange.getIn().getHeader(MessageConstants.MESSAGE_FILE_SIZE));
	    	validMessage.setMetadata(metadata);
	    	validMessage.setIcsr(ichicsr);
	        return validMessage;
	    }       

}
