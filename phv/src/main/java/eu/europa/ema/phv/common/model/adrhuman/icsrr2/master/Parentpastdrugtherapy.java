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
    "parentdrugname",
    "parentdrugstartdateformat",
    "parentdrugstartdate",
    "parentdrugenddateformat",
    "parentdrugenddate",
    "parentdrgindicationmeddraversion",
    "parentdrugindication",
    "parentdrgreactionmeddraversion",
    "parentdrugreaction"
})
@XmlRootElement(name = "parentpastdrugtherapy")
public class Parentpastdrugtherapy
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "lang")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String lang;
    protected Parentdrugname parentdrugname;
    protected Parentdrugstartdateformat parentdrugstartdateformat;
    protected Parentdrugstartdate parentdrugstartdate;
    protected Parentdrugenddateformat parentdrugenddateformat;
    protected Parentdrugenddate parentdrugenddate;
    protected Parentdrgindicationmeddraversion parentdrgindicationmeddraversion;
    protected Parentdrugindication parentdrugindication;
    protected Parentdrgreactionmeddraversion parentdrgreactionmeddraversion;
    protected Parentdrugreaction parentdrugreaction;

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
     * Gets the value of the parentdrugname property.
     * 
     * @return
     *     possible object is
     *     {@link Parentdrugname }
     *     
     */
    public Parentdrugname getParentdrugname() {
        return parentdrugname;
    }

    /**
     * Sets the value of the parentdrugname property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parentdrugname }
     *     
     */
    public void setParentdrugname(Parentdrugname value) {
        this.parentdrugname = value;
    }

    /**
     * Gets the value of the parentdrugstartdateformat property.
     * 
     * @return
     *     possible object is
     *     {@link Parentdrugstartdateformat }
     *     
     */
    public Parentdrugstartdateformat getParentdrugstartdateformat() {
        return parentdrugstartdateformat;
    }

    /**
     * Sets the value of the parentdrugstartdateformat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parentdrugstartdateformat }
     *     
     */
    public void setParentdrugstartdateformat(Parentdrugstartdateformat value) {
        this.parentdrugstartdateformat = value;
    }

    /**
     * Gets the value of the parentdrugstartdate property.
     * 
     * @return
     *     possible object is
     *     {@link Parentdrugstartdate }
     *     
     */
    public Parentdrugstartdate getParentdrugstartdate() {
        return parentdrugstartdate;
    }

    /**
     * Sets the value of the parentdrugstartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parentdrugstartdate }
     *     
     */
    public void setParentdrugstartdate(Parentdrugstartdate value) {
        this.parentdrugstartdate = value;
    }

    /**
     * Gets the value of the parentdrugenddateformat property.
     * 
     * @return
     *     possible object is
     *     {@link Parentdrugenddateformat }
     *     
     */
    public Parentdrugenddateformat getParentdrugenddateformat() {
        return parentdrugenddateformat;
    }

    /**
     * Sets the value of the parentdrugenddateformat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parentdrugenddateformat }
     *     
     */
    public void setParentdrugenddateformat(Parentdrugenddateformat value) {
        this.parentdrugenddateformat = value;
    }

    /**
     * Gets the value of the parentdrugenddate property.
     * 
     * @return
     *     possible object is
     *     {@link Parentdrugenddate }
     *     
     */
    public Parentdrugenddate getParentdrugenddate() {
        return parentdrugenddate;
    }

    /**
     * Sets the value of the parentdrugenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parentdrugenddate }
     *     
     */
    public void setParentdrugenddate(Parentdrugenddate value) {
        this.parentdrugenddate = value;
    }

    /**
     * Gets the value of the parentdrgindicationmeddraversion property.
     * 
     * @return
     *     possible object is
     *     {@link Parentdrgindicationmeddraversion }
     *     
     */
    public Parentdrgindicationmeddraversion getParentdrgindicationmeddraversion() {
        return parentdrgindicationmeddraversion;
    }

    /**
     * Sets the value of the parentdrgindicationmeddraversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parentdrgindicationmeddraversion }
     *     
     */
    public void setParentdrgindicationmeddraversion(Parentdrgindicationmeddraversion value) {
        this.parentdrgindicationmeddraversion = value;
    }

    /**
     * Gets the value of the parentdrugindication property.
     * 
     * @return
     *     possible object is
     *     {@link Parentdrugindication }
     *     
     */
    public Parentdrugindication getParentdrugindication() {
        return parentdrugindication;
    }

    /**
     * Sets the value of the parentdrugindication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parentdrugindication }
     *     
     */
    public void setParentdrugindication(Parentdrugindication value) {
        this.parentdrugindication = value;
    }

    /**
     * Gets the value of the parentdrgreactionmeddraversion property.
     * 
     * @return
     *     possible object is
     *     {@link Parentdrgreactionmeddraversion }
     *     
     */
    public Parentdrgreactionmeddraversion getParentdrgreactionmeddraversion() {
        return parentdrgreactionmeddraversion;
    }

    /**
     * Sets the value of the parentdrgreactionmeddraversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parentdrgreactionmeddraversion }
     *     
     */
    public void setParentdrgreactionmeddraversion(Parentdrgreactionmeddraversion value) {
        this.parentdrgreactionmeddraversion = value;
    }

    /**
     * Gets the value of the parentdrugreaction property.
     * 
     * @return
     *     possible object is
     *     {@link Parentdrugreaction }
     *     
     */
    public Parentdrugreaction getParentdrugreaction() {
        return parentdrugreaction;
    }

    /**
     * Sets the value of the parentdrugreaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parentdrugreaction }
     *     
     */
    public void setParentdrugreaction(Parentdrugreaction value) {
        this.parentdrugreaction = value;
    }

}
