package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the I_REPORTDUPLICATE database table.
 * 
 */
@Entity
@Table(name="I_REPORTDUPLICATE")
@NamedQuery(name="ReportDuplicate.findAll", query="SELECT r FROM ReportDuplicate r")
public class ReportDuplicate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_REPORTDUPLICATE", unique=true, nullable=false, precision=10)
	private long pkReportduplicate;

	@Column(length=100)
	private String duplicatenumb;

	@Column(length=100)
	private String duplicatesource;

	//bi-directional many-to-one association to SafetyReport
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
	private SafetyReport ISafetyreport;

	public ReportDuplicate() {
	}

	public long getPkReportduplicate() {
		return this.pkReportduplicate;
	}

	public void setPkReportduplicate(long pkReportduplicate) {
		this.pkReportduplicate = pkReportduplicate;
	}

	public String getDuplicatenumb() {
		return this.duplicatenumb;
	}

	public void setDuplicatenumb(String duplicatenumb) {
		this.duplicatenumb = duplicatenumb;
	}

	public String getDuplicatesource() {
		return this.duplicatesource;
	}

	public void setDuplicatesource(String duplicatesource) {
		this.duplicatesource = duplicatesource;
	}

	public SafetyReport getISafetyreport() {
		return this.ISafetyreport;
	}

	public void setISafetyreport(SafetyReport ISafetyreport) {
		this.ISafetyreport = ISafetyreport;
	}

}