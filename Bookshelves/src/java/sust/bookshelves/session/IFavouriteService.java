package sust.bookshelves.session;

/**
 * The <code>FavouriteServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IFavouriteService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new favourite to the storage.
    *
    * @param model a data object
    * @return Favourite a data object with the primary key
    */
   sust.bookshelves.entity.Favourite addFavourite(sust.bookshelves.entity.Favourite model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Favourite</code>.
    *
    * @param model the data model to store
    */
   void saveFavourite(sust.bookshelves.entity.Favourite model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a favourite.
    *
    * @param id the unique reference for the favourite
    */
   void deleteFavourite(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Favourite the data object
    */
   sust.bookshelves.entity.Favourite getFavourite(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all favourite instances.
    *
    * @return a list of Favourite objects.
    */
   java.util.List<sust.bookshelves.entity.Favourite> getFavouriteList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all favourite instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of favourite instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getFavouriteListSize()</code> = last record),
    * any values greater than or equal to the total number of favourite instances will cause
    * the full set to be returned.
    * @return a collection of Favourite objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Favourite> getFavouriteList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of favourite objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getFavouriteListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified favouriteId field.
     *
     * @param favouriteId the field
     * @return List of Favourite data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Favourite> findFavouriteByFavouriteId(java.lang.Integer favouriteId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     *
     * @param bookId the field
     * @return List of Favourite data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Favourite> findFavouriteByBookId(java.lang.Integer bookId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Favourite data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Favourite> findFavouriteByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;


}
