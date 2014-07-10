package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the I_SAFETYREPORTS database table.
 */
@Entity
@Table(name = "I_SAFETYREPORTS")
@NamedQuery(name = "SafetyReports.findAll", query = "SELECT s FROM SafetyReports s")
@IdClass(SafetyReportsPK.class)
public class SafetyReports implements Serializable {

    private static final long serialVersionUID = 2389207372789581954L;

    /**
     * Foreign key from SafetyReport
     */
    @Id
    @Column(name = "FK_SAFETYREPORT")
    //, insertable = false, updatable = false, unique = true, nullable = false, precision = 10)
    private long fkSafetyreport;

    /**
     * Foreign key from IchicsrMessage
     */
    @Id
    @Column(name = "FK_ICHICSRMESSAGE")
    //, insertable = false, updatable = false, unique = true, nullable = false, precision = 10)
    private long fkIchicsrmessage;

    /**
     * TODO: Reverse engigneering from database
     */
    @Column(precision = 22)
    private BigDecimal commitrollback;

    // bi-directional many-to-one association to IchicsrMessage
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ICHICSRMESSAGE", nullable = false, insertable = false, updatable = false)
    private IchicsrMessage ichicsrMessage;

    /**
     * bi-directional one-to-one association to SafetyReport
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SAFETYREPORT", nullable = false, insertable = false, updatable = false)
    private SafetyReport safetyReport;

    public SafetyReports() {
    }

    @PrePersist
    public void initializeForeigners() {
        if (safetyReport != null) {
            safetyReport.setISafetyreports(this);
        }
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

    public long getFkSafetyreport() {
        return fkSafetyreport;
    }

    public void setFkSafetyreport(long fkSafetyreport) {
        this.fkSafetyreport = fkSafetyreport;
    }

    public long getFkIchicsrmessage() {
        return fkIchicsrmessage;
    }

    public void setFkIchicsrmessage(long fkIchicsrmessage) {
        this.fkIchicsrmessage = fkIchicsrmessage;
    }

}