package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import trekroulette.entity.Role;

/**
 * DAO class for managing database interactions for the Role class.
 *
 * Methods in class allow for retrieving, adding, editing, and deleting Role objects.
 */
public class RoleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Query the database connection and retrieve results matching provided role ID.
     *
     * @param id id of the role
     * @return Role POJO matching search result data
     */
    public Role getRoleById(int id) {
        Session session = sessionFactory.openSession();
        Query<Role> query = session.createQuery("from Role p where p.id=:id", Role.class);
        query.setParameter("id", id);
        Role role = query.uniqueResult();
        session.close();
        return role;
    }
    /**
     * Query the database connection and retrieve results matching provided role name.
     *
     * @param roleName name of the role
     * @return Role POJO matching search result data
     */
    public Role getRoleByName(String roleName) {
        Session session = sessionFactory.openSession();
        Query<Role> query = session.createQuery("from Role p where p.roleName=:roleName", Role.class);
        query.setParameter("roleName", roleName);
        Role role = query.uniqueResult();
        session.close();
        return role;
    }

    /**
     * Query the database and add a record using attributes of the parameter Role object.
     *
     * @param newRole Role object representing the new data to be persisted
     * @return primary key of new entry in the role table
     */
    public int addNewRole(Role newRole) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newRole);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Query the database and edit a record using attributes of the parameter Role object.
     *
     * @param updatedRole Role object representing the updated data to be persisted
     */
    public void editRoleData(Role updatedRole) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedRole);
        transaction.commit();
        session.close();
    }

    /**
     * Query the database and remove a record using attributes of the parameter Role object.
     *
     * @param deleteRole Role object representing the data to be removed from the role table
     */
    public void deleteRoleData(Role deleteRole) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleteRole);
        transaction.commit();
        session.close();
    }
}