/**
 *
 */
package eu.europa.ema.phv.adrvalidationhuman.processor;

import eu.europa.ema.phv.common.model.adrhuman.IcsrAckCode;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult;

/**
 * Kick the validation and translate the {@link eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage} to the result object
 * {@link eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult}
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 * @since 13 Jun 2014 (creation date)
 */
public class AdrHumanBRValidation {

    /**
     * Execute the validation and translate the {@link eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage} to the result object
     * {@link eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportValidationResult}
     *
     * @param message received to validate
     * @return result of the validation that contains the original message
     */
    public IcsrR2ReportValidationResult validate(IcsrR2ReportMessage message) {
        IcsrR2ReportValidationResult result = new IcsrR2ReportValidationResult();
        result.setAckCode(IcsrAckCode.OK);
        result.setMessage(message);
        return result;
    }

}
