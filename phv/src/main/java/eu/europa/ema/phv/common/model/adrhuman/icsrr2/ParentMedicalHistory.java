package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_PARENTMEDICALHISTORY database table.
 * 
 */
@Entity
@Table(name="I_PARENTMEDICALHISTORY")
@NamedQuery(name="ParentMedicalHistory.findAll", query="SELECT p FROM ParentMedicalHistory p")
public class ParentMedicalHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_PARENTMEDICALHISTORY", unique=true, nullable=false, precision=10)
	private long pkParentmedicalhistory;

	@Column(precision=22)
	private BigDecimal parentmdepisodemv;

	@Column(length=2000)
	private String parentmedicalcomment;

	@Column(precision=1)
	private BigDecimal parentmedicalcontinue;

	@Column(length=14)
	private String parentmedicalenddate;

	@Column(precision=3)
	private BigDecimal parentmedicalenddateformat;

	@Column(precision=10)
	private BigDecimal parentmedicalepisodename;

	@Column(precision=10)
	private BigDecimal parentmedicalepisodenamect;

	@Column(length=14)
	private String parentmedicalstartdate;

	@Column(precision=3)
	private BigDecimal parentmedicalstartdateformat;

	//bi-directional many-to-one association to IParent
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
	private IParent IParent;

	public ParentMedicalHistory() {
	}

	public long getPkParentmedicalhistory() {
		return this.pkParentmedicalhistory;
	}

	public void setPkParentmedicalhistory(long pkParentmedicalhistory) {
		this.pkParentmedicalhistory = pkParentmedicalhistory;
	}

	public BigDecimal getParentmdepisodemv() {
		return this.parentmdepisodemv;
	}

	public void setParentmdepisodemv(BigDecimal parentmdepisodemv) {
		this.parentmdepisodemv = parentmdepisodemv;
	}

	public String getParentmedicalcomment() {
		return this.parentmedicalcomment;
	}

	public void setParentmedicalcomment(String parentmedicalcomment) {
		this.parentmedicalcomment = parentmedicalcomment;
	}

	public BigDecimal getParentmedicalcontinue() {
		return this.parentmedicalcontinue;
	}

	public void setParentmedicalcontinue(BigDecimal parentmedicalcontinue) {
		this.parentmedicalcontinue = parentmedicalcontinue;
	}

	public String getParentmedicalenddate() {
		return this.parentmedicalenddate;
	}

	public void setParentmedicalenddate(String parentmedicalenddate) {
		this.parentmedicalenddate = parentmedicalenddate;
	}

	public BigDecimal getParentmedicalenddateformat() {
		return this.parentmedicalenddateformat;
	}

	public void setParentmedicalenddateformat(BigDecimal parentmedicalenddateformat) {
		this.parentmedicalenddateformat = parentmedicalenddateformat;
	}

	public BigDecimal getParentmedicalepisodename() {
		return this.parentmedicalepisodename;
	}

	public void setParentmedicalepisodename(BigDecimal parentmedicalepisodename) {
		this.parentmedicalepisodename = parentmedicalepisodename;
	}

	public BigDecimal getParentmedicalepisodenamect() {
		return this.parentmedicalepisodenamect;
	}

	public void setParentmedicalepisodenamect(BigDecimal parentmedicalepisodenamect) {
		this.parentmedicalepisodenamect = parentmedicalepisodenamect;
	}

	public String getParentmedicalstartdate() {
		return this.parentmedicalstartdate;
	}

	public void setParentmedicalstartdate(String parentmedicalstartdate) {
		this.parentmedicalstartdate = parentmedicalstartdate;
	}

	public BigDecimal getParentmedicalstartdateformat() {
		return this.parentmedicalstartdateformat;
	}

	public void setParentmedicalstartdateformat(BigDecimal parentmedicalstartdateformat) {
		this.parentmedicalstartdateformat = parentmedicalstartdateformat;
	}

	public IParent getIParent() {
		return this.IParent;
	}

	public void setIParent(IParent IParent) {
		this.IParent = IParent;
	}

}