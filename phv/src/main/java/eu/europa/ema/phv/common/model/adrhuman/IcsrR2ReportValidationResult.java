package eu.europa.ema.phv.common.model.adrhuman;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack.IchIcsrAck;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * After validation message exchange.
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 27/06/2014 $
 * @since 27/06/2014 (creation date)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "IcsrR2ReportValidationResult")
public class IcsrR2ReportValidationResult implements Serializable {

    /**
     * Icsr Report message received
     */
    @XmlElement
    private IcsrR2ReportMessage message;

    /**
     * Error message for the report
     */
    @XmlElement
    private String errorMessage;

    /**
     * Ack code
     */
    private IcsrAckCodeEnum ackCode;

    /**
     * ICSR Acknwoledge structure. It is populated during the aggregation process with the result from the validaiton
     */
    @XmlElement
    private IchIcsrAck icsrAcks;

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

    public IcsrAckCodeEnum getAckCode() {
        return ackCode;
    }

    public void setAckCode(IcsrAckCodeEnum ackCode) {
        this.ackCode = ackCode;
    }

    /**
     * @return {@link #icsrAcks}
     */
    public IchIcsrAck getIcsrAcks() {
        return icsrAcks;
    }

    /**
     * @param icsrAcks {@link #icsrAcks}
     */
    public void setIcsrAcks(IchIcsrAck icsrAcks) {
        this.icsrAcks = icsrAcks;
    }
}
