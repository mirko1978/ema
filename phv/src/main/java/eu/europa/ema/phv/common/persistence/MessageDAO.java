/**
 * 
 */
package eu.europa.ema.phv.common.persistence;

import org.springframework.stereotype.Repository;

import eu.europa.ema.phv.common.model.adrhuman.MessageBoxEntity;

/**
 * The Data Access Service interface for various message related data access calls
 * 
 * @author  Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 10 Jul 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 10 Jul 2014 $
 */

public interface MessageDAO {
    
    /**
     * The read only method to get the row entity from X_MESSAGEBOX table for a given owner (sender or receiver)
     * 
     * @param Owner
     * @return MessageBoxEntity
     */
    MessageBoxEntity findMessageBoxByOwner(String Owner);

}
