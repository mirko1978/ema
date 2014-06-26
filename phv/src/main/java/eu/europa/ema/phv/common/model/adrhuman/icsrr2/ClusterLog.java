package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the I_CLUSTERLOG database table.
 * 
 */
@Entity
@Table(name = "I_CLUSTERLOG")
@NamedQuery(name = "ClusterLog.findAll", query = "SELECT c FROM ClusterLog c")
public class ClusterLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_LOG", unique = true, nullable = false, precision = 10)
    private long pkLog;

    @Column(precision = 10)
    private BigDecimal clusterid;

    @Column(length = 100)
    private String cnmaster;

    @Lob
    private String comments;

    @Column(precision = 2)
    private BigDecimal operationcode;

    @Column(precision = 10)
    private BigDecimal pkmaster;

    @Temporal(TemporalType.DATE)
    @Column(name = "\"WHEN\"", nullable = false)
    private Date when;

    public ClusterLog() {
    }

    public long getPkLog() {
        return this.pkLog;
    }

    public void setPkLog(long pkLog) {
        this.pkLog = pkLog;
    }

    public BigDecimal getClusterid() {
        return this.clusterid;
    }

    public void setClusterid(BigDecimal clusterid) {
        this.clusterid = clusterid;
    }

    public String getCnmaster() {
        return this.cnmaster;
    }

    public void setCnmaster(String cnmaster) {
        this.cnmaster = cnmaster;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getOperationcode() {
        return this.operationcode;
    }

    public void setOperationcode(BigDecimal operationcode) {
        this.operationcode = operationcode;
    }

    public BigDecimal getPkmaster() {
        return this.pkmaster;
    }

    public void setPkmaster(BigDecimal pkmaster) {
        this.pkmaster = pkmaster;
    }

    public Date getWhen() {
        return this.when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

}