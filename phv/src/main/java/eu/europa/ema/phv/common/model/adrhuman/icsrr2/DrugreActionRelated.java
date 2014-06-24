package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_DRUGREACTIONRELATED database table.
 * 
 */
@Entity
@Table(name="I_DRUGREACTIONRELATED")
@NamedQuery(name="DrugreActionRelated.findAll", query="SELECT d FROM DrugreActionRelated d")
public class DrugreActionRelated implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_DRUGREACTIONRELATED", unique=true, nullable=false, precision=10)
	private long pkDrugreactionrelated;

	@Column(length=35)
	private String drugassessmentmethod;

	@Column(length=60)
	private String drugassessmentsource;

	@Column(precision=10)
	private BigDecimal drugreactionasses;

	@Column(precision=10)
	private BigDecimal drugreactionassesct;

	@Column(precision=1)
	private BigDecimal drugreactionassesmrec;

	@Column(precision=22)
	private BigDecimal drugreactionassesmv;

	@Column(length=250)
	private String drugreactionassesrecoded;

	@Column(length=250)
	private String drugreactionassestext;

	@Column(length=35)
	private String drugresult;

	@Column(name="FK_QIDRUGREACTIONASSES", precision=10)
	private BigDecimal fkQidrugreactionasses;

	@Column(precision=1)
	private BigDecimal isdrugreactionasseschanged;

	@Column(precision=1)
	private BigDecimal isdrugreactionassesrecoded;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="FK_DRUG", nullable=false)
	private Drug IDrug;

	public DrugreActionRelated() {
	}

	public long getPkDrugreactionrelated() {
		return this.pkDrugreactionrelated;
	}

	public void setPkDrugreactionrelated(long pkDrugreactionrelated) {
		this.pkDrugreactionrelated = pkDrugreactionrelated;
	}

	public String getDrugassessmentmethod() {
		return this.drugassessmentmethod;
	}

	public void setDrugassessmentmethod(String drugassessmentmethod) {
		this.drugassessmentmethod = drugassessmentmethod;
	}

	public String getDrugassessmentsource() {
		return this.drugassessmentsource;
	}

	public void setDrugassessmentsource(String drugassessmentsource) {
		this.drugassessmentsource = drugassessmentsource;
	}

	public BigDecimal getDrugreactionasses() {
		return this.drugreactionasses;
	}

	public void setDrugreactionasses(BigDecimal drugreactionasses) {
		this.drugreactionasses = drugreactionasses;
	}

	public BigDecimal getDrugreactionassesct() {
		return this.drugreactionassesct;
	}

	public void setDrugreactionassesct(BigDecimal drugreactionassesct) {
		this.drugreactionassesct = drugreactionassesct;
	}

	public BigDecimal getDrugreactionassesmrec() {
		return this.drugreactionassesmrec;
	}

	public void setDrugreactionassesmrec(BigDecimal drugreactionassesmrec) {
		this.drugreactionassesmrec = drugreactionassesmrec;
	}

	public BigDecimal getDrugreactionassesmv() {
		return this.drugreactionassesmv;
	}

	public void setDrugreactionassesmv(BigDecimal drugreactionassesmv) {
		this.drugreactionassesmv = drugreactionassesmv;
	}

	public String getDrugreactionassesrecoded() {
		return this.drugreactionassesrecoded;
	}

	public void setDrugreactionassesrecoded(String drugreactionassesrecoded) {
		this.drugreactionassesrecoded = drugreactionassesrecoded;
	}

	public String getDrugreactionassestext() {
		return this.drugreactionassestext;
	}

	public void setDrugreactionassestext(String drugreactionassestext) {
		this.drugreactionassestext = drugreactionassestext;
	}

	public String getDrugresult() {
		return this.drugresult;
	}

	public void setDrugresult(String drugresult) {
		this.drugresult = drugresult;
	}

	public BigDecimal getFkQidrugreactionasses() {
		return this.fkQidrugreactionasses;
	}

	public void setFkQidrugreactionasses(BigDecimal fkQidrugreactionasses) {
		this.fkQidrugreactionasses = fkQidrugreactionasses;
	}

	public BigDecimal getIsdrugreactionasseschanged() {
		return this.isdrugreactionasseschanged;
	}

	public void setIsdrugreactionasseschanged(BigDecimal isdrugreactionasseschanged) {
		this.isdrugreactionasseschanged = isdrugreactionasseschanged;
	}

	public BigDecimal getIsdrugreactionassesrecoded() {
		return this.isdrugreactionassesrecoded;
	}

	public void setIsdrugreactionassesrecoded(BigDecimal isdrugreactionassesrecoded) {
		this.isdrugreactionassesrecoded = isdrugreactionassesrecoded;
	}

	public Drug getIDrug() {
		return this.IDrug;
	}

	public void setIDrug(Drug IDrug) {
		this.IDrug = IDrug;
	}

}