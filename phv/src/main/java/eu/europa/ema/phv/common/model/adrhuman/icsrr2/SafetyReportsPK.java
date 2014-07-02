package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the I_SAFETYREPORTS database table.
 * 
 */
public class SafetyReportsPK implements Serializable {
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    /** Foreign key from SafetyReport */
    private long fkSafetyreport;

    /** Foreign key from IchicsrMessage */
    private long fkIchicsrmessage;

    public SafetyReportsPK() {
    }

    public long getFkSafetyreport() {
        return this.fkSafetyreport;
    }

    public void setFkSafetyreport(long fkSafetyreport) {
        this.fkSafetyreport = fkSafetyreport;
    }

    public long getFkIchicsrmessage() {
        return this.fkIchicsrmessage;
    }

    public void setFkIchicsrmessage(long fkIchicsrmessage) {
        this.fkIchicsrmessage = fkIchicsrmessage;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafetyReportsPK)) {
            return false;
        }
        SafetyReportsPK castOther = (SafetyReportsPK) other;
        return (this.fkSafetyreport == castOther.fkSafetyreport)
                && (this.fkIchicsrmessage == castOther.fkIchicsrmessage);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.fkSafetyreport ^ (this.fkSafetyreport >>> 32)));
        hash = hash * prime + ((int) (this.fkIchicsrmessage ^ (this.fkIchicsrmessage >>> 32)));

        return hash;
    }
}