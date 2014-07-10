/**
 * 
 */
package eu.europa.ema.phv.messagehandler.processor;

import java.util.Date;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.europa.ema.phv.messagehandler.constants.MessageConstants;

/**
 * 
 * This class populates the camel exchange headers with UniqueID (generated using UUID)
 * filename and received date if the header does not contain one.
 * This done before the message is validated as a common data generator
 * 
 * @author  Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 8 Jul 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 8 Jul 2014 $
 */
public class HeaderProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(HeaderProcessor.class);
	/**
	 * sets missing required headers 
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		// file name is available under CamelFileNameOnly
	    //file size is under CamelFileLength
	    //file last modified (for received date) is under CamelFileLastModified
	    String fileName = (String) exchange.getIn().getHeader("CamelFileNameOnly");
	    exchange.getIn().setHeader(MessageConstants.MESSAGE_FILE_NAME, fileName!=null?fileName:null );

	    Long  date = (Long)exchange.getIn().getHeader("CamelFileLastModified");
		exchange.getIn().setHeader( MessageConstants.MESSAGE_RECEIVED_DATE, date!=null? new Date(date): new Date() );

		Long size = (Long) exchange.getIn().getHeader("CamelFileLength");
		exchange.getIn().setHeader(MessageConstants.MESSAGE_FILE_SIZE, size!=null? size:null );

		exchange.getIn().setHeader("UUID", UUID.randomUUID());

		//store the original message content in the header as once unmarshalled we loose the original content from the exchange body
		exchange.getIn().setHeader(MessageConstants.MESSAGE_ORIGAL_PAYLOAD, exchange.getIn().getBody().toString());
		LOG.debug("Populated intial headers: fileName={}; received date={}; fileSize={}; UUID={}", fileName, date, size,exchange.getIn().getHeader("UUID"));
	}

}
