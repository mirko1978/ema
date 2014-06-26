package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the I_PARENTPASTDRUGTHERAPY database table.
 * 
 */
@Entity
@Table(name = "I_PARENTPASTDRUGTHERAPY")
@NamedQuery(name = "ParentPastDrugTherapy.findAll", query = "SELECT p FROM ParentPastDrugTherapy p")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "parentpastdrugtherapy")
public class ParentPastDrugTherapy implements Serializable {

    private static final long serialVersionUID = -3361137215621775330L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_PARENTPASTDRUGTHERAPY", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkParentpastdrugtherapy;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal blinded;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal blindedmrec;

    @Column(name = "FK_QIPARENTDRUGINDICATION", precision = 10)
    @XmlTransient
    private BigDecimal fkQiparentdrugindication;

    @Column(name = "FK_QIPARENTDRUGNAME", precision = 10)
    @XmlTransient
    private BigDecimal fkQiparentdrugname;

    @Column(name = "FK_QIPARENTDRUGREACTION", precision = 10)
    @XmlTransient
    private BigDecimal fkQiparentdrugreaction;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isblindedchanged;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isparentdrugindicationchanged;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isparentdrugindicationrecoded;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isparentdrugnamechanged;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isparentdrugnamerecoded;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isparentdrugreactionchanged;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal isparentdrugreactionrecoded;

    @Column(precision = 22)
    @XmlElement(name = "parentdrgindicationmeddraversion")
    private BigDecimal parentdrgindicationmv;

    @Column(precision = 22)
    @XmlElement(name = "parentdrgreactionmeddraversion")
    private BigDecimal parentdrgreactionmv;

    @Column(length = 14)
    @XmlElement(name = "parentdrugenddate")
    private String parentdrugenddate;

    @Column(precision = 3)
    @XmlElement(name = "parentdrugenddateformat")
    private BigDecimal parentdrugenddateformat;

    @Column(precision = 10)
    @XmlElement(name = "parentdrugindication")
    private BigDecimal parentdrugindication;

    @Column(precision = 10)
    @XmlTransient
    private BigDecimal parentdrugindicationct;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal parentdrugindicationmrec;

    @Column(length = 250)
    @XmlTransient
    private String parentdrugindicationrecoded;

    @Column(length = 250)
    @XmlTransient
    private String parentdrugindicationtext;

    @Column(length = 200)
    @XmlElement(name = "parentdrugname")
    private String parentdrugname;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal parentdrugnamemrec;

    @Column(length = 200)
    @XmlTransient
    private String parentdrugnamerecoded;

    @Column(precision = 10)
    @XmlElement(name = "parentdrugreaction")
    private BigDecimal parentdrugreaction;

    @Column(precision = 10)
    @XmlTransient
    private BigDecimal parentdrugreactionct;

    @Column(precision = 1)
    @XmlTransient
    private BigDecimal parentdrugreactionmrec;

    @Column(length = 250)
    @XmlTransient
    private String parentdrugreactionrecoded;

    @Column(length = 250)
    @XmlTransient
    private String parentdrugreactiontext;

    @Column(length = 14)
    @XmlElement(name = "parentdrugstartdate")
    private String parentdrugstartdate;

    @Column(precision = 3)
    @XmlElement(name = "parentdrugstartdateformat")
    private BigDecimal parentdrugstartdateformat;

    @Column(name = "PRODUCT_EVCODE", length = 60)
    @XmlTransient
    private String productEvcode;

    @Column(precision = 10)
    @XmlTransient
    private BigDecimal productindexcode;

    @Column(name = "RECODING_STAGE", precision = 22)
    @XmlTransient
    private BigDecimal recodingStage;

    @Temporal(TemporalType.DATE)
    @Column(name = "RECODING_STAMP")
    private Date recodingStamp;

    // bi-directional many-to-one association to IParent
    @ManyToOne
    @JoinColumn(name = "FK_SAFETYREPORT", nullable = false)
    @XmlInverseReference(mappedBy = "IParentpastdrugtherapies")
    private Parent Parent;

    public ParentPastDrugTherapy() {
    }

    public long getPkParentpastdrugtherapy() {
        return this.pkParentpastdrugtherapy;
    }

    public void setPkParentpastdrugtherapy(long pkParentpastdrugtherapy) {
        this.pkParentpastdrugtherapy = pkParentpastdrugtherapy;
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

    public BigDecimal getFkQiparentdrugindication() {
        return this.fkQiparentdrugindication;
    }

    public void setFkQiparentdrugindication(BigDecimal fkQiparentdrugindication) {
        this.fkQiparentdrugindication = fkQiparentdrugindication;
    }

    public BigDecimal getFkQiparentdrugname() {
        return this.fkQiparentdrugname;
    }

    public void setFkQiparentdrugname(BigDecimal fkQiparentdrugname) {
        this.fkQiparentdrugname = fkQiparentdrugname;
    }

    public BigDecimal getFkQiparentdrugreaction() {
        return this.fkQiparentdrugreaction;
    }

    public void setFkQiparentdrugreaction(BigDecimal fkQiparentdrugreaction) {
        this.fkQiparentdrugreaction = fkQiparentdrugreaction;
    }

    public BigDecimal getIsblindedchanged() {
        return this.isblindedchanged;
    }

    public void setIsblindedchanged(BigDecimal isblindedchanged) {
        this.isblindedchanged = isblindedchanged;
    }

    public BigDecimal getIsparentdrugindicationchanged() {
        return this.isparentdrugindicationchanged;
    }

    public void setIsparentdrugindicationchanged(BigDecimal isparentdrugindicationchanged) {
        this.isparentdrugindicationchanged = isparentdrugindicationchanged;
    }

    public BigDecimal getIsparentdrugindicationrecoded() {
        return this.isparentdrugindicationrecoded;
    }

    public void setIsparentdrugindicationrecoded(BigDecimal isparentdrugindicationrecoded) {
        this.isparentdrugindicationrecoded = isparentdrugindicationrecoded;
    }

    public BigDecimal getIsparentdrugnamechanged() {
        return this.isparentdrugnamechanged;
    }

    public void setIsparentdrugnamechanged(BigDecimal isparentdrugnamechanged) {
        this.isparentdrugnamechanged = isparentdrugnamechanged;
    }

    public BigDecimal getIsparentdrugnamerecoded() {
        return this.isparentdrugnamerecoded;
    }

    public void setIsparentdrugnamerecoded(BigDecimal isparentdrugnamerecoded) {
        this.isparentdrugnamerecoded = isparentdrugnamerecoded;
    }

    public BigDecimal getIsparentdrugreactionchanged() {
        return this.isparentdrugreactionchanged;
    }

    public void setIsparentdrugreactionchanged(BigDecimal isparentdrugreactionchanged) {
        this.isparentdrugreactionchanged = isparentdrugreactionchanged;
    }

    public BigDecimal getIsparentdrugreactionrecoded() {
        return this.isparentdrugreactionrecoded;
    }

    public void setIsparentdrugreactionrecoded(BigDecimal isparentdrugreactionrecoded) {
        this.isparentdrugreactionrecoded = isparentdrugreactionrecoded;
    }

    public BigDecimal getParentdrgindicationmv() {
        return this.parentdrgindicationmv;
    }

    public void setParentdrgindicationmv(BigDecimal parentdrgindicationmv) {
        this.parentdrgindicationmv = parentdrgindicationmv;
    }

    public BigDecimal getParentdrgreactionmv() {
        return this.parentdrgreactionmv;
    }

    public void setParentdrgreactionmv(BigDecimal parentdrgreactionmv) {
        this.parentdrgreactionmv = parentdrgreactionmv;
    }

    public String getParentdrugenddate() {
        return this.parentdrugenddate;
    }

    public void setParentdrugenddate(String parentdrugenddate) {
        this.parentdrugenddate = parentdrugenddate;
    }

    public BigDecimal getParentdrugenddateformat() {
        return this.parentdrugenddateformat;
    }

    public void setParentdrugenddateformat(BigDecimal parentdrugenddateformat) {
        this.parentdrugenddateformat = parentdrugenddateformat;
    }

    public BigDecimal getParentdrugindication() {
        return this.parentdrugindication;
    }

    public void setParentdrugindication(BigDecimal parentdrugindication) {
        this.parentdrugindication = parentdrugindication;
    }

    public BigDecimal getParentdrugindicationct() {
        return this.parentdrugindicationct;
    }

    public void setParentdrugindicationct(BigDecimal parentdrugindicationct) {
        this.parentdrugindicationct = parentdrugindicationct;
    }

    public BigDecimal getParentdrugindicationmrec() {
        return this.parentdrugindicationmrec;
    }

    public void setParentdrugindicationmrec(BigDecimal parentdrugindicationmrec) {
        this.parentdrugindicationmrec = parentdrugindicationmrec;
    }

    public String getParentdrugindicationrecoded() {
        return this.parentdrugindicationrecoded;
    }

    public void setParentdrugindicationrecoded(String parentdrugindicationrecoded) {
        this.parentdrugindicationrecoded = parentdrugindicationrecoded;
    }

    public String getParentdrugindicationtext() {
        return this.parentdrugindicationtext;
    }

    public void setParentdrugindicationtext(String parentdrugindicationtext) {
        this.parentdrugindicationtext = parentdrugindicationtext;
    }

    public String getParentdrugname() {
        return this.parentdrugname;
    }

    public void setParentdrugname(String parentdrugname) {
        this.parentdrugname = parentdrugname;
    }

    public BigDecimal getParentdrugnamemrec() {
        return this.parentdrugnamemrec;
    }

    public void setParentdrugnamemrec(BigDecimal parentdrugnamemrec) {
        this.parentdrugnamemrec = parentdrugnamemrec;
    }

    public String getParentdrugnamerecoded() {
        return this.parentdrugnamerecoded;
    }

    public void setParentdrugnamerecoded(String parentdrugnamerecoded) {
        this.parentdrugnamerecoded = parentdrugnamerecoded;
    }

    public BigDecimal getParentdrugreaction() {
        return this.parentdrugreaction;
    }

    public void setParentdrugreaction(BigDecimal parentdrugreaction) {
        this.parentdrugreaction = parentdrugreaction;
    }

    public BigDecimal getParentdrugreactionct() {
        return this.parentdrugreactionct;
    }

    public void setParentdrugreactionct(BigDecimal parentdrugreactionct) {
        this.parentdrugreactionct = parentdrugreactionct;
    }

    public BigDecimal getParentdrugreactionmrec() {
        return this.parentdrugreactionmrec;
    }

    public void setParentdrugreactionmrec(BigDecimal parentdrugreactionmrec) {
        this.parentdrugreactionmrec = parentdrugreactionmrec;
    }

    public String getParentdrugreactionrecoded() {
        return this.parentdrugreactionrecoded;
    }

    public void setParentdrugreactionrecoded(String parentdrugreactionrecoded) {
        this.parentdrugreactionrecoded = parentdrugreactionrecoded;
    }

    public String getParentdrugreactiontext() {
        return this.parentdrugreactiontext;
    }

    public void setParentdrugreactiontext(String parentdrugreactiontext) {
        this.parentdrugreactiontext = parentdrugreactiontext;
    }

    public String getParentdrugstartdate() {
        return this.parentdrugstartdate;
    }

    public void setParentdrugstartdate(String parentdrugstartdate) {
        this.parentdrugstartdate = parentdrugstartdate;
    }

    public BigDecimal getParentdrugstartdateformat() {
        return this.parentdrugstartdateformat;
    }

    public void setParentdrugstartdateformat(BigDecimal parentdrugstartdateformat) {
        this.parentdrugstartdateformat = parentdrugstartdateformat;
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

    public Parent getParent() {
        return this.Parent;
    }

    public void setParent(Parent parent) {
        this.Parent = parent;
    }

}