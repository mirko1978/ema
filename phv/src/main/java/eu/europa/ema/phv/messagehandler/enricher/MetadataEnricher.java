/**
 * 
 */
package eu.europa.ema.phv.messagehandler.enricher;



import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO Class meaningful description...
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 12 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 12 Jun 2014 $
 */
public class MetadataEnricher {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetadataEnricher.class);

    public IchicsrMessage enrich(IchicsrMessage ichicsr) {
    	LOG.info("Message Number : {}", ichicsr.getMessagenumber());
    	//populate the original file name
    	//populate the official received date
    	//if gateway is sending authenticated org Id, check in the report and/or populate
        return ichicsr;
    }       

}
