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
 * The <code>CommentService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class CommentService implements ICommentService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(CommentService.class);


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
    * Adds a new comment to the database.
    *
    * @param model a data object
    * @return Comment a data object with the primary key
    */
   public sust.bookshelves.entity.Comment addComment(sust.bookshelves.entity.Comment model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getComment(model.getPrimaryKey());
      } finally {
         log.debug("finished addComment(sust.bookshelves.entity.Comment model)");
      }
   }

   /**
    * Stores the <code>Comment</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveComment(sust.bookshelves.entity.Comment model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveComment(sust.bookshelves.entity.Comment model)");
      }
   }

   /**
    * Removes a comment.
    *
    * @param id the unique reference for the comment
    */
   public void deleteComment(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Comment bean = (Comment) hibernateTemplate.get(Comment.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteComment(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Comment the data object
    */
   public sust.bookshelves.entity.Comment getComment(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Comment bean = (Comment) hibernateTemplate.get(Comment.class, id);
      return bean;
      } finally {
         log.debug("finished getComment(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all comment instances.
    *
    * @return a list of Comment objects.
    */
   public List getCommentList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Comment.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.commentId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getCommentList");
      }
   }

   /**
    * Returns a subset of all comment instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of comment instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getCommentListSize()</code> = last record),
    * any values greater than or equal to the total number of comment instances will cause
    * the full set to be returned.
    * @return a list of Comment objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getCommentList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Comment.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.commentId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getCommentList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of comment objects in the database.
    *
    * @return an integer value.
    */
   public int getCommentListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Comment.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getCommentListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified commentId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param commentId the field
     * @return List of Comment data objects, empty list in case no results were found.
     */
    public java.util.List findCommentByCommentId(java.lang.Integer commentId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Comment.class.getName() + " e where e.commentId like :commentId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.commentId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "commentId", commentId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findCommentByCommentId(java.lang.Integer commentId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified description field.
     * To use a wildcard search, use a % in the query.
     *
     * @param description the field
     * @return List of Comment data objects, empty list in case no results were found.
     */
    public java.util.List findCommentByDescription(java.lang.String description) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Comment.class.getName() + " e where e.description like :description ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.commentId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "description", description);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findCommentByDescription(java.lang.String description)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of Comment data objects, empty list in case no results were found.
     */
    public java.util.List findCommentByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Comment.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.commentId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findCommentByUserId(java.lang.Integer userId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified statusId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param statusId the field
     * @return List of Comment data objects, empty list in case no results were found.
     */
    public java.util.List findCommentByStatusId(java.lang.Integer statusId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Comment.class.getName() + " e where e.statusId like :statusId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.commentId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "statusId", statusId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findCommentByStatusId(java.lang.Integer statusId)");
      }
    }


}
