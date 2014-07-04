package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the I_DRUGREACTIONRELATED database table.
 */
@Entity
@Table(name = "I_DRUGREACTIONRELATED")
@NamedQuery(name = "DrugReactionRelated.findAll", query = "SELECT d FROM DrugReactionRelated d")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "drugreactionrelatedness")
public class DrugReactionRelated implements Serializable {

    private static final long serialVersionUID = -1293432034449347082L;

    /**
     * Primary Key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DrugReactionRelated")
    @SequenceGenerator(name = "DrugReactionRelated", sequenceName = "SEQ_DRUGREACTIONRELATED", allocationSize = 1)
    @Column(name = "PK_DRUGREACTIONRELATED", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkDrugreactionrelated;

    @Column(length = 35)
    @XmlElement(name = "drugassessmentmethod")
    private String drugassessmentmethod;

    @Column(length = 60)
    @XmlElement(name = "drugassessmentsource")
    private String drugassessmentsource;

    @Column(precision = 10)
    @XmlElement(name = "drugreactionasses")
    private BigDecimal drugreactionasses;

    /**
     * Medra code filled by manual recoding.
     */
    @Column(precision = 10)
    @XmlTransient
    private BigDecimal drugreactionassesct;

    /**
     * drugreactionasses set from the user manually (UI - EV WEB) via manual recoding
     */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal drugreactionassesmrec;

    @Column(precision = 22)
    @XmlElement(name = "drugreactionassesmeddraversion")
    private BigDecimal drugreactionassesmv;

    /**
     * Populate by automatic recoding. If drugreactionasses has been recoded the value is 1 (true)
     */
    @Column(length = 250)
    @XmlTransient
    private String drugreactionassesrecoded;

    /**
     * Medra description of {@link #drugreactionasses}
     */
    @Column(length = 250)
    @XmlTransient
    private String drugreactionassestext;

    @Column(length = 35)
    @XmlElement(name = "drugresult")
    private String drugresult;

    /**
     * It is always null in the databas
     */
    @Deprecated
    @Column(name = "FK_QIDRUGREACTIONASSES", precision = 10)
    @XmlTransient
    private BigDecimal fkQidrugreactionasses;

    /**
     * Automatic recoding reprocess the report. If there are changes on drugreactionasses this is set to 1 (true)
     */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isdrugreactionasseschanged;

    /**
     * Recoded version of drugreactionasses
     */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isdrugreactionassesrecoded;

    // bi-directional many-to-one association to Drug
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_DRUG", referencedColumnName = "PK_DRUG", nullable = false, insertable = false,
            updatable = false)
    @XmlInverseReference(mappedBy = "IDrugreactionrelateds")
    private Drug IDrug;

    @Column(name = "FK_DRUG", nullable = false, precision = 10)
    @XmlTransient
    private long fkDrug;

    public DrugReactionRelated() {
    }

    public long getFkDrug() {
        return fkDrug;
    }

    public void setFkDrug(long fkDrug) {
        this.fkDrug = fkDrug;
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
