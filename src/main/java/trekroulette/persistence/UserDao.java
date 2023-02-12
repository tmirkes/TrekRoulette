package trekroulette.persistence;

import org.hibernate.query.Query;
import trekroulette.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Using search parameter of user's user name, query the database and return all results matching that user name.
     *
     * @param userNameSearch user-provided search user name
     * @return all results matching the search string
     */
    public User getUserByUserName(String userNameSearch) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User p where p.userName=:userNameSearch", User.class);
        query.setParameter("userNameSearch", userNameSearch);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

    public int addNewUser(User newUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newUser);
        transaction.commit();
        session.close();
        return id;
    }

    public void editUserData(User updatedUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedUser);
        transaction.commit();
        session.close();
    }
}