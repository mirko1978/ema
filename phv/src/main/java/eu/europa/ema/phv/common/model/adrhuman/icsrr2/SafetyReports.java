package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_SAFETYREPORTS database table.
 * 
 */
@Entity
@Table(name="I_SAFETYREPORTS")
@NamedQuery(name="SafetyReports.findAll", query="SELECT s FROM SafetyReports s")
public class SafetyReports implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SafetyReportsPK id;

	@Column(precision=22)
	private BigDecimal commitrollback;

	//bi-directional many-to-one association to IchicsrMessage
	@ManyToOne
	@JoinColumn(name="FK_ICHICSRMESSAGE", nullable=false, insertable=false, updatable=false)
	private IchicsrMessage IIchicsrmessage;

	//bi-directional many-to-one association to SafetyReport
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false, insertable=false, updatable=false)
	private SafetyReport ISafetyreport;

	public SafetyReports() {
	}

	public SafetyReportsPK getId() {
		return this.id;
	}

	public void setId(SafetyReportsPK id) {
		this.id = id;
	}

	public BigDecimal getCommitrollback() {
		return this.commitrollback;
	}

	public void setCommitrollback(BigDecimal commitrollback) {
		this.commitrollback = commitrollback;
	}

	public IchicsrMessage getIIchicsrmessage() {
		return this.IIchicsrmessage;
	}

	public void setIIchicsrmessage(IchicsrMessage IIchicsrmessage) {
		this.IIchicsrmessage = IIchicsrmessage;
	}

	public SafetyReport getISafetyreport() {
		return this.ISafetyreport;
	}

	public void setISafetyreport(SafetyReport ISafetyreport) {
		this.ISafetyreport = ISafetyreport;
	}

}