package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the I_SUMMARY database table.
 * 
 */
@Entity
@Table(name = "I_SUMMARY")
@NamedQuery(name = "Summary.findAll", query = "SELECT s FROM Summary s")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "summary")
public class Summary implements Serializable {

    private static final long serialVersionUID = -2036493781447018899L;

    @Id
    @Column(name = "PK_SAFETYREPORT", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkSafetyreport;

    @Lob
    @XmlElement(name = "narrativeincludeclinical")
    private String narrativeincludeclinical;

    @Column(length = 2000)
    @XmlElement(name = "reportercomment")
    private String reportercomment;

    @Column(length = 2000)
    @XmlElement(name = "sendercomment")
    private String sendercomment;

    @Column(precision = 10)
    @XmlElement(name = "senderdiagnosis")
    private BigDecimal senderdiagnosis;

    @Column(precision = 10)
    @XmlTransient
    private BigDecimal senderdiagnosisct;

    @Column(precision = 22)
    @XmlElement(name = "senderdiagnosismeddraversion")
    private BigDecimal senderdiagnosismv;

    // bi-directional one-to-one association to Patient
    @OneToOne
    @JoinColumn(name = "PK_SAFETYREPORT", nullable = false, insertable = false, updatable = false)
    @XmlInverseReference(mappedBy = "ISummary")
    private Patient IPatient;

    public Summary() {
    }

    public long getPkSafetyreport() {
        return this.pkSafetyreport;
    }

    public void setPkSafetyreport(long pkSafetyreport) {
        this.pkSafetyreport = pkSafetyreport;
    }

    public String getNarrativeincludeclinical() {
        return this.narrativeincludeclinical;
    }

    public void setNarrativeincludeclinical(String narrativeincludeclinical) {
        this.narrativeincludeclinical = narrativeincludeclinical;
    }

    public String getReportercomment() {
        return this.reportercomment;
    }

    public void setReportercomment(String reportercomment) {
        this.reportercomment = reportercomment;
    }

    public String getSendercomment() {
        return this.sendercomment;
    }

    public void setSendercomment(String sendercomment) {
        this.sendercomment = sendercomment;
    }

    public BigDecimal getSenderdiagnosis() {
        return this.senderdiagnosis;
    }

    public void setSenderdiagnosis(BigDecimal senderdiagnosis) {
        this.senderdiagnosis = senderdiagnosis;
    }

    public BigDecimal getSenderdiagnosisct() {
        return this.senderdiagnosisct;
    }

    public void setSenderdiagnosisct(BigDecimal senderdiagnosisct) {
        this.senderdiagnosisct = senderdiagnosisct;
    }

    public BigDecimal getSenderdiagnosismv() {
        return this.senderdiagnosismv;
    }

    public void setSenderdiagnosismv(BigDecimal senderdiagnosismv) {
        this.senderdiagnosismv = senderdiagnosismv;
    }

    public Patient getIPatient() {
        return this.IPatient;
    }

    public void setIPatient(Patient IPatient) {
        this.IPatient = IPatient;
    }

}