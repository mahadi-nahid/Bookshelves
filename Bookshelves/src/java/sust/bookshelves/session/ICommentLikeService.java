package sust.bookshelves.session;

/**
 * The <code>CommentLikeServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface ICommentLikeService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new commentlike to the storage.
    *
    * @param model a data object
    * @return Commentlike a data object with the primary key
    */
   sust.bookshelves.entity.Commentlike addCommentlike(sust.bookshelves.entity.Commentlike model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Commentlike</code>.
    *
    * @param model the data model to store
    */
   void saveCommentlike(sust.bookshelves.entity.Commentlike model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a commentlike.
    *
    * @param id the unique reference for the commentlike
    */
   void deleteCommentlike(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Commentlike the data object
    */
   sust.bookshelves.entity.Commentlike getCommentlike(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all commentlike instances.
    *
    * @return a list of Commentlike objects.
    */
   java.util.List<sust.bookshelves.entity.Commentlike> getCommentlikeList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all commentlike instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of commentlike instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getCommentlikeListSize()</code> = last record),
    * any values greater than or equal to the total number of commentlike instances will cause
    * the full set to be returned.
    * @return a collection of Commentlike objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Commentlike> getCommentlikeList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of commentlike objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getCommentlikeListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified commentlikeId field.
     *
     * @param commentlikeId the field
     * @return List of Commentlike data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Commentlike> findCommentlikeByCommentlikeId(java.lang.Integer commentlikeId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Commentlike data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Commentlike> findCommentlikeByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified commentId field.
     *
     * @param commentId the field
     * @return List of Commentlike data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Commentlike> findCommentlikeByCommentId(java.lang.Integer commentId) throws sust.bookshelves.exception.GenericBusinessException;


}
