package trekroulette.persistence;

import org.hibernate.query.Query;
import trekroulette.entity.Series;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * DAO class for managing database interactions for the Series class.
 *
 * Methods in class allow for retrieving, adding, and deleting Series objects.  Full CRUD coverage is not possible due
 * to the FK constraints on the series_season table (the series_season PK field is an FK in the episode table).
 */
public class SeriesDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Query the database connection and retrieve results matching provided parameters.
     *
     * @param seriesNameSearch title of series
     * @param seriesSeason season of series
     * @return Series POJO matching search result data
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

    /**
     * Query the database connection and add a record using attributes of the parameter Series object.
     *
     * @param newSeries Series object representing the new data to be persisted
     * @return primary key of new entry in the series_season table
     */
    public int addNewSeries(Series newSeries) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newSeries);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Query the database and edit a record using attributes of the parameter Series object.
     *
     * @param updatedSeries Series object representing the updated data to be persisted
     */
    public void editSeriesData(Series updatedSeries) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updatedSeries);
        transaction.commit();
        session.close();
    }

    /**
     * Query the database and remove a record using attributes of the parameter Series object.
     *
     * @param deleteSeries Series object representing the data to be removed from the series_season table
     */
    public void deleteSeriesAndSeasonData(Series deleteSeries) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleteSeries);
        transaction.commit();
        session.close();
    }
}