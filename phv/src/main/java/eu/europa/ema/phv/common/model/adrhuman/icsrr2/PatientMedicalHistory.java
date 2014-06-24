package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_PATIENTMEDICALHISTORY database table.
 * 
 */
@Entity
@Table(name="I_PATIENTMEDICALHISTORY")
@NamedQuery(name="PatientMedicalHistory.findAll", query="SELECT p FROM PatientMedicalHistory p")
public class PatientMedicalHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_PATIENTMEDICALHISTORYEPIS", unique=true, nullable=false, precision=10)
	private long pkPatientmedicalhistoryepis;

	@Column(precision=10)
	private BigDecimal patientepisodename;

	@Column(precision=10)
	private BigDecimal patientepisodenamect;

	@Column(precision=22)
	private BigDecimal patientepisodenamemv;

	@Column(length=2000)
	private String patientmedicalcomment;

	@Column(precision=1)
	private BigDecimal patientmedicalcontinue;

	@Column(length=14)
	private String patientmedicalenddate;

	@Column(precision=3)
	private BigDecimal patientmedicalenddateformat;

	@Column(length=14)
	private String patientmedicalstartdate;

	@Column(precision=3)
	private BigDecimal patientmedicalstartdateformat;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
	private Patient IPatient;

	public PatientMedicalHistory() {
	}

	public long getPkPatientmedicalhistoryepis() {
		return this.pkPatientmedicalhistoryepis;
	}

	public void setPkPatientmedicalhistoryepis(long pkPatientmedicalhistoryepis) {
		this.pkPatientmedicalhistoryepis = pkPatientmedicalhistoryepis;
	}

	public BigDecimal getPatientepisodename() {
		return this.patientepisodename;
	}

	public void setPatientepisodename(BigDecimal patientepisodename) {
		this.patientepisodename = patientepisodename;
	}

	public BigDecimal getPatientepisodenamect() {
		return this.patientepisodenamect;
	}

	public void setPatientepisodenamect(BigDecimal patientepisodenamect) {
		this.patientepisodenamect = patientepisodenamect;
	}

	public BigDecimal getPatientepisodenamemv() {
		return this.patientepisodenamemv;
	}

	public void setPatientepisodenamemv(BigDecimal patientepisodenamemv) {
		this.patientepisodenamemv = patientepisodenamemv;
	}

	public String getPatientmedicalcomment() {
		return this.patientmedicalcomment;
	}

	public void setPatientmedicalcomment(String patientmedicalcomment) {
		this.patientmedicalcomment = patientmedicalcomment;
	}

	public BigDecimal getPatientmedicalcontinue() {
		return this.patientmedicalcontinue;
	}

	public void setPatientmedicalcontinue(BigDecimal patientmedicalcontinue) {
		this.patientmedicalcontinue = patientmedicalcontinue;
	}

	public String getPatientmedicalenddate() {
		return this.patientmedicalenddate;
	}

	public void setPatientmedicalenddate(String patientmedicalenddate) {
		this.patientmedicalenddate = patientmedicalenddate;
	}

	public BigDecimal getPatientmedicalenddateformat() {
		return this.patientmedicalenddateformat;
	}

	public void setPatientmedicalenddateformat(BigDecimal patientmedicalenddateformat) {
		this.patientmedicalenddateformat = patientmedicalenddateformat;
	}

	public String getPatientmedicalstartdate() {
		return this.patientmedicalstartdate;
	}

	public void setPatientmedicalstartdate(String patientmedicalstartdate) {
		this.patientmedicalstartdate = patientmedicalstartdate;
	}

	public BigDecimal getPatientmedicalstartdateformat() {
		return this.patientmedicalstartdateformat;
	}

	public void setPatientmedicalstartdateformat(BigDecimal patientmedicalstartdateformat) {
		this.patientmedicalstartdateformat = patientmedicalstartdateformat;
	}

	public Patient getIPatient() {
		return this.IPatient;
	}

	public void setIPatient(Patient IPatient) {
		this.IPatient = IPatient;
	}

}