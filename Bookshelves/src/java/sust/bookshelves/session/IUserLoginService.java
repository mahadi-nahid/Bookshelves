package sust.bookshelves.session;

/**
 * The <code>UserLoginServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IUserLoginService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new userlogin to the storage.
    *
    * @param model a data object
    * @return Userlogin a data object with the primary key
    */
   sust.bookshelves.entity.Userlogin addUserlogin(sust.bookshelves.entity.Userlogin model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Userlogin</code>.
    *
    * @param model the data model to store
    */
   void saveUserlogin(sust.bookshelves.entity.Userlogin model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a userlogin.
    *
    * @param id the unique reference for the userlogin
    */
   void deleteUserlogin(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Userlogin the data object
    */
   sust.bookshelves.entity.Userlogin getUserlogin(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all userlogin instances.
    *
    * @return a list of Userlogin objects.
    */
   java.util.List<sust.bookshelves.entity.Userlogin> getUserloginList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all userlogin instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of userlogin instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserloginListSize()</code> = last record),
    * any values greater than or equal to the total number of userlogin instances will cause
    * the full set to be returned.
    * @return a collection of Userlogin objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Userlogin> getUserloginList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of userlogin objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getUserloginListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified userloginId field.
     *
     * @param userloginId the field
     * @return List of Userlogin data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Userlogin> findUserloginByUserloginId(java.lang.Integer userloginId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified password field.
     *
     * @param password the field
     * @return List of Userlogin data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Userlogin> findUserloginByPassword(java.lang.String password) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of Userlogin data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Userlogin> findUserloginByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;


}
