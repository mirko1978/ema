package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * The persistent class for the I_REPORTDUPLICATE database table.
 * 
 */
@Entity
@Table(name = "I_REPORTDUPLICATE")
@NamedQuery(name = "ReportDuplicate.findAll", query = "SELECT r FROM ReportDuplicate r")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reportduplicate")
public class ReportDuplicate implements Serializable {

    private static final long serialVersionUID = 5172665305281397475L;

    @Id
    @GeneratedValue(generator="ReportDuplicate")
    @SequenceGenerator(name="ReportDuplicate",sequenceName="SEQ_REPORTDUPLICATE", allocationSize=0)
    @Column(name = "PK_REPORTDUPLICATE", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkReportduplicate;

    @Column(length = 100)
    @XmlElement(name = "duplicatenumb")
    private String duplicatenumb;

    @Column(length = 100)
    @XmlElement(name = "duplicatesource")
    private String duplicatesource;

    // bi-directional many-to-one association to SafetyReport
    @ManyToOne
    @JoinColumn(name = "FK_SAFETYREPORT", nullable = false)
    @XmlInverseReference(mappedBy = "IReportduplicates")
    private SafetyReport ISafetyreport;

    public ReportDuplicate() {
    }

    public long getPkReportduplicate() {
        return this.pkReportduplicate;
    }

    public void setPkReportduplicate(long pkReportduplicate) {
        this.pkReportduplicate = pkReportduplicate;
    }

    public String getDuplicatenumb() {
        return this.duplicatenumb;
    }

    public void setDuplicatenumb(String duplicatenumb) {
        this.duplicatenumb = duplicatenumb;
    }

    public String getDuplicatesource() {
        return this.duplicatesource;
    }

    public void setDuplicatesource(String duplicatesource) {
        this.duplicatesource = duplicatesource;
    }

    public SafetyReport getISafetyreport() {
        return this.ISafetyreport;
    }

    public void setISafetyreport(SafetyReport ISafetyreport) {
        this.ISafetyreport = ISafetyreport;
    }

}
