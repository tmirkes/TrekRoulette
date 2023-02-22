package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public GenericDao(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    private Transaction getTransaction(Session session) {
        return session.beginTransaction();
    }

    public T getById(int id) {
        Session session = getSession();
        T entity = session.get(type, id);
        session.close();
        return entity;
    }

    public List<T> getByPropertyEqual(String property, String value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(property), value));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public List<T> getByPropertyLike(String property, Object value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        String searchTerm = "%" + value + "%";
        query.select(root).where(builder.like(root.get(property), searchTerm));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public int addEntity(T entity) {
        Session session = getSession();
        Transaction transaction = getTransaction(session);
        int id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    public void editEntity(T entity) {
        Session session = getSession();
        Transaction transaction = getTransaction(session);
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    public void deleteEntity(T entity) {
        Session session = getSession();
        Transaction transaction = getTransaction(session);
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}