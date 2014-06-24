package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the I_DRUGINTERPRETED database table.
 * 
 */
@Entity
@Table(name="I_DRUGINTERPRETED")
@NamedQuery(name="DrugInterpreted.findAll", query="SELECT d FROM DrugInterpreted d")
public class DrugInterpreted implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_DRUG_INTERPRETED", unique=true, nullable=false, precision=10)
	private long pkDrugInterpreted;

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

	@Column(name="FK_INTERPRETATION_DRUG", precision=10)
	private BigDecimal fkInterpretationDrug;

	@Column(name="FK_MODELDRUG", precision=22)
	private BigDecimal fkModeldrug;

	@Column(name="FK_QIDRUGINDICATION", precision=10)
	private BigDecimal fkQidrugindication;

	@Column(name="FK_QIMEDICINALPRODUCT", precision=10)
	private BigDecimal fkQimedicinalproduct;

	@Temporal(TemporalType.DATE)
	@Column(name="INTERPRETED_DATE")
	private Date interpretedDate;

	@Column(precision=1)
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

	@Temporal(TemporalType.DATE)
	private Date stampnullif;

	//bi-directional many-to-one association to ActiveSubstanceInterpreted
	@OneToMany(mappedBy="IDruginterpreted")
	private List<ActiveSubstanceInterpreted> IActivesubstanceinterpreteds;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="FK_DRUG")
	private Drug IDrug;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
	private Patient IPatient;

	public DrugInterpreted() {
	}

	public long getPkDrugInterpreted() {
		return this.pkDrugInterpreted;
	}

	public void setPkDrugInterpreted(long pkDrugInterpreted) {
		this.pkDrugInterpreted = pkDrugInterpreted;
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

	public BigDecimal getFkInterpretationDrug() {
		return this.fkInterpretationDrug;
	}

	public void setFkInterpretationDrug(BigDecimal fkInterpretationDrug) {
		this.fkInterpretationDrug = fkInterpretationDrug;
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

	public Date getInterpretedDate() {
		return this.interpretedDate;
	}

	public void setInterpretedDate(Date interpretedDate) {
		this.interpretedDate = interpretedDate;
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

	public Date getStampnullif() {
		return this.stampnullif;
	}

	public void setStampnullif(Date stampnullif) {
		this.stampnullif = stampnullif;
	}

	public List<ActiveSubstanceInterpreted> getIActivesubstanceinterpreteds() {
		return this.IActivesubstanceinterpreteds;
	}

	public void setIActivesubstanceinterpreteds(List<ActiveSubstanceInterpreted> IActivesubstanceinterpreteds) {
		this.IActivesubstanceinterpreteds = IActivesubstanceinterpreteds;
	}

	public ActiveSubstanceInterpreted addIActivesubstanceinterpreted(ActiveSubstanceInterpreted IActivesubstanceinterpreted) {
		getIActivesubstanceinterpreteds().add(IActivesubstanceinterpreted);
		IActivesubstanceinterpreted.setIDruginterpreted(this);

		return IActivesubstanceinterpreted;
	}

	public ActiveSubstanceInterpreted removeIActivesubstanceinterpreted(ActiveSubstanceInterpreted IActivesubstanceinterpreted) {
		getIActivesubstanceinterpreteds().remove(IActivesubstanceinterpreted);
		IActivesubstanceinterpreted.setIDruginterpreted(null);

		return IActivesubstanceinterpreted;
	}

	public Drug getIDrug() {
		return this.IDrug;
	}

	public void setIDrug(Drug IDrug) {
		this.IDrug = IDrug;
	}

	public Patient getIPatient() {
		return this.IPatient;
	}

	public void setIPatient(Patient IPatient) {
		this.IPatient = IPatient;
	}

}