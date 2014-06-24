package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_SUMMARY database table.
 * 
 */
@Entity
@Table(name="I_SUMMARY")
@NamedQuery(name="Summary.findAll", query="SELECT s FROM Summary s")
public class Summary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_SAFETYREPORT", unique=true, nullable=false, precision=10)
	private long pkSafetyreport;

	@Lob
	private String narrativeincludeclinical;

	@Column(length=2000)
	private String reportercomment;

	@Column(length=2000)
	private String sendercomment;

	@Column(precision=10)
	private BigDecimal senderdiagnosis;

	@Column(precision=10)
	private BigDecimal senderdiagnosisct;

	@Column(precision=22)
	private BigDecimal senderdiagnosismv;

	//bi-directional one-to-one association to Patient
	@OneToOne
	@JoinColumn(name="PK_SAFETYREPORT", nullable=false, insertable=false, updatable=false)
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