package eu.europa.ema.phv.adrvalidationhuman.processor;

import eu.europa.ema.phv.adrvalidationhuman.AdrValidationHumanCommon;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.persistence.IcsrR2DAO;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

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

    @Inject
    private IcsrR2DAO dao;

    @Override
    public void process(Exchange exchange) throws Exception {
        IcsrR2ReportValidationResult validationResult = exchange.getIn().getBody(IcsrR2ReportValidationResult.class);
        Map<String, Object> headers = exchange.getIn().getHeaders();
        ValidIcsrR2Message icsrR2Message;
        IchicsrMessage saved;

        if(headers.containsKey(AdrValidationHumanCommon.MSG_HEADER)) {
            // It's not the first call... the message is saved in the header
            icsrR2Message = (ValidIcsrR2Message) headers.get(AdrValidationHumanCommon.MSG_HEADER);
            // retrieve the saved icsr
            saved = (IchicsrMessage) headers.get(AdrValidationHumanCommon.SAVED_MSG_HEADER);
        } else {
            // First call... retrieve the message
            icsrR2Message = validationResult.getMessage().getHeader();
            headers.put(AdrValidationHumanCommon.MSG_HEADER, icsrR2Message);
            // persist it
            saved = dao.saveOnlyIcsr(validationResult.getMessage().getHeader().getIcsr());
        }
        // Persist the report
        dao.saveReport(saved, validationResult.getMessage().getReport());
        dao.updateIcsr(saved, icsrR2Message.getIcsr());
    }
}
