package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_PATIENTDEATHCAUSE database table.
 * 
 */
@Entity
@Table(name="I_PATIENTDEATHCAUSE")
@NamedQuery(name="PatientDeathCause.findAll", query="SELECT p FROM PatientDeathCause p")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "patientdeathcause")
public class PatientDeathCause implements Serializable {
    private static final long serialVersionUID = -7413186390803730426L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_PATIENTDEATHCAUSE", unique=true, nullable=false, precision=10)
    @XmlTransient
	private long pkPatientdeathcause;

	@Column(precision=10)
    @XmlElement(name = "patientdeathreport")
	private BigDecimal patientdeathreport;

	@Column(precision=10)
    @XmlTransient
	private BigDecimal patientdeathreportct;

	@Column(precision=22)
    @XmlElement(name = "patientdeathreportmeddraversion")
	private BigDecimal patientdeathreportmv;

	//bi-directional many-to-one association to PatientDeath
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
    @XmlInverseReference(mappedBy = "IPatientdeathcauses")
	private PatientDeath IPatientdeath;

	public PatientDeathCause() {
	}

	public long getPkPatientdeathcause() {
		return this.pkPatientdeathcause;
	}

	public void setPkPatientdeathcause(long pkPatientdeathcause) {
		this.pkPatientdeathcause = pkPatientdeathcause;
	}

	public BigDecimal getPatientdeathreport() {
		return this.patientdeathreport;
	}

	public void setPatientdeathreport(BigDecimal patientdeathreport) {
		this.patientdeathreport = patientdeathreport;
	}

	public BigDecimal getPatientdeathreportct() {
		return this.patientdeathreportct;
	}

	public void setPatientdeathreportct(BigDecimal patientdeathreportct) {
		this.patientdeathreportct = patientdeathreportct;
	}

	public BigDecimal getPatientdeathreportmv() {
		return this.patientdeathreportmv;
	}

	public void setPatientdeathreportmv(BigDecimal patientdeathreportmv) {
		this.patientdeathreportmv = patientdeathreportmv;
	}

	public PatientDeath getIPatientdeath() {
		return this.IPatientdeath;
	}

	public void setIPatientdeath(PatientDeath IPatientdeath) {
		this.IPatientdeath = IPatientdeath;
	}

}