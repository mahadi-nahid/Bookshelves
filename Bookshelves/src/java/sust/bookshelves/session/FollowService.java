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
 * The <code>FollowService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class FollowService implements IFollowService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(FollowService.class);


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
    * Adds a new follow to the database.
    *
    * @param model a data object
    * @return Follow a data object with the primary key
    */
   public sust.bookshelves.entity.Follow addFollow(sust.bookshelves.entity.Follow model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getFollow(model.getPrimaryKey());
      } finally {
         log.debug("finished addFollow(sust.bookshelves.entity.Follow model)");
      }
   }

   /**
    * Stores the <code>Follow</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveFollow(sust.bookshelves.entity.Follow model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveFollow(sust.bookshelves.entity.Follow model)");
      }
   }

   /**
    * Removes a follow.
    *
    * @param id the unique reference for the follow
    */
   public void deleteFollow(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Follow bean = (Follow) hibernateTemplate.get(Follow.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteFollow(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Follow the data object
    */
   public sust.bookshelves.entity.Follow getFollow(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Follow bean = (Follow) hibernateTemplate.get(Follow.class, id);
      return bean;
      } finally {
         log.debug("finished getFollow(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all follow instances.
    *
    * @return a list of Follow objects.
    */
   public List getFollowList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Follow.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.followId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getFollowList");
      }
   }

   /**
    * Returns a subset of all follow instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of follow instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getFollowListSize()</code> = last record),
    * any values greater than or equal to the total number of follow instances will cause
    * the full set to be returned.
    * @return a list of Follow objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getFollowList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Follow.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.followId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getFollowList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of follow objects in the database.
    *
    * @return an integer value.
    */
   public int getFollowListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Follow.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getFollowListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified followId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param followId the field
     * @return List of Follow data objects, empty list in case no results were found.
     */
    public java.util.List findFollowByFollowId(java.lang.Integer followId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Follow.class.getName() + " e where e.followId like :followId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.followId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "followId", followId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findFollowByFollowId(java.lang.Integer followId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userUserId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userUserId the field
     * @return List of Follow data objects, empty list in case no results were found.
     */
    public java.util.List findFollowByUserUserId(java.lang.Integer userUserId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Follow.class.getName() + " e where e.userUserId like :userUserId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.followId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userUserId", userUserId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findFollowByUserUserId(java.lang.Integer userUserId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of Follow data objects, empty list in case no results were found.
     */
    public java.util.List findFollowByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Follow.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.followId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findFollowByUserId(java.lang.Integer userId)");
      }
    }


}
