/**
 * 
 */
package eu.europa.ema.phv.adrparserhuman;

import eu.europa.ema.phv.common.model.adrhuman.IcsrR2Header;
import eu.europa.ema.phv.common.model.adrhuman.IcsrR2ReportMessage;
import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.Ichicsr;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.Safetyreport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Split an ICSR messages in {@link IcsrR2ReportMessage} <br/>
 * TODO: Check that Metadata contains all is necessary!
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 23 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 */
public class ReportSplitter {
    
    private static final Logger LOG = LoggerFactory.getLogger(ReportSplitter.class);

    public List<IcsrR2ReportMessage> split(ValidIcsrR2Message icsrMessage) {
        List<IcsrR2ReportMessage> reportMessages = new LinkedList<IcsrR2ReportMessage>();

        final Integer size = icsrMessage.getIcsr().getSafetyreport().size();
        final MessageMetadata metadata = icsrMessage.getMetadata();
        final Ichicsr icsr = icsrMessage.getIcsr();
        final IcsrR2Header header = new IcsrR2Header(icsr.getIchicsrmessageheader(), icsr.getLang());

        int index = 0;        
        LOG.debug("Splitting message by {} reports",size);

        for (Safetyreport report : icsr.getSafetyreport()) {
            IcsrR2ReportMessage reportMessage = new IcsrR2ReportMessage(report, metadata, index, size, header);
            reportMessages.add(reportMessage);
            LOG.debug("\tReport '{}' added", report.getSafetyreportid().getvalue());
            index++;
        }
        return reportMessages;
    }
}
