package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the I_CLUSTERDUPLICATE database table.
 */
@Entity
@IdClass(value = ClusterDuplicate.class)
@Table(name = "I_CLUSTERDUPLICATE")
@NamedQuery(name = "ClusterDuplicate.findAll", query = "SELECT c FROM ClusterDuplicate c")
public class ClusterDuplicate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "DUPLICATE_ID", precision = 22)
    private BigDecimal duplicateId;

    @Id
    @Column(name = "FK_SAFETYREPORT", precision = 22)
    private BigDecimal fkSafetyreport;

    public ClusterDuplicate() {
    }

    public BigDecimal getDuplicateId() {
        return this.duplicateId;
    }

    public void setDuplicateId(BigDecimal duplicateId) {
        this.duplicateId = duplicateId;
    }

    public BigDecimal getFkSafetyreport() {
        return this.fkSafetyreport;
    }

    public void setFkSafetyreport(BigDecimal fkSafetyreport) {
        this.fkSafetyreport = fkSafetyreport;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((duplicateId == null) ? 0 : duplicateId.hashCode());
        result = prime * result + ((fkSafetyreport == null) ? 0 : fkSafetyreport.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ClusterDuplicate other = (ClusterDuplicate) obj;
        if (duplicateId == null) {
            if (other.duplicateId != null) {
                return false;
            }
        }
        else if (!duplicateId.equals(other.duplicateId)) {
            return false;
        }
        if (fkSafetyreport == null) {
            if (other.fkSafetyreport != null) {
                return false;
            }
        }
        else if (!fkSafetyreport.equals(other.fkSafetyreport)) {
            return false;
        }
        return true;
    }

}