package eu.europa.ema.phv.common.model.adrhuman;

import java.io.Serializable;

/**
 * After validation message exchange.
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 27/06/2014 $
 * @since 27/06/2014 (creation date)
 */
public class IcsrR2ReportValidationResult implements Serializable{

    /**
     * Icsr Report message received
     */
    private IcsrR2ReportMessage message;

    /**
     * Error message for the report
     */
    private String errorMessage;

    /**
     * Ack code
     */
    private IcsrAckCode ackCode;

    public IcsrR2ReportMessage getMessage() {
        return message;
    }

    public void setMessage(IcsrR2ReportMessage message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public IcsrAckCode getAckCode() {
        return ackCode;
    }

    public void setAckCode(IcsrAckCode ackCode) {
        this.ackCode = ackCode;
    }
}
