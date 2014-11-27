package sust.bookshelves.session;

/**
 * The <code>UserServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IUserService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new user to the storage.
    *
    * @param model a data object
    * @return User a data object with the primary key
    */
   sust.bookshelves.entity.User addUser(sust.bookshelves.entity.User model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>User</code>.
    *
    * @param model the data model to store
    */
   void saveUser(sust.bookshelves.entity.User model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a user.
    *
    * @param id the unique reference for the user
    */
   void deleteUser(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return User the data object
    */
   sust.bookshelves.entity.User getUser(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all user instances.
    *
    * @return a list of User objects.
    */
   java.util.List<sust.bookshelves.entity.User> getUserList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all user instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of user instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserListSize()</code> = last record),
    * any values greater than or equal to the total number of user instances will cause
    * the full set to be returned.
    * @return a collection of User objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.User> getUserList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of user objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getUserListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.User> findUserByUserId(java.lang.Integer userId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified username field.
     *
     * @param username the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.User> findUserByUsername(java.lang.String username) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified fname field.
     *
     * @param fname the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.User> findUserByFname(java.lang.String fname) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified lname field.
     *
     * @param lname the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.User> findUserByLname(java.lang.String lname) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified country field.
     *
     * @param country the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.User> findUserByCountry(java.lang.String country) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified address field.
     *
     * @param address the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.User> findUserByAddress(java.lang.String address) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified email field.
     *
     * @param email the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.User> findUserByEmail(java.lang.String email) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified photo field.
     *
     * @param photo the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.User> findUserByPhoto(java.lang.String photo) throws sust.bookshelves.exception.GenericBusinessException;


}
