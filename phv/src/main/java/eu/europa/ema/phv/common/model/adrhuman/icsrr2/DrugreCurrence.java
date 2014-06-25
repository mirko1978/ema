package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_DRUGRECURRENCE database table.
 * 
 */
@Entity
@Table(name="I_DRUGRECURRENCE")
@NamedQuery(name="DrugRecurrence.findAll", query="SELECT d FROM DrugRecurrence d")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "drugrecurrence")
public class DrugRecurrence implements Serializable {

    private static final long serialVersionUID = 4024259418752657631L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_DRUGRECURRENCE", unique=true, nullable=false, precision=10)
    @XmlTransient
	private long pkDrugrecurrence;

	@Column(precision=10)
    @XmlElement(required = true, name = "drugrecuraction")
	private BigDecimal drugrecuraction;

	@Column(precision=10)
    @XmlTransient
	private BigDecimal drugrecuractionct;

	@Column(precision=22)
    @XmlElement(name = "drugrecuractionmeddraversion")
	private BigDecimal drugrecuractionmv;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="FK_DRUG", nullable=false)
    @XmlInverseReference(mappedBy = "IDrugrecurrences")
	private Drug IDrug;

	public DrugRecurrence() {
	}

	public long getPkDrugrecurrence() {
		return this.pkDrugrecurrence;
	}

	public void setPkDrugrecurrence(long pkDrugrecurrence) {
		this.pkDrugrecurrence = pkDrugrecurrence;
	}

	public BigDecimal getDrugrecuraction() {
		return this.drugrecuraction;
	}

	public void setDrugrecuraction(BigDecimal drugrecuraction) {
		this.drugrecuraction = drugrecuraction;
	}

	public BigDecimal getDrugrecuractionct() {
		return this.drugrecuractionct;
	}

	public void setDrugrecuractionct(BigDecimal drugrecuractionct) {
		this.drugrecuractionct = drugrecuractionct;
	}

	public BigDecimal getDrugrecuractionmv() {
		return this.drugrecuractionmv;
	}

	public void setDrugrecuractionmv(BigDecimal drugrecuractionmv) {
		this.drugrecuractionmv = drugrecuractionmv;
	}

	public Drug getIDrug() {
		return this.IDrug;
	}

	public void setIDrug(Drug IDrug) {
		this.IDrug = IDrug;
	}

}