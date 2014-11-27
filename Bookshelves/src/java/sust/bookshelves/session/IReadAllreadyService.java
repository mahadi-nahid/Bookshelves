package sust.bookshelves.session;

/**
 * The <code>ReadAllreadyServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IReadAllreadyService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new readallready to the storage.
    *
    * @param model a data object
    * @return Readallready a data object with the primary key
    */
   sust.bookshelves.entity.Readallready addReadallready(sust.bookshelves.entity.Readallready model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Readallready</code>.
    *
    * @param model the data model to store
    */
   void saveReadallready(sust.bookshelves.entity.Readallready model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a readallready.
    *
    * @param id the unique reference for the readallready
    */
   void deleteReadallready(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Readallready the data object
    */
   sust.bookshelves.entity.Readallready getReadallready(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all readallready instances.
    *
    * @return a list of Readallready objects.
    */
   java.util.List<sust.bookshelves.entity.Readallready> getReadallreadyList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all readallready instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of readallready instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getReadallreadyListSize()</code> = last record),
    * any values greater than or equal to the total number of readallready instances will cause
    * the full set to be returned.
    * @return a collection of Readallready objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Readallready> getReadallreadyList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of readallready objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getReadallreadyListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified readId field.
     *
     * @param readId the field
     * @return List of Readallready data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Readallready> findReadallreadyByReadId(java.lang.Integer readId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     *
     * @param bookId the field
     * @return List of Readallready data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Readallready> findReadallreadyByBookId(java.lang.Integer bookId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Readallready data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Readallready> findReadallreadyByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;


}
