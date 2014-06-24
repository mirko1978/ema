package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_PATIENTAUTOPSY database table.
 * 
 */
@Entity
@Table(name="I_PATIENTAUTOPSY")
@NamedQuery(name="PatientAutopsy.findAll", query="SELECT p FROM PatientAutopsy p")
public class PatientAutopsy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_PATIENTAUTOPSY", unique=true, nullable=false, precision=10)
	private long pkPatientautopsy;

	@Column(precision=22)
	private BigDecimal patientdetermautopsmv;

	@Column(precision=10)
	private BigDecimal patientdetermineautopsy;

	@Column(precision=10)
	private BigDecimal patientdetermineautopsyct;

	//bi-directional many-to-one association to PatientDeath
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
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