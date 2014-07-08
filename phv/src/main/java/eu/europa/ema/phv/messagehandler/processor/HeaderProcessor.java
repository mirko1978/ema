/**
 * 
 */
package eu.europa.ema.phv.messagehandler.processor;

import java.util.Date;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

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

	/**
	 * sets missing required headers 
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		//exchange.getIn().setHeader("filename", value);
		exchange.getIn().setHeader("receivedDate", new Date());
		exchange.getIn().setHeader("UUID", UUID.randomUUID());
	}

}
