/**
 *
 */
package eu.europa.ema.phv.adrparserhuman;

import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage;
import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReport;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReports;
import eu.europa.ema.phv.common.persistence.IcsrR2DAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

/**
 * Split an ICSR messages in {@link IcsrR2ReportMessage} <br/>
 * TODO: Check that Metadata contains all is necessary!
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 * @since 23 Jun 2014 (creation date)
 */
public class ReportSplitter {

    private static final Logger LOG = LoggerFactory.getLogger(ReportSplitter.class);

    @Inject
    private IcsrR2DAO dao;

    /**
     * Create a List of Icsr R2 reports ready to send to ADR Validation Human component. <br/>
     * <b>Only</b> first element of the has the ValidIcsrR2Message set. In the others elements it is set to null.
     *
     * @param icsrMessage Message from Message Handler
     * @return List of {@link eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage}
     */
    public List<IcsrR2ReportMessage> split(ValidIcsrR2Message icsrMessage) {
        List<IcsrR2ReportMessage> reportMessages = new LinkedList<>();

        final Integer size = icsrMessage.getIcsr().getSafetyReports().size();
        final MessageMetadata metadata = icsrMessage.getMetadata();
        final IchicsrMessage icsr = icsrMessage.getIcsr();

        // Split the reports
        int index = 0;
        LOG.debug("Splitting message by {} reports", size);

        // For each report all the icsr headers are attached
        ValidIcsrR2Message header = new ValidIcsrR2Message();
        header.setIcsr(dao.emptyIcsr(icsr));
        header.setMetadata(metadata);

        for (SafetyReports entityReport : icsr.getSafetyReports()) {
            SafetyReport report = entityReport.getSafetyReport();
            IcsrR2ReportMessage reportMessage = new IcsrR2ReportMessage(report, header, index, size);
            reportMessages.add(reportMessage);
            LOG.debug("\tReport '{}' added", report.getSafetyreportid());
            index++;
        }
        return reportMessages;
    }

}
