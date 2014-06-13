package eu.europa.ema.phv.messagehandler.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
/**
 * 
 * The validation runs inside the camel route. In case of failure an exception is throw
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 10 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 10 Jun 2014 $
 */
public class XmlValidator implements Processor{

    /* (non-Javadoc)
     * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        
    }
}
