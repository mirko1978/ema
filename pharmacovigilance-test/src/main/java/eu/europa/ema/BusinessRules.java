package eu.europa.ema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * This class was used before introducing Drools in order to show how to run
 * some custom code inside a Camel route
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @author $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 10 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 10 Jun 2014 $
 */
@Component("BusinessRules")
public class BusinessRules {
    private static final Logger LOG = LoggerFactory.getLogger(BusinessRules.class);

    public void validate(String body) {
        LOG.info("Received report");
    }

}
