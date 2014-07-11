package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the I_DRUG database table.
 */
@Entity
@Table(name = "I_DRUG")
@NamedQuery(name = "Drug.findAll", query = "SELECT d FROM Drug d")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "drug")
public class Drug implements Serializable {

    private static final long serialVersionUID = 908646845918748709L;

    /**
     * Primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Drug")
    @SequenceGenerator(name = "Drug", sequenceName = "SEQ_DRUG", allocationSize = 1)
    @Column(name = "PK_DRUG", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkDrug;

    @Column(precision = 1)
    @XmlElement(name = "actiondrug")
    private BigDecimal actiondrug;

    /**
     * Recoding set to 1 (true) when medicinal product contains blinded phrase<br/>
     * k_IS_BLINDED_TRUE             CONSTANT NUMBER := 1; <br/>
     * k_IS_BLINDED_FALSE            CONSTANT NUMBER := 2;
     */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal blinded;

    /**
     * Blinded flag setted from the user manually (UI - EV WEB) via manual recoding
     */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal blindedmrec;

    @Column(length = 100)
    @XmlElement(name = "drugadditional")
    private String drugadditional;

    @Column(precision = 3)
    @XmlElement(name = "drugadministrationroute")
    private BigDecimal drugadministrationroute;

    @Column(length = 2)
    @XmlElement(name = "drugauthorizationcountry")
    private String drugauthorizationcountry;

    @Column(length = 60)
    @XmlElement(name = "drugauthorizationholder")
    private String drugauthorizationholder;

    @Column(length = 35)
    @XmlElement(name = "drugauthorizationnumb")
    private String drugauthorizationnumb;

    @Column(length = 35)
    @XmlElement(name = "drugbatchnumb")
    private String drugbatchnumb;

    @Column(precision = 1)
    @XmlElement(name = "drugcharacterization")
    private BigDecimal drugcharacterization;

    @Column(precision = 22)
    @XmlElement(name = "drugcumulativedosagenumb")
    private BigDecimal drugcumulativedosagenumb;

    @Column(precision = 3)
    @XmlElement(name = "drugcumulativedosageunit")
    private BigDecimal drugcumulativedosageunit;

    @Column(length = 100)
    @XmlElement(name = "drugdosageform")
    private String drugdosageform;

    /**
     * TODO: look on VB6 / PlSql
     */
    @Column(precision = 3)
    @XmlTransient
    private BigDecimal drugdosageformcode;

    @Column(length = 100)
    @XmlElement(name = "drugdosagetext")
    private String drugdosagetext;

    @Column(length = 14)
    @XmlElement(name = "drugenddate")
    private String drugenddate;

    @Column(precision = 3)
    @XmlElement(name = "drugenddateformat")
    private BigDecimal drugenddateformat;

    /**
     * Can be a text.
     * TODO: VB6/PlSql
     */
    @Column(precision = 10)
    @XmlElement(name = "drugindication")
    private BigDecimal drugindication;

    /**
     * Can be obsolete from ICSR R2.0 when Meddra can be specified only by text. Was from manual recoding
     * TODO: VB6/PlSql
     */
    @Column(precision = 10)
    @XmlTransient
    private BigDecimal drugindicationct;

    /**
     * Manual recoding of {@link #drugindication}
     */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal drugindicationmrec;

    @Column(precision = 22)
    @XmlElement(name = "drugindicationmeddraversion")
    private BigDecimal drugindicationmv;

    /**
     * Used by recoding but no longer required
     */
    @Deprecated
    @Column(length = 250)
    @XmlTransient
    private String drugindicationrecoded;

    /**
     * Used by recoding but no longer required
     */
    @Deprecated
    @Column(length = 250)
    @XmlTransient
    private String drugindicationtext;

    @Column(precision = 3)
    @XmlElement(name = "drugintervaldosagedefinition")
    private BigDecimal drugintervaldosagedefinition;

    @Column(precision = 22)
    @XmlElement(name = "drugintervaldosageunitnumb")
    private BigDecimal drugintervaldosageunitnumb;

    @Column(precision = 22)
    @XmlElement(name = "druglastperiod")
    private BigDecimal druglastperiod;

    @Column(precision = 3)
    @XmlElement(name = "druglastperiodunit")
    private BigDecimal druglastperiodunit;

    @Column(precision = 3)
    @XmlElement(name = "drugparadministration")
    private BigDecimal drugparadministration;

    @Column(precision = 1)
    @XmlElement(name = "drugrecurreadministration")
    private BigDecimal drugrecurreadministration;

    @Column(precision = 22)
    @XmlElement(name = "drugseparatedosagenumb")
    private BigDecimal drugseparatedosagenumb;

    @Column(length = 14)
    @XmlElement(name = "drugstartdate")
    private String drugstartdate;

    @Column(precision = 3)
    @XmlElement(name = "drugstartdateformat")
    private BigDecimal drugstartdateformat;

    @Column(precision = 22)
    @XmlElement(name = "drugstartperiod")
    private BigDecimal drugstartperiod;

    @Column(precision = 3)
    @XmlElement(name = "drugstartperiodunit")
    private BigDecimal drugstartperiodunit;

    @Column(precision = 22)
    @XmlElement(name = "drugstructuredosagenumb")
    private BigDecimal drugstructuredosagenumb;

    @Column(precision = 3)
    @XmlElement(name = "drugstructuredosageunit")
    private BigDecimal drugstructuredosageunit;

    @Column(precision = 22)
    @XmlElement(name = "drugtreatmentduration")
    private BigDecimal drugtreatmentduration;

    @Column(precision = 3)
    @XmlElement(name = "drugtreatmentdurationunit")
    private BigDecimal drugtreatmentdurationunit;

    /**
     * Interpretation populate it. Links ICHICSR.S_MODELDRUG
     */
    @Column(name = "FK_MODELDRUG", precision = 10)
    @XmlTransient
    private BigDecimal fkModeldrug;

    /**
     * Drug indication are no longer provided as text. The code is mandatory
     */
    @Deprecated
    @Column(name = "FK_QIDRUGINDICATION", precision = 10)
    @XmlTransient
    private BigDecimal fkQidrugindication;

    /**
     * It is populated by recoding. It points to ICHICSR.QI_PRODUCT
     */
    @Column(name = "FK_QIMEDICINALPRODUCT", precision = 10)
    @XmlTransient
    private BigDecimal fkQimedicinalproduct;

    /**
     * Automatic recoding reprocess the report. If there are changes on blinded flag this is set to 1 (true)
     */
    @Column(precision = 22)
    @XmlTransient
    private BigDecimal isblindedchanged;

    /**
     * No longer used
     */
    @Deprecated
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isdrugindicationchanged;

    /**
     * No longer used
     */
    @Deprecated
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isdrugindicationrecoded;

    @Column(length = 200)
    @XmlElement(name = "medicinalproduct")
    private String medicinalproduct;

    /**
     * Recoded version of medicinalproduct
     */
    @Column(length = 200)
    @XmlTransient
    private String medicinalproductrecoded;

    /**
     * Populate by automatic recoding. When the result of recoding of medicinal product has changed the value is 1 (true).
     */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal ismedicinalproductchanged;

    /**
     * Populate by automatic recoding. If medicinal product has been recoded the value is 1 (true)
     */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal ismedicinalproductrecoded;

    /** Manual recoding value of {@link #medicinalproduct} */
    /**
     * TODO: Andrea
     */
    @Column(precision = 1)
    @XmlTransient
    private BigDecimal medicinalproductmrec;

    @Column(length = 2)
    @XmlElement(name = "obtaindrugcountry")
    private String obtaindrugcountry;

    /**
     * Result of recoding of the product index (EV code) from PRODUCTS3.P_PRODUCTINDEX<br/>
     * This field is redundant because productindexcode, however is populated by recoding.
     */
    @Column(name = "PRODUCT_EVCODE", length = 60)
    @XmlTransient
    private String productEvcode;

    /**
     * Primary key populated by recoding from the product index PRODUCTS3.P_PRODUCTINDEX
     */
    @Column(precision = 10)
    @XmlTransient
    private BigDecimal productindexcode;

    @Column(precision = 22)
    @XmlElement(name = "reactiongestationperiod")
    private BigDecimal reactiongestationperiod;

    @Column(precision = 3)
    @XmlElement(name = "reactiongestationperiodunit")
    private BigDecimal reactiongestationperiodunit;

    /**
     * TODO: David check
     */
    @Column(name = "REC_CHANGED", precision = 1)
    @XmlTransient
    private BigDecimal recChanged;

    /**
     * Populated by recoding. It is the stage when the recoding found the match
     */
    @Column(name = "RECODING_STAGE", precision = 22)
    @XmlTransient
    private BigDecimal recodingStage;

    /**
     * Populated by recoding. It is the timestamp when the recoding populate
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "RECODING_STAMP")
    @XmlTransient
    private Date recodingStamp;

    // bi-directional many-to-one association to ActiveSubstance
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IDrug")
    @XmlElement(name = "activesubstance")
    private List<ActiveSubstance> IActivesubstances;

    @Column(name = "FK_SAFETYREPORT", nullable = false, precision = 10)
    @XmlTransient
    private long fkSafetyreport;

    // bi-directional many-to-one association to Patient
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SAFETYREPORT", referencedColumnName = "PK_SAFETYREPORT", insertable = false,
            updatable = false)
    @XmlInverseReference(mappedBy = "IDrugs")
    private Patient IPatient;

    // bi-directional many-to-one association to DrugInterpreted
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IDrug")
    @XmlTransient
    private List<DrugInterpreted> IDruginterpreteds;

    // bi-directional many-to-one association to DrugreActionRelated
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IDrug")
    @XmlElement(name = "drugreactionrelatedness")
    private List<DrugReactionRelated> IDrugreactionrelateds;

    // bi-directional many-to-one association to DrugreCurrence
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IDrug")
    @XmlElement(name = "drugrecurrence")
    private List<DrugRecurrence> IDrugrecurrences;

    public Drug() {
    }

    @PrePersist
    public void initializeForeigners() {
        if (IActivesubstances != null) {
            for (ActiveSubstance activeSubstance : IActivesubstances) {
                activeSubstance.setFkDrug(pkDrug);
            }
        }
        if (IDrugreactionrelateds != null) {
            for (DrugReactionRelated related : IDrugreactionrelateds) {
                related.setFkDrug(pkDrug);
            }
        }
    }

    public long getFkSafetyreport() {
        return fkSafetyreport;
    }

    public void setFkSafetyreport(long fkSafetyreport) {
        this.fkSafetyreport = fkSafetyreport;
    }

    public long getPkDrug() {
        return this.pkDrug;
    }

    public void setPkDrug(long pkDrug) {
        this.pkDrug = pkDrug;
    }

    public BigDecimal getActiondrug() {
        return this.actiondrug;
    }

    public void setActiondrug(BigDecimal actiondrug) {
        this.actiondrug = actiondrug;
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

    public String getDrugadditional() {
        return this.drugadditional;
    }

    public void setDrugadditional(String drugadditional) {
        this.drugadditional = drugadditional;
    }

    public BigDecimal getDrugadministrationroute() {
        return this.drugadministrationroute;
    }

    public void setDrugadministrationroute(BigDecimal drugadministrationroute) {
        this.drugadministrationroute = drugadministrationroute;
    }

    public String getDrugauthorizationcountry() {
        return this.drugauthorizationcountry;
    }

    public void setDrugauthorizationcountry(String drugauthorizationcountry) {
        this.drugauthorizationcountry = drugauthorizationcountry;
    }

    public String getDrugauthorizationholder() {
        return this.drugauthorizationholder;
    }

    public void setDrugauthorizationholder(String drugauthorizationholder) {
        this.drugauthorizationholder = drugauthorizationholder;
    }

    public String getDrugauthorizationnumb() {
        return this.drugauthorizationnumb;
    }

    public void setDrugauthorizationnumb(String drugauthorizationnumb) {
        this.drugauthorizationnumb = drugauthorizationnumb;
    }

    public String getDrugbatchnumb() {
        return this.drugbatchnumb;
    }

    public void setDrugbatchnumb(String drugbatchnumb) {
        this.drugbatchnumb = drugbatchnumb;
    }

    public BigDecimal getDrugcharacterization() {
        return this.drugcharacterization;
    }

    public void setDrugcharacterization(BigDecimal drugcharacterization) {
        this.drugcharacterization = drugcharacterization;
    }

    public BigDecimal getDrugcumulativedosagenumb() {
        return this.drugcumulativedosagenumb;
    }

    public void setDrugcumulativedosagenumb(BigDecimal drugcumulativedosagenumb) {
        this.drugcumulativedosagenumb = drugcumulativedosagenumb;
    }

    public BigDecimal getDrugcumulativedosageunit() {
        return this.drugcumulativedosageunit;
    }

    public void setDrugcumulativedosageunit(BigDecimal drugcumulativedosageunit) {
        this.drugcumulativedosageunit = drugcumulativedosageunit;
    }

    public String getDrugdosageform() {
        return this.drugdosageform;
    }

    public void setDrugdosageform(String drugdosageform) {
        this.drugdosageform = drugdosageform;
    }

    public BigDecimal getDrugdosageformcode() {
        return this.drugdosageformcode;
    }

    public void setDrugdosageformcode(BigDecimal drugdosageformcode) {
        this.drugdosageformcode = drugdosageformcode;
    }

    public String getDrugdosagetext() {
        return this.drugdosagetext;
    }

    public void setDrugdosagetext(String drugdosagetext) {
        this.drugdosagetext = drugdosagetext;
    }

    public String getDrugenddate() {
        return this.drugenddate;
    }

    public void setDrugenddate(String drugenddate) {
        this.drugenddate = drugenddate;
    }

    public BigDecimal getDrugenddateformat() {
        return this.drugenddateformat;
    }

    public void setDrugenddateformat(BigDecimal drugenddateformat) {
        this.drugenddateformat = drugenddateformat;
    }

    public BigDecimal getDrugindication() {
        return this.drugindication;
    }

    public void setDrugindication(BigDecimal drugindication) {
        this.drugindication = drugindication;
    }

    public BigDecimal getDrugindicationct() {
        return this.drugindicationct;
    }

    public void setDrugindicationct(BigDecimal drugindicationct) {
        this.drugindicationct = drugindicationct;
    }

    public BigDecimal getDrugindicationmrec() {
        return this.drugindicationmrec;
    }

    public void setDrugindicationmrec(BigDecimal drugindicationmrec) {
        this.drugindicationmrec = drugindicationmrec;
    }

    public BigDecimal getDrugindicationmv() {
        return this.drugindicationmv;
    }

    public void setDrugindicationmv(BigDecimal drugindicationmv) {
        this.drugindicationmv = drugindicationmv;
    }

    public String getDrugindicationrecoded() {
        return this.drugindicationrecoded;
    }

    public void setDrugindicationrecoded(String drugindicationrecoded) {
        this.drugindicationrecoded = drugindicationrecoded;
    }

    public String getDrugindicationtext() {
        return this.drugindicationtext;
    }

    public void setDrugindicationtext(String drugindicationtext) {
        this.drugindicationtext = drugindicationtext;
    }

    public BigDecimal getDrugintervaldosagedefinition() {
        return this.drugintervaldosagedefinition;
    }

    public void setDrugintervaldosagedefinition(BigDecimal drugintervaldosagedefinition) {
        this.drugintervaldosagedefinition = drugintervaldosagedefinition;
    }

    public BigDecimal getDrugintervaldosageunitnumb() {
        return this.drugintervaldosageunitnumb;
    }

    public void setDrugintervaldosageunitnumb(BigDecimal drugintervaldosageunitnumb) {
        this.drugintervaldosageunitnumb = drugintervaldosageunitnumb;
    }

    public BigDecimal getDruglastperiod() {
        return this.druglastperiod;
    }

    public void setDruglastperiod(BigDecimal druglastperiod) {
        this.druglastperiod = druglastperiod;
    }

    public BigDecimal getDruglastperiodunit() {
        return this.druglastperiodunit;
    }

    public void setDruglastperiodunit(BigDecimal druglastperiodunit) {
        this.druglastperiodunit = druglastperiodunit;
    }

    public BigDecimal getDrugparadministration() {
        return this.drugparadministration;
    }

    public void setDrugparadministration(BigDecimal drugparadministration) {
        this.drugparadministration = drugparadministration;
    }

    public BigDecimal getDrugrecurreadministration() {
        return this.drugrecurreadministration;
    }

    public void setDrugrecurreadministration(BigDecimal drugrecurreadministration) {
        this.drugrecurreadministration = drugrecurreadministration;
    }

    public BigDecimal getDrugseparatedosagenumb() {
        return this.drugseparatedosagenumb;
    }

    public void setDrugseparatedosagenumb(BigDecimal drugseparatedosagenumb) {
        this.drugseparatedosagenumb = drugseparatedosagenumb;
    }

    public String getDrugstartdate() {
        return this.drugstartdate;
    }

    public void setDrugstartdate(String drugstartdate) {
        this.drugstartdate = drugstartdate;
    }

    public BigDecimal getDrugstartdateformat() {
        return this.drugstartdateformat;
    }

    public void setDrugstartdateformat(BigDecimal drugstartdateformat) {
        this.drugstartdateformat = drugstartdateformat;
    }

    public BigDecimal getDrugstartperiod() {
        return this.drugstartperiod;
    }

    public void setDrugstartperiod(BigDecimal drugstartperiod) {
        this.drugstartperiod = drugstartperiod;
    }

    public BigDecimal getDrugstartperiodunit() {
        return this.drugstartperiodunit;
    }

    public void setDrugstartperiodunit(BigDecimal drugstartperiodunit) {
        this.drugstartperiodunit = drugstartperiodunit;
    }

    public BigDecimal getDrugstructuredosagenumb() {
        return this.drugstructuredosagenumb;
    }

    public void setDrugstructuredosagenumb(BigDecimal drugstructuredosagenumb) {
        this.drugstructuredosagenumb = drugstructuredosagenumb;
    }

    public BigDecimal getDrugstructuredosageunit() {
        return this.drugstructuredosageunit;
    }

    public void setDrugstructuredosageunit(BigDecimal drugstructuredosageunit) {
        this.drugstructuredosageunit = drugstructuredosageunit;
    }

    public BigDecimal getDrugtreatmentduration() {
        return this.drugtreatmentduration;
    }

    public void setDrugtreatmentduration(BigDecimal drugtreatmentduration) {
        this.drugtreatmentduration = drugtreatmentduration;
    }

    public BigDecimal getDrugtreatmentdurationunit() {
        return this.drugtreatmentdurationunit;
    }

    public void setDrugtreatmentdurationunit(BigDecimal drugtreatmentdurationunit) {
        this.drugtreatmentdurationunit = drugtreatmentdurationunit;
    }

    public BigDecimal getFkModeldrug() {
        return this.fkModeldrug;
    }

    public void setFkModeldrug(BigDecimal fkModeldrug) {
        this.fkModeldrug = fkModeldrug;
    }

    public BigDecimal getFkQidrugindication() {
        return this.fkQidrugindication;
    }

    public void setFkQidrugindication(BigDecimal fkQidrugindication) {
        this.fkQidrugindication = fkQidrugindication;
    }

    public BigDecimal getFkQimedicinalproduct() {
        return this.fkQimedicinalproduct;
    }

    public void setFkQimedicinalproduct(BigDecimal fkQimedicinalproduct) {
        this.fkQimedicinalproduct = fkQimedicinalproduct;
    }

    public BigDecimal getIsblindedchanged() {
        return this.isblindedchanged;
    }

    public void setIsblindedchanged(BigDecimal isblindedchanged) {
        this.isblindedchanged = isblindedchanged;
    }

    public BigDecimal getIsdrugindicationchanged() {
        return this.isdrugindicationchanged;
    }

    public void setIsdrugindicationchanged(BigDecimal isdrugindicationchanged) {
        this.isdrugindicationchanged = isdrugindicationchanged;
    }

    public BigDecimal getIsdrugindicationrecoded() {
        return this.isdrugindicationrecoded;
    }

    public void setIsdrugindicationrecoded(BigDecimal isdrugindicationrecoded) {
        this.isdrugindicationrecoded = isdrugindicationrecoded;
    }

    public BigDecimal getIsmedicinalproductchanged() {
        return this.ismedicinalproductchanged;
    }

    public void setIsmedicinalproductchanged(BigDecimal ismedicinalproductchanged) {
        this.ismedicinalproductchanged = ismedicinalproductchanged;
    }

    public BigDecimal getIsmedicinalproductrecoded() {
        return this.ismedicinalproductrecoded;
    }

    public void setIsmedicinalproductrecoded(BigDecimal ismedicinalproductrecoded) {
        this.ismedicinalproductrecoded = ismedicinalproductrecoded;
    }

    public String getMedicinalproduct() {
        return this.medicinalproduct;
    }

    public void setMedicinalproduct(String medicinalproduct) {
        this.medicinalproduct = medicinalproduct;
    }

    public BigDecimal getMedicinalproductmrec() {
        return this.medicinalproductmrec;
    }

    public void setMedicinalproductmrec(BigDecimal medicinalproductmrec) {
        this.medicinalproductmrec = medicinalproductmrec;
    }

    public String getMedicinalproductrecoded() {
        return this.medicinalproductrecoded;
    }

    public void setMedicinalproductrecoded(String medicinalproductrecoded) {
        this.medicinalproductrecoded = medicinalproductrecoded;
    }

    public String getObtaindrugcountry() {
        return this.obtaindrugcountry;
    }

    public void setObtaindrugcountry(String obtaindrugcountry) {
        this.obtaindrugcountry = obtaindrugcountry;
    }

    public String getProductEvcode() {
        return this.productEvcode;
    }

    public void setProductEvcode(String productEvcode) {
        this.productEvcode = productEvcode;
    }

    public BigDecimal getProductindexcode() {
        return this.productindexcode;
    }

    public void setProductindexcode(BigDecimal productindexcode) {
        this.productindexcode = productindexcode;
    }

    public BigDecimal getReactiongestationperiod() {
        return this.reactiongestationperiod;
    }

    public void setReactiongestationperiod(BigDecimal reactiongestationperiod) {
        this.reactiongestationperiod = reactiongestationperiod;
    }

    public BigDecimal getReactiongestationperiodunit() {
        return this.reactiongestationperiodunit;
    }

    public void setReactiongestationperiodunit(BigDecimal reactiongestationperiodunit) {
        this.reactiongestationperiodunit = reactiongestationperiodunit;
    }

    public BigDecimal getRecChanged() {
        return this.recChanged;
    }

    public void setRecChanged(BigDecimal recChanged) {
        this.recChanged = recChanged;
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

    public List<ActiveSubstance> getIActivesubstances() {
        return this.IActivesubstances;
    }

    public void setIActivesubstances(List<ActiveSubstance> IActivesubstances) {
        this.IActivesubstances = IActivesubstances;
    }

    public ActiveSubstance addIActivesubstance(ActiveSubstance IActivesubstance) {
        getIActivesubstances().add(IActivesubstance);
        IActivesubstance.setIDrug(this);

        return IActivesubstance;
    }

    public ActiveSubstance removeIActivesubstance(ActiveSubstance IActivesubstance) {
        getIActivesubstances().remove(IActivesubstance);
        IActivesubstance.setIDrug(null);

        return IActivesubstance;
    }

    public Patient getIPatient() {
        return this.IPatient;
    }

    public void setIPatient(Patient IPatient) {
        this.IPatient = IPatient;
    }

    public List<DrugInterpreted> getIDruginterpreteds() {
        return this.IDruginterpreteds;
    }

    public void setIDruginterpreteds(List<DrugInterpreted> IDruginterpreteds) {
        this.IDruginterpreteds = IDruginterpreteds;
    }

    public DrugInterpreted addIDruginterpreted(DrugInterpreted IDruginterpreted) {
        getIDruginterpreteds().add(IDruginterpreted);
        IDruginterpreted.setIDrug(this);

        return IDruginterpreted;
    }

    public DrugInterpreted removeIDruginterpreted(DrugInterpreted IDruginterpreted) {
        getIDruginterpreteds().remove(IDruginterpreted);
        IDruginterpreted.setIDrug(null);

        return IDruginterpreted;
    }

    public List<DrugReactionRelated> getIDrugreactionrelateds() {
        return this.IDrugreactionrelateds;
    }

    public void setIDrugreactionrelateds(List<DrugReactionRelated> IDrugreactionrelateds) {
        this.IDrugreactionrelateds = IDrugreactionrelateds;
    }

    public DrugReactionRelated addIDrugreactionrelated(DrugReactionRelated IDrugreactionrelated) {
        getIDrugreactionrelateds().add(IDrugreactionrelated);
        IDrugreactionrelated.setIDrug(this);

        return IDrugreactionrelated;
    }

    public DrugReactionRelated removeIDrugreactionrelated(DrugReactionRelated IDrugreactionrelated) {
        getIDrugreactionrelateds().remove(IDrugreactionrelated);
        IDrugreactionrelated.setIDrug(null);

        return IDrugreactionrelated;
    }

    public List<DrugRecurrence> getIDrugrecurrences() {
        return this.IDrugrecurrences;
    }

    public void setIDrugrecurrences(List<DrugRecurrence> IDrugrecurrences) {
        this.IDrugrecurrences = IDrugrecurrences;
    }

    public DrugRecurrence addIDrugrecurrence(DrugRecurrence IDrugrecurrence) {
        getIDrugrecurrences().add(IDrugrecurrence);
        IDrugrecurrence.setIDrug(this);

        return IDrugrecurrence;
    }

    public DrugRecurrence removeIDrugrecurrence(DrugRecurrence IDrugrecurrence) {
        getIDrugrecurrences().remove(IDrugrecurrence);
        IDrugrecurrence.setIDrug(null);

        return IDrugrecurrence;
    }

}