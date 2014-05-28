package eu.europa.ema.jpa;

/**
 * 
 * Define the Dao interface for saving the record
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @author $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 27 May 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 27 May 2014 $
 */
public interface RecordDao {

    /** Save the record in the database */
    void save(Record record);
}
