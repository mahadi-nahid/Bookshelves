package sust.bookshelves.session;

/**
 * The <code>NotificationServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface INotificationService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new notification to the storage.
    *
    * @param model a data object
    * @return Notification a data object with the primary key
    */
   sust.bookshelves.entity.Notification addNotification(sust.bookshelves.entity.Notification model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Notification</code>.
    *
    * @param model the data model to store
    */
   void saveNotification(sust.bookshelves.entity.Notification model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a notification.
    *
    * @param id the unique reference for the notification
    */
   void deleteNotification(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Notification the data object
    */
   sust.bookshelves.entity.Notification getNotification(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all notification instances.
    *
    * @return a list of Notification objects.
    */
   java.util.List<sust.bookshelves.entity.Notification> getNotificationList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all notification instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of notification instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getNotificationListSize()</code> = last record),
    * any values greater than or equal to the total number of notification instances will cause
    * the full set to be returned.
    * @return a collection of Notification objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Notification> getNotificationList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of notification objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getNotificationListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified notificationId field.
     *
     * @param notificationId the field
     * @return List of Notification data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Notification> findNotificationByNotificationId(java.lang.Integer notificationId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return List of Notification data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Notification> findNotificationByDescription(java.lang.String description) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified isseen field.
     *
     * @param isseen the field
     * @return List of Notification data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Notification> findNotificationByIsseen(java.lang.String isseen) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Notification data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Notification> findNotificationByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;


}
