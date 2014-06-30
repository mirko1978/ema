package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the I_ACTIVESUBSTANCE database table.
 * 
 */
@Entity
@Table(name = "I_ACTIVESUBSTANCE")
@NamedQuery(name = "ActiveSubstance.findAll", query = "SELECT a FROM ActiveSubstance a")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "activesubstance")
public class ActiveSubstance implements Serializable {

    private static final long serialVersionUID = -347331926340033853L;

    /** Primary key */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_ACTIVESUBSTANCE", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkActivesubstance;

    /** Filled by automatic recoding TODO: David */
    @Column(name = "ACTIVESUBSTANCE_EVCODE", length = 240)
    @XmlTransient
    private String activesubstanceEvcode;

    /** Filled by automatic recoding TODO: David */
    @Column(precision = 10)
    @XmlTransient
    private BigDecimal activesubstancecode;

    /** Populate by automatic recoding. When the result of recoding of active substance has changed the value is 1 (true).*/
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isactivesubstancechanged;

    /** Recoding set to 1 (true) when medicinal product contains blinded phrase<br/>
     * k_IS_BLINDED_TRUE             CONSTANT NUMBER := 1; <br/>
     * k_IS_BLINDED_FALSE            CONSTANT NUMBER := 2;
     * */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal blinded;

    /** Blinded flag setted from the user manually (UI - EV WEB) via manual recoding */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal blindedmrec;

    /** Interpretation job. TODO: David */
    @Column(name = "FK_MODELSUBSTANCE", precision = 10)
    @XmlTransient
    private BigDecimal fkModelsubstance;

    /** Foreign key for ICHICSR.QI_ACTIVESUBSTANCE  */
    @Column(name = "FK_QIACTIVESUBSTANCE", precision = 10)
    @XmlTransient
    private BigDecimal fkQiactivesubstance;

    @Column(length = 200)
    @XmlElement(required = true, name = "activesubstancename")
    private String activesubstancename;

    /** Recoded version of activesubstancename */
    @Column(length = 200)
    @XmlTransient
    private String activesubstancenamerecoded;

    /** activesubstancename set from the user manually (UI - EV WEB) via manual recoding */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal activesubstancenamemrec;

    /** Populate by automatic recoding. If active substance name has been recoded the value is 1 (true)*/
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isactivesubstancenamerecoded;

    /** Automatic recoding reprocess the report. If there are changes on blinded flag this is set to 1 (true)*/
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isblindedchanged;

    /** Populated by recoding. It is the stage when the recoding found the match */
    @Column(name = "RECODING_STAGE", precision = 22)
    @XmlTransient
    private BigDecimal recodingStage;

    /** Populated by recoding. It is the timestamp when the recoding populate */
    @Temporal(TemporalType.DATE)
    @Column(name = "RECODING_STAMP")
    @XmlTransient
    private Date recodingStamp;

    // bi-directional many-to-one association to Drug
    @ManyToOne
    @JoinColumn(name = "FK_DRUG", nullable = false)
    @XmlInverseReference(mappedBy = "IActivesubstances")
    private Drug IDrug;

    public ActiveSubstance() {
    }

    public long getPkActivesubstance() {
        return this.pkActivesubstance;
    }

    public void setPkActivesubstance(long pkActivesubstance) {
        this.pkActivesubstance = pkActivesubstance;
    }

    public String getActivesubstanceEvcode() {
        return this.activesubstanceEvcode;
    }

    public void setActivesubstanceEvcode(String activesubstanceEvcode) {
        this.activesubstanceEvcode = activesubstanceEvcode;
    }

    public BigDecimal getActivesubstancecode() {
        return this.activesubstancecode;
    }

    public void setActivesubstancecode(BigDecimal activesubstancecode) {
        this.activesubstancecode = activesubstancecode;
    }

    public String getActivesubstancename() {
        return this.activesubstancename;
    }

    public void setActivesubstancename(String activesubstancename) {
        this.activesubstancename = activesubstancename;
    }

    public BigDecimal getActivesubstancenamemrec() {
        return this.activesubstancenamemrec;
    }

    public void setActivesubstancenamemrec(BigDecimal activesubstancenamemrec) {
        this.activesubstancenamemrec = activesubstancenamemrec;
    }

    public String getActivesubstancenamerecoded() {
        return this.activesubstancenamerecoded;
    }

    public void setActivesubstancenamerecoded(String activesubstancenamerecoded) {
        this.activesubstancenamerecoded = activesubstancenamerecoded;
    }

    public BigDecimal getBlinded() {
        return this.blinded;
    }

    public void setBlinded(BigDecimal blinded) {
        this.blinded = blinded;
    }

    public BigDecimal getBlindedmrec() {
        return this.blindedmrec;
    }

    public void setBlindedmrec(BigDecimal blindedmrec) {
        this.blindedmrec = blindedmrec;
    }

    public BigDecimal getFkModelsubstance() {
        return this.fkModelsubstance;
    }

    public void setFkModelsubstance(BigDecimal fkModelsubstance) {
        this.fkModelsubstance = fkModelsubstance;
    }

    public BigDecimal getFkQiactivesubstance() {
        return this.fkQiactivesubstance;
    }

    public void setFkQiactivesubstance(BigDecimal fkQiactivesubstance) {
        this.fkQiactivesubstance = fkQiactivesubstance;
    }

    public BigDecimal getIsactivesubstancechanged() {
        return this.isactivesubstancechanged;
    }

    public void setIsactivesubstancechanged(BigDecimal isactivesubstancechanged) {
        this.isactivesubstancechanged = isactivesubstancechanged;
    }

    public BigDecimal getIsactivesubstancenamerecoded() {
        return this.isactivesubstancenamerecoded;
    }

    public void setIsactivesubstancenamerecoded(BigDecimal isactivesubstancenamerecoded) {
        this.isactivesubstancenamerecoded = isactivesubstancenamerecoded;
    }

    public BigDecimal getIsblindedchanged() {
        return this.isblindedchanged;
    }

    public void setIsblindedchanged(BigDecimal isblindedchanged) {
        this.isblindedchanged = isblindedchanged;
    }

    public BigDecimal getRecodingStage() {
        return this.recodingStage;
    }

    public void setRecodingStage(BigDecimal recodingStage) {
        this.recodingStage = recodingStage;
    }

    public Date getRecodingStamp() {
        return this.recodingStamp;
    }

    public void setRecodingStamp(Date recodingStamp) {
        this.recodingStamp = recodingStamp;
    }

    public Drug getIDrug() {
        return this.IDrug;
    }

    public void setIDrug(Drug IDrug) {
        this.IDrug = IDrug;
    }

}