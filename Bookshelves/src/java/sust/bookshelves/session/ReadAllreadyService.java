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
 * The <code>ReadAllreadyService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class ReadAllreadyService implements IReadAllreadyService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(ReadAllreadyService.class);


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
    * Adds a new readallready to the database.
    *
    * @param model a data object
    * @return Readallready a data object with the primary key
    */
   public sust.bookshelves.entity.Readallready addReadallready(sust.bookshelves.entity.Readallready model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getReadallready(model.getPrimaryKey());
      } finally {
         log.debug("finished addReadallready(sust.bookshelves.entity.Readallready model)");
      }
   }

   /**
    * Stores the <code>Readallready</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveReadallready(sust.bookshelves.entity.Readallready model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveReadallready(sust.bookshelves.entity.Readallready model)");
      }
   }

   /**
    * Removes a readallready.
    *
    * @param id the unique reference for the readallready
    */
   public void deleteReadallready(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Readallready bean = (Readallready) hibernateTemplate.get(Readallready.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteReadallready(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Readallready the data object
    */
   public sust.bookshelves.entity.Readallready getReadallready(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Readallready bean = (Readallready) hibernateTemplate.get(Readallready.class, id);
      return bean;
      } finally {
         log.debug("finished getReadallready(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all readallready instances.
    *
    * @return a list of Readallready objects.
    */
   public List getReadallreadyList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Readallready.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.readId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getReadallreadyList");
      }
   }

   /**
    * Returns a subset of all readallready instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of readallready instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getReadallreadyListSize()</code> = last record),
    * any values greater than or equal to the total number of readallready instances will cause
    * the full set to be returned.
    * @return a list of Readallready objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getReadallreadyList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Readallready.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.readId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getReadallreadyList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of readallready objects in the database.
    *
    * @return an integer value.
    */
   public int getReadallreadyListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Readallready.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getReadallreadyListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified readId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param readId the field
     * @return List of Readallready data objects, empty list in case no results were found.
     */
    public java.util.List findReadallreadyByReadId(java.lang.Integer readId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Readallready.class.getName() + " e where e.readId like :readId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.readId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "readId", readId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findReadallreadyByReadId(java.lang.Integer readId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param bookId the field
     * @return List of Readallready data objects, empty list in case no results were found.
     */
    public java.util.List findReadallreadyByBookId(java.lang.Integer bookId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Readallready.class.getName() + " e where e.bookId like :bookId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.readId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "bookId", bookId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findReadallreadyByBookId(java.lang.Integer bookId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of Readallready data objects, empty list in case no results were found.
     */
    public java.util.List findReadallreadyByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Readallready.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.readId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findReadallreadyByUserId(java.lang.Integer userId)");
      }
    }


}
