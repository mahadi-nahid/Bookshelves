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
 * The <code>FavouriteService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class FavouriteService implements IFavouriteService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(FavouriteService.class);


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
    * Adds a new favourite to the database.
    *
    * @param model a data object
    * @return Favourite a data object with the primary key
    */
   public sust.bookshelves.entity.Favourite addFavourite(sust.bookshelves.entity.Favourite model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getFavourite(model.getPrimaryKey());
      } finally {
         log.debug("finished addFavourite(sust.bookshelves.entity.Favourite model)");
      }
   }

   /**
    * Stores the <code>Favourite</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveFavourite(sust.bookshelves.entity.Favourite model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveFavourite(sust.bookshelves.entity.Favourite model)");
      }
   }

   /**
    * Removes a favourite.
    *
    * @param id the unique reference for the favourite
    */
   public void deleteFavourite(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Favourite bean = (Favourite) hibernateTemplate.get(Favourite.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteFavourite(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Favourite the data object
    */
   public sust.bookshelves.entity.Favourite getFavourite(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Favourite bean = (Favourite) hibernateTemplate.get(Favourite.class, id);
      return bean;
      } finally {
         log.debug("finished getFavourite(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all favourite instances.
    *
    * @return a list of Favourite objects.
    */
   public List getFavouriteList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Favourite.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.favouriteId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getFavouriteList");
      }
   }

   /**
    * Returns a subset of all favourite instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of favourite instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getFavouriteListSize()</code> = last record),
    * any values greater than or equal to the total number of favourite instances will cause
    * the full set to be returned.
    * @return a list of Favourite objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getFavouriteList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Favourite.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.favouriteId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getFavouriteList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of favourite objects in the database.
    *
    * @return an integer value.
    */
   public int getFavouriteListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Favourite.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getFavouriteListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified favouriteId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param favouriteId the field
     * @return List of Favourite data objects, empty list in case no results were found.
     */
    public java.util.List findFavouriteByFavouriteId(java.lang.Integer favouriteId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Favourite.class.getName() + " e where e.favouriteId like :favouriteId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.favouriteId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "favouriteId", favouriteId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findFavouriteByFavouriteId(java.lang.Integer favouriteId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param bookId the field
     * @return List of Favourite data objects, empty list in case no results were found.
     */
    public java.util.List findFavouriteByBookId(java.lang.Integer bookId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Favourite.class.getName() + " e where e.bookId like :bookId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.favouriteId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "bookId", bookId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findFavouriteByBookId(java.lang.Integer bookId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of Favourite data objects, empty list in case no results were found.
     */
    public java.util.List findFavouriteByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Favourite.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.favouriteId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findFavouriteByUserId(java.lang.Integer userId)");
      }
    }


}
