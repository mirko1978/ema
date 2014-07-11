package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the I_PATIENTAUTOPSY database table.
 */
@Entity
@Table(name = "I_PATIENTAUTOPSY")
@NamedQuery(name = "PatientAutopsy.findAll", query = "SELECT p FROM PatientAutopsy p")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "patientautopsy")
public class PatientAutopsy implements Serializable {

    private static final long serialVersionUID = 366638283225756012L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PatientAutopsy")
    @SequenceGenerator(name = "PatientAutopsy", sequenceName = "SEQ_PATIENTAUTOPSY", allocationSize = 1)
    @Column(name = "PK_PATIENTAUTOPSY", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkPatientautopsy;

    @Column(precision = 22)
    @XmlElement(name = "patientdetermautopsmeddraversion")
    private BigDecimal patientdetermautopsmv;

    @Column(precision = 10)
    @XmlElement(name = "patientdetermineautopsy")
    private BigDecimal patientdetermineautopsy;

    @Column(precision = 10)
    @XmlTransient
    private BigDecimal patientdetermineautopsyct;

    // bi-directional many-to-one association to PatientDeath
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SAFETYREPORT", nullable = false)
    @XmlInverseReference(mappedBy = "IPatientautopsies")
    private PatientDeath IPatientdeath;

    public PatientAutopsy() {
    }

    public long getPkPatientautopsy() {
        return this.pkPatientautopsy;
    }

    public void setPkPatientautopsy(long pkPatientautopsy) {
        this.pkPatientautopsy = pkPatientautopsy;
    }

    public BigDecimal getPatientdetermautopsmv() {
        return this.patientdetermautopsmv;
    }

    public void setPatientdetermautopsmv(BigDecimal patientdetermautopsmv) {
        this.patientdetermautopsmv = patientdetermautopsmv;
    }

    public BigDecimal getPatientdetermineautopsy() {
        return this.patientdetermineautopsy;
    }

    public void setPatientdetermineautopsy(BigDecimal patientdetermineautopsy) {
        this.patientdetermineautopsy = patientdetermineautopsy;
    }

    public BigDecimal getPatientdetermineautopsyct() {
        return this.patientdetermineautopsyct;
    }

    public void setPatientdetermineautopsyct(BigDecimal patientdetermineautopsyct) {
        this.patientdetermineautopsyct = patientdetermineautopsyct;
    }

    public PatientDeath getIPatientdeath() {
        return this.IPatientdeath;
    }

    public void setIPatientdeath(PatientDeath IPatientdeath) {
        this.IPatientdeath = IPatientdeath;
    }

}
