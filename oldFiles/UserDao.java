package trekroulette.persistence;

import org.hibernate.query.Query;
import trekroulette.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * DAO class for managing database interactions for the User class.
 *
 * Methods in class allow for retrieving, adding, editing, and deleting User objects.
 */
public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Query the database connection and retrieve results matching provided parameters.
     *
     * @param userNameSearch user name
     * @return User POJO matching search result data
     */
    public User getUserByUserName(String userNameSearch) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User p where p.userName=:userNameSearch", User.class);
        query.setParameter("userNameSearch", userNameSearch);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

    /**
     * Query the database connection and add a record using attributes of the parameter User object.
     *
     * @param newUser User object representing the data to be persisted
     * @return primary key of the new entry in the user table
     */
    public int addNewUser(User newUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newUser);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Query the database and edit a record using attributes of the parameter User object.
     *
     * @param updatedUser User object representing the updated data to be persisted
     */
    public void editUserData(User updatedUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedUser);
        transaction.commit();
        session.close();
    }

    /**
     * Query the database and remove a record using attributes of the parameter User object.
     *
     * @param deleteUser User object representing the data to be removed from the user table
     */
    public void deleteUserData(User deleteUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleteUser);
        transaction.commit();
        session.close();
    }
}