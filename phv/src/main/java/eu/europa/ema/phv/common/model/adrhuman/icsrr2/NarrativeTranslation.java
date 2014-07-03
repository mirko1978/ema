package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the I_NARRATIVE_TRANSLATION database table.
 * 
 */
@Entity
@Table(name = "I_NARRATIVE_TRANSLATION")
@NamedQuery(name = "NarrativeTranslation.findAll", query = "SELECT n FROM NarrativeTranslation n")
public class NarrativeTranslation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NarrativeTranslation")
    @SequenceGenerator(name="NarrativeTranslation",sequenceName="SEQ_NARRATIVETRANSLATION", allocationSize=1)
    @Column(name = "PK_TRANSLATION", unique = true, nullable = false, precision = 10)
    private long pkTranslation;

    @Lob
    private String casenarrative;

    @Column(length = 400)
    private String casenumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_STAMP")
    private Date createdStamp;

    @Column(name = "FK_SAFETYREPORT", precision = 22)
    private BigDecimal fkSafetyreport;

    @Column(length = 60)
    private String headquarterid;

    @Column(name = "LANGUAGE_CODE", length = 8)
    private String languageCode;

    @Column(name = "NULLIFYBY_USER", length = 240)
    private String nullifybyUser;

    @Temporal(TemporalType.DATE)
    @Column(name = "REPLACED_STAMP")
    private Date replacedStamp;

    @Temporal(TemporalType.DATE)
    @Column(name = "STAMP_NULLIF")
    private Date stampNullif;

    @Column(length = 240)
    private String userid;

    public NarrativeTranslation() {
    }

    public long getPkTranslation() {
        return this.pkTranslation;
    }

    public void setPkTranslation(long pkTranslation) {
        this.pkTranslation = pkTranslation;
    }

    public String getCasenarrative() {
        return this.casenarrative;
    }

    public void setCasenarrative(String casenarrative) {
        this.casenarrative = casenarrative;
    }

    public String getCasenumber() {
        return this.casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber;
    }

    public Date getCreatedStamp() {
        return this.createdStamp;
    }

    public void setCreatedStamp(Date createdStamp) {
        this.createdStamp = createdStamp;
    }

    public BigDecimal getFkSafetyreport() {
        return this.fkSafetyreport;
    }

    public void setFkSafetyreport(BigDecimal fkSafetyreport) {
        this.fkSafetyreport = fkSafetyreport;
    }

    public String getHeadquarterid() {
        return this.headquarterid;
    }

    public void setHeadquarterid(String headquarterid) {
        this.headquarterid = headquarterid;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getNullifybyUser() {
        return this.nullifybyUser;
    }

    public void setNullifybyUser(String nullifybyUser) {
        this.nullifybyUser = nullifybyUser;
    }

    public Date getReplacedStamp() {
        return this.replacedStamp;
    }

    public void setReplacedStamp(Date replacedStamp) {
        this.replacedStamp = replacedStamp;
    }

    public Date getStampNullif() {
        return this.stampNullif;
    }

    public void setStampNullif(Date stampNullif) {
        this.stampNullif = stampNullif;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}