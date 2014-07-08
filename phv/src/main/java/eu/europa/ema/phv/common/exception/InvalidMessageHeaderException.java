package eu.europa.ema.phv.common.exception;

/**
 * 
 * The custom exception class to indicate invalid header error
 * examples are missing mandatory headers like senderId, received date etc
 * 
 * @author  Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 8 Jul 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 8 Jul 2014 $
 */


public class InvalidMessageHeaderException extends Exception {

   
   
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
