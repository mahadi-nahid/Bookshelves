package sust.bookshelves.servicelocator;

import sust.bookshelves.exception.*;

/**
 * Interface that determines the service.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
public interface ServiceInfo {
    /**
     * determine service.
     * @return Locatable Service
     * @throws ServiceInstantiationException service can not be started.
     * @throws UnknownServiceException Unknown service
     */
    LocatableService getService() throws ServiceInstantiationException, UnknownServiceException;
}
