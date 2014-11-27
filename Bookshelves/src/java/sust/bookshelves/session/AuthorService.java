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
 * The <code>AuthorService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class AuthorService implements IAuthorService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(AuthorService.class);


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
    * Adds a new author to the database.
    *
    * @param model a data object
    * @return Author a data object with the primary key
    */
   public sust.bookshelves.entity.Author addAuthor(sust.bookshelves.entity.Author model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getAuthor(model.getPrimaryKey());
      } finally {
         log.debug("finished addAuthor(sust.bookshelves.entity.Author model)");
      }
   }

   /**
    * Stores the <code>Author</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveAuthor(sust.bookshelves.entity.Author model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveAuthor(sust.bookshelves.entity.Author model)");
      }
   }

   /**
    * Removes a author.
    *
    * @param id the unique reference for the author
    */
   public void deleteAuthor(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Author bean = (Author) hibernateTemplate.get(Author.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteAuthor(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Author the data object
    */
   public sust.bookshelves.entity.Author getAuthor(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Author bean = (Author) hibernateTemplate.get(Author.class, id);
      return bean;
      } finally {
         log.debug("finished getAuthor(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all author instances.
    *
    * @return a list of Author objects.
    */
   public List getAuthorList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Author.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.authorId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getAuthorList");
      }
   }

   /**
    * Returns a subset of all author instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of author instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getAuthorListSize()</code> = last record),
    * any values greater than or equal to the total number of author instances will cause
    * the full set to be returned.
    * @return a list of Author objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getAuthorList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Author.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.authorId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getAuthorList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of author objects in the database.
    *
    * @return an integer value.
    */
   public int getAuthorListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Author.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getAuthorListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified authorId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param authorId the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    public java.util.List findAuthorByAuthorId(java.lang.Integer authorId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Author.class.getName() + " e where e.authorId like :authorId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.authorId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "authorId", authorId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findAuthorByAuthorId(java.lang.Integer authorId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified fname field.
     * To use a wildcard search, use a % in the query.
     *
     * @param fname the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    public java.util.List findAuthorByFname(java.lang.String fname) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Author.class.getName() + " e where e.fname like :fname ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.authorId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "fname", fname);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findAuthorByFname(java.lang.String fname)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified lname field.
     * To use a wildcard search, use a % in the query.
     *
     * @param lname the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    public java.util.List findAuthorByLname(java.lang.String lname) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Author.class.getName() + " e where e.lname like :lname ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.authorId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "lname", lname);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findAuthorByLname(java.lang.String lname)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified dob field.
     * To use a wildcard search, use a % in the query.
     *
     * @param dob the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    public java.util.List findAuthorByDob(java.sql.Date dob) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Author.class.getName() + " e where e.dob like :dob ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.authorId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "dob", dob);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findAuthorByDob(java.sql.Date dob)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified dod field.
     * To use a wildcard search, use a % in the query.
     *
     * @param dod the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    public java.util.List findAuthorByDod(java.sql.Date dod) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Author.class.getName() + " e where e.dod like :dod ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.authorId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "dod", dod);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findAuthorByDod(java.sql.Date dod)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified country field.
     * To use a wildcard search, use a % in the query.
     *
     * @param country the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    public java.util.List findAuthorByCountry(java.lang.String country) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Author.class.getName() + " e where e.country like :country ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.authorId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "country", country);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findAuthorByCountry(java.lang.String country)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified description field.
     * To use a wildcard search, use a % in the query.
     *
     * @param description the field
     * @return List of Author data objects, empty list in case no results were found.
     */
    public java.util.List findAuthorByDescription(java.lang.String description) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Author.class.getName() + " e where e.description like :description ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.authorId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "description", description);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findAuthorByDescription(java.lang.String description)");
      }
    }


}
