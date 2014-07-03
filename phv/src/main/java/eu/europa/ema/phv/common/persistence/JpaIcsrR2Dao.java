package eu.europa.ema.phv.common.persistence;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReport;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReports;
import org.eclipse.persistence.annotations.ReturnInsert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

/**
 * Persiste the ICSR R2 using JPA. <br/>
 * Please note that the {@link #saveOnlyIcsr(IchicsrMessage)} method return the context attached entity.
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 30/06/2014 $
 * @since 30/06/2014 (creation date)
 */
public class JpaIcsrR2Dao implements IcsrR2DAO {
    private static final Logger LOG = LoggerFactory.getLogger(JpaIcsrR2Dao.class);

    @PersistenceContext(unitName = "icsrJta")
    private EntityManager manager;

    @Override
    @ReturnInsert
    @Transactional
    public IchicsrMessage saveOnlyIcsr(IchicsrMessage icsr) {
        IchicsrMessage saved = new IchicsrMessage();
        updateIcsr(icsr, saved);
        saved.setSafetyReports(null);
        manager.persist(saved);
        if(LOG.isDebugEnabled()) {
            LOG.debug("DAO: ICSR core message saved for {}", saved);
        }
        return saved;
    }

    @Override
    @ReturnInsert
    @Transactional
    public void saveReport(IchicsrMessage icsr, SafetyReport report) {
        SafetyReports safetyReports = new SafetyReports();
        safetyReports.setIchicsrMessage(icsr);
        safetyReports.setSafetyReport(report);
        if(report.getISafetyreports() == null) {
            report.setISafetyreports(new LinkedList<SafetyReports>());
        }
        report.getISafetyreports().add(safetyReports);
        if(icsr.getSafetyReports() == null) {
            icsr.setSafetyReports(new LinkedList<SafetyReports>());
        }
        icsr.getSafetyReports().add(safetyReports);
        manager.persist(safetyReports);
        if(LOG.isDebugEnabled()) {
            LOG.debug("DAO: Report saved for {}", report);
        }
    }

    @Override
    public void updateIcsr(IchicsrMessage source, IchicsrMessage destination) {
        destination.setPkIchicsrmessage(source.getPkIchicsrmessage());
        destination.setAckgendate(source.getAckgendate());
        destination.setAcksenddate(source.getAcksenddate());
        destination.setArchived(source.getArchived());
        destination.setContextsequenceid(source.getContextsequenceid());
        destination.setDocumenttype(source.getDocumenttype());
        destination.setFkQiofficialreceivedate(source.getFkQiofficialreceivedate());
        destination.setIsmessagereceivedatechanged(source.getIsmessagereceivedatechanged());
        destination.setMdnackreceivedate(source.getMdnackreceivedate());
        destination.setMessagedate(source.getMessagedate());
        destination.setMessageformatversion(source.getMessageformatversion());
        destination.setMessageid(source.getMessageid());
        destination.setMessagelang(source.getMessagelang());
        destination.setMessagenumber(source.getMessagenumber());
        destination.setMessagereceivedate(source.getMessagereceivedate());
        destination.setMessagereleaseversion(source.getMessagereleaseversion());
        destination.setMessagetype(source.getMessagetype());
        destination.setOfficialreceivedate(source.getOfficialreceivedate());
        destination.setOfficialreceivedatemrec(source.getOfficialreceivedatemrec());
        destination.setOriginalackref(source.getOriginalackref());
        destination.setOriginalmessageref(source.getOriginalmessageref());
        destination.setSenderid(source.getSenderid());
        destination.setReceiverid(source.getReceiverid());
        destination.setMessageDateFormat(source.getMessageDateFormat());
        destination.setIMessageack(source.getIMessageack());
        if(source.getSafetyReports() != destination.getSafetyReports()) {
            destination.setSafetyReports(source.getSafetyReports());
        }
    }

}
