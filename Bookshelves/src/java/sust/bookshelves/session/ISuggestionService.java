package sust.bookshelves.session;

/**
 * The <code>SuggestionServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface ISuggestionService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new suggestion to the storage.
    *
    * @param model a data object
    * @return Suggestion a data object with the primary key
    */
   sust.bookshelves.entity.Suggestion addSuggestion(sust.bookshelves.entity.Suggestion model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Suggestion</code>.
    *
    * @param model the data model to store
    */
   void saveSuggestion(sust.bookshelves.entity.Suggestion model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a suggestion.
    *
    * @param id the unique reference for the suggestion
    */
   void deleteSuggestion(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Suggestion the data object
    */
   sust.bookshelves.entity.Suggestion getSuggestion(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all suggestion instances.
    *
    * @return a list of Suggestion objects.
    */
   java.util.List<sust.bookshelves.entity.Suggestion> getSuggestionList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all suggestion instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of suggestion instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getSuggestionListSize()</code> = last record),
    * any values greater than or equal to the total number of suggestion instances will cause
    * the full set to be returned.
    * @return a collection of Suggestion objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Suggestion> getSuggestionList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of suggestion objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getSuggestionListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified suggestionId field.
     *
     * @param suggestionId the field
     * @return List of Suggestion data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Suggestion> findSuggestionBySuggestionId(java.lang.Integer suggestionId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     *
     * @param bookId the field
     * @return List of Suggestion data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Suggestion> findSuggestionByBookId(java.lang.Integer bookId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userUserId field.
     *
     * @param userUserId the field
     * @return List of Suggestion data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Suggestion> findSuggestionByUserUserId(java.lang.Integer userUserId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Suggestion data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Suggestion> findSuggestionByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;


}
