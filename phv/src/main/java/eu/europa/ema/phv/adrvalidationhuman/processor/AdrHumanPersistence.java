package eu.europa.ema.phv.adrvalidationhuman.processor;

import eu.europa.ema.phv.adrvalidationhuman.AdrValidationHumanCommon;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.persistence.IcsrR2DAO;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;

/**
 * Persist the ICSR and reports into the database
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 30/06/2014 $
 * @since 30/06/2014 (creation date)
 */
public class AdrHumanPersistence implements Processor {
    private static final Logger LOG = LoggerFactory.getLogger(AdrHumanPersistence.class);

    @Inject
    private IcsrR2DAO dao;

    @Override
    public void process(Exchange exchange) throws Exception {
        IcsrR2ReportValidationResult validationResult = exchange.getIn().getBody(IcsrR2ReportValidationResult.class);
        Map<String, Object> headers = exchange.getIn().getHeaders();
        IcsrR2ReportValidationResult firstMessage = (IcsrR2ReportValidationResult) headers
                .get(AdrValidationHumanCommon.FIRST_MESSAGE);
        IchicsrMessage saved;

        if (headers.containsKey(AdrValidationHumanCommon.SAVED_ICSR)) {
            // retrieve from the header the icsr
            saved = (IchicsrMessage) headers.get(AdrValidationHumanCommon.SAVED_ICSR);
        }
        else {
            if(LOG.isDebugEnabled()) {
                LOG.debug("Saving the ICSR headers for {}", validationResult.getMessage().getUniqueId());
            }
            // persist the message core without reports
            saved = dao.saveOnlyIcsr(validationResult.getMessage().getHeader().getIcsr());
            // store in the header the saved message
            headers.put(AdrValidationHumanCommon.SAVED_ICSR, saved);
            if(LOG.isDebugEnabled()) {
                LOG.debug("Saved ICSR {}", validationResult.getMessage().getHeader().getIcsr());
            }
        }
        // Persist the report
        dao.saveReport(saved, validationResult.getMessage().getReport());
        dao.updateIcsr(saved, firstMessage.getMessage().getHeader().getIcsr());
        if(LOG.isDebugEnabled()) {
            LOG.debug("Saved report {} ",validationResult.getMessage().getReport());
        }
    }
}
