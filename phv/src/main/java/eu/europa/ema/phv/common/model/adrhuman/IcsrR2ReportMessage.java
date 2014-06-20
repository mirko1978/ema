/**
 * 
 */
package eu.europa.ema.phv.common.model.adrhuman;

import java.io.Serializable;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Safetyreport;

/**
 * Describe the single report message with the related metadata
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 20 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 20 Jun 2014 $
 */
public class IcsrR2ReportMessage implements Serializable {

    private static final long serialVersionUID = -9012109384791397040L;

    private Safetyreport report;

    private MessageMetadata metadata;

    private Integer number;

    private Integer total;

    /**
     * @return the metadata
     */
    public MessageMetadata getMetadata() {
        return metadata;
    }

    /**
     * @param metadata the metadata to set
     */
    public void setMetadata(MessageMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return the report
     */
    public Safetyreport getReport() {
        return report;
    }

    /**
     * @param report the report to set
     */
    public void setReport(Safetyreport report) {
        this.report = report;
    }

}
