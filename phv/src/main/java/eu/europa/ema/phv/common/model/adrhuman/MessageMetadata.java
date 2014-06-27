package eu.europa.ema.phv.common.model.adrhuman;

import java.io.Serializable;
import java.util.Date;

/**
 * Describe the Message metadata like file name, arrival date etc.
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 20 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 20 Jun 2014 $
 */
public class MessageMetadata implements Serializable {

    private static final long serialVersionUID = -4085873752167382721L;

    private String fileName;

    private Date received;

    /** Unique identifier for the received message. It is set by Message Handler component */
    private String messageId;

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the received
     */
    public Date getReceived() {
        return received;
    }

    /**
     * @param received the received to set
     */
    public void setReceived(Date received) {
        this.received = received;
    }

    /**
     *
     * @return {@link #messageId}
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     *
     * @param messageId {@link #messageId}
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
