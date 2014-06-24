package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the I_REACTION database table.
 * 
 */
@Entity
@Table(name="I_REACTION")
@NamedQuery(name="Reaction.findAll", query="SELECT r FROM Reaction r")
public class Reaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_REACTION", unique=true, nullable=false, precision=10)
	private long pkReaction;

	@Column(length=200)
	private String primarysourcereaction;

	@Column(precision=22)
	private BigDecimal reactionduration;

	@Column(precision=3)
	private BigDecimal reactiondurationunit;

	@Column(length=14)
	private String reactionenddate;

	@Column(precision=3)
	private BigDecimal reactionenddateformat;

	@Column(precision=22)
	private BigDecimal reactionfirsttime;

	@Column(precision=3)
	private BigDecimal reactionfirsttimeunit;

	@Column(precision=22)
	private BigDecimal reactionlasttime;

	@Column(precision=3)
	private BigDecimal reactionlasttimeunit;

	@Column(precision=10)
	private BigDecimal reactionmeddrallt;

	@Column(precision=10)
	private BigDecimal reactionmeddralltct;

	@Column(precision=22)
	private BigDecimal reactionmeddraversionllt;

	@Column(precision=1)
	private BigDecimal reactionoutcome;

	@Column(length=14)
	private String reactionstartdate;

	@Column(precision=3)
	private BigDecimal reactionstartdateformat;

	@Column(precision=1)
	private BigDecimal termhighlighted;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="FK_SAFETYREPORT", nullable=false)
	private Patient IPatient;

	public Reaction() {
	}

	public long getPkReaction() {
		return this.pkReaction;
	}

	public void setPkReaction(long pkReaction) {
		this.pkReaction = pkReaction;
	}

	public String getPrimarysourcereaction() {
		return this.primarysourcereaction;
	}

	public void setPrimarysourcereaction(String primarysourcereaction) {
		this.primarysourcereaction = primarysourcereaction;
	}

	public BigDecimal getReactionduration() {
		return this.reactionduration;
	}

	public void setReactionduration(BigDecimal reactionduration) {
		this.reactionduration = reactionduration;
	}

	public BigDecimal getReactiondurationunit() {
		return this.reactiondurationunit;
	}

	public void setReactiondurationunit(BigDecimal reactiondurationunit) {
		this.reactiondurationunit = reactiondurationunit;
	}

	public String getReactionenddate() {
		return this.reactionenddate;
	}

	public void setReactionenddate(String reactionenddate) {
		this.reactionenddate = reactionenddate;
	}

	public BigDecimal getReactionenddateformat() {
		return this.reactionenddateformat;
	}

	public void setReactionenddateformat(BigDecimal reactionenddateformat) {
		this.reactionenddateformat = reactionenddateformat;
	}

	public BigDecimal getReactionfirsttime() {
		return this.reactionfirsttime;
	}

	public void setReactionfirsttime(BigDecimal reactionfirsttime) {
		this.reactionfirsttime = reactionfirsttime;
	}

	public BigDecimal getReactionfirsttimeunit() {
		return this.reactionfirsttimeunit;
	}

	public void setReactionfirsttimeunit(BigDecimal reactionfirsttimeunit) {
		this.reactionfirsttimeunit = reactionfirsttimeunit;
	}

	public BigDecimal getReactionlasttime() {
		return this.reactionlasttime;
	}

	public void setReactionlasttime(BigDecimal reactionlasttime) {
		this.reactionlasttime = reactionlasttime;
	}

	public BigDecimal getReactionlasttimeunit() {
		return this.reactionlasttimeunit;
	}

	public void setReactionlasttimeunit(BigDecimal reactionlasttimeunit) {
		this.reactionlasttimeunit = reactionlasttimeunit;
	}

	public BigDecimal getReactionmeddrallt() {
		return this.reactionmeddrallt;
	}

	public void setReactionmeddrallt(BigDecimal reactionmeddrallt) {
		this.reactionmeddrallt = reactionmeddrallt;
	}

	public BigDecimal getReactionmeddralltct() {
		return this.reactionmeddralltct;
	}

	public void setReactionmeddralltct(BigDecimal reactionmeddralltct) {
		this.reactionmeddralltct = reactionmeddralltct;
	}

	public BigDecimal getReactionmeddraversionllt() {
		return this.reactionmeddraversionllt;
	}

	public void setReactionmeddraversionllt(BigDecimal reactionmeddraversionllt) {
		this.reactionmeddraversionllt = reactionmeddraversionllt;
	}

	public BigDecimal getReactionoutcome() {
		return this.reactionoutcome;
	}

	public void setReactionoutcome(BigDecimal reactionoutcome) {
		this.reactionoutcome = reactionoutcome;
	}

	public String getReactionstartdate() {
		return this.reactionstartdate;
	}

	public void setReactionstartdate(String reactionstartdate) {
		this.reactionstartdate = reactionstartdate;
	}

	public BigDecimal getReactionstartdateformat() {
		return this.reactionstartdateformat;
	}

	public void setReactionstartdateformat(BigDecimal reactionstartdateformat) {
		this.reactionstartdateformat = reactionstartdateformat;
	}

	public BigDecimal getTermhighlighted() {
		return this.termhighlighted;
	}

	public void setTermhighlighted(BigDecimal termhighlighted) {
		this.termhighlighted = termhighlighted;
	}

	public Patient getIPatient() {
		return this.IPatient;
	}

	public void setIPatient(Patient IPatient) {
		this.IPatient = IPatient;
	}

}