//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.20 at 03:16:34 PM BST 
//

package eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "acknowledgment")
public class Acknowledgment implements Serializable {

    private final static long serialVersionUID = 1L;

    @XmlAttribute(name = "lang")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String lang;

    @XmlElement(required = true)
    protected Messageacknowledgment messageacknowledgment;

    protected List<ReportAcknowledgment> reportAcknowledgment;

    /**
     * Gets the value of the lang property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the messageacknowledgment property.
     * 
     * @return possible object is {@link Messageacknowledgment }
     * 
     */
    public Messageacknowledgment getMessageacknowledgment() {
        return messageacknowledgment;
    }

    /**
     * Sets the value of the messageacknowledgment property.
     * 
     * @param value allowed object is {@link Messageacknowledgment }
     * 
     */
    public void setMessageacknowledgment(Messageacknowledgment value) {
        this.messageacknowledgment = value;
    }

    /**
     * Gets the value of the reportAcknowledgment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the reportAcknowledgment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getReportAcknowledgment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportAcknowledgment }
     * 
     * 
     */
    public List<ReportAcknowledgment> getReportAcknowledgment() {
        if (reportAcknowledgment == null) {
            reportAcknowledgment = new ArrayList<ReportAcknowledgment>();
        }
        return this.reportAcknowledgment;
    }

}