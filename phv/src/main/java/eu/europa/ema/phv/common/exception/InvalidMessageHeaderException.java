package eu.europa.ema.phv.common.exception;

/**
 * The custom exception class to indicate invalid header error
 * examples are missing mandatory headers like senderId, received date etc
 *
 * @author Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 8 Jul 2014 (creation date)
 */

public class InvalidMessageHeaderException extends Exception {

    private static final long serialVersionUID = -6202243087448231971L;

    public InvalidMessageHeaderException() {
        super();
    }

    public InvalidMessageHeaderException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidMessageHeaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMessageHeaderException(String message) {
        super(message);
    }

    public InvalidMessageHeaderException(Throwable cause) {
        super(cause);
    }

}
