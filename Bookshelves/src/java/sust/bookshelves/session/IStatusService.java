package sust.bookshelves.session;

/**
 * The <code>StatusServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IStatusService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new status to the storage.
    *
    * @param model a data object
    * @return Status a data object with the primary key
    */
   sust.bookshelves.entity.Status addStatus(sust.bookshelves.entity.Status model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Status</code>.
    *
    * @param model the data model to store
    */
   void saveStatus(sust.bookshelves.entity.Status model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a status.
    *
    * @param id the unique reference for the status
    */
   void deleteStatus(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Status the data object
    */
   sust.bookshelves.entity.Status getStatus(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all status instances.
    *
    * @return a list of Status objects.
    */
   java.util.List<sust.bookshelves.entity.Status> getStatusList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all status instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of status instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getStatusListSize()</code> = last record),
    * any values greater than or equal to the total number of status instances will cause
    * the full set to be returned.
    * @return a collection of Status objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Status> getStatusList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of status objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getStatusListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified statusId field.
     *
     * @param statusId the field
     * @return List of Status data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Status> findStatusByStatusId(java.lang.Integer statusId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return List of Status data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Status> findStatusByDescription(java.lang.String description) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Status data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Status> findStatusByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;


}
