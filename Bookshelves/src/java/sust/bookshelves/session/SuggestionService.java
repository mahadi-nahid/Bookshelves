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
 * The <code>SuggestionService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class SuggestionService implements ISuggestionService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(SuggestionService.class);


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
    * Adds a new suggestion to the database.
    *
    * @param model a data object
    * @return Suggestion a data object with the primary key
    */
   public sust.bookshelves.entity.Suggestion addSuggestion(sust.bookshelves.entity.Suggestion model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getSuggestion(model.getPrimaryKey());
      } finally {
         log.debug("finished addSuggestion(sust.bookshelves.entity.Suggestion model)");
      }
   }

   /**
    * Stores the <code>Suggestion</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveSuggestion(sust.bookshelves.entity.Suggestion model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveSuggestion(sust.bookshelves.entity.Suggestion model)");
      }
   }

   /**
    * Removes a suggestion.
    *
    * @param id the unique reference for the suggestion
    */
   public void deleteSuggestion(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Suggestion bean = (Suggestion) hibernateTemplate.get(Suggestion.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteSuggestion(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Suggestion the data object
    */
   public sust.bookshelves.entity.Suggestion getSuggestion(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Suggestion bean = (Suggestion) hibernateTemplate.get(Suggestion.class, id);
      return bean;
      } finally {
         log.debug("finished getSuggestion(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all suggestion instances.
    *
    * @return a list of Suggestion objects.
    */
   public List getSuggestionList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Suggestion.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.suggestionId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getSuggestionList");
      }
   }

   /**
    * Returns a subset of all suggestion instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of suggestion instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getSuggestionListSize()</code> = last record),
    * any values greater than or equal to the total number of suggestion instances will cause
    * the full set to be returned.
    * @return a list of Suggestion objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getSuggestionList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Suggestion.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.suggestionId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getSuggestionList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of suggestion objects in the database.
    *
    * @return an integer value.
    */
   public int getSuggestionListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Suggestion.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getSuggestionListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified suggestionId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param suggestionId the field
     * @return List of Suggestion data objects, empty list in case no results were found.
     */
    public java.util.List findSuggestionBySuggestionId(java.lang.Integer suggestionId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Suggestion.class.getName() + " e where e.suggestionId like :suggestionId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.suggestionId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "suggestionId", suggestionId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findSuggestionBySuggestionId(java.lang.Integer suggestionId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified bookId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param bookId the field
     * @return List of Suggestion data objects, empty list in case no results were found.
     */
    public java.util.List findSuggestionByBookId(java.lang.Integer bookId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Suggestion.class.getName() + " e where e.bookId like :bookId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.suggestionId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "bookId", bookId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findSuggestionByBookId(java.lang.Integer bookId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userUserId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userUserId the field
     * @return List of Suggestion data objects, empty list in case no results were found.
     */
    public java.util.List findSuggestionByUserUserId(java.lang.Integer userUserId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Suggestion.class.getName() + " e where e.userUserId like :userUserId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.suggestionId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userUserId", userUserId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findSuggestionByUserUserId(java.lang.Integer userUserId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of Suggestion data objects, empty list in case no results were found.
     */
    public java.util.List findSuggestionByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Suggestion.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.suggestionId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findSuggestionByUserId(java.lang.Integer userId)");
      }
    }


}
