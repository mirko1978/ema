package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the I_PATIENTDEATH database table.
 * 
 */
@Entity
@Table(name = "I_PATIENTDEATH")
@NamedQuery(name = "PatientDeath.findAll", query = "SELECT p FROM PatientDeath p")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "patientdeath")
public class PatientDeath implements Serializable {
    private static final long serialVersionUID = 973264161185359482L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_SAFETYREPORT", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkSafetyreport;

    @Column(precision = 1)
    @XmlElement(name = "patientautopsyyesno")
    private BigDecimal patientautopsyyesno;

    @Column(length = 14)
    @XmlElement(name = "patientdeathdate")
    private String patientdeathdate;

    @Column(precision = 3)
    @XmlElement(name = "patientdeathdateformat")
    private BigDecimal patientdeathdateformat;

    // bi-directional many-to-one association to PatientAutopsy
    @OneToMany(mappedBy = "IPatientdeath")
    @XmlElement(name = "patientautopsy")
    private List<PatientAutopsy> IPatientautopsies;

    // bi-directional one-to-one association to Patient
    @OneToOne
    @JoinColumn(name = "PK_SAFETYREPORT", nullable = false, insertable = false, updatable = false)
    @XmlInverseReference(mappedBy = "IPatientdeath")
    private Patient IPatient;

    // bi-directional many-to-one association to PatientDeathCause
    @OneToMany(mappedBy = "IPatientdeath")
    @XmlElement(name = "patientdeathcause")
    private List<PatientDeathCause> IPatientdeathcauses;

    public PatientDeath() {
    }

    public long getPkSafetyreport() {
        return this.pkSafetyreport;
    }

    public void setPkSafetyreport(long pkSafetyreport) {
        this.pkSafetyreport = pkSafetyreport;
    }

    public BigDecimal getPatientautopsyyesno() {
        return this.patientautopsyyesno;
    }

    public void setPatientautopsyyesno(BigDecimal patientautopsyyesno) {
        this.patientautopsyyesno = patientautopsyyesno;
    }

    public String getPatientdeathdate() {
        return this.patientdeathdate;
    }

    public void setPatientdeathdate(String patientdeathdate) {
        this.patientdeathdate = patientdeathdate;
    }

    public BigDecimal getPatientdeathdateformat() {
        return this.patientdeathdateformat;
    }

    public void setPatientdeathdateformat(BigDecimal patientdeathdateformat) {
        this.patientdeathdateformat = patientdeathdateformat;
    }

    public List<PatientAutopsy> getIPatientautopsies() {
        return this.IPatientautopsies;
    }

    public void setIPatientautopsies(List<PatientAutopsy> IPatientautopsies) {
        this.IPatientautopsies = IPatientautopsies;
    }

    public PatientAutopsy addIPatientautopsy(PatientAutopsy IPatientautopsy) {
        getIPatientautopsies().add(IPatientautopsy);
        IPatientautopsy.setIPatientdeath(this);

        return IPatientautopsy;
    }

    public PatientAutopsy removeIPatientautopsy(PatientAutopsy IPatientautopsy) {
        getIPatientautopsies().remove(IPatientautopsy);
        IPatientautopsy.setIPatientdeath(null);

        return IPatientautopsy;
    }

    public Patient getIPatient() {
        return this.IPatient;
    }

    public void setIPatient(Patient IPatient) {
        this.IPatient = IPatient;
    }

    public List<PatientDeathCause> getIPatientdeathcauses() {
        return this.IPatientdeathcauses;
    }

    public void setIPatientdeathcauses(List<PatientDeathCause> IPatientdeathcauses) {
        this.IPatientdeathcauses = IPatientdeathcauses;
    }

    public PatientDeathCause addIPatientdeathcaus(PatientDeathCause IPatientdeathcaus) {
        getIPatientdeathcauses().add(IPatientdeathcaus);
        IPatientdeathcaus.setIPatientdeath(this);

        return IPatientdeathcaus;
    }

    public PatientDeathCause removeIPatientdeathcaus(PatientDeathCause IPatientdeathcaus) {
        getIPatientdeathcauses().remove(IPatientdeathcaus);
        IPatientdeathcaus.setIPatientdeath(null);

        return IPatientdeathcaus;
    }

}