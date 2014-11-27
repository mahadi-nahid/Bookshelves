package sust.bookshelves.session;

/**
 * The <code>RatingServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IRatingService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new rating to the storage.
    *
    * @param model a data object
    * @return Rating a data object with the primary key
    */
   sust.bookshelves.entity.Rating addRating(sust.bookshelves.entity.Rating model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Rating</code>.
    *
    * @param model the data model to store
    */
   void saveRating(sust.bookshelves.entity.Rating model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a rating.
    *
    * @param id the unique reference for the rating
    */
   void deleteRating(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Rating the data object
    */
   sust.bookshelves.entity.Rating getRating(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all rating instances.
    *
    * @return a list of Rating objects.
    */
   java.util.List<sust.bookshelves.entity.Rating> getRatingList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all rating instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of rating instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getRatingListSize()</code> = last record),
    * any values greater than or equal to the total number of rating instances will cause
    * the full set to be returned.
    * @return a collection of Rating objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Rating> getRatingList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of rating objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getRatingListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified ratingId field.
     *
     * @param ratingId the field
     * @return List of Rating data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Rating> findRatingByRatingId(java.lang.Integer ratingId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified counter field.
     *
     * @param counter the field
     * @return List of Rating data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Rating> findRatingByCounter(java.lang.Integer counter) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified currentrating field.
     *
     * @param currentrating the field
     * @return List of Rating data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Rating> findRatingByCurrentrating(java.lang.Double currentrating) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     *
     * @param bookId the field
     * @return List of Rating data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Rating> findRatingByBookId(java.lang.Integer bookId) throws sust.bookshelves.exception.GenericBusinessException;


}
