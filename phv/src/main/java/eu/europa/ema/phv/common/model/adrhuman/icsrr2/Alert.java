package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the I_ALERTS database table.
 * 
 */
@Entity
@Table(name = "I_ALERTS")
@NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a")
public class Alert implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_ALERTS", unique = true, nullable = false, precision = 10)
    private long pkAlerts;

    @Column(name = "ALERT_USER", length = 100)
    private String alertUser;

    @Column(nullable = false, precision = 2)
    private BigDecimal alertcode;

    @Column(nullable = false, precision = 2)
    private BigDecimal alertstatus;

    @Column(nullable = false, precision = 10)
    private BigDecimal clusterid;

    @Lob
    private String comments;

    @Column(name = "PK_EVENTREPORTS", precision = 10)
    private BigDecimal pkEventreports;

    @Column(name = "PK_MASTER", nullable = false, precision = 10)
    private BigDecimal pkMaster;

    @Temporal(TemporalType.DATE)
    @Column(name = "\"WHEN\"", nullable = false)
    private Date when;

    public Alert() {
    }

    public long getPkAlerts() {
        return this.pkAlerts;
    }

    public void setPkAlerts(long pkAlerts) {
        this.pkAlerts = pkAlerts;
    }

    public String getAlertUser() {
        return this.alertUser;
    }

    public void setAlertUser(String alertUser) {
        this.alertUser = alertUser;
    }

    public BigDecimal getAlertcode() {
        return this.alertcode;
    }

    public void setAlertcode(BigDecimal alertcode) {
        this.alertcode = alertcode;
    }

    public BigDecimal getAlertstatus() {
        return this.alertstatus;
    }

    public void setAlertstatus(BigDecimal alertstatus) {
        this.alertstatus = alertstatus;
    }

    public BigDecimal getClusterid() {
        return this.clusterid;
    }

    public void setClusterid(BigDecimal clusterid) {
        this.clusterid = clusterid;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getPkEventreports() {
        return this.pkEventreports;
    }

    public void setPkEventreports(BigDecimal pkEventreports) {
        this.pkEventreports = pkEventreports;
    }

    public BigDecimal getPkMaster() {
        return this.pkMaster;
    }

    public void setPkMaster(BigDecimal pkMaster) {
        this.pkMaster = pkMaster;
    }

    public Date getWhen() {
        return this.when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

}