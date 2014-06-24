package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the I_SAFETYREPORT database table.
 * 
 */
@Entity
@Table(name="I_SAFETYREPORT")
@NamedQuery(name="SafetyReport.findAll", query="SELECT s FROM SafetyReport s")
public class SafetyReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_SAFETYREPORT", unique=true, nullable=false, precision=10)
	private long pkSafetyreport;

	@Column(precision=1)
	private BigDecimal additionaldocument;

	@Column(precision=1)
	private BigDecimal blinded;

	@Column(name="BLINDED_SUGGESTED", precision=1)
	private BigDecimal blindedSuggested;

	@Column(precision=1)
	private BigDecimal blindedmrec;

	@Column(precision=1)
	private BigDecimal casenullification;

	@Column(length=100)
	private String casenumber;

	@Column(precision=1)
	private BigDecimal casetype;

	@Column(precision=1)
	private BigDecimal dataquality;

	@Column(precision=1)
	private BigDecimal dataqualitymrec;

	@Column(length=100)
	private String documentlist;

	@Column(precision=1)
	private BigDecimal duplicate;

	@Column(precision=1)
	private BigDecimal fulfillexpeditecriteria;

	@Column(precision=22)
	private BigDecimal isblindedchanged;

	@Column(precision=1)
	private BigDecimal medicallyconfirm;

	@Column(precision=2)
	private BigDecimal messagetype;

	@Column(length=200)
	private String nullificationreason;

	@Column(length=2)
	private String occurcountry;

	@Temporal(TemporalType.DATE)
	private Date officialreceivedate;

	@Column(precision=1)
	private BigDecimal officialreceivedatemrec;

	@Column(length=2)
	private String primarysourcecountry;

	@Column(length=14)
	private String receiptdate;

	@Column(precision=3)
	private BigDecimal receiptdateformat;

	@Column(length=14)
	private String receivedate;

	@Column(precision=3)
	private BigDecimal receivedateformat;

	@Column(precision=1)
	private BigDecimal reporttype;

	@Column(length=100)
	private String safetyreportid;

	@Column(length=2)
	private String safetyreportversion;

	@Column(precision=1)
	private BigDecimal serious;

	@Column(precision=1)
	private BigDecimal seriousnesscongenitalanomali;

	@Column(precision=1)
	private BigDecimal seriousnessdeath;

	@Column(precision=1)
	private BigDecimal seriousnessdisabling;

	@Column(precision=1)
	private BigDecimal seriousnesshospitalization;

	@Column(precision=1)
	private BigDecimal seriousnesslifethreatening;

	@Column(precision=1)
	private BigDecimal seriousnessother;

	@Column(length=14)
	private String transmissiondate;

	@Column(precision=3)
	private BigDecimal transmissiondateformat;

	//bi-directional one-to-one association to Cluster
	@OneToOne(mappedBy="ISafetyreport")
	private Cluster ICluster;

	//bi-directional many-to-one association to FlagStatus
	@OneToMany(mappedBy="ISafetyreport")
	private List<FlagStatus> IFlagstatuses;

	//bi-directional many-to-one association to LinkedReport
	@OneToMany(mappedBy="ISafetyreport")
	private List<LinkedReport> ILinkedreports;

	//bi-directional one-to-one association to Patient
	@OneToOne(mappedBy="ISafetyreport")
	private Patient IPatient;

	//bi-directional many-to-one association to PrimarySource
	@OneToMany(mappedBy="ISafetyreport")
	private List<PrimarySource> IPrimarysources;

	//bi-directional one-to-one association to Receiver
	@OneToOne(mappedBy="ISafetyreport")
	private Receiver IReceiver;

	//bi-directional one-to-one association to ReportAck
	@OneToOne(mappedBy="ISafetyreport")
	private ReportAck IReportack;

	//bi-directional many-to-one association to ReportDuplicate
	@OneToMany(mappedBy="ISafetyreport")
	private List<ReportDuplicate> IReportduplicates;

	//bi-directional many-to-one association to SafetyReports
	@OneToMany(mappedBy="ISafetyreport")
	private List<SafetyReports> ISafetyreports;

	//bi-directional one-to-one association to Sender
	@OneToOne(mappedBy="ISafetyreport")
	private Sender ISender;

	public SafetyReport() {
	}

	public long getPkSafetyreport() {
		return this.pkSafetyreport;
	}

	public void setPkSafetyreport(long pkSafetyreport) {
		this.pkSafetyreport = pkSafetyreport;
	}

	public BigDecimal getAdditionaldocument() {
		return this.additionaldocument;
	}

	public void setAdditionaldocument(BigDecimal additionaldocument) {
		this.additionaldocument = additionaldocument;
	}

	public BigDecimal getBlinded() {
		return this.blinded;
	}

	public void setBlinded(BigDecimal blinded) {
		this.blinded = blinded;
	}

	public BigDecimal getBlindedSuggested() {
		return this.blindedSuggested;
	}

	public void setBlindedSuggested(BigDecimal blindedSuggested) {
		this.blindedSuggested = blindedSuggested;
	}

	public BigDecimal getBlindedmrec() {
		return this.blindedmrec;
	}

	public void setBlindedmrec(BigDecimal blindedmrec) {
		this.blindedmrec = blindedmrec;
	}

	public BigDecimal getCasenullification() {
		return this.casenullification;
	}

	public void setCasenullification(BigDecimal casenullification) {
		this.casenullification = casenullification;
	}

	public String getCasenumber() {
		return this.casenumber;
	}

	public void setCasenumber(String casenumber) {
		this.casenumber = casenumber;
	}

	public BigDecimal getCasetype() {
		return this.casetype;
	}

	public void setCasetype(BigDecimal casetype) {
		this.casetype = casetype;
	}

	public BigDecimal getDataquality() {
		return this.dataquality;
	}

	public void setDataquality(BigDecimal dataquality) {
		this.dataquality = dataquality;
	}

	public BigDecimal getDataqualitymrec() {
		return this.dataqualitymrec;
	}

	public void setDataqualitymrec(BigDecimal dataqualitymrec) {
		this.dataqualitymrec = dataqualitymrec;
	}

	public String getDocumentlist() {
		return this.documentlist;
	}

	public void setDocumentlist(String documentlist) {
		this.documentlist = documentlist;
	}

	public BigDecimal getDuplicate() {
		return this.duplicate;
	}

	public void setDuplicate(BigDecimal duplicate) {
		this.duplicate = duplicate;
	}

	public BigDecimal getFulfillexpeditecriteria() {
		return this.fulfillexpeditecriteria;
	}

	public void setFulfillexpeditecriteria(BigDecimal fulfillexpeditecriteria) {
		this.fulfillexpeditecriteria = fulfillexpeditecriteria;
	}

	public BigDecimal getIsblindedchanged() {
		return this.isblindedchanged;
	}

	public void setIsblindedchanged(BigDecimal isblindedchanged) {
		this.isblindedchanged = isblindedchanged;
	}

	public BigDecimal getMedicallyconfirm() {
		return this.medicallyconfirm;
	}

	public void setMedicallyconfirm(BigDecimal medicallyconfirm) {
		this.medicallyconfirm = medicallyconfirm;
	}

	public BigDecimal getMessagetype() {
		return this.messagetype;
	}

	public void setMessagetype(BigDecimal messagetype) {
		this.messagetype = messagetype;
	}

	public String getNullificationreason() {
		return this.nullificationreason;
	}

	public void setNullificationreason(String nullificationreason) {
		this.nullificationreason = nullificationreason;
	}

	public String getOccurcountry() {
		return this.occurcountry;
	}

	public void setOccurcountry(String occurcountry) {
		this.occurcountry = occurcountry;
	}

	public Date getOfficialreceivedate() {
		return this.officialreceivedate;
	}

	public void setOfficialreceivedate(Date officialreceivedate) {
		this.officialreceivedate = officialreceivedate;
	}

	public BigDecimal getOfficialreceivedatemrec() {
		return this.officialreceivedatemrec;
	}

	public void setOfficialreceivedatemrec(BigDecimal officialreceivedatemrec) {
		this.officialreceivedatemrec = officialreceivedatemrec;
	}

	public String getPrimarysourcecountry() {
		return this.primarysourcecountry;
	}

	public void setPrimarysourcecountry(String primarysourcecountry) {
		this.primarysourcecountry = primarysourcecountry;
	}

	public String getReceiptdate() {
		return this.receiptdate;
	}

	public void setReceiptdate(String receiptdate) {
		this.receiptdate = receiptdate;
	}

	public BigDecimal getReceiptdateformat() {
		return this.receiptdateformat;
	}

	public void setReceiptdateformat(BigDecimal receiptdateformat) {
		this.receiptdateformat = receiptdateformat;
	}

	public String getReceivedate() {
		return this.receivedate;
	}

	public void setReceivedate(String receivedate) {
		this.receivedate = receivedate;
	}

	public BigDecimal getReceivedateformat() {
		return this.receivedateformat;
	}

	public void setReceivedateformat(BigDecimal receivedateformat) {
		this.receivedateformat = receivedateformat;
	}

	public BigDecimal getReporttype() {
		return this.reporttype;
	}

	public void setReporttype(BigDecimal reporttype) {
		this.reporttype = reporttype;
	}

	public String getSafetyreportid() {
		return this.safetyreportid;
	}

	public void setSafetyreportid(String safetyreportid) {
		this.safetyreportid = safetyreportid;
	}

	public String getSafetyreportversion() {
		return this.safetyreportversion;
	}

	public void setSafetyreportversion(String safetyreportversion) {
		this.safetyreportversion = safetyreportversion;
	}

	public BigDecimal getSerious() {
		return this.serious;
	}

	public void setSerious(BigDecimal serious) {
		this.serious = serious;
	}

	public BigDecimal getSeriousnesscongenitalanomali() {
		return this.seriousnesscongenitalanomali;
	}

	public void setSeriousnesscongenitalanomali(BigDecimal seriousnesscongenitalanomali) {
		this.seriousnesscongenitalanomali = seriousnesscongenitalanomali;
	}

	public BigDecimal getSeriousnessdeath() {
		return this.seriousnessdeath;
	}

	public void setSeriousnessdeath(BigDecimal seriousnessdeath) {
		this.seriousnessdeath = seriousnessdeath;
	}

	public BigDecimal getSeriousnessdisabling() {
		return this.seriousnessdisabling;
	}

	public void setSeriousnessdisabling(BigDecimal seriousnessdisabling) {
		this.seriousnessdisabling = seriousnessdisabling;
	}

	public BigDecimal getSeriousnesshospitalization() {
		return this.seriousnesshospitalization;
	}

	public void setSeriousnesshospitalization(BigDecimal seriousnesshospitalization) {
		this.seriousnesshospitalization = seriousnesshospitalization;
	}

	public BigDecimal getSeriousnesslifethreatening() {
		return this.seriousnesslifethreatening;
	}

	public void setSeriousnesslifethreatening(BigDecimal seriousnesslifethreatening) {
		this.seriousnesslifethreatening = seriousnesslifethreatening;
	}

	public BigDecimal getSeriousnessother() {
		return this.seriousnessother;
	}

	public void setSeriousnessother(BigDecimal seriousnessother) {
		this.seriousnessother = seriousnessother;
	}

	public String getTransmissiondate() {
		return this.transmissiondate;
	}

	public void setTransmissiondate(String transmissiondate) {
		this.transmissiondate = transmissiondate;
	}

	public BigDecimal getTransmissiondateformat() {
		return this.transmissiondateformat;
	}

	public void setTransmissiondateformat(BigDecimal transmissiondateformat) {
		this.transmissiondateformat = transmissiondateformat;
	}

	public Cluster getICluster() {
		return this.ICluster;
	}

	public void setICluster(Cluster ICluster) {
		this.ICluster = ICluster;
	}

	public List<FlagStatus> getIFlagstatuses() {
		return this.IFlagstatuses;
	}

	public void setIFlagstatuses(List<FlagStatus> IFlagstatuses) {
		this.IFlagstatuses = IFlagstatuses;
	}

	public FlagStatus addIFlagstatus(FlagStatus IFlagstatus) {
		getIFlagstatuses().add(IFlagstatus);
		IFlagstatus.setISafetyreport(this);

		return IFlagstatus;
	}

	public FlagStatus removeIFlagstatus(FlagStatus IFlagstatus) {
		getIFlagstatuses().remove(IFlagstatus);
		IFlagstatus.setISafetyreport(null);

		return IFlagstatus;
	}

	public List<LinkedReport> getILinkedreports() {
		return this.ILinkedreports;
	}

	public void setILinkedreports(List<LinkedReport> ILinkedreports) {
		this.ILinkedreports = ILinkedreports;
	}

	public LinkedReport addILinkedreport(LinkedReport ILinkedreport) {
		getILinkedreports().add(ILinkedreport);
		ILinkedreport.setISafetyreport(this);

		return ILinkedreport;
	}

	public LinkedReport removeILinkedreport(LinkedReport ILinkedreport) {
		getILinkedreports().remove(ILinkedreport);
		ILinkedreport.setISafetyreport(null);

		return ILinkedreport;
	}

	public Patient getIPatient() {
		return this.IPatient;
	}

	public void setIPatient(Patient IPatient) {
		this.IPatient = IPatient;
	}

	public List<PrimarySource> getIPrimarysources() {
		return this.IPrimarysources;
	}

	public void setIPrimarysources(List<PrimarySource> IPrimarysources) {
		this.IPrimarysources = IPrimarysources;
	}

	public PrimarySource addIPrimarysource(PrimarySource IPrimarysource) {
		getIPrimarysources().add(IPrimarysource);
		IPrimarysource.setISafetyreport(this);

		return IPrimarysource;
	}

	public PrimarySource removeIPrimarysource(PrimarySource IPrimarysource) {
		getIPrimarysources().remove(IPrimarysource);
		IPrimarysource.setISafetyreport(null);

		return IPrimarysource;
	}

	public Receiver getIReceiver() {
		return this.IReceiver;
	}

	public void setIReceiver(Receiver IReceiver) {
		this.IReceiver = IReceiver;
	}

	public ReportAck getIReportack() {
		return this.IReportack;
	}

	public void setIReportack(ReportAck IReportack) {
		this.IReportack = IReportack;
	}

	public List<ReportDuplicate> getIReportduplicates() {
		return this.IReportduplicates;
	}

	public void setIReportduplicates(List<ReportDuplicate> IReportduplicates) {
		this.IReportduplicates = IReportduplicates;
	}

	public ReportDuplicate addIReportduplicate(ReportDuplicate IReportduplicate) {
		getIReportduplicates().add(IReportduplicate);
		IReportduplicate.setISafetyreport(this);

		return IReportduplicate;
	}

	public ReportDuplicate removeIReportduplicate(ReportDuplicate IReportduplicate) {
		getIReportduplicates().remove(IReportduplicate);
		IReportduplicate.setISafetyreport(null);

		return IReportduplicate;
	}

	public List<SafetyReports> getISafetyreports() {
		return this.ISafetyreports;
	}

	public void setISafetyreports(List<SafetyReports> ISafetyreports) {
		this.ISafetyreports = ISafetyreports;
	}

	public SafetyReports addISafetyreport(SafetyReports ISafetyreport) {
		getISafetyreports().add(ISafetyreport);
		ISafetyreport.setISafetyreport(this);

		return ISafetyreport;
	}

	public SafetyReports removeISafetyreport(SafetyReports ISafetyreport) {
		getISafetyreports().remove(ISafetyreport);
		ISafetyreport.setISafetyreport(null);

		return ISafetyreport;
	}

	public Sender getISender() {
		return this.ISender;
	}

	public void setISender(Sender ISender) {
		this.ISender = ISender;
	}

}