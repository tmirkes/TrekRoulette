package trekroulette.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import trekroulette.entity.User;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }
/**
    public List<User> getUsersByLastName(String lastName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<User> getUsersByFirstName(String firstName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("firstName");
        query.where(builder.like(propertyPath, "%" + firstName + "%"));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<User> getUsersByUserName(String userName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("userName");
        query.where(builder.like(propertyPath, "%" + userName + "%"));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<User> getUsersByEmail(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("email");
        query.where(builder.like(propertyPath, "%" + email + "%"));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }
*/
}