package eu.europa.ema.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * Save an entity without using the JTA transaction manager. See the comments
 * below for configuring the persitence.xml and the spring context. This class
 * is not used in the test context, because it is configured to use the Weblogic
 * JTA implementation
 * 
 * @author Bernardoni Mirko (created by)
 * @author $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 27 May 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 27 May 2014 $
 */
// Spring context
//
// <bean id="entityManagerFactory"
// class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
// <property name="persistenceUnitName" value="recordJTA" />
// </bean>
//

//
// persistence.xml
//
// <?xml version="1.0" encoding="windows-1252" ?>
// <persistence xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
// xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
// version="2.0" xmlns="http://java.sun.com/xml/ns/persistence">
//
// <persistence-unit name="recordJTA" transaction-type="JTA">
// <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
// <jta-data-source>jdbc/ev7</jta-data-source>
// <class>eu.europa.ema.jpa.Record</class>
// <properties>
// <property name="eclipselink.weaving" value="false" />
// </properties>
// </persistence-unit>
//
// </persistence>
@Service
public class RecordJPADaoWithoutJTA implements RecordDao {

    private static final Logger LOG = LoggerFactory.getLogger(RecordJPADaoWithoutJTA.class);

    @PersistenceUnit(unitName = "recordJTA")
    private EntityManagerFactory emf;

    @Override
    public void save(Record record) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction utx = em.getTransaction();
        try {
            LOG.info("Saving via JPA ..." + record.getBody().substring(0, 20) + " id=" + record.getId());
            utx.begin();
            em.persist(record);
            utx.commit();
        }
        catch (Exception e) {
            LOG.error("Cannot save ", e);
            try {
                utx.rollback();
            }
            catch (Exception e1) {
                LOG.error("Exception in the rollback", e1);
                e1.printStackTrace();
            }
        }
        em.close();
    }

}
