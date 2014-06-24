package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the I_MESSAGEACK database table.
 * 
 */
@Entity
@Table(name="I_MESSAGEACK")
@NamedQuery(name="MessageAck.findAll", query="SELECT m FROM MessageAck m")
public class MessageAck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PK_ICHICSRMESSAGE", unique=true, nullable=false, precision=10)
	private long pkIchicsrmessage;

	@Column(length=56)
	private String icsrmessagedate;

	@Column(precision=3)
	private BigDecimal icsrmessagedateformat;

	@Column(length=400)
	private String icsrmessagenumb;

	@Column(length=240)
	private String icsrmessagereceiveridentifier;

	@Column(length=240)
	private String icsrmessagesenderidentifier;

	@Column(length=400)
	private String localmessagenumb;

	@Lob
	private String parsingerrormessage;

	@Column(length=8)
	private String transmissionacknowledgmentcode;

	//bi-directional one-to-one association to IchicsrMessage
	@OneToOne
	@JoinColumn(name="PK_ICHICSRMESSAGE", nullable=false, insertable=false, updatable=false)
	private IchicsrMessage IIchicsrmessage;

	//bi-directional many-to-many association to ReportAck
	@ManyToMany(mappedBy="IMessageacks")
	private List<ReportAck> IReportacks;

	public MessageAck() {
	}

	public long getPkIchicsrmessage() {
		return this.pkIchicsrmessage;
	}

	public void setPkIchicsrmessage(long pkIchicsrmessage) {
		this.pkIchicsrmessage = pkIchicsrmessage;
	}

	public String getIcsrmessagedate() {
		return this.icsrmessagedate;
	}

	public void setIcsrmessagedate(String icsrmessagedate) {
		this.icsrmessagedate = icsrmessagedate;
	}

	public BigDecimal getIcsrmessagedateformat() {
		return this.icsrmessagedateformat;
	}

	public void setIcsrmessagedateformat(BigDecimal icsrmessagedateformat) {
		this.icsrmessagedateformat = icsrmessagedateformat;
	}

	public String getIcsrmessagenumb() {
		return this.icsrmessagenumb;
	}

	public void setIcsrmessagenumb(String icsrmessagenumb) {
		this.icsrmessagenumb = icsrmessagenumb;
	}

	public String getIcsrmessagereceiveridentifier() {
		return this.icsrmessagereceiveridentifier;
	}

	public void setIcsrmessagereceiveridentifier(String icsrmessagereceiveridentifier) {
		this.icsrmessagereceiveridentifier = icsrmessagereceiveridentifier;
	}

	public String getIcsrmessagesenderidentifier() {
		return this.icsrmessagesenderidentifier;
	}

	public void setIcsrmessagesenderidentifier(String icsrmessagesenderidentifier) {
		this.icsrmessagesenderidentifier = icsrmessagesenderidentifier;
	}

	public String getLocalmessagenumb() {
		return this.localmessagenumb;
	}

	public void setLocalmessagenumb(String localmessagenumb) {
		this.localmessagenumb = localmessagenumb;
	}

	public String getParsingerrormessage() {
		return this.parsingerrormessage;
	}

	public void setParsingerrormessage(String parsingerrormessage) {
		this.parsingerrormessage = parsingerrormessage;
	}

	public String getTransmissionacknowledgmentcode() {
		return this.transmissionacknowledgmentcode;
	}

	public void setTransmissionacknowledgmentcode(String transmissionacknowledgmentcode) {
		this.transmissionacknowledgmentcode = transmissionacknowledgmentcode;
	}

	public IchicsrMessage getIIchicsrmessage() {
		return this.IIchicsrmessage;
	}

	public void setIIchicsrmessage(IchicsrMessage IIchicsrmessage) {
		this.IIchicsrmessage = IIchicsrmessage;
	}

	public List<ReportAck> getIReportacks() {
		return this.IReportacks;
	}

	public void setIReportacks(List<ReportAck> IReportacks) {
		this.IReportacks = IReportacks;
	}

}