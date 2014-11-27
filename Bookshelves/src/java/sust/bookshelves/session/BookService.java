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
 * The <code>BookService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class BookService implements IBookService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(BookService.class);


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
    * Adds a new book to the database.
    *
    * @param model a data object
    * @return Book a data object with the primary key
    */
   public sust.bookshelves.entity.Book addBook(sust.bookshelves.entity.Book model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getBook(model.getPrimaryKey());
      } finally {
         log.debug("finished addBook(sust.bookshelves.entity.Book model)");
      }
   }

   /**
    * Stores the <code>Book</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveBook(sust.bookshelves.entity.Book model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveBook(sust.bookshelves.entity.Book model)");
      }
   }

   /**
    * Removes a book.
    *
    * @param id the unique reference for the book
    */
   public void deleteBook(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Book bean = (Book) hibernateTemplate.get(Book.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteBook(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Book the data object
    */
   public sust.bookshelves.entity.Book getBook(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Book bean = (Book) hibernateTemplate.get(Book.class, id);
      return bean;
      } finally {
         log.debug("finished getBook(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all book instances.
    *
    * @return a list of Book objects.
    */
   public List getBookList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Book.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.bookId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getBookList");
      }
   }

   /**
    * Returns a subset of all book instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of book instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getBookListSize()</code> = last record),
    * any values greater than or equal to the total number of book instances will cause
    * the full set to be returned.
    * @return a list of Book objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getBookList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Book.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.bookId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getBookList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of book objects in the database.
    *
    * @return an integer value.
    */
   public int getBookListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Book.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getBookListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param bookId the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    public java.util.List findBookByBookId(java.lang.Integer bookId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Book.class.getName() + " e where e.bookId like :bookId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.bookId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "bookId", bookId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findBookByBookId(java.lang.Integer bookId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified description field.
     * To use a wildcard search, use a % in the query.
     *
     * @param description the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    public java.util.List findBookByDescription(java.lang.String description) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Book.class.getName() + " e where e.description like :description ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.bookId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "description", description);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findBookByDescription(java.lang.String description)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified year field.
     * To use a wildcard search, use a % in the query.
     *
     * @param year the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    public java.util.List findBookByYear(java.lang.Integer year) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Book.class.getName() + " e where e.year like :year ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.bookId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "year", year);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findBookByYear(java.lang.Integer year)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified title field.
     * To use a wildcard search, use a % in the query.
     *
     * @param title the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    public java.util.List findBookByTitle(java.lang.String title) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Book.class.getName() + " e where e.title like :title ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.bookId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "title", title);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findBookByTitle(java.lang.String title)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified authorId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param authorId the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    public java.util.List findBookByAuthorId(java.lang.Integer authorId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Book.class.getName() + " e where e.authorId like :authorId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.bookId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "authorId", authorId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findBookByAuthorId(java.lang.Integer authorId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified catagoryId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param catagoryId the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    public java.util.List findBookByCatagoryId(java.lang.Integer catagoryId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Book.class.getName() + " e where e.catagoryId like :catagoryId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.bookId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "catagoryId", catagoryId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findBookByCatagoryId(java.lang.Integer catagoryId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified publisherId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param publisherId the field
     * @return List of Book data objects, empty list in case no results were found.
     */
    public java.util.List findBookByPublisherId(java.lang.Integer publisherId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Book.class.getName() + " e where e.publisherId like :publisherId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.bookId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "publisherId", publisherId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findBookByPublisherId(java.lang.Integer publisherId)");
      }
    }


}
