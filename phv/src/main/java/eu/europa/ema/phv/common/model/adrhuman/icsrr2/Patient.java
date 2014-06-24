package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the I_PATIENT database table.
 * 
 */
@Entity
@Table(name="I_PATIENT")
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_SAFETYREPORT", unique=true, nullable=false, precision=10)
	private long pkSafetyreport;

	@Column(precision=22)
	private BigDecimal gestationperiod;

	@Column(precision=3)
	private BigDecimal gestationperiodunit;

	@Column(precision=3)
	private BigDecimal lastmenstrualdateformat;

	@Column(precision=1)
	private BigDecimal patientagegroup;

	@Column(length=56)
	private String patientbirthdate;

	@Column(precision=3)
	private BigDecimal patientbirthdateformat;

	@Column(length=80)
	private String patientgpmedicalrecordnumb;

	@Column(precision=22)
	private BigDecimal patientheight;

	@Column(length=80)
	private String patienthospitalrecordnumb;

	@Column(length=40)
	private String patientinitial;

	@Column(length=80)
	private String patientinvestigationnumb;

	@Column(length=56)
	private String patientlastmenstrualdate;

	@Lob
	private String patientmedicalhistorytext;

	@Column(precision=22)
	private BigDecimal patientonsetage;

	@Column(precision=3)
	private BigDecimal patientonsetageunit;

	@Column(precision=1)
	private BigDecimal patientsex;

	@Column(length=80)
	private String patientspecialistrecordnumb;

	@Column(precision=22)
	private BigDecimal patientweight;

	@Column(length=4000)
	private String resultstestsprocedures;

	//bi-directional many-to-one association to Drug
	@OneToMany(mappedBy="IPatient")
	private List<Drug> IDrugs;

	//bi-directional many-to-one association to DrugInterpreted
	@OneToMany(mappedBy="IPatient")
	private List<DrugInterpreted> IDruginterpreteds;

	//bi-directional one-to-one association to IParent
	@OneToOne(mappedBy="IPatient")
	private IParent IParent;

	//bi-directional one-to-one association to SafetyReport
	@OneToOne
	@JoinColumn(name="PK_SAFETYREPORT", nullable=false, insertable=false, updatable=false)
	private SafetyReport ISafetyreport;

	//bi-directional one-to-one association to PatientDeath
	@OneToOne(mappedBy="IPatient")
	private PatientDeath IPatientdeath;

	//bi-directional many-to-one association to PatientMedicalHistory
	@OneToMany(mappedBy="IPatient")
	private List<PatientMedicalHistory> IPatientmedicalhistories;

	//bi-directional many-to-one association to PatientPastDrugTherapy
	@OneToMany(mappedBy="IPatient")
	private List<PatientPastDrugTherapy> IPatientpastdrugtherapies;

	//bi-directional many-to-one association to Reaction
	@OneToMany(mappedBy="IPatient")
	private List<Reaction> IReactions;

	//bi-directional one-to-one association to Summary
	@OneToOne(mappedBy="IPatient")
	private Summary ISummary;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="IPatient")
	private List<Test> ITests;

	public Patient() {
	}

	public long getPkSafetyreport() {
		return this.pkSafetyreport;
	}

	public void setPkSafetyreport(long pkSafetyreport) {
		this.pkSafetyreport = pkSafetyreport;
	}

	public BigDecimal getGestationperiod() {
		return this.gestationperiod;
	}

	public void setGestationperiod(BigDecimal gestationperiod) {
		this.gestationperiod = gestationperiod;
	}

	public BigDecimal getGestationperiodunit() {
		return this.gestationperiodunit;
	}

	public void setGestationperiodunit(BigDecimal gestationperiodunit) {
		this.gestationperiodunit = gestationperiodunit;
	}

	public BigDecimal getLastmenstrualdateformat() {
		return this.lastmenstrualdateformat;
	}

	public void setLastmenstrualdateformat(BigDecimal lastmenstrualdateformat) {
		this.lastmenstrualdateformat = lastmenstrualdateformat;
	}

	public BigDecimal getPatientagegroup() {
		return this.patientagegroup;
	}

	public void setPatientagegroup(BigDecimal patientagegroup) {
		this.patientagegroup = patientagegroup;
	}

	public String getPatientbirthdate() {
		return this.patientbirthdate;
	}

	public void setPatientbirthdate(String patientbirthdate) {
		this.patientbirthdate = patientbirthdate;
	}

	public BigDecimal getPatientbirthdateformat() {
		return this.patientbirthdateformat;
	}

	public void setPatientbirthdateformat(BigDecimal patientbirthdateformat) {
		this.patientbirthdateformat = patientbirthdateformat;
	}

	public String getPatientgpmedicalrecordnumb() {
		return this.patientgpmedicalrecordnumb;
	}

	public void setPatientgpmedicalrecordnumb(String patientgpmedicalrecordnumb) {
		this.patientgpmedicalrecordnumb = patientgpmedicalrecordnumb;
	}

	public BigDecimal getPatientheight() {
		return this.patientheight;
	}

	public void setPatientheight(BigDecimal patientheight) {
		this.patientheight = patientheight;
	}

	public String getPatienthospitalrecordnumb() {
		return this.patienthospitalrecordnumb;
	}

	public void setPatienthospitalrecordnumb(String patienthospitalrecordnumb) {
		this.patienthospitalrecordnumb = patienthospitalrecordnumb;
	}

	public String getPatientinitial() {
		return this.patientinitial;
	}

	public void setPatientinitial(String patientinitial) {
		this.patientinitial = patientinitial;
	}

	public String getPatientinvestigationnumb() {
		return this.patientinvestigationnumb;
	}

	public void setPatientinvestigationnumb(String patientinvestigationnumb) {
		this.patientinvestigationnumb = patientinvestigationnumb;
	}

	public String getPatientlastmenstrualdate() {
		return this.patientlastmenstrualdate;
	}

	public void setPatientlastmenstrualdate(String patientlastmenstrualdate) {
		this.patientlastmenstrualdate = patientlastmenstrualdate;
	}

	public String getPatientmedicalhistorytext() {
		return this.patientmedicalhistorytext;
	}

	public void setPatientmedicalhistorytext(String patientmedicalhistorytext) {
		this.patientmedicalhistorytext = patientmedicalhistorytext;
	}

	public BigDecimal getPatientonsetage() {
		return this.patientonsetage;
	}

	public void setPatientonsetage(BigDecimal patientonsetage) {
		this.patientonsetage = patientonsetage;
	}

	public BigDecimal getPatientonsetageunit() {
		return this.patientonsetageunit;
	}

	public void setPatientonsetageunit(BigDecimal patientonsetageunit) {
		this.patientonsetageunit = patientonsetageunit;
	}

	public BigDecimal getPatientsex() {
		return this.patientsex;
	}

	public void setPatientsex(BigDecimal patientsex) {
		this.patientsex = patientsex;
	}

	public String getPatientspecialistrecordnumb() {
		return this.patientspecialistrecordnumb;
	}

	public void setPatientspecialistrecordnumb(String patientspecialistrecordnumb) {
		this.patientspecialistrecordnumb = patientspecialistrecordnumb;
	}

	public BigDecimal getPatientweight() {
		return this.patientweight;
	}

	public void setPatientweight(BigDecimal patientweight) {
		this.patientweight = patientweight;
	}

	public String getResultstestsprocedures() {
		return this.resultstestsprocedures;
	}

	public void setResultstestsprocedures(String resultstestsprocedures) {
		this.resultstestsprocedures = resultstestsprocedures;
	}

	public List<Drug> getIDrugs() {
		return this.IDrugs;
	}

	public void setIDrugs(List<Drug> IDrugs) {
		this.IDrugs = IDrugs;
	}

	public Drug addIDrug(Drug IDrug) {
		getIDrugs().add(IDrug);
		IDrug.setIPatient(this);

		return IDrug;
	}

	public Drug removeIDrug(Drug IDrug) {
		getIDrugs().remove(IDrug);
		IDrug.setIPatient(null);

		return IDrug;
	}

	public List<DrugInterpreted> getIDruginterpreteds() {
		return this.IDruginterpreteds;
	}

	public void setIDruginterpreteds(List<DrugInterpreted> IDruginterpreteds) {
		this.IDruginterpreteds = IDruginterpreteds;
	}

	public DrugInterpreted addIDruginterpreted(DrugInterpreted IDruginterpreted) {
		getIDruginterpreteds().add(IDruginterpreted);
		IDruginterpreted.setIPatient(this);

		return IDruginterpreted;
	}

	public DrugInterpreted removeIDruginterpreted(DrugInterpreted IDruginterpreted) {
		getIDruginterpreteds().remove(IDruginterpreted);
		IDruginterpreted.setIPatient(null);

		return IDruginterpreted;
	}

	public IParent getIParent() {
		return this.IParent;
	}

	public void setIParent(IParent IParent) {
		this.IParent = IParent;
	}

	public SafetyReport getISafetyreport() {
		return this.ISafetyreport;
	}

	public void setISafetyreport(SafetyReport ISafetyreport) {
		this.ISafetyreport = ISafetyreport;
	}

	public PatientDeath getIPatientdeath() {
		return this.IPatientdeath;
	}

	public void setIPatientdeath(PatientDeath IPatientdeath) {
		this.IPatientdeath = IPatientdeath;
	}

	public List<PatientMedicalHistory> getIPatientmedicalhistories() {
		return this.IPatientmedicalhistories;
	}

	public void setIPatientmedicalhistories(List<PatientMedicalHistory> IPatientmedicalhistories) {
		this.IPatientmedicalhistories = IPatientmedicalhistories;
	}

	public PatientMedicalHistory addIPatientmedicalhistory(PatientMedicalHistory IPatientmedicalhistory) {
		getIPatientmedicalhistories().add(IPatientmedicalhistory);
		IPatientmedicalhistory.setIPatient(this);

		return IPatientmedicalhistory;
	}

	public PatientMedicalHistory removeIPatientmedicalhistory(PatientMedicalHistory IPatientmedicalhistory) {
		getIPatientmedicalhistories().remove(IPatientmedicalhistory);
		IPatientmedicalhistory.setIPatient(null);

		return IPatientmedicalhistory;
	}

	public List<PatientPastDrugTherapy> getIPatientpastdrugtherapies() {
		return this.IPatientpastdrugtherapies;
	}

	public void setIPatientpastdrugtherapies(List<PatientPastDrugTherapy> IPatientpastdrugtherapies) {
		this.IPatientpastdrugtherapies = IPatientpastdrugtherapies;
	}

	public PatientPastDrugTherapy addIPatientpastdrugtherapy(PatientPastDrugTherapy IPatientpastdrugtherapy) {
		getIPatientpastdrugtherapies().add(IPatientpastdrugtherapy);
		IPatientpastdrugtherapy.setIPatient(this);

		return IPatientpastdrugtherapy;
	}

	public PatientPastDrugTherapy removeIPatientpastdrugtherapy(PatientPastDrugTherapy IPatientpastdrugtherapy) {
		getIPatientpastdrugtherapies().remove(IPatientpastdrugtherapy);
		IPatientpastdrugtherapy.setIPatient(null);

		return IPatientpastdrugtherapy;
	}

	public List<Reaction> getIReactions() {
		return this.IReactions;
	}

	public void setIReactions(List<Reaction> IReactions) {
		this.IReactions = IReactions;
	}

	public Reaction addIReaction(Reaction IReaction) {
		getIReactions().add(IReaction);
		IReaction.setIPatient(this);

		return IReaction;
	}

	public Reaction removeIReaction(Reaction IReaction) {
		getIReactions().remove(IReaction);
		IReaction.setIPatient(null);

		return IReaction;
	}

	public Summary getISummary() {
		return this.ISummary;
	}

	public void setISummary(Summary ISummary) {
		this.ISummary = ISummary;
	}

	public List<Test> getITests() {
		return this.ITests;
	}

	public void setITests(List<Test> ITests) {
		this.ITests = ITests;
	}

	public Test addITest(Test ITest) {
		getITests().add(ITest);
		ITest.setIPatient(this);

		return ITest;
	}

	public Test removeITest(Test ITest) {
		getITests().remove(ITest);
		ITest.setIPatient(null);

		return ITest;
	}

}