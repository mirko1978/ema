package eu.europa.ema.phv.common.model.adrhuman;

import eu.europa.ema.phv.common.xmladapter.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Describe the Message metadata like file name, arrival date etc.
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 20 Jun 2014 $
 * @since 20 Jun 2014 (creation date)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MessageMetadata")
public class MessageMetadata implements Serializable {

    private static final long serialVersionUID = -4085873752167382721L;

    @XmlElement
    private String fileName = "foo.xml";

    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
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

}
