package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the I_PRIMARYSOURCE database table.
 */
@Entity
@Table(name = "I_PRIMARYSOURCE")
@NamedQuery(name = "PrimarySource.findAll", query = "SELECT p FROM PrimarySource p")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "primarysource")
public class PrimarySource implements Serializable {

    private static final long serialVersionUID = -163305822979064045L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PrimarySource")
    @SequenceGenerator(name = "PrimarySource", sequenceName = "SEQ_PRIMARYSOURCE", allocationSize = 1)
    @Column(name = "PK_PRIMARYSOURCE", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkPrimarysource;

    @Column(name = "CLEANED_LITERATUREREFERENCE", length = 500)
    @XmlTransient
    private String cleanedLiteraturereference;

    @Column(length = 500)
    @XmlElement(name = "literaturereference")
    private String literaturereference;

    @Column(precision = 1)
    @XmlElement(name = "observestudytype")
    private BigDecimal observestudytype;

    @Column(name = "\"QUALIFICATION\"", precision = 1)
    @XmlElement(name = "qualification")
    private BigDecimal qualification;

    @Column(length = 35)
    @XmlElement(name = "reportercity")
    private String reportercity;

    @Column(length = 2)
    @XmlElement(name = "reportercountry")
    private String reportercountry;

    @Column(length = 60)
    @XmlElement(name = "reporterdepartment")
    private String reporterdepartment;

    @Column(length = 100)
    @XmlElement(name = "reporterfamilyname")
    private String reporterfamilyname;

    @Column(length = 35)
    @XmlElement(name = "reportergivename")
    private String reportergivename;

    @Column(length = 15)
    @XmlElement(name = "reportermiddlename")
    private String reportermiddlename;

    @Column(length = 60)
    @XmlElement(name = "reporterorganization")
    private String reporterorganization;

    @Column(length = 15)
    @XmlElement(name = "reporterpostcode")
    private String reporterpostcode;

    @Column(length = 40)
    @XmlElement(name = "reporterstate")
    private String reporterstate;

    @Column(length = 100)
    @XmlElement(name = "reporterstreet")
    private String reporterstreet;

    @Column(length = 50)
    @XmlElement(name = "reportertitle")
    private String reportertitle;

    @Column(length = 35)
    @XmlElement(name = "sponsorstudynumb")
    private String sponsorstudynumb;

    @Column(length = 100)
    @XmlElement(name = "studyname")
    private String studyname;

    @Column(length = 500)
    private String title;

    // bi-directional many-to-one association to SafetyReport
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SAFETYREPORT", nullable = false)
    @XmlInverseReference(mappedBy = "IPrimarysources")
    private SafetyReport ISafetyreport;

    public PrimarySource() {
    }

    public long getPkPrimarysource() {
        return this.pkPrimarysource;
    }

    public void setPkPrimarysource(long pkPrimarysource) {
        this.pkPrimarysource = pkPrimarysource;
    }

    public String getCleanedLiteraturereference() {
        return this.cleanedLiteraturereference;
    }

    public void setCleanedLiteraturereference(String cleanedLiteraturereference) {
        this.cleanedLiteraturereference = cleanedLiteraturereference;
    }

    public String getLiteraturereference() {
        return this.literaturereference;
    }

    public void setLiteraturereference(String literaturereference) {
        this.literaturereference = literaturereference;
    }

    public BigDecimal getObservestudytype() {
        return this.observestudytype;
    }

    public void setObservestudytype(BigDecimal observestudytype) {
        this.observestudytype = observestudytype;
    }

    public BigDecimal getQualification() {
        return this.qualification;
    }

    public void setQualification(BigDecimal qualification) {
        this.qualification = qualification;
    }

    public String getReportercity() {
        return this.reportercity;
    }

    public void setReportercity(String reportercity) {
        this.reportercity = reportercity;
    }

    public String getReportercountry() {
        return this.reportercountry;
    }

    public void setReportercountry(String reportercountry) {
        this.reportercountry = reportercountry;
    }

    public String getReporterdepartment() {
        return this.reporterdepartment;
    }

    public void setReporterdepartment(String reporterdepartment) {
        this.reporterdepartment = reporterdepartment;
    }

    public String getReporterfamilyname() {
        return this.reporterfamilyname;
    }

    public void setReporterfamilyname(String reporterfamilyname) {
        this.reporterfamilyname = reporterfamilyname;
    }

    public String getReportergivename() {
        return this.reportergivename;
    }

    public void setReportergivename(String reportergivename) {
        this.reportergivename = reportergivename;
    }

    public String getReportermiddlename() {
        return this.reportermiddlename;
    }

    public void setReportermiddlename(String reportermiddlename) {
        this.reportermiddlename = reportermiddlename;
    }

    public String getReporterorganization() {
        return this.reporterorganization;
    }

    public void setReporterorganization(String reporterorganization) {
        this.reporterorganization = reporterorganization;
    }

    public String getReporterpostcode() {
        return this.reporterpostcode;
    }

    public void setReporterpostcode(String reporterpostcode) {
        this.reporterpostcode = reporterpostcode;
    }

    public String getReporterstate() {
        return this.reporterstate;
    }

    public void setReporterstate(String reporterstate) {
        this.reporterstate = reporterstate;
    }

    public String getReporterstreet() {
        return this.reporterstreet;
    }

    public void setReporterstreet(String reporterstreet) {
        this.reporterstreet = reporterstreet;
    }

    public String getReportertitle() {
        return this.reportertitle;
    }

    public void setReportertitle(String reportertitle) {
        this.reportertitle = reportertitle;
    }

    public String getSponsorstudynumb() {
        return this.sponsorstudynumb;
    }

    public void setSponsorstudynumb(String sponsorstudynumb) {
        this.sponsorstudynumb = sponsorstudynumb;
    }

    public String getStudyname() {
        return this.studyname;
    }

    public void setStudyname(String studyname) {
        this.studyname = studyname;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SafetyReport getISafetyreport() {
        return this.ISafetyreport;
    }

    public void setISafetyreport(SafetyReport ISafetyreport) {
        this.ISafetyreport = ISafetyreport;
    }

}