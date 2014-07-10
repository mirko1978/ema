package eu.europa.ema.phv.common.persistence;

import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;

/**
 * DAO for managing the ICSR R2 data to the database
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 30/06/2014 $
 * @since 30/06/2014 (creation date)
 */
public interface IcsrR2DAO {

    /**
     * Create a new entity in the database.
     *
     * @param icsr the received icsr
     * @return The saved icsr without the reports
     */
    void persist(IchicsrMessage icsr);

    /**
     * Copy a new ICSR message without any reports inside.
     *
     * @param source source ICSR message
     * @return new ICSR without reports
     */
    IchicsrMessage emptyIcsr(IchicsrMessage source);

    /**
     * Add all the metadata and set the field in order to prepare for persist the ICSR message
     *
     * @param message
     * @param metadata
     */
    void prepare(IchicsrMessage message, MessageMetadata metadata);
}
