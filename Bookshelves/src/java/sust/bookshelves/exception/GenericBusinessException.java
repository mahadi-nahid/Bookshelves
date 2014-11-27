package sust.bookshelves.exception;


/**
 * Base Exception class that can be thrown by the business layer.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
public class GenericBusinessException extends Exception {
    /**
     * message constructo.
     * @param message the error message
     */
    public GenericBusinessException(String message) {
        super(message);
    }

    /**
     * cause constructor.
     * @param cause the cause
     */
    public GenericBusinessException(Exception cause) {
        super(cause);
    }

    /**
     * message en cause constructor.
     * @param message the error message
     * @param cause   the cause
     */
    public GenericBusinessException(String message, Exception cause) {
        super(message, cause);
    }
}
