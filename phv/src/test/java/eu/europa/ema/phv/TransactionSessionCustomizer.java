package eu.europa.ema.phv;

import com.atomikos.icatch.jta.UserTransactionManager;
import org.eclipse.persistence.transaction.JTATransactionController;

import javax.transaction.TransactionManager;

public class TransactionSessionCustomizer extends JTATransactionController {

    @Override
    protected TransactionManager acquireTransactionManager() throws Exception {

        Class<?> clazz = Class.forName("com.atomikos.icatch.jta.UserTransactionManager");
        UserTransactionManager atomikosTransactionManager = (UserTransactionManager) clazz.newInstance();
        atomikosTransactionManager.setTransactionTimeout(1);
        atomikosTransactionManager.setForceShutdown(true);
        return atomikosTransactionManager;

    }

}
/*
@Configurable
public class TransactionSessionCustomizer implements SessionCustomizer {

   private JtaTransactionManager jtaTransactionManager;

    public TransactionSessionCustomizer(JtaTransactionManager jtaTransactionManager) {
        this.jtaTransactionManager = jtaTransactionManager;
    }

    public void setTransactionManager(
            JtaTransactionManager jtaTransactionManager) {
        this.jtaTransactionManager = jtaTransactionManager;
    }

    public void customize(Session session) throws Exception {
        session.setExternalTransactionController(new CustomJTATransactionController());
    }

    class CustomJTATransactionController extends JTATransactionController {

        @Override
        protected TransactionManager acquireTransactionManager()
                throws Exception {
            if(jtaTransactionManager == null)
                return null;
            return jtaTransactionManager.getTransactionManager();
        }

    }
}
    */