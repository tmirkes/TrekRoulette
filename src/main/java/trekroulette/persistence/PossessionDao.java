package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import trekroulette.entity.Possession;

import java.util.List;

/**
 * DAO class for managing database interactions for the Possession class.
 *
 * Methods in class allow for retrieving, adding, editing, and deleting Possession objects.
 */
public class PossessionDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    /**
     * Query the database connection and retrieve results matching provided possession ID.
     *
     * @param id id of the record
     * @return Possession POJO matching search result data
     */
    public Possession getPossessionById(int id) {
        Session session = sessionFactory.openSession();
        Query<Possession> query = session.createQuery("from Possession p where p.id=:id", Possession.class);
        query.setParameter("id", id);
        Possession possession = query.uniqueResult();
        session.close();
        return possession;
    }

    /**
     * Query the database connection and retrieve results matching provided possession ID.
     *
     * @param userId user id of the possession owner
     * @return Possession POJO matching search result data
     */
    public List<Possession> getPossessionByUserId(int userId) {
        Session session = sessionFactory.openSession();
        Query<Possession> query = session.createQuery("from Possession p where p.userId=:userId", Possession.class);
        query.setParameter("userId", userId);
        List<Possession> possession = query.getResultList();
        session.close();
        return possession;
    }
    /**
     * Query the database connection and retrieve results matching provided possession ID.
     *
     * @param seriesSeasonId id of the session/season
     * @return Possession POJO matching search result data
     */
    public List<Possession> getPossessionBySeriesSeasonId(int seriesSeasonId) {
        Session session = sessionFactory.openSession();
        Query<Possession> query = session.createQuery("from Possession p where p.seriesSeasonId=:seriesSeasonId", Possession.class);
        query.setParameter("seriesSeasonId", seriesSeasonId);
        List<Possession> possession = query.getResultList();
        session.close();
        return possession;
    }

    /**
     * Query the database and add a record using attributes of the parameter Possession object.
     *
     * @param newPossession Possession object representing the new data to be persisted
     * @return primary key of new entry in the possession table
     */
    public int addNewPossession(Possession newPossession) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newPossession);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Query the database and edit a record using attributes of the parameter Possession object.
     *
     * @param updatedPossession Possession object representing the updated data to be persisted
     */
    public void editPossessionData(Possession updatedPossession) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedPossession);
        transaction.commit();
        session.close();
    }

    /**
     * Query the database and remove a record using attributes of the parameter Possession object.
     *
     * @param deletePossession Possession object representing the data to be removed from the possession table
     */
    public void deletePossessionData(Possession deletePossession) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deletePossession);
        transaction.commit();
        session.close();
    }
}