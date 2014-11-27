package sust.bookshelves.session;

import java.util.*;
import sust.bookshelves.*;
import sust.bookshelves.servicelocator.LocatableService;
import com.finalist.util.log.*;
import sust.bookshelves.exception.GenericBusinessException;
//import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.finalist.util.log.*;
import sust.bookshelves.entity.*;

/**
 * The <code>NotificationService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class NotificationService implements INotificationService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(NotificationService.class);


   /**
    * Default implementation for the Locatable Service interface.
    */
    public void init() {
    }

   /**
    * Default implementation for the Locatable Service interface.
    */
    public void destroy() {
    }

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/



   /**
    * Adds a new notification to the database.
    *
    * @param model a data object
    * @return Notification a data object with the primary key
    */
   public sust.bookshelves.entity.Notification addNotification(sust.bookshelves.entity.Notification model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getNotification(model.getPrimaryKey());
      } finally {
         log.debug("finished addNotification(sust.bookshelves.entity.Notification model)");
      }
   }

   /**
    * Stores the <code>Notification</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveNotification(sust.bookshelves.entity.Notification model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveNotification(sust.bookshelves.entity.Notification model)");
      }
   }

   /**
    * Removes a notification.
    *
    * @param id the unique reference for the notification
    */
   public void deleteNotification(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Notification bean = (Notification) hibernateTemplate.get(Notification.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteNotification(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Notification the data object
    */
   public sust.bookshelves.entity.Notification getNotification(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Notification bean = (Notification) hibernateTemplate.get(Notification.class, id);
      return bean;
      } finally {
         log.debug("finished getNotification(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all notification instances.
    *
    * @return a list of Notification objects.
    */
   public List getNotificationList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Notification.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.notificationId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getNotificationList");
      }
   }

   /**
    * Returns a subset of all notification instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of notification instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getNotificationListSize()</code> = last record),
    * any values greater than or equal to the total number of notification instances will cause
    * the full set to be returned.
    * @return a list of Notification objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getNotificationList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Notification.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.notificationId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getNotificationList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of notification objects in the database.
    *
    * @return an integer value.
    */
   public int getNotificationListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Notification.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getNotificationListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified notificationId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param notificationId the field
     * @return List of Notification data objects, empty list in case no results were found.
     */
    public java.util.List findNotificationByNotificationId(java.lang.Integer notificationId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Notification.class.getName() + " e where e.notificationId like :notificationId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.notificationId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "notificationId", notificationId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findNotificationByNotificationId(java.lang.Integer notificationId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified description field.
     * To use a wildcard search, use a % in the query.
     *
     * @param description the field
     * @return List of Notification data objects, empty list in case no results were found.
     */
    public java.util.List findNotificationByDescription(java.lang.String description) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Notification.class.getName() + " e where e.description like :description ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.notificationId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "description", description);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findNotificationByDescription(java.lang.String description)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified isseen field.
     * To use a wildcard search, use a % in the query.
     *
     * @param isseen the field
     * @return List of Notification data objects, empty list in case no results were found.
     */
    public java.util.List findNotificationByIsseen(java.lang.String isseen) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Notification.class.getName() + " e where e.isseen like :isseen ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.notificationId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "isseen", isseen);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findNotificationByIsseen(java.lang.String isseen)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of Notification data objects, empty list in case no results were found.
     */
    public java.util.List findNotificationByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Notification.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.notificationId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findNotificationByUserId(java.lang.Integer userId)");
      }
    }


}
