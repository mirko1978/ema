package eu.europa.ema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("BusinessRules")
public class BusinessRules {
    private static final Logger LOG = LoggerFactory.getLogger(BusinessRules.class);

    public void validate(String body) {
        LOG.info("Received report");
    }

}
