package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the I_RECEIVER database table.
 */
@Entity
@Table(name = "I_RECEIVER")
@NamedQuery(name = "Receiver.findAll", query = "SELECT r FROM Receiver r")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "receiver")
public class Receiver implements Serializable {

    private static final long serialVersionUID = 5784821136635059909L;

    @Id
    @Column(name = "PK_SAFETYREPORT", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkSafetyreport;

    @Column(length = 35)
    @XmlElement(name = "receivercity")
    private String receivercity;

    @Column(length = 2)
    @XmlElement(name = "receivercountrycode")
    private String receivercountrycode;

    @Column(length = 60)
    @XmlElement(name = "receiverdepartment")
    private String receiverdepartment;

    @Column(length = 100)
    @XmlElement(name = "receiveremailaddress")
    private String receiveremailaddress;

    @Column(length = 35)
    @XmlElement(name = "receiverfamilyname")
    private String receiverfamilyname;

    @Column(length = 10)
    @XmlElement(name = "receiverfax")
    private String receiverfax;

    @Column(length = 3)
    @XmlElement(name = "receiverfaxcountrycode")
    private String receiverfaxcountrycode;

    @Column(length = 10)
    @XmlElement(name = "receiverfaxextension")
    private String receiverfaxextension;

    @Column(length = 35)
    @XmlElement(name = "receivergivename")
    private String receivergivename;

    @Column(length = 15)
    @XmlElement(name = "receivermiddlename")
    private String receivermiddlename;

    @Column(length = 60)
    @XmlElement(name = "receiverorganization")
    private String receiverorganization;

    @Column(length = 15)
    @XmlElement(name = "receiverpostcode")
    private String receiverpostcode;

    @Column(length = 40)
    @XmlElement(name = "receiverstate")
    private String receiverstate;

    @Column(length = 100)
    @XmlElement(name = "receiverstreetaddress")
    private String receiverstreetaddress;

    @Column(length = 10)
    @XmlElement(name = "receivertel")
    private String receivertel;

    @Column(length = 3)
    @XmlElement(name = "receivertelcountrycode")
    private String receivertelcountrycode;

    @Column(length = 10)
    @XmlElement(name = "receivertelextension")
    private String receivertelextension;

    @Column(length = 10)
    @XmlElement(name = "receivertitle")
    private String receivertitle;

    @Column(precision = 1)
    @XmlElement(name = "receivertype")
    private BigDecimal receivertype;

    // bi-directional one-to-one association to SafetyReport
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PK_SAFETYREPORT", nullable = false, insertable = false, updatable = false)
    @XmlInverseReference(mappedBy = "IReceiver")
    private SafetyReport ISafetyreport;

    public Receiver() {
    }

    public long getPkSafetyreport() {
        return this.pkSafetyreport;
    }

    public void setPkSafetyreport(long pkSafetyreport) {
        this.pkSafetyreport = pkSafetyreport;
    }

    public String getReceivercity() {
        return this.receivercity;
    }

    public void setReceivercity(String receivercity) {
        this.receivercity = receivercity;
    }

    public String getReceivercountrycode() {
        return this.receivercountrycode;
    }

    public void setReceivercountrycode(String receivercountrycode) {
        this.receivercountrycode = receivercountrycode;
    }

    public String getReceiverdepartment() {
        return this.receiverdepartment;
    }

    public void setReceiverdepartment(String receiverdepartment) {
        this.receiverdepartment = receiverdepartment;
    }

    public String getReceiveremailaddress() {
        return this.receiveremailaddress;
    }

    public void setReceiveremailaddress(String receiveremailaddress) {
        this.receiveremailaddress = receiveremailaddress;
    }

    public String getReceiverfamilyname() {
        return this.receiverfamilyname;
    }

    public void setReceiverfamilyname(String receiverfamilyname) {
        this.receiverfamilyname = receiverfamilyname;
    }

    public String getReceiverfax() {
        return this.receiverfax;
    }

    public void setReceiverfax(String receiverfax) {
        this.receiverfax = receiverfax;
    }

    public String getReceiverfaxcountrycode() {
        return this.receiverfaxcountrycode;
    }

    public void setReceiverfaxcountrycode(String receiverfaxcountrycode) {
        this.receiverfaxcountrycode = receiverfaxcountrycode;
    }

    public String getReceiverfaxextension() {
        return this.receiverfaxextension;
    }

    public void setReceiverfaxextension(String receiverfaxextension) {
        this.receiverfaxextension = receiverfaxextension;
    }

    public String getReceivergivename() {
        return this.receivergivename;
    }

    public void setReceivergivename(String receivergivename) {
        this.receivergivename = receivergivename;
    }

    public String getReceivermiddlename() {
        return this.receivermiddlename;
    }

    public void setReceivermiddlename(String receivermiddlename) {
        this.receivermiddlename = receivermiddlename;
    }

    public String getReceiverorganization() {
        return this.receiverorganization;
    }

    public void setReceiverorganization(String receiverorganization) {
        this.receiverorganization = receiverorganization;
    }

    public String getReceiverpostcode() {
        return this.receiverpostcode;
    }

    public void setReceiverpostcode(String receiverpostcode) {
        this.receiverpostcode = receiverpostcode;
    }

    public String getReceiverstate() {
        return this.receiverstate;
    }

    public void setReceiverstate(String receiverstate) {
        this.receiverstate = receiverstate;
    }

    public String getReceiverstreetaddress() {
        return this.receiverstreetaddress;
    }

    public void setReceiverstreetaddress(String receiverstreetaddress) {
        this.receiverstreetaddress = receiverstreetaddress;
    }

    public String getReceivertel() {
        return this.receivertel;
    }

    public void setReceivertel(String receivertel) {
        this.receivertel = receivertel;
    }

    public String getReceivertelcountrycode() {
        return this.receivertelcountrycode;
    }

    public void setReceivertelcountrycode(String receivertelcountrycode) {
        this.receivertelcountrycode = receivertelcountrycode;
    }

    public String getReceivertelextension() {
        return this.receivertelextension;
    }

    public void setReceivertelextension(String receivertelextension) {
        this.receivertelextension = receivertelextension;
    }

    public String getReceivertitle() {
        return this.receivertitle;
    }

    public void setReceivertitle(String receivertitle) {
        this.receivertitle = receivertitle;
    }

    public BigDecimal getReceivertype() {
        return this.receivertype;
    }

    public void setReceivertype(BigDecimal receivertype) {
        this.receivertype = receivertype;
    }

    public SafetyReport getISafetyreport() {
        return this.ISafetyreport;
    }

    public void setISafetyreport(SafetyReport ISafetyreport) {
        this.ISafetyreport = ISafetyreport;
    }

}