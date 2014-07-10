/**
 * 
 */
package eu.europa.ema.phv.common.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.europa.ema.phv.common.model.adrhuman.MessageBoxEntity;

/**
 * The implementation class for MessageDAO that uses JPA mode
 * 
 * @author  Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 10 Jul 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 10 Jul 2014 $
 */

public class JpaMessageDAO implements MessageDAO {
    
    private static final Logger LOG = LoggerFactory.getLogger(JpaMessageDAO.class);
    
    @PersistenceContext (unitName="messageJTA")
    private EntityManager em;

    /*  
     * @see eu.europa.ema.phv.common.persistence.MessageDAO#getMessageBoxForOwner(java.lang.String)
     */
    @Override
    @Transactional
    public MessageBoxEntity findMessageBoxByOwner(String Owner) {
        LOG.debug("findByOwner, owner:" + Owner);
        System.out.println("em:"+this.em +"; query:");
        TypedQuery<MessageBoxEntity> query =
                  this.em.createNamedQuery("MessageBoxEntity.findByOwner", MessageBoxEntity.class).setParameter("owner", Owner);
          
              return query.getResultList().get(0);
       
    }

}
