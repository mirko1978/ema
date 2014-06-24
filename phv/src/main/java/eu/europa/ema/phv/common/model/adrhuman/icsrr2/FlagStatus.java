package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the I_FLAGSTATUS database table.
 * 
 */
@Entity
@Table(name="I_FLAGSTATUS")
@NamedQuery(name="FlagStatus.findAll", query="SELECT f FROM FlagStatus f")
public class FlagStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FlagStatusPK id;

	@Column(nullable=false, precision=3)
	private BigDecimal flagvalue;

	@Column(length=3)
	private String origin;

	@Temporal(TemporalType.DATE)
	@Column(name="\"WHEN\"")
	private Date when;

	//bi-directional many-to-one association to SafetyReport
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false, insertable=false, updatable=false)
	private SafetyReport ISafetyreport;

	public FlagStatus() {
	}

	public FlagStatusPK getId() {
		return this.id;
	}

	public void setId(FlagStatusPK id) {
		this.id = id;
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

}