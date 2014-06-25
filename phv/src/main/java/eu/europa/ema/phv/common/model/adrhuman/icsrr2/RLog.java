package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the I_R_LOG database table.
 * 
 */
@Entity
@Table(name="I_R_LOG")
@NamedQuery(name="RLog.findAll", query="SELECT r FROM RLog r")
public class RLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=10)
	private long logid;

	@Column(name="\"LOG\"", length=100)
	private String log;

	@Column(name="NEW_VALUEMREC", precision=1)
	private BigDecimal newValuemrec;

	@Column(name="NEW_VALUERECODED", length=240)
	private String newValuerecoded;

	@Column(name="PK_FIELDMREC", precision=10)
	private BigDecimal pkFieldmrec;

	@Column(precision=10)
	private BigDecimal recodedid;

	@Column(length=60)
	private String userid;

	@Column(name="WHEN_LOG")
	private Timestamp whenLog;

	public RLog() {
	}

	public long getLogid() {
		return this.logid;
	}

	public void setLogid(long logid) {
		this.logid = logid;
	}

	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public BigDecimal getNewValuemrec() {
		return this.newValuemrec;
	}

	public void setNewValuemrec(BigDecimal newValuemrec) {
		this.newValuemrec = newValuemrec;
	}

	public String getNewValuerecoded() {
		return this.newValuerecoded;
	}

	public void setNewValuerecoded(String newValuerecoded) {
		this.newValuerecoded = newValuerecoded;
	}

	public BigDecimal getPkFieldmrec() {
		return this.pkFieldmrec;
	}

	public void setPkFieldmrec(BigDecimal pkFieldmrec) {
		this.pkFieldmrec = pkFieldmrec;
	}

	public BigDecimal getRecodedid() {
		return this.recodedid;
	}

	public void setRecodedid(BigDecimal recodedid) {
		this.recodedid = recodedid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Timestamp getWhenLog() {
		return this.whenLog;
	}

	public void setWhenLog(Timestamp whenLog) {
		this.whenLog = whenLog;
	}

}