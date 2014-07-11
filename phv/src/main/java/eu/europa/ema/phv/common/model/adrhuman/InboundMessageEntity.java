package eu.europa.ema.phv.common.model.adrhuman;

import eu.europa.ema.phv.common.model.DocumentTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the X_INBOUND database table in the repository schema
 *
 * @author Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 9 Jul 2014 $
 * @since 9 Jul 2014 (creation date)
 */
@Entity
@Table(name = "X_INBOUND")
@NamedQuery(name = "InboundMessageEntity.findAll", query = "SELECT i FROM InboundMessageEntity i")
public class InboundMessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Primary key generated using the seq_inbound, the persistent layer should auto populate it
     */
    @Id
    @GeneratedValue(generator = "InboundMessageEntity")
    @SequenceGenerator(name = "InboundMessageEntity", sequenceName = "SEQ_INBOUND", allocationSize = 1)
    @Column(name = "PK_INBOUND", unique = true, nullable = false, precision = 10)
    private long pkInbound;

    /**
     * this field is not used for the incoming messages
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "ACK_STAMP")
    private Date ackStamp;

    /**
     * Not used by the incoming messages, might be updated when archived by other processes
     */
    @Column(precision = 1, columnDefinition = "tinyint")
    private Integer archived;

    /**
     * The document type is based on the value in the xml message mapped to Enum values as reflected in the METABASE.LK_DOCUMENTTYPE
     * See {@linkplain DocumentTypeEnum}
     */
    @Column(nullable = false, precision = 2, columnDefinition = "tinyint")
    private Integer doctype;

    /**
     * The original xml content
     */
    @Lob
    private String document;

    /**
     * The xml file name
     */
    @Column(length = 255)
    private String fileid;

    /**
     * The message number in the xml message as specified by the user
     */
    @Column(length = 400)
    private String messagenumb;

    /**
     * The date on which the message was received by the gateway
     */
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date receivedate;

    /**
     * The messagesenderidentifier as specified in the message
     */
    @Column(nullable = false, length = 240)
    private String senderid;

    /**
     * This field is not populated in the current system, but this module will populate with the validation status
     * Y/N
     */
    @Column(length = 1)
    private String status;

    /**
     * This field is not populated in the current system, but this module will populate with the date when the validation
     * was done
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "STATUS_STAMP")
    private Date statusStamp;

    //bi-directional many-to-one association to MessageBoxEntity
    @ManyToOne
    @JoinColumn(name = "FK_MESSAGEBOX", nullable = false)
    private MessageBoxEntity XMessagebox;

    public InboundMessageEntity() {
    }

    public long getPkInbound() {
        return this.pkInbound;
    }

    public void setPkInbound(long pkInbound) {
        this.pkInbound = pkInbound;
    }

    public Date getAckStamp() {
        return this.ackStamp;
    }

    public void setAckStamp(Date ackStamp) {
        this.ackStamp = ackStamp;
    }

    public Integer getArchived() {
        return this.archived;
    }

    public void setArchived(Integer archived) {
        this.archived = archived;
    }

    public Integer getDoctype() {
        return this.doctype;
    }

    public void setDoctype(Integer doctype) {
        this.doctype = doctype;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFileid() {
        return this.fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getMessagenumb() {
        return this.messagenumb;
    }

    public void setMessagenumb(String messagenumb) {
        this.messagenumb = messagenumb;
    }

    public Date getReceivedate() {
        return this.receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public String getSenderid() {
        return this.senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusStamp() {
        return this.statusStamp;
    }

    public void setStatusStamp(Date statusStamp) {
        this.statusStamp = statusStamp;
    }

    public MessageBoxEntity getXMessagebox() {
        return this.XMessagebox;
    }

    public void setXMessagebox(MessageBoxEntity XMessagebox) {
        this.XMessagebox = XMessagebox;
    }

}