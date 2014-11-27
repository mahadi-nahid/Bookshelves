package sust.bookshelves.session;

/**
 * The <code>WantToReadServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IWantToReadService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new wanttoread to the storage.
    *
    * @param model a data object
    * @return Wanttoread a data object with the primary key
    */
   sust.bookshelves.entity.Wanttoread addWanttoread(sust.bookshelves.entity.Wanttoread model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Wanttoread</code>.
    *
    * @param model the data model to store
    */
   void saveWanttoread(sust.bookshelves.entity.Wanttoread model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a wanttoread.
    *
    * @param id the unique reference for the wanttoread
    */
   void deleteWanttoread(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Wanttoread the data object
    */
   sust.bookshelves.entity.Wanttoread getWanttoread(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all wanttoread instances.
    *
    * @return a list of Wanttoread objects.
    */
   java.util.List<sust.bookshelves.entity.Wanttoread> getWanttoreadList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all wanttoread instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of wanttoread instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getWanttoreadListSize()</code> = last record),
    * any values greater than or equal to the total number of wanttoread instances will cause
    * the full set to be returned.
    * @return a collection of Wanttoread objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Wanttoread> getWanttoreadList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of wanttoread objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getWanttoreadListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified wanttoreadId field.
     *
     * @param wanttoreadId the field
     * @return List of Wanttoread data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Wanttoread> findWanttoreadByWanttoreadId(java.lang.Integer wanttoreadId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     *
     * @param bookId the field
     * @return List of Wanttoread data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Wanttoread> findWanttoreadByBookId(java.lang.Integer bookId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Wanttoread data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Wanttoread> findWanttoreadByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;


}
