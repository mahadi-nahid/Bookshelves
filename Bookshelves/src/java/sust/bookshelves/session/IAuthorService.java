package sust.bookshelves.session;

/**
 * The <code>AuthorServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IAuthorService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new author to the storage.
    *
    * @param model a data object
    * @return Author a data object with the primary key
    */
   sust.bookshelves.entity.Author addAuthor(sust.bookshelves.entity.Author model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Author</code>.
    *
    * @param model the data model to store
    */
   void saveAuthor(sust.bookshelves.entity.Author model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a author.
    *
    * @param id the unique reference for the author
    */
   void deleteAuthor(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Author the data object
    */
   sust.bookshelves.entity.Author getAuthor(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all author instances.
    *
    * @return a list of Author objects.
    */
   java.util.List<sust.bookshelves.entity.Author> getAuthorList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all author instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of author instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getAuthorListSize()</code> = last record),
    * any values greater than or equal to the total number of author instances will cause
    * the full set to be returned.
    * @return a collection of Author objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Author> getAuthorList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of author objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getAuthorListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified authorId field.
     *
     * @param authorId the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Author> findAuthorByAuthorId(java.lang.Integer authorId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified fname field.
     *
     * @param fname the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Author> findAuthorByFname(java.lang.String fname) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified lname field.
     *
     * @param lname the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Author> findAuthorByLname(java.lang.String lname) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified dob field.
     *
     * @param dob the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Author> findAuthorByDob(java.sql.Date dob) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified dod field.
     *
     * @param dod the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Author> findAuthorByDod(java.sql.Date dod) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified country field.
     *
     * @param country the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Author> findAuthorByCountry(java.lang.String country) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Author> findAuthorByDescription(java.lang.String description) throws sust.bookshelves.exception.GenericBusinessException;


}
