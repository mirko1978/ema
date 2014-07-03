package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the I_ACTIVESUBSTANCEINTERPRETED database table.<br/>
 * All these fields are set by the interpretation job automatically. They are not from the XML.
 * 
 */
@Entity
@Table(name = "I_ACTIVESUBSTANCEINTERPRETED")
@NamedQuery(name = "ActiveSubstanceInterpreted.findAll", query = "SELECT a FROM ActiveSubstanceInterpreted a")
public class ActiveSubstanceInterpreted implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Primary key */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ActiveSubstanceInterpreted")
    @SequenceGenerator(name="ActiveSubstanceInterpreted",sequenceName="SEQ_SUB_INTPRETED", allocationSize=1)
    @Column(name = "PK_ACTIVESUBSTANCE_INTERPRETED", unique = true, nullable = false, precision = 10)
    private long pkActivesubstanceInterpreted;

    /** TODO: David */
    @Column(name = "ACTIVESUBSTANCE_EVCODE", length = 240)
    private String activesubstanceEvcode;

    /** TODO: David */
    @Column(precision = 10)
    private BigDecimal activesubstancecode;

    /** TODO: David */
    @Column(length = 200)
    private String activesubstancename;

    /** activesubstancename set from the user manually (UI - EV WEB) via manual recoding */
    @Column(precision = 1)
    private BigDecimal activesubstancenamemrec;

    /** Populate by automatic recoding. If active substance name has been recoded the value is 1 (true)*/
    @Column(length = 200)
    private String activesubstancenamerecoded;

    /** Automatic recoding reprocess the report. If there are changes on activesubstance this is set to 1 (true)*/
    @Column(precision = 1)
    private BigDecimal isactivesubstancechanged;

    /** Populate by automatic recoding. If active substance name has been recoded the value is 1 (true)*/
    @Column(precision = 1)
    private BigDecimal isactivesubstancenamerecoded;

    /** Recoding set to 1 (true) when medicinal product contains blinded phrase<br/>
     * k_IS_BLINDED_TRUE             CONSTANT NUMBER := 1; <br/>
     * k_IS_BLINDED_FALSE            CONSTANT NUMBER := 2;
     * */
    @Column(precision = 1)
    private BigDecimal blinded;

    /** Blinded flag setted from the user manually (UI - EV WEB) via manual recoding */
    @Column(precision = 1)
    private BigDecimal blindedmrec;

    /** TODO: David */
    @Column(name = "FK_INTERPRETATION_SUBSTANCE", precision = 10)
    private BigDecimal fkInterpretationSubstance;

    /** Foreign key for ICHICSR.QI_ACTIVESUBSTANCE  */
    @Column(name = "FK_QIACTIVESUBSTANCE", precision = 10)
    private BigDecimal fkQiactivesubstance;

    /** TODO: David */
    @Temporal(TemporalType.DATE)
    @Column(name = "INTERPRETED_DATE")
    private Date interpretedDate;

    /** Automatic recoding reprocess the report. If there are changes on blinded flag this is set to 1 (true)*/
    @Column(precision = 1)
    private BigDecimal isblindedchanged;

    /** Populated by recoding. It is the stage when the recoding found the match */
    @Column(name = "RECODING_STAGE", precision = 22)
    private BigDecimal recodingStage;

    /** Populated by recoding. It is the timestamp when the recoding populate */
    @Temporal(TemporalType.DATE)
    @Column(name = "RECODING_STAMP")
    private Date recodingStamp;

    /** TODO: David */
    @Temporal(TemporalType.DATE)
    private Date stampnullif;

    // bi-directional many-to-one association to DrugInterpreted
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_DRUG_INTERPRETED", nullable = false)
    private DrugInterpreted IDruginterpreted;

    public ActiveSubstanceInterpreted() {
    }

    public long getPkActivesubstanceInterpreted() {
        return this.pkActivesubstanceInterpreted;
    }

    public void setPkActivesubstanceInterpreted(long pkActivesubstanceInterpreted) {
        this.pkActivesubstanceInterpreted = pkActivesubstanceInterpreted;
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

    public BigDecimal getFkInterpretationSubstance() {
        return this.fkInterpretationSubstance;
    }

    public void setFkInterpretationSubstance(BigDecimal fkInterpretationSubstance) {
        this.fkInterpretationSubstance = fkInterpretationSubstance;
    }

    public BigDecimal getFkQiactivesubstance() {
        return this.fkQiactivesubstance;
    }

    public void setFkQiactivesubstance(BigDecimal fkQiactivesubstance) {
        this.fkQiactivesubstance = fkQiactivesubstance;
    }

    public Date getInterpretedDate() {
        return this.interpretedDate;
    }

    public void setInterpretedDate(Date interpretedDate) {
        this.interpretedDate = interpretedDate;
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

    public Date getStampnullif() {
        return this.stampnullif;
    }

    public void setStampnullif(Date stampnullif) {
        this.stampnullif = stampnullif;
    }

    public DrugInterpreted getIDruginterpreted() {
        return this.IDruginterpreted;
    }

    public void setIDruginterpreted(DrugInterpreted IDruginterpreted) {
        this.IDruginterpreted = IDruginterpreted;
    }

}