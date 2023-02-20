package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import trekroulette.entity.Credit;
import java.util.List;

/**
 * DAO class for managing database interactions for the Credit class.
 *
 * Methods in class allow for retrieving, adding, editing, and deleting Credit objects.
 */
public class CreditDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Query the database connection and retrieve results matching provided episode ID.
     *
     * @param episodeId id of the parent episode
     * @return list containing Credit POJOs matching search result data
     */
    public List<Credit> getCreditsByEpisodeId(int episodeId) {
        Session session = sessionFactory.openSession();
        Query<Credit> query = session.createQuery("from Credit p where p.episodeId=:episodeId", Credit.class);
        query.setParameter("episodeId", episodeId);
        List<Credit> credit = query.getResultList();
        session.close();
        return credit;
    }
    /**
     * Query the database connection and retrieve results matching provided credit ID.
     *
     * @param episodeId id of the parent episode
     * @return list containing Credit POJOs matching search result data
     */
    public Credit getCreditsById(int id) {
        Session session = sessionFactory.openSession();
        Query<Credit> query = session.createQuery("from Credit p where p.id=:id", Credit.class);
        query.setParameter("id", id);
        Credit credit = query.uniqueResult();
        session.close();
        return credit;
    }
    /**
     * Query the database connection and retrieve results matching provided credited name.
     *
     * @param firstName first name of the credited individual
     * @param lastName last name of the credited individual
     * @return list containing Credit POJOs matching search result data
     */
    public List<Credit> getCreditsByPerson(String firstName, String lastName) {
        Session session = sessionFactory.openSession();
        Query<Credit> query = session.createQuery("from Credit p where p.firstName=:firstName and p.lastName=:lastName", Credit.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        List<Credit> credit = query.getResultList();
        session.close();
        return credit;
    }
    /**
     * Query the database connection and retrieve results matching provided role ID.
     *
     * @param roleId id of the parent episode
     * @return list containing Credit POJOs matching search result data
     */
    public List<Credit> getCreditsByRoleId(int roleId) {
        Session session = sessionFactory.openSession();
        Query<Credit> query = session.createQuery("from Credit p where p.roleId=:roleId", Credit.class);
        query.setParameter("roleId", roleId);
        List<Credit> credit = query.getResultList();
        session.close();
        return credit;
    }

    /**
     * Query the database and add a record using attributes of the parameter Credit object.
     *
     * @param newCredit Credit object representing the new data to be persisted
     * @return primary key of new entry in the credit table
     */
    public int addNewCredit(Credit newCredit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newCredit);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Query the database and edit a record using attributes of the parameter Credit object.
     *
     * @param updatedCredit Credit object representing the updated data to be persisted
     */
    public void editCreditData(Credit updatedCredit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedCredit);
        transaction.commit();
        session.close();
    }

    /**
     * Query the database and remove a record using attributes of the parameter Credit object.
     *
     * @param deleteCredit Credit object representing the data to be removed from the credit table
     */
    public void deleteCreditData(Credit deleteCredit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleteCredit);
        transaction.commit();
        session.close();
    }
}