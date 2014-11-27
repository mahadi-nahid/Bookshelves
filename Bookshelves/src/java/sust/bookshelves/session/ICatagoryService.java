package sust.bookshelves.session;

/**
 * The <code>CatagoryServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface ICatagoryService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new catagory to the storage.
    *
    * @param model a data object
    * @return Catagory a data object with the primary key
    */
   sust.bookshelves.entity.Catagory addCatagory(sust.bookshelves.entity.Catagory model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Catagory</code>.
    *
    * @param model the data model to store
    */
   void saveCatagory(sust.bookshelves.entity.Catagory model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a catagory.
    *
    * @param id the unique reference for the catagory
    */
   void deleteCatagory(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Catagory the data object
    */
   sust.bookshelves.entity.Catagory getCatagory(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all catagory instances.
    *
    * @return a list of Catagory objects.
    */
   java.util.List<sust.bookshelves.entity.Catagory> getCatagoryList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all catagory instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of catagory instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getCatagoryListSize()</code> = last record),
    * any values greater than or equal to the total number of catagory instances will cause
    * the full set to be returned.
    * @return a collection of Catagory objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Catagory> getCatagoryList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of catagory objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getCatagoryListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified catagoryId field.
     *
     * @param catagoryId the field
     * @return List of Catagory data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Catagory> findCatagoryByCatagoryId(java.lang.Integer catagoryId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified catagoryname field.
     *
     * @param catagoryname the field
     * @return List of Catagory data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Catagory> findCatagoryByCatagoryname(java.lang.String catagoryname) throws sust.bookshelves.exception.GenericBusinessException;


}
