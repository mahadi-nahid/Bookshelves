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
 * The <code>CatagoryService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class CatagoryService implements ICatagoryService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(CatagoryService.class);


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
    * Adds a new catagory to the database.
    *
    * @param model a data object
    * @return Catagory a data object with the primary key
    */
   public sust.bookshelves.entity.Catagory addCatagory(sust.bookshelves.entity.Catagory model) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getCatagory(model.getPrimaryKey());
      } finally {
         log.debug("finished addCatagory(sust.bookshelves.entity.Catagory model)");
      }
   }

   /**
    * Stores the <code>Catagory</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveCatagory(sust.bookshelves.entity.Catagory model) throws GenericBusinessException {
      // We have to create an object:
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveCatagory(sust.bookshelves.entity.Catagory model)");
      }
   }

   /**
    * Removes a catagory.
    *
    * @param id the unique reference for the catagory
    */
   public void deleteCatagory(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Catagory bean = (Catagory) hibernateTemplate.get(Catagory.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteCatagory(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Catagory the data object
    */
   public sust.bookshelves.entity.Catagory getCatagory(java.lang.Integer id) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
      Catagory bean = (Catagory) hibernateTemplate.get(Catagory.class, id);
      return bean;
      } finally {
         log.debug("finished getCatagory(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all catagory instances.
    *
    * @return a list of Catagory objects.
    */
   public List getCatagoryList() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Catagory.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.catagoryId";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getCatagoryList");
      }
   }

   /**
    * Returns a subset of all catagory instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of catagory instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getCatagoryListSize()</code> = last record),
    * any values greater than or equal to the total number of catagory instances will cause
    * the full set to be returned.
    * @return a list of Catagory objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getCatagoryList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Catagory.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.catagoryId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getCatagoryList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of catagory objects in the database.
    *
    * @return an integer value.
    */
   public int getCatagoryListSize() throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Catagory.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getCatagoryListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified catagoryId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param catagoryId the field
     * @return List of Catagory data objects, empty list in case no results were found.
     */
    public java.util.List findCatagoryByCatagoryId(java.lang.Integer catagoryId) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Catagory.class.getName() + " e where e.catagoryId like :catagoryId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.catagoryId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "catagoryId", catagoryId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findCatagoryByCatagoryId(java.lang.Integer catagoryId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified catagoryname field.
     * To use a wildcard search, use a % in the query.
     *
     * @param catagoryname the field
     * @return List of Catagory data objects, empty list in case no results were found.
     */
    public java.util.List findCatagoryByCatagoryname(java.lang.String catagoryname) throws GenericBusinessException {
      sust.bookshelves.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.bookshelves.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Catagory.class.getName() + " e where e.catagoryname like :catagoryname ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.catagoryId";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "catagoryname", catagoryname);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findCatagoryByCatagoryname(java.lang.String catagoryname)");
      }
    }


}
