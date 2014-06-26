package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the I_SAFETYREPORTS database table.
 * 
 */
@Entity
@Table(name = "I_SAFETYREPORTS")
@NamedQuery(name = "SafetyReports.findAll", query = "SELECT s FROM SafetyReports s")
//@XmlAccessorType(XmlAccessType.FIELD)
public class SafetyReports implements Serializable {

    private static final long serialVersionUID = 2389207372789581954L;

    @EmbeddedId
//    @XmlTransient
    private SafetyReportsPK id;

    @Column(precision = 22)
//    @XmlTransient
    private BigDecimal commitrollback;

    // bi-directional many-to-one association to IchicsrMessage
    @ManyToOne
    @JoinColumn(name = "FK_ICHICSRMESSAGE", nullable = false, insertable = false, updatable = false)
//    @XmlInverseReference(mappedBy = "safetyReports")
    private IchicsrMessage ichicsrMessage;

    // bi-directional many-to-one association to SafetyReport
    @ManyToOne
    @JoinColumn(name = "FK_SAFETYREPORT", nullable = false, insertable = false, updatable = false)
//    @XmlElement(name = "safetyreport")
    private SafetyReport safetyReport;

    public SafetyReports() {
    }

    public SafetyReportsPK getId() {
        return this.id;
    }

    public void setId(SafetyReportsPK id) {
        this.id = id;
    }

    public BigDecimal getCommitrollback() {
        return this.commitrollback;
    }

    public void setCommitrollback(BigDecimal commitrollback) {
        this.commitrollback = commitrollback;
    }

    public IchicsrMessage getIchicsrMessage() {
        return this.ichicsrMessage;
    }

    public void setIchicsrMessage(IchicsrMessage IIchicsrmessage) {
        this.ichicsrMessage = IIchicsrmessage;
    }

    public SafetyReport getSafetyReport() {
        return this.safetyReport;
    }

    public void setSafetyReport(SafetyReport ISafetyreport) {
        this.safetyReport = ISafetyreport;
    }

}