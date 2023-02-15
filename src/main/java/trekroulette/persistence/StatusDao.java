package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import trekroulette.entity.Status;

/**
 * DAO class for managing database interactions for the Status class.
 *
 * Methods in class allow for retrieving, adding, editing, and deleting Status objects.
 */
public class StatusDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Query the database connection and retrieve results matching provided status ID.
     *
     * @param statusId id of the status
     * @return Status POJO matching search result data
     */
    public Status getStatusById(int id) {
        Session session = sessionFactory.openSession();
        Query<Status> query = session.createQuery("from Status p where p.id=:id", Status.class);
        query.setParameter("id", id);
        Status status = query.uniqueResult();
        session.close();
        return status;
    }
    /**
     * Query the database connection and retrieve results matching provided status text.
     *
     * @param statusText name of the status
     * @return Status POJO matching search result data
     */
    public Status getStatusByName(String status) {
        Session session = sessionFactory.openSession();
        Query<Status> query = session.createQuery("from Status p where p.status=:status", Status.class);
        query.setParameter("status", status);
        Status statusResult = query.uniqueResult();
        session.close();
        return statusResult;
    }

    /**
     * Query the database and add a record using attributes of the parameter Status object.
     *
     * @param newStatus Status object representing the new data to be persisted
     * @return primary key of new entry in the status table
     */
    public int addNewStatus(Status newStatus) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newStatus);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Query the database and edit a record using attributes of the parameter Status object.
     *
     * @param updatedStatus Status object representing the updated data to be persisted
     */
    public void editStatusData(Status updatedStatus) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedStatus);
        transaction.commit();
        session.close();
    }

    /**
     * Query the database and remove a record using attributes of the parameter Status object.
     *
     * @param deleteStatus Status object representing the data to be removed from the status table
     */
    public void deleteStatusData(Status deleteStatus) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleteStatus);
        transaction.commit();
        session.close();
    }
}