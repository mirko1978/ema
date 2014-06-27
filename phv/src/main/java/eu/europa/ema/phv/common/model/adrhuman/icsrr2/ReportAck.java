package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the I_REPORTACK database table.
 * 
 */
@Entity
@Table(name = "I_REPORTACK")
@NamedQuery(name = "ReportAck.findAll", query = "SELECT r FROM ReportAck r")
public class ReportAck implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Primary key from ICHICSR.I_SAFETYREPORT */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_SAFETYREPORT", unique = true, nullable = false, precision = 10)
    private long pkSafetyreport;

    @Column(length = 400)
    private String casenumber;

    @Column(precision = 1)
    private BigDecimal casetype;

    @Lob
    private String errormessagecomment;

    @Column(length = 400)
    private String localreportnumb;

    @Column(precision = 1)
    private BigDecimal newreportstatus;

    @Column(length = 400)
    private String oldlocalreportnumb;

    @Column(precision = 1)
    private BigDecimal oldreportstatus;

    @Column(length = 56)
    private String receiptdate;

    @Column(precision = 3)
    private BigDecimal receiptdateformat;

    @Column(length = 8)
    private String reportacknowledgmentcode;

    @Column(length = 400)
    private String safetyreportid;

    @Column(length = 8)
    private String safetyreportversion;

    // bi-directional many-to-many association to MessageAck
    @ManyToMany
    @JoinTable(name = "I_SAFETYREPORTACKS", joinColumns = { @JoinColumn(name = "FK_SAFETYREPORT", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "FK_ICHICSRMESSAGE", nullable = false) })
    private List<MessageAck> IMessageacks;

    // bi-directional one-to-one association to SafetyReport
    @OneToOne
    @JoinColumn(name = "PK_SAFETYREPORT", nullable = false, insertable = false, updatable = false)
    private SafetyReport ISafetyreport;

    // bi-directional many-to-one association to ReportComment
    @OneToMany(mappedBy = "IReportack")
    private List<ReportComment> IReportcomments;

    public ReportAck() {
    }

    public long getPkSafetyreport() {
        return this.pkSafetyreport;
    }

    public void setPkSafetyreport(long pkSafetyreport) {
        this.pkSafetyreport = pkSafetyreport;
    }

    public String getCasenumber() {
        return this.casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber;
    }

    public BigDecimal getCasetype() {
        return this.casetype;
    }

    public void setCasetype(BigDecimal casetype) {
        this.casetype = casetype;
    }

    public String getErrormessagecomment() {
        return this.errormessagecomment;
    }

    public void setErrormessagecomment(String errormessagecomment) {
        this.errormessagecomment = errormessagecomment;
    }

    public String getLocalreportnumb() {
        return this.localreportnumb;
    }

    public void setLocalreportnumb(String localreportnumb) {
        this.localreportnumb = localreportnumb;
    }

    public BigDecimal getNewreportstatus() {
        return this.newreportstatus;
    }

    public void setNewreportstatus(BigDecimal newreportstatus) {
        this.newreportstatus = newreportstatus;
    }

    public String getOldlocalreportnumb() {
        return this.oldlocalreportnumb;
    }

    public void setOldlocalreportnumb(String oldlocalreportnumb) {
        this.oldlocalreportnumb = oldlocalreportnumb;
    }

    public BigDecimal getOldreportstatus() {
        return this.oldreportstatus;
    }

    public void setOldreportstatus(BigDecimal oldreportstatus) {
        this.oldreportstatus = oldreportstatus;
    }

    public String getReceiptdate() {
        return this.receiptdate;
    }

    public void setReceiptdate(String receiptdate) {
        this.receiptdate = receiptdate;
    }

    public BigDecimal getReceiptdateformat() {
        return this.receiptdateformat;
    }

    public void setReceiptdateformat(BigDecimal receiptdateformat) {
        this.receiptdateformat = receiptdateformat;
    }

    public String getReportacknowledgmentcode() {
        return this.reportacknowledgmentcode;
    }

    public void setReportacknowledgmentcode(String reportacknowledgmentcode) {
        this.reportacknowledgmentcode = reportacknowledgmentcode;
    }

    public String getSafetyreportid() {
        return this.safetyreportid;
    }

    public void setSafetyreportid(String safetyreportid) {
        this.safetyreportid = safetyreportid;
    }

    public String getSafetyreportversion() {
        return this.safetyreportversion;
    }

    public void setSafetyreportversion(String safetyreportversion) {
        this.safetyreportversion = safetyreportversion;
    }

    public List<MessageAck> getIMessageacks() {
        return this.IMessageacks;
    }

    public void setIMessageacks(List<MessageAck> IMessageacks) {
        this.IMessageacks = IMessageacks;
    }

    public SafetyReport getISafetyreport() {
        return this.ISafetyreport;
    }

    public void setISafetyreport(SafetyReport ISafetyreport) {
        this.ISafetyreport = ISafetyreport;
    }

    public List<ReportComment> getIReportcomments() {
        return this.IReportcomments;
    }

    public void setIReportcomments(List<ReportComment> IReportcomments) {
        this.IReportcomments = IReportcomments;
    }

    public ReportComment addIReportcomment(ReportComment IReportcomment) {
        getIReportcomments().add(IReportcomment);
        IReportcomment.setIReportack(this);

        return IReportcomment;
    }

    public ReportComment removeIReportcomment(ReportComment IReportcomment) {
        getIReportcomments().remove(IReportcomment);
        IReportcomment.setIReportack(null);

        return IReportcomment;
    }

}