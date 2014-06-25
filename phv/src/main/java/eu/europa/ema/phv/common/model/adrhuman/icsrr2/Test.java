package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_TEST database table.
 * 
 */
@Entity
@Table(name="I_TEST")
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "test")
public class Test implements Serializable {

    private static final long serialVersionUID = 1991155154911306660L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_TEST", unique=true, nullable=false, precision=10)
    @XmlTransient
	private long pkTest;

	@Column(name="FK_QITESTNAME", precision=10)
    @XmlTransient
	private BigDecimal fkQitestname;

	@Column(length=50)
    @XmlElement(name = "hightestrange")
	private String hightestrange;

	@Column(precision=1)
    @XmlTransient
	private BigDecimal istestnamechanged;

	@Column(precision=1)
    @XmlTransient
	private BigDecimal istestnamerecoded;

	@Column(length=50)
    @XmlElement(name = "lowtestrange")
	private String lowtestrange;

	@Column(precision=1)
    @XmlElement(name = "moreinformation")
	private BigDecimal moreinformation;

	@Column(length=14)
    @XmlElement(name = "testdate")
	private String testdate;

	@Column(precision=3)
    @XmlElement(name = "testdateformat")
	private BigDecimal testdateformat;

	@Column(length=100)
    @XmlElement(name = "testname")
	private String testname;

	@Column(precision=10)
    @XmlTransient
	private BigDecimal testnamellt;

	@Column(precision=10)
    @XmlTransient
	private BigDecimal testnamelltct;

	@Column(length=100)
    @XmlTransient
	private String testnamemrec;

	@Column(precision=22)
    @XmlTransient
	private BigDecimal testnamemv;

	@Column(length=100)
    @XmlTransient
	private String testnamerecoded;

	@Column(length=50)
    @XmlElement(name = "testresult")
	private String testresult;

	@Column(length=35)
    @XmlElement(name = "testunit")
	private String testunit;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
    @XmlInverseReference(mappedBy = "ITests")
	private Patient IPatient;

	public Test() {
	}

	public long getPkTest() {
		return this.pkTest;
	}

	public void setPkTest(long pkTest) {
		this.pkTest = pkTest;
	}

	public BigDecimal getFkQitestname() {
		return this.fkQitestname;
	}

	public void setFkQitestname(BigDecimal fkQitestname) {
		this.fkQitestname = fkQitestname;
	}

	public String getHightestrange() {
		return this.hightestrange;
	}

	public void setHightestrange(String hightestrange) {
		this.hightestrange = hightestrange;
	}

	public BigDecimal getIstestnamechanged() {
		return this.istestnamechanged;
	}

	public void setIstestnamechanged(BigDecimal istestnamechanged) {
		this.istestnamechanged = istestnamechanged;
	}

	public BigDecimal getIstestnamerecoded() {
		return this.istestnamerecoded;
	}

	public void setIstestnamerecoded(BigDecimal istestnamerecoded) {
		this.istestnamerecoded = istestnamerecoded;
	}

	public String getLowtestrange() {
		return this.lowtestrange;
	}

	public void setLowtestrange(String lowtestrange) {
		this.lowtestrange = lowtestrange;
	}

	public BigDecimal getMoreinformation() {
		return this.moreinformation;
	}

	public void setMoreinformation(BigDecimal moreinformation) {
		this.moreinformation = moreinformation;
	}

	public String getTestdate() {
		return this.testdate;
	}

	public void setTestdate(String testdate) {
		this.testdate = testdate;
	}

	public BigDecimal getTestdateformat() {
		return this.testdateformat;
	}

	public void setTestdateformat(BigDecimal testdateformat) {
		this.testdateformat = testdateformat;
	}

	public String getTestname() {
		return this.testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public BigDecimal getTestnamellt() {
		return this.testnamellt;
	}

	public void setTestnamellt(BigDecimal testnamellt) {
		this.testnamellt = testnamellt;
	}

	public BigDecimal getTestnamelltct() {
		return this.testnamelltct;
	}

	public void setTestnamelltct(BigDecimal testnamelltct) {
		this.testnamelltct = testnamelltct;
	}

	public String getTestnamemrec() {
		return this.testnamemrec;
	}

	public void setTestnamemrec(String testnamemrec) {
		this.testnamemrec = testnamemrec;
	}

	public BigDecimal getTestnamemv() {
		return this.testnamemv;
	}

	public void setTestnamemv(BigDecimal testnamemv) {
		this.testnamemv = testnamemv;
	}

	public String getTestnamerecoded() {
		return this.testnamerecoded;
	}

	public void setTestnamerecoded(String testnamerecoded) {
		this.testnamerecoded = testnamerecoded;
	}

	public String getTestresult() {
		return this.testresult;
	}

	public void setTestresult(String testresult) {
		this.testresult = testresult;
	}

	public String getTestunit() {
		return this.testunit;
	}

	public void setTestunit(String testunit) {
		this.testunit = testunit;
	}

	public Patient getIPatient() {
		return this.IPatient;
	}

	public void setIPatient(Patient IPatient) {
		this.IPatient = IPatient;
	}

}