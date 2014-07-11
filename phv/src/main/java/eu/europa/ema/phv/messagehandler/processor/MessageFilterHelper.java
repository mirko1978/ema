/**
 *
 */
package eu.europa.ema.phv.messagehandler.processor;

import eu.europa.ema.phv.common.model.adrhuman.MessageBoxEntity;
import eu.europa.ema.phv.common.persistence.MessageDAO;
import eu.europa.ema.phv.messagehandler.constants.MessageConstants;
import org.apache.camel.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * The helper class to filter messages
 *
 * @author Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 11 Jul 2014 $
 * @since 11 Jul 2014 (creation date)
 */
public class MessageFilterHelper {

    private static final Logger LOG = LoggerFactory.getLogger(MessageFilterHelper.class);

    @Inject
    private MessageDAO messageDAO;

    /**
     * This method verifies if there is an  message box for the given user; excludes EVHUMAN
     *
     * @param receiverId
     * @return
     */
    public boolean isNotWebTrader(
            @Header(MessageConstants.MESSAGE_HEADER_RECEIVER)
            String receiverId) {
        boolean isNotaWebTrader = true;
        LOG.debug("Checking if a message box exists in the database for a receiver Id " + receiverId);
        if (MessageConstants.MESSAGE_RECEIVER_EVHUMAN.equalsIgnoreCase(receiverId)) {
            return isNotaWebTrader;
        }
        try {
            MessageBoxEntity msgBox = messageDAO.findMessageBoxByOwner(receiverId);
            isNotaWebTrader = msgBox == null;
        }
        catch (Exception e) {//No row found
            LOG.info("Message box does not exist  for {} in the database, hence not considered as a WebTrader",
                    receiverId);
        }
        return isNotaWebTrader;
    }

}
