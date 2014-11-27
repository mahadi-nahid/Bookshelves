package sust.bookshelves.session;

/**
 * The <code>BookServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IBookService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new book to the storage.
    *
    * @param model a data object
    * @return Book a data object with the primary key
    */
   sust.bookshelves.entity.Book addBook(sust.bookshelves.entity.Book model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Book</code>.
    *
    * @param model the data model to store
    */
   void saveBook(sust.bookshelves.entity.Book model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a book.
    *
    * @param id the unique reference for the book
    */
   void deleteBook(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Book the data object
    */
   sust.bookshelves.entity.Book getBook(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all book instances.
    *
    * @return a list of Book objects.
    */
   java.util.List<sust.bookshelves.entity.Book> getBookList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all book instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of book instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getBookListSize()</code> = last record),
    * any values greater than or equal to the total number of book instances will cause
    * the full set to be returned.
    * @return a collection of Book objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Book> getBookList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of book objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getBookListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     *
     * @param bookId the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Book> findBookByBookId(java.lang.Integer bookId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Book> findBookByDescription(java.lang.String description) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified year field.
     *
     * @param year the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Book> findBookByYear(java.lang.Integer year) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified title field.
     *
     * @param title the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Book> findBookByTitle(java.lang.String title) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified authorId field.
     *
     * @param authorId the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Book> findBookByAuthorId(java.lang.Integer authorId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified catagoryId field.
     *
     * @param catagoryId the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Book> findBookByCatagoryId(java.lang.Integer catagoryId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified publisherId field.
     *
     * @param publisherId the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Book> findBookByPublisherId(java.lang.Integer publisherId) throws sust.bookshelves.exception.GenericBusinessException;


}
