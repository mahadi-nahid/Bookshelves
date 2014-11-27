package sust.bookshelves.session;

/**
 * The <code>ReadingServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IReadingService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new reading to the storage.
    *
    * @param model a data object
    * @return Reading a data object with the primary key
    */
   sust.bookshelves.entity.Reading addReading(sust.bookshelves.entity.Reading model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Reading</code>.
    *
    * @param model the data model to store
    */
   void saveReading(sust.bookshelves.entity.Reading model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a reading.
    *
    * @param id the unique reference for the reading
    */
   void deleteReading(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Reading the data object
    */
   sust.bookshelves.entity.Reading getReading(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all reading instances.
    *
    * @return a list of Reading objects.
    */
   java.util.List<sust.bookshelves.entity.Reading> getReadingList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all reading instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of reading instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getReadingListSize()</code> = last record),
    * any values greater than or equal to the total number of reading instances will cause
    * the full set to be returned.
    * @return a collection of Reading objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Reading> getReadingList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of reading objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getReadingListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified readingId field.
     *
     * @param readingId the field
     * @return List of Reading data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Reading> findReadingByReadingId(java.lang.Integer readingId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     *
     * @param bookId the field
     * @return List of Reading data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Reading> findReadingByBookId(java.lang.Integer bookId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Reading data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Reading> findReadingByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;


}
