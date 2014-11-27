package sust.bookshelves.exception;


/**
 * Exception that will be thrown if the service is unknown.
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
public class UnknownServiceException extends GenericBusinessException {
    /**
     * message constructor.
     * @param message the error message
     */
    public UnknownServiceException(String message) {
        super(message);
    }

    /**
     * cause constructor.
     * @param cause the cause
     */
    public UnknownServiceException(Exception cause) {
        super(cause);
    }

    /**
     * message en cause constructor.
     * @param message the error message
     * @param cause   the cause
     */
    public UnknownServiceException(String message, Exception cause) {
        super(message, cause);
    }
}
