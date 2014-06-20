//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.20 at 03:15:02 PM BST 
//


package eu.europa.ema.phv.common.model.adrhuman.icsrr2.master;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "receivertype",
    "receiverorganization",
    "receiverdepartment",
    "receivertitle",
    "receivergivename",
    "receivermiddlename",
    "receiverfamilyname",
    "receiverstreetaddress",
    "receivercity",
    "receiverstate",
    "receiverpostcode",
    "receivercountrycode",
    "receivertel",
    "receivertelextension",
    "receivertelcountrycode",
    "receiverfax",
    "receiverfaxextension",
    "receiverfaxcountrycode",
    "receiveremailaddress"
})
@XmlRootElement(name = "receiver")
public class Receiver
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "lang")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String lang;
    protected Receivertype receivertype;
    protected Receiverorganization receiverorganization;
    protected Receiverdepartment receiverdepartment;
    protected Receivertitle receivertitle;
    protected Receivergivename receivergivename;
    protected Receivermiddlename receivermiddlename;
    protected Receiverfamilyname receiverfamilyname;
    protected Receiverstreetaddress receiverstreetaddress;
    protected Receivercity receivercity;
    protected Receiverstate receiverstate;
    protected Receiverpostcode receiverpostcode;
    protected Receivercountrycode receivercountrycode;
    protected Receivertel receivertel;
    protected Receivertelextension receivertelextension;
    protected Receivertelcountrycode receivertelcountrycode;
    protected Receiverfax receiverfax;
    protected Receiverfaxextension receiverfaxextension;
    protected Receiverfaxcountrycode receiverfaxcountrycode;
    protected Receiveremailaddress receiveremailaddress;

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the receivertype property.
     * 
     * @return
     *     possible object is
     *     {@link Receivertype }
     *     
     */
    public Receivertype getReceivertype() {
        return receivertype;
    }

    /**
     * Sets the value of the receivertype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivertype }
     *     
     */
    public void setReceivertype(Receivertype value) {
        this.receivertype = value;
    }

    /**
     * Gets the value of the receiverorganization property.
     * 
     * @return
     *     possible object is
     *     {@link Receiverorganization }
     *     
     */
    public Receiverorganization getReceiverorganization() {
        return receiverorganization;
    }

    /**
     * Sets the value of the receiverorganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiverorganization }
     *     
     */
    public void setReceiverorganization(Receiverorganization value) {
        this.receiverorganization = value;
    }

    /**
     * Gets the value of the receiverdepartment property.
     * 
     * @return
     *     possible object is
     *     {@link Receiverdepartment }
     *     
     */
    public Receiverdepartment getReceiverdepartment() {
        return receiverdepartment;
    }

    /**
     * Sets the value of the receiverdepartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiverdepartment }
     *     
     */
    public void setReceiverdepartment(Receiverdepartment value) {
        this.receiverdepartment = value;
    }

    /**
     * Gets the value of the receivertitle property.
     * 
     * @return
     *     possible object is
     *     {@link Receivertitle }
     *     
     */
    public Receivertitle getReceivertitle() {
        return receivertitle;
    }

    /**
     * Sets the value of the receivertitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivertitle }
     *     
     */
    public void setReceivertitle(Receivertitle value) {
        this.receivertitle = value;
    }

    /**
     * Gets the value of the receivergivename property.
     * 
     * @return
     *     possible object is
     *     {@link Receivergivename }
     *     
     */
    public Receivergivename getReceivergivename() {
        return receivergivename;
    }

    /**
     * Sets the value of the receivergivename property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivergivename }
     *     
     */
    public void setReceivergivename(Receivergivename value) {
        this.receivergivename = value;
    }

    /**
     * Gets the value of the receivermiddlename property.
     * 
     * @return
     *     possible object is
     *     {@link Receivermiddlename }
     *     
     */
    public Receivermiddlename getReceivermiddlename() {
        return receivermiddlename;
    }

    /**
     * Sets the value of the receivermiddlename property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivermiddlename }
     *     
     */
    public void setReceivermiddlename(Receivermiddlename value) {
        this.receivermiddlename = value;
    }

    /**
     * Gets the value of the receiverfamilyname property.
     * 
     * @return
     *     possible object is
     *     {@link Receiverfamilyname }
     *     
     */
    public Receiverfamilyname getReceiverfamilyname() {
        return receiverfamilyname;
    }

    /**
     * Sets the value of the receiverfamilyname property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiverfamilyname }
     *     
     */
    public void setReceiverfamilyname(Receiverfamilyname value) {
        this.receiverfamilyname = value;
    }

    /**
     * Gets the value of the receiverstreetaddress property.
     * 
     * @return
     *     possible object is
     *     {@link Receiverstreetaddress }
     *     
     */
    public Receiverstreetaddress getReceiverstreetaddress() {
        return receiverstreetaddress;
    }

    /**
     * Sets the value of the receiverstreetaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiverstreetaddress }
     *     
     */
    public void setReceiverstreetaddress(Receiverstreetaddress value) {
        this.receiverstreetaddress = value;
    }

    /**
     * Gets the value of the receivercity property.
     * 
     * @return
     *     possible object is
     *     {@link Receivercity }
     *     
     */
    public Receivercity getReceivercity() {
        return receivercity;
    }

    /**
     * Sets the value of the receivercity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivercity }
     *     
     */
    public void setReceivercity(Receivercity value) {
        this.receivercity = value;
    }

    /**
     * Gets the value of the receiverstate property.
     * 
     * @return
     *     possible object is
     *     {@link Receiverstate }
     *     
     */
    public Receiverstate getReceiverstate() {
        return receiverstate;
    }

    /**
     * Sets the value of the receiverstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiverstate }
     *     
     */
    public void setReceiverstate(Receiverstate value) {
        this.receiverstate = value;
    }

    /**
     * Gets the value of the receiverpostcode property.
     * 
     * @return
     *     possible object is
     *     {@link Receiverpostcode }
     *     
     */
    public Receiverpostcode getReceiverpostcode() {
        return receiverpostcode;
    }

    /**
     * Sets the value of the receiverpostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiverpostcode }
     *     
     */
    public void setReceiverpostcode(Receiverpostcode value) {
        this.receiverpostcode = value;
    }

    /**
     * Gets the value of the receivercountrycode property.
     * 
     * @return
     *     possible object is
     *     {@link Receivercountrycode }
     *     
     */
    public Receivercountrycode getReceivercountrycode() {
        return receivercountrycode;
    }

    /**
     * Sets the value of the receivercountrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivercountrycode }
     *     
     */
    public void setReceivercountrycode(Receivercountrycode value) {
        this.receivercountrycode = value;
    }

    /**
     * Gets the value of the receivertel property.
     * 
     * @return
     *     possible object is
     *     {@link Receivertel }
     *     
     */
    public Receivertel getReceivertel() {
        return receivertel;
    }

    /**
     * Sets the value of the receivertel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivertel }
     *     
     */
    public void setReceivertel(Receivertel value) {
        this.receivertel = value;
    }

    /**
     * Gets the value of the receivertelextension property.
     * 
     * @return
     *     possible object is
     *     {@link Receivertelextension }
     *     
     */
    public Receivertelextension getReceivertelextension() {
        return receivertelextension;
    }

    /**
     * Sets the value of the receivertelextension property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivertelextension }
     *     
     */
    public void setReceivertelextension(Receivertelextension value) {
        this.receivertelextension = value;
    }

    /**
     * Gets the value of the receivertelcountrycode property.
     * 
     * @return
     *     possible object is
     *     {@link Receivertelcountrycode }
     *     
     */
    public Receivertelcountrycode getReceivertelcountrycode() {
        return receivertelcountrycode;
    }

    /**
     * Sets the value of the receivertelcountrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivertelcountrycode }
     *     
     */
    public void setReceivertelcountrycode(Receivertelcountrycode value) {
        this.receivertelcountrycode = value;
    }

    /**
     * Gets the value of the receiverfax property.
     * 
     * @return
     *     possible object is
     *     {@link Receiverfax }
     *     
     */
    public Receiverfax getReceiverfax() {
        return receiverfax;
    }

    /**
     * Sets the value of the receiverfax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiverfax }
     *     
     */
    public void setReceiverfax(Receiverfax value) {
        this.receiverfax = value;
    }

    /**
     * Gets the value of the receiverfaxextension property.
     * 
     * @return
     *     possible object is
     *     {@link Receiverfaxextension }
     *     
     */
    public Receiverfaxextension getReceiverfaxextension() {
        return receiverfaxextension;
    }

    /**
     * Sets the value of the receiverfaxextension property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiverfaxextension }
     *     
     */
    public void setReceiverfaxextension(Receiverfaxextension value) {
        this.receiverfaxextension = value;
    }

    /**
     * Gets the value of the receiverfaxcountrycode property.
     * 
     * @return
     *     possible object is
     *     {@link Receiverfaxcountrycode }
     *     
     */
    public Receiverfaxcountrycode getReceiverfaxcountrycode() {
        return receiverfaxcountrycode;
    }

    /**
     * Sets the value of the receiverfaxcountrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiverfaxcountrycode }
     *     
     */
    public void setReceiverfaxcountrycode(Receiverfaxcountrycode value) {
        this.receiverfaxcountrycode = value;
    }

    /**
     * Gets the value of the receiveremailaddress property.
     * 
     * @return
     *     possible object is
     *     {@link Receiveremailaddress }
     *     
     */
    public Receiveremailaddress getReceiveremailaddress() {
        return receiveremailaddress;
    }

    /**
     * Sets the value of the receiveremailaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiveremailaddress }
     *     
     */
    public void setReceiveremailaddress(Receiveremailaddress value) {
        this.receiveremailaddress = value;
    }

}
