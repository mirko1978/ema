package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the I_FLAGSTATUS database table. <br/>
 * Look at the stored procedure ICHICSR.EV_ICHICSR_STATUS. <br/>
 */
@Entity
@Table(name = "I_FLAGSTATUS")
@NamedQuery(name = "FlagStatus.findAll", query = "SELECT f FROM FlagStatus f")
@IdClass(FlagStatusPK.class)
public class FlagStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FK_SAFETYREPORT", precision = 10)
    private long fkSafetyreport;

    @Id
    @Column(unique = true, nullable = false, precision = 3)
    private long flagcode;

    /**
     * Foregein key from METABASE.LK_FLAGVALUE
     */
    @Column(nullable = false, precision = 3)
    private BigDecimal flagvalue;

    /** System that wrote the record.<br/>
     * ETL = ETL from DWH <br/>
     * NQI = ??
     * CCL = Duplicate Detection Client <br/>
     * MAN = Manual ?? <br/>
     * ETD = ?? <br/>
     * REC = Automatic recoding <br/>
     * CLA = Classification <br/>
     * INT = Interpretation
     *
     */
    /**
     * TODO: Andrea
     */
    @Column(length = 3)
    private String origin;

    /**
     * Date when the record was created
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "\"WHEN\"")
    private Date when;

    // bi-directional many-to-one association to SafetyReport
    @ManyToOne
    @JoinColumn(name = "FK_SAFETYREPORT", nullable = false, insertable = false, updatable = false)
    private SafetyReport ISafetyreport;

    public FlagStatus() {
    }

    public BigDecimal getFlagvalue() {
        return this.flagvalue;
    }

    public void setFlagvalue(BigDecimal flagvalue) {
        this.flagvalue = flagvalue;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getWhen() {
        return this.when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public SafetyReport getISafetyreport() {
        return this.ISafetyreport;
    }

    public void setISafetyreport(SafetyReport ISafetyreport) {
        this.ISafetyreport = ISafetyreport;
    }

    public long getFkSafetyreport() {
        return fkSafetyreport;
    }

    public void setFkSafetyreport(long fkSafetyreport) {
        this.fkSafetyreport = fkSafetyreport;
    }

    public long getFlagcode() {
        return flagcode;
    }

    public void setFlagcode(long flagcode) {
        this.flagcode = flagcode;
    }
}