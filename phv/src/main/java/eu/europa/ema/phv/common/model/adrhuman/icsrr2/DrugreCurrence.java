package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_DRUGRECURRENCE database table.
 * 
 */
@Entity
@Table(name="I_DRUGRECURRENCE")
@NamedQuery(name="DrugreCurrence.findAll", query="SELECT d FROM DrugreCurrence d")
public class DrugreCurrence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_DRUGRECURRENCE", unique=true, nullable=false, precision=10)
	private long pkDrugrecurrence;

	@Column(precision=10)
	private BigDecimal drugrecuraction;

	@Column(precision=10)
	private BigDecimal drugrecuractionct;

	@Column(precision=22)
	private BigDecimal drugrecuractionmv;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="FK_DRUG", nullable=false)
	private Drug IDrug;

	public DrugreCurrence() {
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