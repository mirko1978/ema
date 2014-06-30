package eu.europa.ema.phv.common.persistence;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.SafetyReport;

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
     * Persist only the Icsr without any report.
     * @param icsr
     * @return The saved icsr without the reports
     */
    IchicsrMessage saveOnlyIcsr(IchicsrMessage icsr);

    /**
     * Update all the fields except the Reports on destination copying its from source.
     * @param source source with the data to copy
     * @param destination icsr to synconize
     */
    void updateIcsr(IchicsrMessage source, IchicsrMessage destination);

    /**
     * Add the report to the icsr and save it.
     * @param icsr the icsr
     * @param report the report to save and add to icsr
     */
    void saveReport(IchicsrMessage icsr, SafetyReport report);
}
