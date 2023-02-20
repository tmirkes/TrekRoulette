package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import trekroulette.entity.View;
import java.util.List;

/**
 * DAO class for managing database interactions for the View class.
 *
 * Methods in class allow for retrieving, adding, editing, and deleting View objects.
 */
public class ViewDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public View getViewById(int id) {
        Session session = sessionFactory.openSession();
        Query<View> query = session.createQuery("from View p where p.id=:id", View.class);
        query.setParameter("id", id);
        View view = query.uniqueResult();
        session.close();
        return view;
    }
    public List<View> getViewByUserId(int userId) {
        Session session = sessionFactory.openSession();
        Query<View> query = session.createQuery("from View p where p.userId=:userId", View.class);
        query.setParameter("userId", userId);
        List<View> view = query.getResultList();
        session.close();
        return view;
    }
    public List<View> getViewBySeriesSeasonId(int seriesSeasonId) {
        Session session = sessionFactory.openSession();
        Query<View> query = session.createQuery("from View p where p.seriesSeasonId=:seriesSeasonId", View.class);
        query.setParameter("seriesSeasonId", seriesSeasonId);
        List<View> view = query.getResultList();
        session.close();
        return view;
    }
    public List<View> getViewByEpisodeId(int episodeId) {
        Session session = sessionFactory.openSession();
        Query<View> query = session.createQuery("from View p where p.episodeId=:episodeId", View.class);
        query.setParameter("episodeId", episodeId);
        List<View> view = query.getResultList();
        session.close();
        return view;
    }
    public List<View> getViewByStatusId(int statusId) {
        Session session = sessionFactory.openSession();
        Query<View> query = session.createQuery("from View p where p.statusId=:statusId", View.class);
        query.setParameter("statusId", statusId);
        List<View> view = query.getResultList();
        session.close();
        return view;
    }
    public int addNewView(View newView) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(newView);
        transaction.commit();
        session.close();
        return id;
    }
    public void editViewData(View updatedView) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedView);
        transaction.commit();
        session.close();
    }
    public void deleteViewData(View deleteView) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleteView);
        transaction.commit();
        session.close();
    }
}