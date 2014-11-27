package sust.bookshelves.session;

/**
 * The <code>StatusLikeServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IStatusLikeService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new statuslike to the storage.
    *
    * @param model a data object
    * @return Statuslike a data object with the primary key
    */
   sust.bookshelves.entity.Statuslike addStatuslike(sust.bookshelves.entity.Statuslike model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Statuslike</code>.
    *
    * @param model the data model to store
    */
   void saveStatuslike(sust.bookshelves.entity.Statuslike model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a statuslike.
    *
    * @param id the unique reference for the statuslike
    */
   void deleteStatuslike(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Statuslike the data object
    */
   sust.bookshelves.entity.Statuslike getStatuslike(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all statuslike instances.
    *
    * @return a list of Statuslike objects.
    */
   java.util.List<sust.bookshelves.entity.Statuslike> getStatuslikeList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all statuslike instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of statuslike instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getStatuslikeListSize()</code> = last record),
    * any values greater than or equal to the total number of statuslike instances will cause
    * the full set to be returned.
    * @return a collection of Statuslike objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Statuslike> getStatuslikeList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of statuslike objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getStatuslikeListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified statuslikeId field.
     *
     * @param statuslikeId the field
     * @return List of Statuslike data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Statuslike> findStatuslikeByStatuslikeId(java.lang.Integer statuslikeId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Statuslike data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Statuslike> findStatuslikeByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified statusId field.
     *
     * @param statusId the field
     * @return List of Statuslike data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Statuslike> findStatuslikeByStatusId(java.lang.Integer statusId) throws sust.bookshelves.exception.GenericBusinessException;


}
