package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the I_CLUSTER database table.
 * 
 */
@Entity
@Table(name = "I_CLUSTER")
@NamedQuery(name = "Cluster.findAll", query = "SELECT c FROM Cluster c")
public class Cluster implements Serializable {
    private static final long serialVersionUID = 1L;

    /** TODO: Sujata */
    @Id
    @GeneratedValue(generator="Cluster")
    @SequenceGenerator(name="Cluster",sequenceName="SEQ_CLUSTERID", allocationSize=100)
    @Column(name = "FK_SAFETYREPORT", unique = true, nullable = false, precision = 22)
    private long fkSafetyreport;

    @Temporal(TemporalType.DATE)
    @Column(name = "CLUSTER_ALERT")
    private Date clusterAlert;

    @Column(precision = 22)
    private BigDecimal clusterrole;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "PK_CLUSTERID", precision = 22)
    private BigDecimal pkClusterid;

    // bi-directional one-to-one association to SafetyReport
    @OneToOne
    @JoinColumn(name = "FK_SAFETYREPORT", nullable = false, insertable = false, updatable = false)
    private SafetyReport ISafetyreport;

    public Cluster() {
    }

    public long getFkSafetyreport() {
        return this.fkSafetyreport;
    }

    public void setFkSafetyreport(long fkSafetyreport) {
        this.fkSafetyreport = fkSafetyreport;
    }

    public Date getClusterAlert() {
        return this.clusterAlert;
    }

    public void setClusterAlert(Date clusterAlert) {
        this.clusterAlert = clusterAlert;
    }

    public BigDecimal getClusterrole() {
        return this.clusterrole;
    }

    public void setClusterrole(BigDecimal clusterrole) {
        this.clusterrole = clusterrole;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getPkClusterid() {
        return this.pkClusterid;
    }

    public void setPkClusterid(BigDecimal pkClusterid) {
        this.pkClusterid = pkClusterid;
    }

    public SafetyReport getISafetyreport() {
        return this.ISafetyreport;
    }

    public void setISafetyreport(SafetyReport ISafetyreport) {
        this.ISafetyreport = ISafetyreport;
    }

}