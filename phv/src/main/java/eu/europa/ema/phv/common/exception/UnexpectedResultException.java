/**
 *
 */
package eu.europa.ema.phv.common.exception;

/**
 * Result not expected from the previous operation
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 12 Jun 2014 $
 * @since 12 Jun 2014 (creation date)
 */
public class UnexpectedResultException extends PhvException {

    private static final long serialVersionUID = -6486226847088462604L;

    /**
     * Constructs a new exception with <code>null</code> as its detail message.
     */
    public UnexpectedResultException() {
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message
     */
    public UnexpectedResultException(String message) {
        super(message);
    }

}
