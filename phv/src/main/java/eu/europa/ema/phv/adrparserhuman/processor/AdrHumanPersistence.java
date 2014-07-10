package eu.europa.ema.phv.adrparserhuman.processor;

import eu.europa.ema.phv.common.model.adrhuman.ValidIcsrR2Message;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.persistence.IcsrR2DAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Prepare and persist the received ICSR to the database
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 09/07/2014 $
 * @since 09/07/2014 (creation date)
 */
public class AdrHumanPersistence {
    private static final Logger LOG = LoggerFactory.getLogger(AdrHumanPersistence.class);

    @Inject
    private IcsrR2DAO dao;

    public void persist(ValidIcsrR2Message icsrMessage) {
        IchicsrMessage icsr = (icsrMessage.getIcsr());
        // add the metadata to the icsr
        dao.prepare(icsr, icsrMessage.getMetadata());
        // Create a new entity on the database with the received message
        dao.persist(icsr);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Saved ICSR {}", icsrMessage);
        }
    }
}
