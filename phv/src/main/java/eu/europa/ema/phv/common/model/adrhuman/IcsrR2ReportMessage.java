/**
 *
 */
package eu.europa.ema.phv.common.model.adrhuman;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Describe the single report message with the related metadata
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 20 Jun 2014 $
 * @since 20 Jun 2014 (creation date)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "IcsrR2ReportMessage")
public class IcsrR2ReportMessage implements Serializable {

    private static final long serialVersionUID = -9012109384791397040L;

    /**
     * Safety report
     */
    @XmlElement
    private SafetyReport report;

    /**
     * The original message is populated only for the first safety report sent
     */
    @XmlElement
    private ValidIcsrR2Message header;

    /**
     * Safety report position
     */
    @XmlElement
    private Integer index;

    /**
     * total number of safety report in the message
     */
    @XmlElement
    private Integer total;

    /**
     * New instance of IcsrR2ReportMessage
     *
     * @param report {@link #report}
     * @param header {@link #header}
     * @param index  {@link #index}
     * @param total  {@link #total}
     */
    public IcsrR2ReportMessage(SafetyReport report, ValidIcsrR2Message header, Integer index, Integer total) {
        this.report = report;
        this.header = header;
        this.index = index;
        this.total = total;
    }

    /**
     * New instance of IcsrR2ReportMessage
     */
    public IcsrR2ReportMessage() {
    }

    /**
     * {@link #report}
     */
    public SafetyReport getReport() {
        return report;
    }

    /**
     * @param report {@link #report}
     */
    public void setReport(SafetyReport report) {
        this.report = report;
    }

    /**
     * {@link #header}
     */
    public ValidIcsrR2Message getHeader() {
        return header;
    }

    /**
     * {@link #header}
     */
    public void setHeader(ValidIcsrR2Message header) {
        this.header = header;
    }

    /**
     * {@link #index}
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * {@link #index}
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * {@link #total}
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * {@link #total}
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
