package sust.bookshelves.session;

/**
 * The <code>FollowServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IFollowService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new follow to the storage.
    *
    * @param model a data object
    * @return Follow a data object with the primary key
    */
   sust.bookshelves.entity.Follow addFollow(sust.bookshelves.entity.Follow model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Follow</code>.
    *
    * @param model the data model to store
    */
   void saveFollow(sust.bookshelves.entity.Follow model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a follow.
    *
    * @param id the unique reference for the follow
    */
   void deleteFollow(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Follow the data object
    */
   sust.bookshelves.entity.Follow getFollow(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all follow instances.
    *
    * @return a list of Follow objects.
    */
   java.util.List<sust.bookshelves.entity.Follow> getFollowList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all follow instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of follow instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getFollowListSize()</code> = last record),
    * any values greater than or equal to the total number of follow instances will cause
    * the full set to be returned.
    * @return a collection of Follow objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Follow> getFollowList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of follow objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getFollowListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified followId field.
     *
     * @param followId the field
     * @return List of Follow data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Follow> findFollowByFollowId(java.lang.Integer followId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userUserId field.
     *
     * @param userUserId the field
     * @return List of Follow data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Follow> findFollowByUserUserId(java.lang.Integer userUserId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Follow data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Follow> findFollowByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;


}
