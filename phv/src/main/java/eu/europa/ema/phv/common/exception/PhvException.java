/**
 * 
 */
package eu.europa.ema.phv.common.exception;

/**
 * Exception base class for phv
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 12 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 12 Jun 2014 $
 */
public class PhvException extends Exception {

    private static final long serialVersionUID = -501387316117862920L;

    /**
     * Constructs a new exception with <code>null</code> as its detail message.
     */
    public PhvException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.
     * @param message
     */
    public PhvException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message
     * of <code>(cause == null ? null : cause.toString())</code> (which
     * typically contains the class and detail message of cause).
     * @param cause
     */
    public PhvException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * @param message
     * @param cause
     */
    public PhvException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message, cause,
     * suppression enabled or disabled, and writable stack trace enabled or
     * disabled.
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public PhvException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
