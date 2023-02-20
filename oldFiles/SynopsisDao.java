package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import trekroulette.entity.Synopsis;

/**
 * DAO class for managing database interactions for the Synopsis class.
 *
 * Methods in class allow for retrieving, adding, editing, and deleting Synopsis objects.
 */
public class SynopsisDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Query the database connection and retrieve results matching provided episode ID.
     *
     * @param episodeId id of the parent episode
     * @return Synopsis POJO matching search result data
     */
    public Synopsis getSynopsisByEpisodeId(int episodeId) {
        Session session = sessionFactory.openSession();
        Query<Synopsis> query = session.createQuery("from Synopsis p where p.episodeId=:episodeId", Synopsis.class);
        query.setParameter("episodeId", episodeId);
        Synopsis synopsis = query.uniqueResult();
        session.close();
        return synopsis;
    }
    /**
     * Query the database connection and retrieve results matching provided ID.
     *
     * @param id id of the parent episode
     * @return Synopsis POJO matching search result data
     */
    public Synopsis getSynopsisById(int id) {
        Session session = sessionFactory.openSession();
        Query<Synopsis> query = session.createQuery("from Synopsis p where p.id=:id", Synopsis.class);
        query.setParameter("id", id);
        Synopsis synopsis = query.uniqueResult();
        session.close();
        return synopsis;
    }

    /**
     * Query the database and add a record using attributes of the parameter Synopsis object.
     *
     * @param newSynopsis Synopsis object representing the new data to be persisted
     * @return primary key of new entry in the synopsis table
     */
    public int addNewSynopsis(Synopsis newSynopsis) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newSynopsis);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Query the database and edit a record using attributes of the parameter Synopsis object.
     *
     * @param updatedSynopsis Synopsis object representing the updated data to be persisted
     */
    public void editSynopsisData(Synopsis updatedSynopsis) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedSynopsis);
        transaction.commit();
        session.close();
    }

    /**
     * Query the database and remove a record using attributes of the parameter Synopsis object.
     *
     * @param deleteSynopsis Synopsis object representing the data to be removed from the synopsis table
     */
    public void deleteSynopsisData(Synopsis deleteSynopsis) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleteSynopsis);
        transaction.commit();
        session.close();
    }
}