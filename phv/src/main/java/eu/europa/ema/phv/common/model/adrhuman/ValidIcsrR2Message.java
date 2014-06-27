/**
 * 
 */
package eu.europa.ema.phv.common.model.adrhuman;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;

import java.io.Serializable;

/**
 * Describe the ICSR R2 message with the metadata
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 20 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 20 Jun 2014 $
 */
public class ValidIcsrR2Message implements Serializable {

    private static final long serialVersionUID = -8815339976705776959L;

    private IchicsrMessage icsr;

    private MessageMetadata metadata;

    /**
     * @return the metadata
     */
    public MessageMetadata getMetadata() {
        return metadata;
    }

    /**
     * @param metadata the metadata to set
     */
    public void setMetadata(MessageMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * @return the icsr can be null if the message is a master
     */
    public IchicsrMessage getIcsr() {
        return icsr;
    }

    /**
     * @param icsr the icsr to set
     */
    public void setIcsr(IchicsrMessage icsr) {
        this.icsr = icsr;
    }

}
