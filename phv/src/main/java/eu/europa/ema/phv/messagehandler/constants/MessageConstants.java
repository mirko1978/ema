/**
 *
 */
package eu.europa.ema.phv.messagehandler.constants;

/**
 * An interface to hold constants for Message Handler module
 *
 * @author Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 8 Jul 2014 $
 * @since 8 Jul 2014 (creation date)
 */
public interface MessageConstants {

    String MESSAGE_HEADER_ICSR = "icsr";
    String MESSAGE_HEADER_VALIDATIONRESULT = "validationResult";
    String MESSAGE_HEADER_VALID = "valid";
    String MESSAGE_HEADER_INVALID = "invalid";
    String MESSAGE_HEADER_RECEIVER = "receiverid";
    String MESSAGE_HEADER_VALIDATION_DATE = "validationDate";
    String MESSAGE_RECEIVED_DATE = "receivedDate";
    String MESSAGE_FILE_SIZE = "fileSize";
    String MESSAGE_FILE_NAME = "fileName";
    String MESSAGE_ORIGAL_PAYLOAD = "originalPayload";

    //the header value for the above for EMA consumption
    String MESSAGE_RECEIVER_EVHUMAN = "EVHUMAN";

}
