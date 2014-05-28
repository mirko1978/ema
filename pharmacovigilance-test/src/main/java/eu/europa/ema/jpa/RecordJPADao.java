package eu.europa.ema.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * Save an Entity using JTA
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @author $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 27 May 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 27 May 2014 $
 */
@Service("RecordJPADao")
public class RecordJPADao implements RecordDao {
    private static final Logger LOG = LoggerFactory.getLogger(RecordJPADao.class);

    @PersistenceUnit(unitName = "recordJTA")
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Record record) {
        LOG.info("Saving via JPA ..." + record.getBody().substring(0, 20) + " id=" + record.getId());
        em.persist(record);
    }
}
