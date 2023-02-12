package trekroulette.persistence;

import org.hibernate.query.Query;
import trekroulette.entity.Series;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SeriesDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Using search parameter of series's series name, query the database and return all results matching that series name.
     *
     * @param seriesNameSearch series-provided search series name
     * @return all results matching the search string
     */
    public Series getSeriesBySeriesNameAndSeason(String seriesNameSearch, int seriesSeason) {
        Session session = sessionFactory.openSession();
        Query<Series> query = session.createQuery("from Series p where p.seriesName=:seriesNameSearch and p.season=:seriesSeason", Series.class);
        query.setParameter("seriesNameSearch", seriesNameSearch);
        query.setParameter("seriesSeason", seriesSeason);
        Series series = query.uniqueResult();
        session.close();
        return series;
    }

    public int addNewSeries(Series newSeries) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newSeries);
        transaction.commit();
        session.close();
        return id;
    }

    public void editSeriesData(Series updatedSeries) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedSeries);
        transaction.commit();
        session.close();
    }
}