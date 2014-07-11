package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the I_R_LOCKING database table.
 */
@Entity
@Table(name = "I_R_LOCKING")
@NamedQuery(name = "RLocking.findAll", query = "SELECT r FROM RLocking r")
public class RLocking implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PK_SAFETYREPORT", unique = true, nullable = false, precision = 10)
    private long pkSafetyreport;

    @Column(name = "START_JOB")
    private Timestamp startJob;

    @Column(length = 60)
    private String userid;

    public RLocking() {
    }

    public long getPkSafetyreport() {
        return this.pkSafetyreport;
    }

    public void setPkSafetyreport(long pkSafetyreport) {
        this.pkSafetyreport = pkSafetyreport;
    }

    public Timestamp getStartJob() {
        return this.startJob;
    }

    public void setStartJob(Timestamp startJob) {
        this.startJob = startJob;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}