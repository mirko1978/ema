package eu.europa.ema.phv;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;
/**
 * 
 * Dummy transaction manager for testing purposes
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 23 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 */
public class DummyTransactionManager implements PlatformTransactionManager {
    public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
        return new SimpleTransactionStatus();
    }

    public void commit(TransactionStatus transactionStatus) throws TransactionException {
    }

    public void rollback(TransactionStatus transactionStatus) throws TransactionException {

    }
}