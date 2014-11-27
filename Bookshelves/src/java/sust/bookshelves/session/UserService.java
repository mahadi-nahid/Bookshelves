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
 * The <code>UserService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class UserService implements IUserService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(UserService.class);


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
    * Adds a new user to the database.
    *
    * @param model a data object
    * @return User a data object with the primary key
    */
   public sust.bookshelves.entity.User addUser(sust.bookshelves.entity.User model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getUser(model.getPrimaryKey());
      } finally {
         log.debug("finished addUser(sust.bookshelves.entity.User model)");
      }
   }

   /**
    * Stores the <code>User</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveUser(sust.bookshelves.entity.User model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveUser(sust.bookshelves.entity.User model)");
      }
   }

   /**
    * Removes a user.
    *
    * @param id the unique reference for the user
    */
   public void deleteUser(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         User bean = (User) hibernateTemplate.get(User.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteUser(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return User the data object
    */
   public sust.bookshelves.entity.User getUser(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      User bean = (User) hibernateTemplate.get(User.class, id);
      return bean;
      } finally {
         log.debug("finished getUser(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all user instances.
    *
    * @return a list of User objects.
    */
   public List getUserList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + User.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.userId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getUserList");
      }
   }

   /**
    * Returns a subset of all user instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of user instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserListSize()</code> = last record),
    * any values greater than or equal to the total number of user instances will cause
    * the full set to be returned.
    * @return a list of User objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getUserList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getUserList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of user objects in the database.
    *
    * @return an integer value.
    */
   public int getUserListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + User.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getUserListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByUserId(java.lang.Integer userId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified username field.
     * To use a wildcard search, use a % in the query.
     *
     * @param username the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByUsername(java.lang.String username) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.username like :username ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "username", username);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByUsername(java.lang.String username)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified fname field.
     * To use a wildcard search, use a % in the query.
     *
     * @param fname the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByFname(java.lang.String fname) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.fname like :fname ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "fname", fname);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByFname(java.lang.String fname)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified lname field.
     * To use a wildcard search, use a % in the query.
     *
     * @param lname the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByLname(java.lang.String lname) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.lname like :lname ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "lname", lname);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByLname(java.lang.String lname)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified country field.
     * To use a wildcard search, use a % in the query.
     *
     * @param country the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByCountry(java.lang.String country) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.country like :country ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "country", country);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByCountry(java.lang.String country)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified address field.
     * To use a wildcard search, use a % in the query.
     *
     * @param address the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByAddress(java.lang.String address) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.address like :address ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "address", address);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByAddress(java.lang.String address)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified email field.
     * To use a wildcard search, use a % in the query.
     *
     * @param email the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByEmail(java.lang.String email) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.email like :email ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "email", email);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByEmail(java.lang.String email)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified photo field.
     * To use a wildcard search, use a % in the query.
     *
     * @param photo the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByPhoto(java.lang.String photo) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.photo like :photo ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.userId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "photo", photo);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByPhoto(java.lang.String photo)");
      }
    }


}
