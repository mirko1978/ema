package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the I_DRUG database table.
 * 
 */
@Entity
@Table(name="I_DRUG")
@NamedQuery(name="Drug.findAll", query="SELECT d FROM Drug d")
public class Drug implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_DRUG", unique=true, nullable=false, precision=10)
	private long pkDrug;

	@Column(precision=1)
	private BigDecimal actiondrug;

	@Column(precision=1)
	private BigDecimal blinded;

	@Column(precision=1)
	private BigDecimal blindedmrec;

	@Column(length=100)
	private String drugadditional;

	@Column(precision=3)
	private BigDecimal drugadministrationroute;

	@Column(length=2)
	private String drugauthorizationcountry;

	@Column(length=60)
	private String drugauthorizationholder;

	@Column(length=35)
	private String drugauthorizationnumb;

	@Column(length=35)
	private String drugbatchnumb;

	@Column(precision=1)
	private BigDecimal drugcharacterization;

	@Column(precision=22)
	private BigDecimal drugcumulativedosagenumb;

	@Column(precision=3)
	private BigDecimal drugcumulativedosageunit;

	@Column(length=100)
	private String drugdosageform;

	@Column(precision=3)
	private BigDecimal drugdosageformcode;

	@Column(length=100)
	private String drugdosagetext;

	@Column(length=14)
	private String drugenddate;

	@Column(precision=3)
	private BigDecimal drugenddateformat;

	@Column(precision=10)
	private BigDecimal drugindication;

	@Column(precision=10)
	private BigDecimal drugindicationct;

	@Column(precision=1)
	private BigDecimal drugindicationmrec;

	@Column(precision=22)
	private BigDecimal drugindicationmv;

	@Column(length=250)
	private String drugindicationrecoded;

	@Column(length=250)
	private String drugindicationtext;

	@Column(precision=3)
	private BigDecimal drugintervaldosagedefinition;

	@Column(precision=22)
	private BigDecimal drugintervaldosageunitnumb;

	@Column(precision=22)
	private BigDecimal druglastperiod;

	@Column(precision=3)
	private BigDecimal druglastperiodunit;

	@Column(precision=3)
	private BigDecimal drugparadministration;

	@Column(precision=1)
	private BigDecimal drugrecurreadministration;

	@Column(precision=22)
	private BigDecimal drugseparatedosagenumb;

	@Column(length=14)
	private String drugstartdate;

	@Column(precision=3)
	private BigDecimal drugstartdateformat;

	@Column(precision=22)
	private BigDecimal drugstartperiod;

	@Column(precision=3)
	private BigDecimal drugstartperiodunit;

	@Column(precision=22)
	private BigDecimal drugstructuredosagenumb;

	@Column(precision=3)
	private BigDecimal drugstructuredosageunit;

	@Column(precision=22)
	private BigDecimal drugtreatmentduration;

	@Column(precision=3)
	private BigDecimal drugtreatmentdurationunit;

	@Column(name="FK_MODELDRUG", precision=10)
	private BigDecimal fkModeldrug;

	@Column(name="FK_QIDRUGINDICATION", precision=10)
	private BigDecimal fkQidrugindication;

	@Column(name="FK_QIMEDICINALPRODUCT", precision=10)
	private BigDecimal fkQimedicinalproduct;

	@Column(precision=22)
	private BigDecimal isblindedchanged;

	@Column(precision=1)
	private BigDecimal isdrugindicationchanged;

	@Column(precision=1)
	private BigDecimal isdrugindicationrecoded;

	@Column(precision=1)
	private BigDecimal ismedicinalproductchanged;

	@Column(precision=1)
	private BigDecimal ismedicinalproductrecoded;

	@Column(length=200)
	private String medicinalproduct;

	@Column(precision=1)
	private BigDecimal medicinalproductmrec;

	@Column(length=200)
	private String medicinalproductrecoded;

	@Column(length=2)
	private String obtaindrugcountry;

	@Column(name="PRODUCT_EVCODE", length=60)
	private String productEvcode;

	@Column(precision=10)
	private BigDecimal productindexcode;

	@Column(precision=22)
	private BigDecimal reactiongestationperiod;

	@Column(precision=3)
	private BigDecimal reactiongestationperiodunit;

	@Column(name="REC_CHANGED", precision=1)
	private BigDecimal recChanged;

	@Column(name="RECODING_STAGE", precision=22)
	private BigDecimal recodingStage;

	@Temporal(TemporalType.DATE)
	@Column(name="RECODING_STAMP")
	private Date recodingStamp;

	//bi-directional many-to-one association to ActiveSubstance
	@OneToMany(mappedBy="IDrug")
	private List<ActiveSubstance> IActivesubstances;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
	private Patient IPatient;

	//bi-directional many-to-one association to DrugInterpreted
	@OneToMany(mappedBy="IDrug")
	private List<DrugInterpreted> IDruginterpreteds;

	//bi-directional many-to-one association to DrugreActionRelated
	@OneToMany(mappedBy="IDrug")
	private List<DrugreActionRelated> IDrugreactionrelateds;

	//bi-directional many-to-one association to DrugreCurrence
	@OneToMany(mappedBy="IDrug")
	private List<DrugreCurrence> IDrugrecurrences;

	public Drug() {
	}

	public long getPkDrug() {
		return this.pkDrug;
	}

	public void setPkDrug(long pkDrug) {
		this.pkDrug = pkDrug;
	}

	public BigDecimal getActiondrug() {
		return this.actiondrug;
	}

	public void setActiondrug(BigDecimal actiondrug) {
		this.actiondrug = actiondrug;
	}

	public BigDecimal getBlinded() {
		return this.blinded;
	}

	public void setBlinded(BigDecimal blinded) {
		this.blinded = blinded;
	}

	public BigDecimal getBlindedmrec() {
		return this.blindedmrec;
	}

	public void setBlindedmrec(BigDecimal blindedmrec) {
		this.blindedmrec = blindedmrec;
	}

	public String getDrugadditional() {
		return this.drugadditional;
	}

	public void setDrugadditional(String drugadditional) {
		this.drugadditional = drugadditional;
	}

	public BigDecimal getDrugadministrationroute() {
		return this.drugadministrationroute;
	}

	public void setDrugadministrationroute(BigDecimal drugadministrationroute) {
		this.drugadministrationroute = drugadministrationroute;
	}

	public String getDrugauthorizationcountry() {
		return this.drugauthorizationcountry;
	}

	public void setDrugauthorizationcountry(String drugauthorizationcountry) {
		this.drugauthorizationcountry = drugauthorizationcountry;
	}

	public String getDrugauthorizationholder() {
		return this.drugauthorizationholder;
	}

	public void setDrugauthorizationholder(String drugauthorizationholder) {
		this.drugauthorizationholder = drugauthorizationholder;
	}

	public String getDrugauthorizationnumb() {
		return this.drugauthorizationnumb;
	}

	public void setDrugauthorizationnumb(String drugauthorizationnumb) {
		this.drugauthorizationnumb = drugauthorizationnumb;
	}

	public String getDrugbatchnumb() {
		return this.drugbatchnumb;
	}

	public void setDrugbatchnumb(String drugbatchnumb) {
		this.drugbatchnumb = drugbatchnumb;
	}

	public BigDecimal getDrugcharacterization() {
		return this.drugcharacterization;
	}

	public void setDrugcharacterization(BigDecimal drugcharacterization) {
		this.drugcharacterization = drugcharacterization;
	}

	public BigDecimal getDrugcumulativedosagenumb() {
		return this.drugcumulativedosagenumb;
	}

	public void setDrugcumulativedosagenumb(BigDecimal drugcumulativedosagenumb) {
		this.drugcumulativedosagenumb = drugcumulativedosagenumb;
	}

	public BigDecimal getDrugcumulativedosageunit() {
		return this.drugcumulativedosageunit;
	}

	public void setDrugcumulativedosageunit(BigDecimal drugcumulativedosageunit) {
		this.drugcumulativedosageunit = drugcumulativedosageunit;
	}

	public String getDrugdosageform() {
		return this.drugdosageform;
	}

	public void setDrugdosageform(String drugdosageform) {
		this.drugdosageform = drugdosageform;
	}

	public BigDecimal getDrugdosageformcode() {
		return this.drugdosageformcode;
	}

	public void setDrugdosageformcode(BigDecimal drugdosageformcode) {
		this.drugdosageformcode = drugdosageformcode;
	}

	public String getDrugdosagetext() {
		return this.drugdosagetext;
	}

	public void setDrugdosagetext(String drugdosagetext) {
		this.drugdosagetext = drugdosagetext;
	}

	public String getDrugenddate() {
		return this.drugenddate;
	}

	public void setDrugenddate(String drugenddate) {
		this.drugenddate = drugenddate;
	}

	public BigDecimal getDrugenddateformat() {
		return this.drugenddateformat;
	}

	public void setDrugenddateformat(BigDecimal drugenddateformat) {
		this.drugenddateformat = drugenddateformat;
	}

	public BigDecimal getDrugindication() {
		return this.drugindication;
	}

	public void setDrugindication(BigDecimal drugindication) {
		this.drugindication = drugindication;
	}

	public BigDecimal getDrugindicationct() {
		return this.drugindicationct;
	}

	public void setDrugindicationct(BigDecimal drugindicationct) {
		this.drugindicationct = drugindicationct;
	}

	public BigDecimal getDrugindicationmrec() {
		return this.drugindicationmrec;
	}

	public void setDrugindicationmrec(BigDecimal drugindicationmrec) {
		this.drugindicationmrec = drugindicationmrec;
	}

	public BigDecimal getDrugindicationmv() {
		return this.drugindicationmv;
	}

	public void setDrugindicationmv(BigDecimal drugindicationmv) {
		this.drugindicationmv = drugindicationmv;
	}

	public String getDrugindicationrecoded() {
		return this.drugindicationrecoded;
	}

	public void setDrugindicationrecoded(String drugindicationrecoded) {
		this.drugindicationrecoded = drugindicationrecoded;
	}

	public String getDrugindicationtext() {
		return this.drugindicationtext;
	}

	public void setDrugindicationtext(String drugindicationtext) {
		this.drugindicationtext = drugindicationtext;
	}

	public BigDecimal getDrugintervaldosagedefinition() {
		return this.drugintervaldosagedefinition;
	}

	public void setDrugintervaldosagedefinition(BigDecimal drugintervaldosagedefinition) {
		this.drugintervaldosagedefinition = drugintervaldosagedefinition;
	}

	public BigDecimal getDrugintervaldosageunitnumb() {
		return this.drugintervaldosageunitnumb;
	}

	public void setDrugintervaldosageunitnumb(BigDecimal drugintervaldosageunitnumb) {
		this.drugintervaldosageunitnumb = drugintervaldosageunitnumb;
	}

	public BigDecimal getDruglastperiod() {
		return this.druglastperiod;
	}

	public void setDruglastperiod(BigDecimal druglastperiod) {
		this.druglastperiod = druglastperiod;
	}

	public BigDecimal getDruglastperiodunit() {
		return this.druglastperiodunit;
	}

	public void setDruglastperiodunit(BigDecimal druglastperiodunit) {
		this.druglastperiodunit = druglastperiodunit;
	}

	public BigDecimal getDrugparadministration() {
		return this.drugparadministration;
	}

	public void setDrugparadministration(BigDecimal drugparadministration) {
		this.drugparadministration = drugparadministration;
	}

	public BigDecimal getDrugrecurreadministration() {
		return this.drugrecurreadministration;
	}

	public void setDrugrecurreadministration(BigDecimal drugrecurreadministration) {
		this.drugrecurreadministration = drugrecurreadministration;
	}

	public BigDecimal getDrugseparatedosagenumb() {
		return this.drugseparatedosagenumb;
	}

	public void setDrugseparatedosagenumb(BigDecimal drugseparatedosagenumb) {
		this.drugseparatedosagenumb = drugseparatedosagenumb;
	}

	public String getDrugstartdate() {
		return this.drugstartdate;
	}

	public void setDrugstartdate(String drugstartdate) {
		this.drugstartdate = drugstartdate;
	}

	public BigDecimal getDrugstartdateformat() {
		return this.drugstartdateformat;
	}

	public void setDrugstartdateformat(BigDecimal drugstartdateformat) {
		this.drugstartdateformat = drugstartdateformat;
	}

	public BigDecimal getDrugstartperiod() {
		return this.drugstartperiod;
	}

	public void setDrugstartperiod(BigDecimal drugstartperiod) {
		this.drugstartperiod = drugstartperiod;
	}

	public BigDecimal getDrugstartperiodunit() {
		return this.drugstartperiodunit;
	}

	public void setDrugstartperiodunit(BigDecimal drugstartperiodunit) {
		this.drugstartperiodunit = drugstartperiodunit;
	}

	public BigDecimal getDrugstructuredosagenumb() {
		return this.drugstructuredosagenumb;
	}

	public void setDrugstructuredosagenumb(BigDecimal drugstructuredosagenumb) {
		this.drugstructuredosagenumb = drugstructuredosagenumb;
	}

	public BigDecimal getDrugstructuredosageunit() {
		return this.drugstructuredosageunit;
	}

	public void setDrugstructuredosageunit(BigDecimal drugstructuredosageunit) {
		this.drugstructuredosageunit = drugstructuredosageunit;
	}

	public BigDecimal getDrugtreatmentduration() {
		return this.drugtreatmentduration;
	}

	public void setDrugtreatmentduration(BigDecimal drugtreatmentduration) {
		this.drugtreatmentduration = drugtreatmentduration;
	}

	public BigDecimal getDrugtreatmentdurationunit() {
		return this.drugtreatmentdurationunit;
	}

	public void setDrugtreatmentdurationunit(BigDecimal drugtreatmentdurationunit) {
		this.drugtreatmentdurationunit = drugtreatmentdurationunit;
	}

	public BigDecimal getFkModeldrug() {
		return this.fkModeldrug;
	}

	public void setFkModeldrug(BigDecimal fkModeldrug) {
		this.fkModeldrug = fkModeldrug;
	}

	public BigDecimal getFkQidrugindication() {
		return this.fkQidrugindication;
	}

	public void setFkQidrugindication(BigDecimal fkQidrugindication) {
		this.fkQidrugindication = fkQidrugindication;
	}

	public BigDecimal getFkQimedicinalproduct() {
		return this.fkQimedicinalproduct;
	}

	public void setFkQimedicinalproduct(BigDecimal fkQimedicinalproduct) {
		this.fkQimedicinalproduct = fkQimedicinalproduct;
	}

	public BigDecimal getIsblindedchanged() {
		return this.isblindedchanged;
	}

	public void setIsblindedchanged(BigDecimal isblindedchanged) {
		this.isblindedchanged = isblindedchanged;
	}

	public BigDecimal getIsdrugindicationchanged() {
		return this.isdrugindicationchanged;
	}

	public void setIsdrugindicationchanged(BigDecimal isdrugindicationchanged) {
		this.isdrugindicationchanged = isdrugindicationchanged;
	}

	public BigDecimal getIsdrugindicationrecoded() {
		return this.isdrugindicationrecoded;
	}

	public void setIsdrugindicationrecoded(BigDecimal isdrugindicationrecoded) {
		this.isdrugindicationrecoded = isdrugindicationrecoded;
	}

	public BigDecimal getIsmedicinalproductchanged() {
		return this.ismedicinalproductchanged;
	}

	public void setIsmedicinalproductchanged(BigDecimal ismedicinalproductchanged) {
		this.ismedicinalproductchanged = ismedicinalproductchanged;
	}

	public BigDecimal getIsmedicinalproductrecoded() {
		return this.ismedicinalproductrecoded;
	}

	public void setIsmedicinalproductrecoded(BigDecimal ismedicinalproductrecoded) {
		this.ismedicinalproductrecoded = ismedicinalproductrecoded;
	}

	public String getMedicinalproduct() {
		return this.medicinalproduct;
	}

	public void setMedicinalproduct(String medicinalproduct) {
		this.medicinalproduct = medicinalproduct;
	}

	public BigDecimal getMedicinalproductmrec() {
		return this.medicinalproductmrec;
	}

	public void setMedicinalproductmrec(BigDecimal medicinalproductmrec) {
		this.medicinalproductmrec = medicinalproductmrec;
	}

	public String getMedicinalproductrecoded() {
		return this.medicinalproductrecoded;
	}

	public void setMedicinalproductrecoded(String medicinalproductrecoded) {
		this.medicinalproductrecoded = medicinalproductrecoded;
	}

	public String getObtaindrugcountry() {
		return this.obtaindrugcountry;
	}

	public void setObtaindrugcountry(String obtaindrugcountry) {
		this.obtaindrugcountry = obtaindrugcountry;
	}

	public String getProductEvcode() {
		return this.productEvcode;
	}

	public void setProductEvcode(String productEvcode) {
		this.productEvcode = productEvcode;
	}

	public BigDecimal getProductindexcode() {
		return this.productindexcode;
	}

	public void setProductindexcode(BigDecimal productindexcode) {
		this.productindexcode = productindexcode;
	}

	public BigDecimal getReactiongestationperiod() {
		return this.reactiongestationperiod;
	}

	public void setReactiongestationperiod(BigDecimal reactiongestationperiod) {
		this.reactiongestationperiod = reactiongestationperiod;
	}

	public BigDecimal getReactiongestationperiodunit() {
		return this.reactiongestationperiodunit;
	}

	public void setReactiongestationperiodunit(BigDecimal reactiongestationperiodunit) {
		this.reactiongestationperiodunit = reactiongestationperiodunit;
	}

	public BigDecimal getRecChanged() {
		return this.recChanged;
	}

	public void setRecChanged(BigDecimal recChanged) {
		this.recChanged = recChanged;
	}

	public BigDecimal getRecodingStage() {
		return this.recodingStage;
	}

	public void setRecodingStage(BigDecimal recodingStage) {
		this.recodingStage = recodingStage;
	}

	public Date getRecodingStamp() {
		return this.recodingStamp;
	}

	public void setRecodingStamp(Date recodingStamp) {
		this.recodingStamp = recodingStamp;
	}

	public List<ActiveSubstance> getIActivesubstances() {
		return this.IActivesubstances;
	}

	public void setIActivesubstances(List<ActiveSubstance> IActivesubstances) {
		this.IActivesubstances = IActivesubstances;
	}

	public ActiveSubstance addIActivesubstance(ActiveSubstance IActivesubstance) {
		getIActivesubstances().add(IActivesubstance);
		IActivesubstance.setIDrug(this);

		return IActivesubstance;
	}

	public ActiveSubstance removeIActivesubstance(ActiveSubstance IActivesubstance) {
		getIActivesubstances().remove(IActivesubstance);
		IActivesubstance.setIDrug(null);

		return IActivesubstance;
	}

	public Patient getIPatient() {
		return this.IPatient;
	}

	public void setIPatient(Patient IPatient) {
		this.IPatient = IPatient;
	}

	public List<DrugInterpreted> getIDruginterpreteds() {
		return this.IDruginterpreteds;
	}

	public void setIDruginterpreteds(List<DrugInterpreted> IDruginterpreteds) {
		this.IDruginterpreteds = IDruginterpreteds;
	}

	public DrugInterpreted addIDruginterpreted(DrugInterpreted IDruginterpreted) {
		getIDruginterpreteds().add(IDruginterpreted);
		IDruginterpreted.setIDrug(this);

		return IDruginterpreted;
	}

	public DrugInterpreted removeIDruginterpreted(DrugInterpreted IDruginterpreted) {
		getIDruginterpreteds().remove(IDruginterpreted);
		IDruginterpreted.setIDrug(null);

		return IDruginterpreted;
	}

	public List<DrugreActionRelated> getIDrugreactionrelateds() {
		return this.IDrugreactionrelateds;
	}

	public void setIDrugreactionrelateds(List<DrugreActionRelated> IDrugreactionrelateds) {
		this.IDrugreactionrelateds = IDrugreactionrelateds;
	}

	public DrugreActionRelated addIDrugreactionrelated(DrugreActionRelated IDrugreactionrelated) {
		getIDrugreactionrelateds().add(IDrugreactionrelated);
		IDrugreactionrelated.setIDrug(this);

		return IDrugreactionrelated;
	}

	public DrugreActionRelated removeIDrugreactionrelated(DrugreActionRelated IDrugreactionrelated) {
		getIDrugreactionrelateds().remove(IDrugreactionrelated);
		IDrugreactionrelated.setIDrug(null);

		return IDrugreactionrelated;
	}

	public List<DrugreCurrence> getIDrugrecurrences() {
		return this.IDrugrecurrences;
	}

	public void setIDrugrecurrences(List<DrugreCurrence> IDrugrecurrences) {
		this.IDrugrecurrences = IDrugrecurrences;
	}

	public DrugreCurrence addIDrugrecurrence(DrugreCurrence IDrugrecurrence) {
		getIDrugrecurrences().add(IDrugrecurrence);
		IDrugrecurrence.setIDrug(this);

		return IDrugrecurrence;
	}

	public DrugreCurrence removeIDrugrecurrence(DrugreCurrence IDrugrecurrence) {
		getIDrugrecurrences().remove(IDrugrecurrence);
		IDrugrecurrence.setIDrug(null);

		return IDrugrecurrence;
	}

}