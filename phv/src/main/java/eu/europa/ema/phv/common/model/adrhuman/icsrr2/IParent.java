package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the I_PARENT database table.
 * 
 */
@Entity
@Table(name="I_PARENT")
@NamedQuery(name="IParent.findAll", query="SELECT i FROM IParent i")
public class IParent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_SAFETYREPORT", unique=true, nullable=false, precision=10)
	private long pkSafetyreport;

	@Column(precision=22)
	private BigDecimal parentage;

	@Column(precision=3)
	private BigDecimal parentageunit;

	@Column(length=56)
	private String parentbirthdate;

	@Column(precision=3)
	private BigDecimal parentbirthdateformat;

	@Column(precision=22)
	private BigDecimal parentheight;

	@Column(length=40)
	private String parentidentification;

	@Column(length=56)
	private String parentlastmenstrualdate;

	@Column(precision=3)
	private BigDecimal parentlastmenstrualdateformat;

	@Lob
	private String parentmedicalrelevanttext;

	@Column(precision=1)
	private BigDecimal parentsex;

	@Column(precision=22)
	private BigDecimal parentweight;

	//bi-directional one-to-one association to Patient
	@OneToOne
	@JoinColumn(name="PK_SAFETYREPORT", nullable=false, insertable=false, updatable=false)
	private Patient IPatient;

	//bi-directional many-to-one association to ParentMedicalHistory
	@OneToMany(mappedBy="IParent")
	private List<ParentMedicalHistory> IParentmedicalhistories;

	//bi-directional many-to-one association to ParentPastDrugTherapy
	@OneToMany(mappedBy="IParent")
	private List<ParentPastDrugTherapy> IParentpastdrugtherapies;

	public IParent() {
	}

	public long getPkSafetyreport() {
		return this.pkSafetyreport;
	}

	public void setPkSafetyreport(long pkSafetyreport) {
		this.pkSafetyreport = pkSafetyreport;
	}

	public BigDecimal getParentage() {
		return this.parentage;
	}

	public void setParentage(BigDecimal parentage) {
		this.parentage = parentage;
	}

	public BigDecimal getParentageunit() {
		return this.parentageunit;
	}

	public void setParentageunit(BigDecimal parentageunit) {
		this.parentageunit = parentageunit;
	}

	public String getParentbirthdate() {
		return this.parentbirthdate;
	}

	public void setParentbirthdate(String parentbirthdate) {
		this.parentbirthdate = parentbirthdate;
	}

	public BigDecimal getParentbirthdateformat() {
		return this.parentbirthdateformat;
	}

	public void setParentbirthdateformat(BigDecimal parentbirthdateformat) {
		this.parentbirthdateformat = parentbirthdateformat;
	}

	public BigDecimal getParentheight() {
		return this.parentheight;
	}

	public void setParentheight(BigDecimal parentheight) {
		this.parentheight = parentheight;
	}

	public String getParentidentification() {
		return this.parentidentification;
	}

	public void setParentidentification(String parentidentification) {
		this.parentidentification = parentidentification;
	}

	public String getParentlastmenstrualdate() {
		return this.parentlastmenstrualdate;
	}

	public void setParentlastmenstrualdate(String parentlastmenstrualdate) {
		this.parentlastmenstrualdate = parentlastmenstrualdate;
	}

	public BigDecimal getParentlastmenstrualdateformat() {
		return this.parentlastmenstrualdateformat;
	}

	public void setParentlastmenstrualdateformat(BigDecimal parentlastmenstrualdateformat) {
		this.parentlastmenstrualdateformat = parentlastmenstrualdateformat;
	}

	public String getParentmedicalrelevanttext() {
		return this.parentmedicalrelevanttext;
	}

	public void setParentmedicalrelevanttext(String parentmedicalrelevanttext) {
		this.parentmedicalrelevanttext = parentmedicalrelevanttext;
	}

	public BigDecimal getParentsex() {
		return this.parentsex;
	}

	public void setParentsex(BigDecimal parentsex) {
		this.parentsex = parentsex;
	}

	public BigDecimal getParentweight() {
		return this.parentweight;
	}

	public void setParentweight(BigDecimal parentweight) {
		this.parentweight = parentweight;
	}

	public Patient getIPatient() {
		return this.IPatient;
	}

	public void setIPatient(Patient IPatient) {
		this.IPatient = IPatient;
	}

	public List<ParentMedicalHistory> getIParentmedicalhistories() {
		return this.IParentmedicalhistories;
	}

	public void setIParentmedicalhistories(List<ParentMedicalHistory> IParentmedicalhistories) {
		this.IParentmedicalhistories = IParentmedicalhistories;
	}

	public ParentMedicalHistory addIParentmedicalhistory(ParentMedicalHistory IParentmedicalhistory) {
		getIParentmedicalhistories().add(IParentmedicalhistory);
		IParentmedicalhistory.setIParent(this);

		return IParentmedicalhistory;
	}

	public ParentMedicalHistory removeIParentmedicalhistory(ParentMedicalHistory IParentmedicalhistory) {
		getIParentmedicalhistories().remove(IParentmedicalhistory);
		IParentmedicalhistory.setIParent(null);

		return IParentmedicalhistory;
	}

	public List<ParentPastDrugTherapy> getIParentpastdrugtherapies() {
		return this.IParentpastdrugtherapies;
	}

	public void setIParentpastdrugtherapies(List<ParentPastDrugTherapy> IParentpastdrugtherapies) {
		this.IParentpastdrugtherapies = IParentpastdrugtherapies;
	}

	public ParentPastDrugTherapy addIParentpastdrugtherapy(ParentPastDrugTherapy IParentpastdrugtherapy) {
		getIParentpastdrugtherapies().add(IParentpastdrugtherapy);
		IParentpastdrugtherapy.setIParent(this);

		return IParentpastdrugtherapy;
	}

	public ParentPastDrugTherapy removeIParentpastdrugtherapy(ParentPastDrugTherapy IParentpastdrugtherapy) {
		getIParentpastdrugtherapies().remove(IParentpastdrugtherapy);
		IParentpastdrugtherapy.setIParent(null);

		return IParentpastdrugtherapy;
	}

}