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
 * The <code>RatingService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class RatingService implements IRatingService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(RatingService.class);


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
    * Adds a new rating to the database.
    *
    * @param model a data object
    * @return Rating a data object with the primary key
    */
   public sust.bookshelves.entity.Rating addRating(sust.bookshelves.entity.Rating model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getRating(model.getPrimaryKey());
      } finally {
         log.debug("finished addRating(sust.bookshelves.entity.Rating model)");
      }
   }

   /**
    * Stores the <code>Rating</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveRating(sust.bookshelves.entity.Rating model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveRating(sust.bookshelves.entity.Rating model)");
      }
   }

   /**
    * Removes a rating.
    *
    * @param id the unique reference for the rating
    */
   public void deleteRating(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Rating bean = (Rating) hibernateTemplate.get(Rating.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteRating(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Rating the data object
    */
   public sust.bookshelves.entity.Rating getRating(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Rating bean = (Rating) hibernateTemplate.get(Rating.class, id);
      return bean;
      } finally {
         log.debug("finished getRating(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all rating instances.
    *
    * @return a list of Rating objects.
    */
   public List getRatingList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Rating.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.ratingId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getRatingList");
      }
   }

   /**
    * Returns a subset of all rating instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of rating instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getRatingListSize()</code> = last record),
    * any values greater than or equal to the total number of rating instances will cause
    * the full set to be returned.
    * @return a list of Rating objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getRatingList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Rating.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.ratingId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getRatingList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of rating objects in the database.
    *
    * @return an integer value.
    */
   public int getRatingListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Rating.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getRatingListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified ratingId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param ratingId the field
     * @return List of Rating data objects, empty list in case no results were found.
     */
    public java.util.List findRatingByRatingId(java.lang.Integer ratingId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Rating.class.getName() + " e where e.ratingId like :ratingId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.ratingId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "ratingId", ratingId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRatingByRatingId(java.lang.Integer ratingId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified counter field.
     * To use a wildcard search, use a % in the query.
     *
     * @param counter the field
     * @return List of Rating data objects, empty list in case no results were found.
     */
    public java.util.List findRatingByCounter(java.lang.Integer counter) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Rating.class.getName() + " e where e.counter like :counter ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.ratingId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "counter", counter);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRatingByCounter(java.lang.Integer counter)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified currentrating field.
     * To use a wildcard search, use a % in the query.
     *
     * @param currentrating the field
     * @return List of Rating data objects, empty list in case no results were found.
     */
    public java.util.List findRatingByCurrentrating(java.lang.Double currentrating) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Rating.class.getName() + " e where e.currentrating like :currentrating ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.ratingId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "currentrating", currentrating);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRatingByCurrentrating(java.lang.Double currentrating)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param bookId the field
     * @return List of Rating data objects, empty list in case no results were found.
     */
    public java.util.List findRatingByBookId(java.lang.Integer bookId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Rating.class.getName() + " e where e.bookId like :bookId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.ratingId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "bookId", bookId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRatingByBookId(java.lang.Integer bookId)");
      }
    }


}
