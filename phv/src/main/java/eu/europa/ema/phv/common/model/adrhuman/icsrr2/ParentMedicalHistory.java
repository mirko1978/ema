package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_PARENTMEDICALHISTORY database table.
 * 
 */
@Entity
@Table(name="I_PARENTMEDICALHISTORY")
@NamedQuery(name="ParentMedicalHistory.findAll", query="SELECT p FROM ParentMedicalHistory p")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "parentmedicalhistoryepisode")
public class ParentMedicalHistory implements Serializable {

    private static final long serialVersionUID = 2040155526676608919L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_PARENTMEDICALHISTORY", unique=true, nullable=false, precision=10)
    @XmlTransient
	private long pkParentmedicalhistory;

	@Column(precision=22)
    @XmlElement(name = "parentmdepisodemeddraversion")
	private BigDecimal parentmdepisodemv;

	@Column(length=2000)
    @XmlElement(name = "parentmedicalcomment")
	private String parentmedicalcomment;

	@Column(precision=1)
    @XmlElement(name = "parentmedicalcontinue")
	private BigDecimal parentmedicalcontinue;

	@Column(length=14)
    @XmlElement(name = "parentmedicalenddate")
	private String parentmedicalenddate;

	@Column(precision=3)
    @XmlElement(name = "parentmedicalenddateformat")
	private BigDecimal parentmedicalenddateformat;

	@Column(precision=10)
    @XmlElement(name = "parentmedicalepisodename")
	private BigDecimal parentmedicalepisodename;

	@Column(precision=10)
    @XmlTransient
	private BigDecimal parentmedicalepisodenamect;

	@Column(length=14)
    @XmlElement(name = "parentmedicalstartdate")
	private String parentmedicalstartdate;

	@Column(precision=3)
    @XmlElement(name = "parentmedicalstartdateformat")
	private BigDecimal parentmedicalstartdateformat;

	//bi-directional many-to-one association to IParent
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
    @XmlInverseReference(mappedBy = "IParentmedicalhistories")
	private Parent Parent;

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

	public Parent getParent() {
		return this.Parent;
	}

	public void setParent(Parent parent) {
		this.Parent = parent;
	}

}