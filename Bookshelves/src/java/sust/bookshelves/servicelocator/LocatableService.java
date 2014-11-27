package sust.bookshelves.servicelocator;

import sust.bookshelves.exception.*;

/**
 * Services have to implement the LocatebleService interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
public interface LocatableService {
    /**
     * init.
     * @throws GenericBusinessException the business exception.
     */
    void init() throws GenericBusinessException;

    /**
     * destroy.
     * @throws GenericBusinessException the business exception.
     */
    void destroy() throws GenericBusinessException;
}
