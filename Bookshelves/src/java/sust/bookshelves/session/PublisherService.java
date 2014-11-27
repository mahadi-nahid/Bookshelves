package sust.bookshelves.session;

import java.util.*;
import sust.bookshelves.*;
import sust.bookshelves.servicelocator.LocatableService;
import com.finalist.util.log.*;
import sust.bookshelves.exception.GenericBusinessException;
//import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.finalist.util.log.*;
import sust.bookshelves.entity.*;

/**
 * The <code>PublisherService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class PublisherService implements IPublisherService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(PublisherService.class);


   /**
    * Default implementation for the Locatable Service interface.
    */
    public void init() {
    }

   /**
    * Default implementation for the Locatable Service interface.
    */
    public void destroy() {
    }

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/



   /**
    * Adds a new publisher to the database.
    *
    * @param model a data object
    * @return Publisher a data object with the primary key
    */
   public sust.bookshelves.entity.Publisher addPublisher(sust.bookshelves.entity.Publisher model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getPublisher(model.getPrimaryKey());
      } finally {
         log.debug("finished addPublisher(sust.bookshelves.entity.Publisher model)");
      }
   }

   /**
    * Stores the <code>Publisher</code> in the database.
    *
    * @param model the data model to store
    */
   public void savePublisher(sust.bookshelves.entity.Publisher model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished savePublisher(sust.bookshelves.entity.Publisher model)");
      }
   }

   /**
    * Removes a publisher.
    *
    * @param id the unique reference for the publisher
    */
   public void deletePublisher(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Publisher bean = (Publisher) hibernateTemplate.get(Publisher.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deletePublisher(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Publisher the data object
    */
   public sust.bookshelves.entity.Publisher getPublisher(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Publisher bean = (Publisher) hibernateTemplate.get(Publisher.class, id);
      return bean;
      } finally {
         log.debug("finished getPublisher(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all publisher instances.
    *
    * @return a list of Publisher objects.
    */
   public List getPublisherList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Publisher.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.publisherId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getPublisherList");
      }
   }

   /**
    * Returns a subset of all publisher instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of publisher instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getPublisherListSize()</code> = last record),
    * any values greater than or equal to the total number of publisher instances will cause
    * the full set to be returned.
    * @return a list of Publisher objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getPublisherList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Publisher.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.publisherId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getPublisherList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of publisher objects in the database.
    *
    * @return an integer value.
    */
   public int getPublisherListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Publisher.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getPublisherListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified publisherId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param publisherId the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    public java.util.List findPublisherByPublisherId(java.lang.Integer publisherId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Publisher.class.getName() + " e where e.publisherId like :publisherId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.publisherId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "publisherId", publisherId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPublisherByPublisherId(java.lang.Integer publisherId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified publishername field.
     * To use a wildcard search, use a % in the query.
     *
     * @param publishername the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    public java.util.List findPublisherByPublishername(java.lang.String publishername) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Publisher.class.getName() + " e where e.publishername like :publishername ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.publisherId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "publishername", publishername);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPublisherByPublishername(java.lang.String publishername)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified country field.
     * To use a wildcard search, use a % in the query.
     *
     * @param country the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    public java.util.List findPublisherByCountry(java.lang.String country) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Publisher.class.getName() + " e where e.country like :country ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.publisherId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "country", country);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPublisherByCountry(java.lang.String country)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified address field.
     * To use a wildcard search, use a % in the query.
     *
     * @param address the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    public java.util.List findPublisherByAddress(java.lang.String address) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Publisher.class.getName() + " e where e.address like :address ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.publisherId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "address", address);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPublisherByAddress(java.lang.String address)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified contactinfo field.
     * To use a wildcard search, use a % in the query.
     *
     * @param contactinfo the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    public java.util.List findPublisherByContactinfo(java.lang.String contactinfo) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Publisher.class.getName() + " e where e.contactinfo like :contactinfo ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.publisherId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "contactinfo", contactinfo);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPublisherByContactinfo(java.lang.String contactinfo)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified description field.
     * To use a wildcard search, use a % in the query.
     *
     * @param description the field
     * @return List of Publisher data objects, empty list in case no results were found.
     */
    public java.util.List findPublisherByDescription(java.lang.String description) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Publisher.class.getName() + " e where e.description like :description ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.publisherId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "description", description);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPublisherByDescription(java.lang.String description)");
      }
    }


}
