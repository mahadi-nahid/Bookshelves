package sust.bookshelves.session;

/**
 * The <code>PublisherServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IPublisherService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new publisher to the storage.
    *
    * @param model a data object
    * @return Publisher a data object with the primary key
    */
   sust.bookshelves.entity.Publisher addPublisher(sust.bookshelves.entity.Publisher model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Stores the <code>Publisher</code>.
    *
    * @param model the data model to store
    */
   void savePublisher(sust.bookshelves.entity.Publisher model) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Removes a publisher.
    *
    * @param id the unique reference for the publisher
    */
   void deletePublisher(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Publisher the data object
    */
   sust.bookshelves.entity.Publisher getPublisher(java.lang.Integer id) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a list of all publisher instances.
    *
    * @return a list of Publisher objects.
    */
   java.util.List<sust.bookshelves.entity.Publisher> getPublisherList() throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Returns a subset of all publisher instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of publisher instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getPublisherListSize()</code> = last record),
    * any values greater than or equal to the total number of publisher instances will cause
    * the full set to be returned.
    * @return a collection of Publisher objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.bookshelves.entity.Publisher> getPublisherList(int startIndex, int endIndex) throws sust.bookshelves.exception.GenericBusinessException;

   /**
    * Obtains the total number of publisher objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getPublisherListSize() throws sust.bookshelves.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified publisherId field.
     *
     * @param publisherId the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Publisher> findPublisherByPublisherId(java.lang.Integer publisherId) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified publishername field.
     *
     * @param publishername the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Publisher> findPublisherByPublishername(java.lang.String publishername) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified country field.
     *
     * @param country the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Publisher> findPublisherByCountry(java.lang.String country) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified address field.
     *
     * @param address the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Publisher> findPublisherByAddress(java.lang.String address) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified contactinfo field.
     *
     * @param contactinfo the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Publisher> findPublisherByContactinfo(java.lang.String contactinfo) throws sust.bookshelves.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    java.util.List<sust.bookshelves.entity.Publisher> findPublisherByDescription(java.lang.String description) throws sust.bookshelves.exception.GenericBusinessException;


}
