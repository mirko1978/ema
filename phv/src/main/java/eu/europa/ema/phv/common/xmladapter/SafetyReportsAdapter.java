package eu.europa.ema.phv.common.xmladapter;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReport;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReports;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Manage the {@link eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReports} to {@link eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReport}
 * relationship. This relation is only on the database level, on the XML schema the message is connected directly to SafetyReport
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 26/06/2014 $
 * @since 26/06/2014 (creation date)
 */
public class SafetyReportsAdapter extends XmlAdapter<SafetyReport, SafetyReports> {

    @Override
    public SafetyReports unmarshal(SafetyReport safetyReport) throws Exception {
        SafetyReports entityReport = new SafetyReports();
        entityReport.setSafetyReport(safetyReport);
        return entityReport;
    }

    @Override
    public SafetyReport marshal(SafetyReports entityReport) throws Exception {
        return entityReport.getSafetyReport();
    }
}
