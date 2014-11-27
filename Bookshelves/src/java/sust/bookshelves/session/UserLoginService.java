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
 * The <code>UserLoginService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class UserLoginService implements IUserLoginService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(UserLoginService.class);


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
    * Adds a new userlogin to the database.
    *
    * @param model a data object
    * @return Userlogin a data object with the primary key
    */
   public sust.bookshelves.entity.Userlogin addUserlogin(sust.bookshelves.entity.Userlogin model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getUserlogin(model.getPrimaryKey());
      } finally {
         log.debug("finished addUserlogin(sust.bookshelves.entity.Userlogin model)");
      }
   }

   /**
    * Stores the <code>Userlogin</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveUserlogin(sust.bookshelves.entity.Userlogin model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveUserlogin(sust.bookshelves.entity.Userlogin model)");
      }
   }

   /**
    * Removes a userlogin.
    *
    * @param id the unique reference for the userlogin
    */
   public void deleteUserlogin(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Userlogin bean = (Userlogin) hibernateTemplate.get(Userlogin.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteUserlogin(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Userlogin the data object
    */
   public sust.bookshelves.entity.Userlogin getUserlogin(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Userlogin bean = (Userlogin) hibernateTemplate.get(Userlogin.class, id);
      return bean;
      } finally {
         log.debug("finished getUserlogin(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all userlogin instances.
    *
    * @return a list of Userlogin objects.
    */
   public List getUserloginList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Userlogin.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.userloginId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getUserloginList");
      }
   }

   /**
    * Returns a subset of all userlogin instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of userlogin instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserloginListSize()</code> = last record),
    * any values greater than or equal to the total number of userlogin instances will cause
    * the full set to be returned.
    * @return a list of Userlogin objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getUserloginList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Userlogin.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userloginId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getUserloginList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of userlogin objects in the database.
    *
    * @return an integer value.
    */
   public int getUserloginListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Userlogin.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getUserloginListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified userloginId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userloginId the field
     * @return List of Userlogin data objects, empty list in case no results were found.
     */
    public java.util.List findUserloginByUserloginId(java.lang.Integer userloginId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Userlogin.class.getName() + " e where e.userloginId like :userloginId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userloginId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userloginId", userloginId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserloginByUserloginId(java.lang.Integer userloginId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified password field.
     * To use a wildcard search, use a % in the query.
     *
     * @param password the field
     * @return List of Userlogin data objects, empty list in case no results were found.
     */
    public java.util.List findUserloginByPassword(java.lang.String password) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Userlogin.class.getName() + " e where e.password like :password ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userloginId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "password", password);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserloginByPassword(java.lang.String password)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of Userlogin data objects, empty list in case no results were found.
     */
    public java.util.List findUserloginByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Userlogin.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userloginId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserloginByUserId(java.lang.Integer userId)");
      }
    }


}
