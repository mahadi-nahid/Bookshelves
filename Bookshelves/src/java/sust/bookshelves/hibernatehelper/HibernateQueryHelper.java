package sust.bookshelves.hibernatehelper;

import com.finalist.util.log.*;
import java.sql.*;
import sust.bookshelves.exception.GenericBusinessException;
//import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

/**
 * This class is a Helper for Hibernate queries and crud operations.
 *
 * @author Nahid and Afjal sust
 * @version $Revision: 1.5 $, $Date: 2006/03/18 19:36:13 $
 */
public class HibernateQueryHelper {

    /**
     * The logger
     */
    private static Logger log = LogService.getLogger(HibernateQueryHelper.class);
    private Session session = null;
    Transaction tx = null;

    public Session getSession() {
        return session;
    }

    /**
     * Creates a new instance of QueryHelper
     */
    public HibernateQueryHelper() throws GenericBusinessException {
        try {
            session = HibernateSession.getSession();
            // Start the transaction.
        } catch (Exception e) {
            String message = "Error while getting the hibernate session.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public Object load(Class theClazz, java.io.Serializable id) throws GenericBusinessException {
        try {
            return session.load(theClazz, id);
        } catch (Exception e) {
            String message = "Error while loading the hibernate object.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public Object get(Class theClazz, java.io.Serializable id) throws GenericBusinessException {
        try {
            return session.get(theClazz, id);
        } catch (Exception e) {
            String message = "Error while getting the hibernate object.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public Query createQuery(String queryString) throws GenericBusinessException {
        try {
            return session.createQuery(queryString);
        } catch (Exception e) {
            String message = "Error while getting the hibernate query.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public void setQueryParameter(Query query, String name, Object val) throws GenericBusinessException {
        try {
            query.setParameter(name, val);
        } catch (Exception e) {
            String message = "Error while setting the hibernate query parameter.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public java.util.List list(Query query) throws GenericBusinessException {
        try {
            return query.list();
        } catch (Exception e) {
            String message = "Error while getting the hibernate query list.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public void save(Object o) throws GenericBusinessException {
        try {
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                // In case of an exception, roll back the transaction.
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    log.error("Error while rolling back the transaction.", ex);
                }
            }
            String message = "Error while saving object.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public void update(Object o) throws GenericBusinessException {
        try {
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                // In case of an exception, roll back the transaction.
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    log.error("Error while rolling back the transaction.", ex);
                }
            }
            String message = "Error while saving object.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public void delete(Object o) throws GenericBusinessException {
        try {
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                // In case of an exception, roll back the transaction.
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    log.error("Error while rolling back the transaction.", ex);
                }
            }
            String message = "Error while saving object.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public void saveOrUpdate(Object o) throws GenericBusinessException {
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(o);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                // In case of an exception, roll back the transaction.
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    log.error("Error while rolling back the transaction.", ex);
                }
            }
            String message = "Error while saving object.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    public void merge(Object o) throws GenericBusinessException {
        try {
            tx = session.beginTransaction();
            session.merge(o);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                // In case of an exception, roll back the transaction.
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    log.error("Error while rolling back the transaction.", ex);
                }
            }
            String message = "Error while saving object.";
            log.error(message, e);
            GenericBusinessException gbe = new GenericBusinessException(message, e);
            throw gbe;
        }
    }

    /**
     * Close the database connection.
     */
    public void close() throws GenericBusinessException {
        if (session != null) {
            try {
                // And always close the connection.
                session.close();
            } catch (Exception ex) {
                String message = "Error while closing the database session.";
                log.error(message, ex);
                GenericBusinessException gbe = new GenericBusinessException(message, ex);
                throw gbe;
            }
        }
    }

}
