/**
 * 
 */
package eu.europa.ema.phv.messagehandler.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Extract the metadata and add to the message
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 12 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 12 Jun 2014 $
 */
public class MetadataExtractor implements Processor {
   
    /* (non-Javadoc)
     * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        // TODO Auto-generated method stub

    }

}
