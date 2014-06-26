/**
 * 
 */
package eu.europa.ema.phv.messagehandler.enricher;



import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Ichicsr;
import eu.europa.ema.phv.messagehandler.processor.MetadataExtractor;



/**
 * TODO Class meaningful description...
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 12 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 12 Jun 2014 $
 */
public class MetadataEnricher {
	
	private static final Logger log = LoggerFactory.getLogger(MetadataEnricher.class);

    public Ichicsr enrich(Ichicsr ichicsr) {
    	log.info("Message Number : " + ichicsr.getIchicsrmessageheader().getMessagenumb().getvalue() );
    	//populate the original file name
    	//populate the official received date
    	//if gateway is sending authenticated org Id, check in the report and/or populate
        return ichicsr;
    }       

}
