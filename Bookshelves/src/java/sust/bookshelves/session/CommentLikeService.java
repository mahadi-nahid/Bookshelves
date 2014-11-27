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
 * The <code>CommentLikeService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class CommentLikeService implements ICommentLikeService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(CommentLikeService.class);


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
    * Adds a new commentlike to the database.
    *
    * @param model a data object
    * @return Commentlike a data object with the primary key
    */
   public sust.bookshelves.entity.Commentlike addCommentlike(sust.bookshelves.entity.Commentlike model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getCommentlike(model.getPrimaryKey());
      } finally {
         log.debug("finished addCommentlike(sust.bookshelves.entity.Commentlike model)");
      }
   }

   /**
    * Stores the <code>Commentlike</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveCommentlike(sust.bookshelves.entity.Commentlike model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveCommentlike(sust.bookshelves.entity.Commentlike model)");
      }
   }

   /**
    * Removes a commentlike.
    *
    * @param id the unique reference for the commentlike
    */
   public void deleteCommentlike(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Commentlike bean = (Commentlike) hibernateTemplate.get(Commentlike.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteCommentlike(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Commentlike the data object
    */
   public sust.bookshelves.entity.Commentlike getCommentlike(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Commentlike bean = (Commentlike) hibernateTemplate.get(Commentlike.class, id);
      return bean;
      } finally {
         log.debug("finished getCommentlike(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all commentlike instances.
    *
    * @return a list of Commentlike objects.
    */
   public List getCommentlikeList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Commentlike.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.commentlikeId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getCommentlikeList");
      }
   }

   /**
    * Returns a subset of all commentlike instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of commentlike instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getCommentlikeListSize()</code> = last record),
    * any values greater than or equal to the total number of commentlike instances will cause
    * the full set to be returned.
    * @return a list of Commentlike objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getCommentlikeList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Commentlike.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.commentlikeId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getCommentlikeList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of commentlike objects in the database.
    *
    * @return an integer value.
    */
   public int getCommentlikeListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Commentlike.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getCommentlikeListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified commentlikeId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param commentlikeId the field
     * @return List of Commentlike data objects, empty list in case no results were found.
     */
    public java.util.List findCommentlikeByCommentlikeId(java.lang.Integer commentlikeId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Commentlike.class.getName() + " e where e.commentlikeId like :commentlikeId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.commentlikeId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "commentlikeId", commentlikeId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findCommentlikeByCommentlikeId(java.lang.Integer commentlikeId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of Commentlike data objects, empty list in case no results were found.
     */
    public java.util.List findCommentlikeByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Commentlike.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.commentlikeId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findCommentlikeByUserId(java.lang.Integer userId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified commentId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param commentId the field
     * @return List of Commentlike data objects, empty list in case no results were found.
     */
    public java.util.List findCommentlikeByCommentId(java.lang.Integer commentId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Commentlike.class.getName() + " e where e.commentId like :commentId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.commentlikeId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "commentId", commentId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findCommentlikeByCommentId(java.lang.Integer commentId)");
      }
    }


}
