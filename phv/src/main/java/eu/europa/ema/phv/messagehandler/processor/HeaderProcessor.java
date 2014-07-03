/**
 * 
 */
package eu.europa.ema.phv.messagehandler.processor;

import java.util.Date;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author raov
 *
 */
public class HeaderProcessor implements Processor {

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		//exchange.getIn().setHeader("filename", value);
		exchange.getIn().setHeader("receivedDate", new Date());
		exchange.getIn().setHeader("UUID", UUID.randomUUID());
	}

}
