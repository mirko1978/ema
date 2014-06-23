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

    private Integer index;

    private Integer total;

    private IcsrR2Header header;

    /**
     * 
     */
    public IcsrR2ReportMessage() {
    }

    /**
     * @param report
     * @param metadata
     * @param index
     * @param total
     * @param header
     */
    public IcsrR2ReportMessage(Safetyreport report, MessageMetadata metadata, Integer index, Integer total,
            IcsrR2Header header) {
        this.report = report;
        this.metadata = metadata;
        this.index = index;
        this.total = total;
        this.header = header;
    }

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

    /**
     * @return the index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(Integer index) {
        this.index = index;
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
     * @return the header
     */
    public IcsrR2Header getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(IcsrR2Header header) {
        this.header = header;
    }

}
