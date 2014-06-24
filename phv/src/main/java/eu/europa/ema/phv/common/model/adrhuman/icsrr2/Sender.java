package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_SENDER database table.
 * 
 */
@Entity
@Table(name="I_SENDER")
@NamedQuery(name="Sender.findAll", query="SELECT s FROM Sender s")
public class Sender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_SAFETYREPORT", unique=true, nullable=false, precision=10)
	private long pkSafetyreport;

	@Column(length=35)
	private String sendercity;

	@Column(length=2)
	private String sendercountrycode;

	@Column(length=60)
	private String senderdepartment;

	@Column(length=100)
	private String senderemailaddress;

	@Column(length=35)
	private String senderfamilyname;

	@Column(length=10)
	private String senderfax;

	@Column(length=3)
	private String senderfaxcountrycode;

	@Column(length=10)
	private String senderfaxextension;

	@Column(length=35)
	private String sendergivename;

	@Column(length=15)
	private String sendermiddlename;

	@Column(length=60)
	private String senderorganization;

	@Column(precision=10)
	private BigDecimal senderorganizationcode;

	@Column(length=15)
	private String senderpostcode;

	@Column(length=40)
	private String senderstate;

	@Column(length=100)
	private String senderstreetaddress;

	@Column(length=10)
	private String sendertel;

	@Column(length=3)
	private String sendertelcountrycode;

	@Column(length=10)
	private String sendertelextension;

	@Column(length=10)
	private String sendertitle;

	@Column(precision=1)
	private BigDecimal sendertype;

	//bi-directional one-to-one association to SafetyReport
	@OneToOne
	@JoinColumn(name="PK_SAFETYREPORT", nullable=false, insertable=false, updatable=false)
	private SafetyReport ISafetyreport;

	public Sender() {
	}

	public long getPkSafetyreport() {
		return this.pkSafetyreport;
	}

	public void setPkSafetyreport(long pkSafetyreport) {
		this.pkSafetyreport = pkSafetyreport;
	}

	public String getSendercity() {
		return this.sendercity;
	}

	public void setSendercity(String sendercity) {
		this.sendercity = sendercity;
	}

	public String getSendercountrycode() {
		return this.sendercountrycode;
	}

	public void setSendercountrycode(String sendercountrycode) {
		this.sendercountrycode = sendercountrycode;
	}

	public String getSenderdepartment() {
		return this.senderdepartment;
	}

	public void setSenderdepartment(String senderdepartment) {
		this.senderdepartment = senderdepartment;
	}

	public String getSenderemailaddress() {
		return this.senderemailaddress;
	}

	public void setSenderemailaddress(String senderemailaddress) {
		this.senderemailaddress = senderemailaddress;
	}

	public String getSenderfamilyname() {
		return this.senderfamilyname;
	}

	public void setSenderfamilyname(String senderfamilyname) {
		this.senderfamilyname = senderfamilyname;
	}

	public String getSenderfax() {
		return this.senderfax;
	}

	public void setSenderfax(String senderfax) {
		this.senderfax = senderfax;
	}

	public String getSenderfaxcountrycode() {
		return this.senderfaxcountrycode;
	}

	public void setSenderfaxcountrycode(String senderfaxcountrycode) {
		this.senderfaxcountrycode = senderfaxcountrycode;
	}

	public String getSenderfaxextension() {
		return this.senderfaxextension;
	}

	public void setSenderfaxextension(String senderfaxextension) {
		this.senderfaxextension = senderfaxextension;
	}

	public String getSendergivename() {
		return this.sendergivename;
	}

	public void setSendergivename(String sendergivename) {
		this.sendergivename = sendergivename;
	}

	public String getSendermiddlename() {
		return this.sendermiddlename;
	}

	public void setSendermiddlename(String sendermiddlename) {
		this.sendermiddlename = sendermiddlename;
	}

	public String getSenderorganization() {
		return this.senderorganization;
	}

	public void setSenderorganization(String senderorganization) {
		this.senderorganization = senderorganization;
	}

	public BigDecimal getSenderorganizationcode() {
		return this.senderorganizationcode;
	}

	public void setSenderorganizationcode(BigDecimal senderorganizationcode) {
		this.senderorganizationcode = senderorganizationcode;
	}

	public String getSenderpostcode() {
		return this.senderpostcode;
	}

	public void setSenderpostcode(String senderpostcode) {
		this.senderpostcode = senderpostcode;
	}

	public String getSenderstate() {
		return this.senderstate;
	}

	public void setSenderstate(String senderstate) {
		this.senderstate = senderstate;
	}

	public String getSenderstreetaddress() {
		return this.senderstreetaddress;
	}

	public void setSenderstreetaddress(String senderstreetaddress) {
		this.senderstreetaddress = senderstreetaddress;
	}

	public String getSendertel() {
		return this.sendertel;
	}

	public void setSendertel(String sendertel) {
		this.sendertel = sendertel;
	}

	public String getSendertelcountrycode() {
		return this.sendertelcountrycode;
	}

	public void setSendertelcountrycode(String sendertelcountrycode) {
		this.sendertelcountrycode = sendertelcountrycode;
	}

	public String getSendertelextension() {
		return this.sendertelextension;
	}

	public void setSendertelextension(String sendertelextension) {
		this.sendertelextension = sendertelextension;
	}

	public String getSendertitle() {
		return this.sendertitle;
	}

	public void setSendertitle(String sendertitle) {
		this.sendertitle = sendertitle;
	}

	public BigDecimal getSendertype() {
		return this.sendertype;
	}

	public void setSendertype(BigDecimal sendertype) {
		this.sendertype = sendertype;
	}

	public SafetyReport getISafetyreport() {
		return this.ISafetyreport;
	}

	public void setISafetyreport(SafetyReport ISafetyreport) {
		this.ISafetyreport = ISafetyreport;
	}

}