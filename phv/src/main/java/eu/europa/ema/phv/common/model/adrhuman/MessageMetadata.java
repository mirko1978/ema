package eu.europa.ema.phv.common.model.adrhuman;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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

    /** Unique identifier for the received message. It is set by Message Handler component */
    private UUID uniqueId;

    private String fileName = "foo.xml";

    private Date received = new Date();

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
     * @return {@link #uniqueId}
     */
    public UUID getUniqueId() {
        return uniqueId;
    }

    /**
     *
     * @param uniqueId {@link #uniqueId}
     */
    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

}
