package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the I_PATIENTPASTDRUGTHERAPY database table.
 * 
 */
@Entity
@Table(name="I_PATIENTPASTDRUGTHERAPY")
@NamedQuery(name="PatientPastDrugTherapy.findAll", query="SELECT p FROM PatientPastDrugTherapy p")
public class PatientPastDrugTherapy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_PATIENTPASTDRUGTHERAPY", unique=true, nullable=false, precision=10)
	private long pkPatientpastdrugtherapy;

	@Column(precision=1)
	private BigDecimal blinded;

	@Column(precision=1)
	private BigDecimal blindedmrec;

	@Column(name="FK_QIPATIENTDRUGINDICATION", precision=10)
	private BigDecimal fkQipatientdrugindication;

	@Column(name="FK_QIPATIENTDRUGNAME", precision=10)
	private BigDecimal fkQipatientdrugname;

	@Column(name="FK_QIPATIENTDRUGREACTION", precision=10)
	private BigDecimal fkQipatientdrugreaction;

	@Column(precision=1)
	private BigDecimal isblindedchanged;

	@Column(precision=1)
	private BigDecimal ispatientdrugindicationchanged;

	@Column(precision=1)
	private BigDecimal ispatientdrugindicationrecoded;

	@Column(precision=1)
	private BigDecimal ispatientdrugnamechanged;

	@Column(precision=1)
	private BigDecimal ispatientdrugnamerecoded;

	@Column(precision=1)
	private BigDecimal ispatientdrugreactionchanged;

	@Column(precision=1)
	private BigDecimal ispatientdrugreactionrecoded;

	@Column(precision=22)
	private BigDecimal patientdrgreactionmv;

	@Column(length=14)
	private String patientdrugenddate;

	@Column(precision=3)
	private BigDecimal patientdrugenddateformat;

	@Column(precision=10)
	private BigDecimal patientdrugindication;

	@Column(precision=10)
	private BigDecimal patientdrugindicationct;

	@Column(precision=1)
	private BigDecimal patientdrugindicationmrec;

	@Column(length=250)
	private String patientdrugindicationrecoded;

	@Column(length=250)
	private String patientdrugindicationtext;

	@Column(length=200)
	private String patientdrugname;

	@Column(precision=1)
	private BigDecimal patientdrugnamemrec;

	@Column(length=200)
	private String patientdrugnamerecoded;

	@Column(precision=10)
	private BigDecimal patientdrugreaction;

	@Column(precision=10)
	private BigDecimal patientdrugreactionct;

	@Column(precision=1)
	private BigDecimal patientdrugreactionmrec;

	@Column(length=250)
	private String patientdrugreactionrecoded;

	@Column(length=250)
	private String patientdrugreactiontext;

	@Column(length=14)
	private String patientdrugstartdate;

	@Column(precision=3)
	private BigDecimal patientdrugstartdateformat;

	@Column(precision=22)
	private BigDecimal patientindicationmv;

	@Column(name="PRODUCT_EVCODE", length=60)
	private String productEvcode;

	@Column(precision=10)
	private BigDecimal productindexcode;

	@Column(name="RECODING_STAGE", precision=22)
	private BigDecimal recodingStage;

	@Temporal(TemporalType.DATE)
	@Column(name="RECODING_STAMP")
	private Date recodingStamp;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
	private Patient IPatient;

	public PatientPastDrugTherapy() {
	}

	public long getPkPatientpastdrugtherapy() {
		return this.pkPatientpastdrugtherapy;
	}

	public void setPkPatientpastdrugtherapy(long pkPatientpastdrugtherapy) {
		this.pkPatientpastdrugtherapy = pkPatientpastdrugtherapy;
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

	public BigDecimal getFkQipatientdrugindication() {
		return this.fkQipatientdrugindication;
	}

	public void setFkQipatientdrugindication(BigDecimal fkQipatientdrugindication) {
		this.fkQipatientdrugindication = fkQipatientdrugindication;
	}

	public BigDecimal getFkQipatientdrugname() {
		return this.fkQipatientdrugname;
	}

	public void setFkQipatientdrugname(BigDecimal fkQipatientdrugname) {
		this.fkQipatientdrugname = fkQipatientdrugname;
	}

	public BigDecimal getFkQipatientdrugreaction() {
		return this.fkQipatientdrugreaction;
	}

	public void setFkQipatientdrugreaction(BigDecimal fkQipatientdrugreaction) {
		this.fkQipatientdrugreaction = fkQipatientdrugreaction;
	}

	public BigDecimal getIsblindedchanged() {
		return this.isblindedchanged;
	}

	public void setIsblindedchanged(BigDecimal isblindedchanged) {
		this.isblindedchanged = isblindedchanged;
	}

	public BigDecimal getIspatientdrugindicationchanged() {
		return this.ispatientdrugindicationchanged;
	}

	public void setIspatientdrugindicationchanged(BigDecimal ispatientdrugindicationchanged) {
		this.ispatientdrugindicationchanged = ispatientdrugindicationchanged;
	}

	public BigDecimal getIspatientdrugindicationrecoded() {
		return this.ispatientdrugindicationrecoded;
	}

	public void setIspatientdrugindicationrecoded(BigDecimal ispatientdrugindicationrecoded) {
		this.ispatientdrugindicationrecoded = ispatientdrugindicationrecoded;
	}

	public BigDecimal getIspatientdrugnamechanged() {
		return this.ispatientdrugnamechanged;
	}

	public void setIspatientdrugnamechanged(BigDecimal ispatientdrugnamechanged) {
		this.ispatientdrugnamechanged = ispatientdrugnamechanged;
	}

	public BigDecimal getIspatientdrugnamerecoded() {
		return this.ispatientdrugnamerecoded;
	}

	public void setIspatientdrugnamerecoded(BigDecimal ispatientdrugnamerecoded) {
		this.ispatientdrugnamerecoded = ispatientdrugnamerecoded;
	}

	public BigDecimal getIspatientdrugreactionchanged() {
		return this.ispatientdrugreactionchanged;
	}

	public void setIspatientdrugreactionchanged(BigDecimal ispatientdrugreactionchanged) {
		this.ispatientdrugreactionchanged = ispatientdrugreactionchanged;
	}

	public BigDecimal getIspatientdrugreactionrecoded() {
		return this.ispatientdrugreactionrecoded;
	}

	public void setIspatientdrugreactionrecoded(BigDecimal ispatientdrugreactionrecoded) {
		this.ispatientdrugreactionrecoded = ispatientdrugreactionrecoded;
	}

	public BigDecimal getPatientdrgreactionmv() {
		return this.patientdrgreactionmv;
	}

	public void setPatientdrgreactionmv(BigDecimal patientdrgreactionmv) {
		this.patientdrgreactionmv = patientdrgreactionmv;
	}

	public String getPatientdrugenddate() {
		return this.patientdrugenddate;
	}

	public void setPatientdrugenddate(String patientdrugenddate) {
		this.patientdrugenddate = patientdrugenddate;
	}

	public BigDecimal getPatientdrugenddateformat() {
		return this.patientdrugenddateformat;
	}

	public void setPatientdrugenddateformat(BigDecimal patientdrugenddateformat) {
		this.patientdrugenddateformat = patientdrugenddateformat;
	}

	public BigDecimal getPatientdrugindication() {
		return this.patientdrugindication;
	}

	public void setPatientdrugindication(BigDecimal patientdrugindication) {
		this.patientdrugindication = patientdrugindication;
	}

	public BigDecimal getPatientdrugindicationct() {
		return this.patientdrugindicationct;
	}

	public void setPatientdrugindicationct(BigDecimal patientdrugindicationct) {
		this.patientdrugindicationct = patientdrugindicationct;
	}

	public BigDecimal getPatientdrugindicationmrec() {
		return this.patientdrugindicationmrec;
	}

	public void setPatientdrugindicationmrec(BigDecimal patientdrugindicationmrec) {
		this.patientdrugindicationmrec = patientdrugindicationmrec;
	}

	public String getPatientdrugindicationrecoded() {
		return this.patientdrugindicationrecoded;
	}

	public void setPatientdrugindicationrecoded(String patientdrugindicationrecoded) {
		this.patientdrugindicationrecoded = patientdrugindicationrecoded;
	}

	public String getPatientdrugindicationtext() {
		return this.patientdrugindicationtext;
	}

	public void setPatientdrugindicationtext(String patientdrugindicationtext) {
		this.patientdrugindicationtext = patientdrugindicationtext;
	}

	public String getPatientdrugname() {
		return this.patientdrugname;
	}

	public void setPatientdrugname(String patientdrugname) {
		this.patientdrugname = patientdrugname;
	}

	public BigDecimal getPatientdrugnamemrec() {
		return this.patientdrugnamemrec;
	}

	public void setPatientdrugnamemrec(BigDecimal patientdrugnamemrec) {
		this.patientdrugnamemrec = patientdrugnamemrec;
	}

	public String getPatientdrugnamerecoded() {
		return this.patientdrugnamerecoded;
	}

	public void setPatientdrugnamerecoded(String patientdrugnamerecoded) {
		this.patientdrugnamerecoded = patientdrugnamerecoded;
	}

	public BigDecimal getPatientdrugreaction() {
		return this.patientdrugreaction;
	}

	public void setPatientdrugreaction(BigDecimal patientdrugreaction) {
		this.patientdrugreaction = patientdrugreaction;
	}

	public BigDecimal getPatientdrugreactionct() {
		return this.patientdrugreactionct;
	}

	public void setPatientdrugreactionct(BigDecimal patientdrugreactionct) {
		this.patientdrugreactionct = patientdrugreactionct;
	}

	public BigDecimal getPatientdrugreactionmrec() {
		return this.patientdrugreactionmrec;
	}

	public void setPatientdrugreactionmrec(BigDecimal patientdrugreactionmrec) {
		this.patientdrugreactionmrec = patientdrugreactionmrec;
	}

	public String getPatientdrugreactionrecoded() {
		return this.patientdrugreactionrecoded;
	}

	public void setPatientdrugreactionrecoded(String patientdrugreactionrecoded) {
		this.patientdrugreactionrecoded = patientdrugreactionrecoded;
	}

	public String getPatientdrugreactiontext() {
		return this.patientdrugreactiontext;
	}

	public void setPatientdrugreactiontext(String patientdrugreactiontext) {
		this.patientdrugreactiontext = patientdrugreactiontext;
	}

	public String getPatientdrugstartdate() {
		return this.patientdrugstartdate;
	}

	public void setPatientdrugstartdate(String patientdrugstartdate) {
		this.patientdrugstartdate = patientdrugstartdate;
	}

	public BigDecimal getPatientdrugstartdateformat() {
		return this.patientdrugstartdateformat;
	}

	public void setPatientdrugstartdateformat(BigDecimal patientdrugstartdateformat) {
		this.patientdrugstartdateformat = patientdrugstartdateformat;
	}

	public BigDecimal getPatientindicationmv() {
		return this.patientindicationmv;
	}

	public void setPatientindicationmv(BigDecimal patientindicationmv) {
		this.patientindicationmv = patientindicationmv;
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

	public Patient getIPatient() {
		return this.IPatient;
	}

	public void setIPatient(Patient IPatient) {
		this.IPatient = IPatient;
	}

}