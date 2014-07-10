package eu.europa.ema.phv.common.model.adrhuman;

import eu.europa.ema.phv.common.model.DocumentTypeEnum;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the X_INBOUND database table in the repository schema
 */
@Entity
@Table(name = "X_INBOUND")
@NamedQuery(name = "InboundMessageEntity.findAll", query = "SELECT i FROM InboundMessageEntity i")
public class InboundMessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "X_INBOUND_PKINBOUND_GENERATOR", sequenceName = "SEQ_INBOUND")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "X_INBOUND_PKINBOUND_GENERATOR")
    @Column(name = "PK_INBOUND", unique = true, nullable = false, precision = 10)
    private long pkInbound;

    @Temporal(TemporalType.DATE)
    @Column(name = "ACK_STAMP")
    private Date ackStamp;

    @Column(precision = 1, columnDefinition = "tinyint")
    private Integer archived;

    @Column(nullable = false, precision = 2, columnDefinition = "tinyint")
    @Enumerated(EnumType.ORDINAL)
    private DocumentTypeEnum doctype;

    @Lob
    private String document;

    @Column(length = 255)
    private String fileid;

    @Column(length = 400)
    private String messagenumb;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date receivedate;

    @Column(nullable = false, length = 240)
    private String senderid;

    @Column(length = 1)
    private String status;

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

    public DocumentTypeEnum getDoctype() {
        return this.doctype;
    }

    public void setDoctype(DocumentTypeEnum doctype) {
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