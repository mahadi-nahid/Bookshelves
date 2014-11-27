package sust.bookshelves.servicelocator;

import sust.bookshelves.exception.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import sust.bookshelves.session.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


/**
 * The Service Locator maps an interface to an implementation.
 * See:
 * http://java.sun.com/blueprints/corej2eepatterns/Patterns/ServiceLocator.html
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.3 $, $Date: 2006/01/29 21:26:04 $
 */
public class ServiceLocator {
    /**
     * the logger.
     */
    private static Logger log = LogService.getLogger(ServiceLocator.class);

    /**
     * The DatabaseSessionService name.
     */
    public static final String DATABASE_SESSION_SERVICE = "DATABASE_SESSION_SERVICE";



    /**
     * The AuthorServiceService name.
     */
    public static final String AUTHORSERVICE_SERVICE = "AUTHORSERVICE_SERVICE";

    /**
     * The BookServiceService name.
     */
    public static final String BOOKSERVICE_SERVICE = "BOOKSERVICE_SERVICE";

    /**
     * The CatagoryServiceService name.
     */
    public static final String CATAGORYSERVICE_SERVICE = "CATAGORYSERVICE_SERVICE";

    /**
     * The CommentServiceService name.
     */
    public static final String COMMENTSERVICE_SERVICE = "COMMENTSERVICE_SERVICE";

    /**
     * The CommentLikeServiceService name.
     */
    public static final String COMMENTLIKESERVICE_SERVICE = "COMMENTLIKESERVICE_SERVICE";

    /**
     * The FavouriteServiceService name.
     */
    public static final String FAVOURITESERVICE_SERVICE = "FAVOURITESERVICE_SERVICE";

    /**
     * The FollowServiceService name.
     */
    public static final String FOLLOWSERVICE_SERVICE = "FOLLOWSERVICE_SERVICE";

    /**
     * The NotificationServiceService name.
     */
    public static final String NOTIFICATIONSERVICE_SERVICE = "NOTIFICATIONSERVICE_SERVICE";

    /**
     * The PublisherServiceService name.
     */
    public static final String PUBLISHERSERVICE_SERVICE = "PUBLISHERSERVICE_SERVICE";

    /**
     * The RatingServiceService name.
     */
    public static final String RATINGSERVICE_SERVICE = "RATINGSERVICE_SERVICE";

    /**
     * The ReadAllreadyServiceService name.
     */
    public static final String READALLREADYSERVICE_SERVICE = "READALLREADYSERVICE_SERVICE";

    /**
     * The ReadingServiceService name.
     */
    public static final String READINGSERVICE_SERVICE = "READINGSERVICE_SERVICE";

    /**
     * The StatusServiceService name.
     */
    public static final String STATUSSERVICE_SERVICE = "STATUSSERVICE_SERVICE";

    /**
     * The StatusLikeServiceService name.
     */
    public static final String STATUSLIKESERVICE_SERVICE = "STATUSLIKESERVICE_SERVICE";

    /**
     * The SuggestionServiceService name.
     */
    public static final String SUGGESTIONSERVICE_SERVICE = "SUGGESTIONSERVICE_SERVICE";

    /**
     * The UserServiceService name.
     */
    public static final String USERSERVICE_SERVICE = "USERSERVICE_SERVICE";

    /**
     * The UserLoginServiceService name.
     */
    public static final String USERLOGINSERVICE_SERVICE = "USERLOGINSERVICE_SERVICE";

    /**
     * The WantToReadServiceService name.
     */
    public static final String WANTTOREADSERVICE_SERVICE = "WANTTOREADSERVICE_SERVICE";

    /**
     * Contains the class constants
     */
    private static HashMap map;

    /**
     * Contains the classname of the implementation class.
     */
    private static Map serviceInfoMap;

    /**
     * Contains the interface name of the service.
     */
    private static Map serviceInterfaceMap;

    /**
     * Contains the instantiated services.
     */
    private static Map serviceMap;

    /**
     * property.
     */
    static Properties props = null;

    /**
     * Read the service properties.
     */
    static {
        props = ServicePropertyReader.getProperties();
        serviceInfoMap = new HashMap();
        serviceMap = new HashMap();
        serviceInterfaceMap = new HashMap();

        serviceInfoMap.put(DATABASE_SESSION_SERVICE,
                           props.getProperty(DATABASE_SESSION_SERVICE));
        serviceInfoMap.put(AUTHORSERVICE_SERVICE,
                           props.getProperty(AUTHORSERVICE_SERVICE));

        serviceInfoMap.put(BOOKSERVICE_SERVICE,
                           props.getProperty(BOOKSERVICE_SERVICE));

        serviceInfoMap.put(CATAGORYSERVICE_SERVICE,
                           props.getProperty(CATAGORYSERVICE_SERVICE));

        serviceInfoMap.put(COMMENTSERVICE_SERVICE,
                           props.getProperty(COMMENTSERVICE_SERVICE));

        serviceInfoMap.put(COMMENTLIKESERVICE_SERVICE,
                           props.getProperty(COMMENTLIKESERVICE_SERVICE));

        serviceInfoMap.put(FAVOURITESERVICE_SERVICE,
                           props.getProperty(FAVOURITESERVICE_SERVICE));

        serviceInfoMap.put(FOLLOWSERVICE_SERVICE,
                           props.getProperty(FOLLOWSERVICE_SERVICE));

        serviceInfoMap.put(NOTIFICATIONSERVICE_SERVICE,
                           props.getProperty(NOTIFICATIONSERVICE_SERVICE));

        serviceInfoMap.put(PUBLISHERSERVICE_SERVICE,
                           props.getProperty(PUBLISHERSERVICE_SERVICE));

        serviceInfoMap.put(RATINGSERVICE_SERVICE,
                           props.getProperty(RATINGSERVICE_SERVICE));

        serviceInfoMap.put(READALLREADYSERVICE_SERVICE,
                           props.getProperty(READALLREADYSERVICE_SERVICE));

        serviceInfoMap.put(READINGSERVICE_SERVICE,
                           props.getProperty(READINGSERVICE_SERVICE));

        serviceInfoMap.put(STATUSSERVICE_SERVICE,
                           props.getProperty(STATUSSERVICE_SERVICE));

        serviceInfoMap.put(STATUSLIKESERVICE_SERVICE,
                           props.getProperty(STATUSLIKESERVICE_SERVICE));

        serviceInfoMap.put(SUGGESTIONSERVICE_SERVICE,
                           props.getProperty(SUGGESTIONSERVICE_SERVICE));

        serviceInfoMap.put(USERSERVICE_SERVICE,
                           props.getProperty(USERSERVICE_SERVICE));

        serviceInfoMap.put(USERLOGINSERVICE_SERVICE,
                           props.getProperty(USERLOGINSERVICE_SERVICE));

        serviceInfoMap.put(WANTTOREADSERVICE_SERVICE,
                           props.getProperty(WANTTOREADSERVICE_SERVICE));

        serviceInterfaceMap.put(DATABASE_SESSION_SERVICE,
                           "sust.bookshelves.DatabaseSessionService");

        serviceInterfaceMap.put(AUTHORSERVICE_SERVICE,
                           "sust.bookshelves.session.IAuthorService");
        serviceInterfaceMap.put(BOOKSERVICE_SERVICE,
                           "sust.bookshelves.session.IBookService");
        serviceInterfaceMap.put(CATAGORYSERVICE_SERVICE,
                           "sust.bookshelves.session.ICatagoryService");
        serviceInterfaceMap.put(COMMENTSERVICE_SERVICE,
                           "sust.bookshelves.session.ICommentService");
        serviceInterfaceMap.put(COMMENTLIKESERVICE_SERVICE,
                           "sust.bookshelves.session.ICommentLikeService");
        serviceInterfaceMap.put(FAVOURITESERVICE_SERVICE,
                           "sust.bookshelves.session.IFavouriteService");
        serviceInterfaceMap.put(FOLLOWSERVICE_SERVICE,
                           "sust.bookshelves.session.IFollowService");
        serviceInterfaceMap.put(NOTIFICATIONSERVICE_SERVICE,
                           "sust.bookshelves.session.INotificationService");
        serviceInterfaceMap.put(PUBLISHERSERVICE_SERVICE,
                           "sust.bookshelves.session.IPublisherService");
        serviceInterfaceMap.put(RATINGSERVICE_SERVICE,
                           "sust.bookshelves.session.IRatingService");
        serviceInterfaceMap.put(READALLREADYSERVICE_SERVICE,
                           "sust.bookshelves.session.IReadAllreadyService");
        serviceInterfaceMap.put(READINGSERVICE_SERVICE,
                           "sust.bookshelves.session.IReadingService");
        serviceInterfaceMap.put(STATUSSERVICE_SERVICE,
                           "sust.bookshelves.session.IStatusService");
        serviceInterfaceMap.put(STATUSLIKESERVICE_SERVICE,
                           "sust.bookshelves.session.IStatusLikeService");
        serviceInterfaceMap.put(SUGGESTIONSERVICE_SERVICE,
                           "sust.bookshelves.session.ISuggestionService");
        serviceInterfaceMap.put(USERSERVICE_SERVICE,
                           "sust.bookshelves.session.IUserService");
        serviceInterfaceMap.put(USERLOGINSERVICE_SERVICE,
                           "sust.bookshelves.session.IUserLoginService");
        serviceInterfaceMap.put(WANTTOREADSERVICE_SERVICE,
                           "sust.bookshelves.session.IWantToReadService");

    }

    /**
     * Locate a Service implementation by passing the Name of the service. The
     * getService() method will initalize an implementation of the service.
     *
     * @param serviceName de naam van de service
     * @return Een Implementatie van de gespecificeerde service.
     * @throws UnknownServiceException de exceptie
     * @throws ServiceInstantiationException de exceptie
     */
    public static LocatableService getService(String serviceName)
                                       throws UnknownServiceException,
                                              ServiceInstantiationException {
        log.debug("Locating service for " + serviceName);

        //see if there is a initialized
        LocatableService service = (LocatableService) serviceMap.get(serviceName);

        if (service != null) {
            return service;
        } else {
            //get service for the first time
            String className = (String) serviceInfoMap.get(serviceName);
            log.debug("Found service " + className);
            String interfaceName = (String) serviceInterfaceMap.get(serviceName);
            log.debug("Found service " + interfaceName);

            if (className != null) {
                try {
                    log.debug("Use classloader to find class: " + interfaceName);
                    Class theServiceInterface = Class.forName(interfaceName);
                    log.debug("Use classloader to find class: " + className);                    
                    Class theDelegateClass = Class.forName(className);
   					  log.debug("Create a new instance of the loaded class.");
						  try {
                        log.debug("Create a new instance of the loaded class.");
                        service = (LocatableService) theDelegateClass.newInstance();
                    } catch (Exception e) {
                        log.debug("Create a dynamic proxy for the loaded class.");
                        service = (LocatableService) Proxy.newProxyInstance(theServiceInterface.getClassLoader(), new Class[]{theServiceInterface, LocatableService.class}, (InvocationHandler) theDelegateClass.newInstance());
                    }
                    service.init();
                    log.debug("The service was initialized");
                    serviceMap.put(serviceName, service);
                    log.debug("The service was put in the map");

                    return service;
                } catch (Exception e) {
                    log.error("Error instantiating the service", e);
                    throw new ServiceInstantiationException(e);
                }
            }

            throw new UnknownServiceException("Service not found:" + serviceName);
        }
    }
   /**
    * Determines a list of all constants using reflection and put them in a hashmap.
    *
    * @return HashMap with the names of all constants and their String values.
    */
   public synchronized static HashMap getConstants() {
      if (map != null) {
         return map;
      }
      map = new HashMap();
      Field fields[] = null;

      try {
         fields = ServiceLocator.class.getDeclaredFields();
      }
      catch (SecurityException e) {
         e.printStackTrace();
         return new HashMap();
      }
      if (fields != null) {
         if (fields.length != 0) {
            for (int i = 0; i < fields.length; i++) {
               if (Modifier.isPublic(fields[i].getModifiers())
                  && Modifier.isFinal(fields[i].getModifiers())
                  && Modifier.isStatic(fields[i].getModifiers())
               ) {
                  // It's a constant!
                  try {
                     map.put(fields[i].getName(), fields[i].get(null));
                  }
                  catch (Exception e) {
                     e.printStackTrace();
                     return new HashMap();
                  }
               }
            }
         }
      }
      return map;
   }
}
