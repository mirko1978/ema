package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the I_REPORTCOMMENT database table.
 * 
 */
@Entity
@Table(name = "I_REPORTCOMMENT")
@NamedQuery(name = "ReportComment.findAll", query = "SELECT r FROM ReportComment r")
public class ReportComment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReportComment")
    @SequenceGenerator(name="ReportComment",sequenceName="SEQ_REPORTCOMMENT", allocationSize=1)
    @Column(name = "PK_REPORTCOMMENT", unique = true, nullable = false, precision = 10)
    private long pkReportcomment;

    @Column(nullable = false, precision = 3)
    private BigDecimal commentcode;

    @Temporal(TemporalType.DATE)
    private Date commentdate;

    @Column(length = 2000)
    private String commenttext;

    @Column(nullable = false, length = 60)
    private String fieldname;

    @Column(length = 2000)
    private String fieldvalue;

    @Column(name = "FK_ROW", nullable = false, precision = 10)
    private BigDecimal fkRow;

    @Column(nullable = false, precision = 1)
    private BigDecimal severity;

    @Column(nullable = false, length = 30)
    private String tablename;

    @Column(precision = 10)
    private BigDecimal userid;

    // bi-directional many-to-one association to ReportAck
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SAFETYREPORT", nullable = false)
    private ReportAck IReportack;

    public ReportComment() {
    }

    public long getPkReportcomment() {
        return this.pkReportcomment;
    }

    public void setPkReportcomment(long pkReportcomment) {
        this.pkReportcomment = pkReportcomment;
    }

    public BigDecimal getCommentcode() {
        return this.commentcode;
    }

    public void setCommentcode(BigDecimal commentcode) {
        this.commentcode = commentcode;
    }

    public Date getCommentdate() {
        return this.commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }

    public String getCommenttext() {
        return this.commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public String getFieldname() {
        return this.fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getFieldvalue() {
        return this.fieldvalue;
    }

    public void setFieldvalue(String fieldvalue) {
        this.fieldvalue = fieldvalue;
    }

    public BigDecimal getFkRow() {
        return this.fkRow;
    }

    public void setFkRow(BigDecimal fkRow) {
        this.fkRow = fkRow;
    }

    public BigDecimal getSeverity() {
        return this.severity;
    }

    public void setSeverity(BigDecimal severity) {
        this.severity = severity;
    }

    public String getTablename() {
        return this.tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public BigDecimal getUserid() {
        return this.userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public ReportAck getIReportack() {
        return this.IReportack;
    }

    public void setIReportack(ReportAck IReportack) {
        this.IReportack = IReportack;
    }

}