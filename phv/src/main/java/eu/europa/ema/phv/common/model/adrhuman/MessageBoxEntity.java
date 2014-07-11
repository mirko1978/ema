package eu.europa.ema.phv.common.model.adrhuman;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.jpa.JpaQuery;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



/**
 * The persistent class for the X_MESSAGEBOX database table in the Repository schema
 * 
 * @author  Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 11 Jul 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 11 Jul 2014 $
 */
@Entity
@Table(name="X_MESSAGEBOX")
@NamedQueries({
	@NamedQuery(name="MessageBoxEntity.findAll", query="SELECT m FROM MessageBoxEntity m"),
	@NamedQuery(name="MessageBoxEntity.findByOwner", query="SELECT m FROM MessageBoxEntity m where m.owner = :owner")
})
public class MessageBoxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="messageJTA") 
	protected transient  EntityManager em;
	
	@Id
	@Column(name="PK_MESSAGEBOX", unique=true, nullable=false, precision=10)
	private long pkMessagebox;

	@Column(precision=4)
	private BigDecimal archiveinterval;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date creationdate;

	@Column(nullable=false, length=60)
	private String messageboxname;

	@Column(nullable=false, precision=10)
	private BigDecimal numarchivedin;

	@Column(nullable=false, precision=10)
	private BigDecimal numarchivedout;

	@Column(precision=10)
	private BigDecimal nummaxmessagein;

	@Column(precision=10)
	private BigDecimal nummaxmessageout;

	@Column(nullable=false, precision=10)
	private BigDecimal nummessagein;

	@Column(nullable=false, precision=10)
	private BigDecimal nummessageout;

	@Column(nullable=false, length=60)
	private String owner;

	//bi-directional many-to-one association to InboundMessageEntity
	@OneToMany(mappedBy="XMessagebox")
	private List<InboundMessageEntity> XInbounds;

	public MessageBoxEntity() {
	}

	public long getPkMessagebox() {
		return this.pkMessagebox;
	}

	public void setPkMessagebox(long pkMessagebox) {
		this.pkMessagebox = pkMessagebox;
	}

	public BigDecimal getArchiveinterval() {
		return this.archiveinterval;
	}

	public void setArchiveinterval(BigDecimal archiveinterval) {
		this.archiveinterval = archiveinterval;
	}

	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public String getMessageboxname() {
		return this.messageboxname;
	}

	public void setMessageboxname(String messageboxname) {
		this.messageboxname = messageboxname;
	}

	public BigDecimal getNumarchivedin() {
		return this.numarchivedin;
	}

	public void setNumarchivedin(BigDecimal numarchivedin) {
		this.numarchivedin = numarchivedin;
	}

	public BigDecimal getNumarchivedout() {
		return this.numarchivedout;
	}

	public void setNumarchivedout(BigDecimal numarchivedout) {
		this.numarchivedout = numarchivedout;
	}

	public BigDecimal getNummaxmessagein() {
		return this.nummaxmessagein;
	}

	public void setNummaxmessagein(BigDecimal nummaxmessagein) {
		this.nummaxmessagein = nummaxmessagein;
	}

	public BigDecimal getNummaxmessageout() {
		return this.nummaxmessageout;
	}

	public void setNummaxmessageout(BigDecimal nummaxmessageout) {
		this.nummaxmessageout = nummaxmessageout;
	}

	public BigDecimal getNummessagein() {
		return this.nummessagein;
	}

	public void setNummessagein(BigDecimal nummessagein) {
		this.nummessagein = nummessagein;
	}

	public BigDecimal getNummessageout() {
		return this.nummessageout;
	}

	public void setNummessageout(BigDecimal nummessageout) {
		this.nummessageout = nummessageout;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<InboundMessageEntity> getXInbounds() {
		return this.XInbounds;
	}

	public void setXInbounds(List<InboundMessageEntity> XInbounds) {
		this.XInbounds = XInbounds;
	}

	public InboundMessageEntity addXInbound(InboundMessageEntity XInbound) {
		getXInbounds().add(XInbound);
		XInbound.setXMessagebox(this);

		return XInbound;
	}

	public InboundMessageEntity removeXInbound(InboundMessageEntity XInbound) {
		getXInbounds().remove(XInbound);
		XInbound.setXMessagebox(null);

		return XInbound;
	}
	

}