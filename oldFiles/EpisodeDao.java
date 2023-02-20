package trekroulette.persistence;

import org.hibernate.query.Query;
import trekroulette.entity.Episode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * DAO class for managing database interactions for the Episode class.
 *
 * Methods in class allow for retrieving, adding, and deleting Episode objects.  Full CRUD coverage is not possible due
 * to the FK constraints on the episode table (the season_series_id field is the PK in the series_season table).
 */
public class EpisodeDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Query the database connection and retrieve results matching provided parameters.
     *
     * @param epTitle title of the episode
     * @param seriesSeasonId foreign key representing series and season of the episode in the season_series table
     * @return Episode POJO matching search result data
     */
    public Episode getEpisodeByEpisodeNameAndSeason(String epTitle, int seriesSeasonId) {
        Session session = sessionFactory.openSession();
        Query<Episode> query = session.createQuery("from Episode p where p.epTitle=:epTitle and p.seriesSeasonId=:seriesSeasonId", Episode.class);
        query.setParameter("epTitle", epTitle);
        query.setParameter("seriesSeasonId", seriesSeasonId);
        Episode episode = query.uniqueResult();
        session.close();
        return episode;
    }

    /**
     * Query the database and add a record using attributes of the parameter Episode object.
     *
     * @param newEpisode Episode object representing the new data to be persisted
     * @return primary key of new entry in the episode table
     */
    public int addNewEpisode(Episode newEpisode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newEpisode);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Query the database and remove a record using attributes of the parameter Episode object.
     *
     * @param deleteEpisode Episode object representing the data to be removed from the episode table
     */
    public void deleteEpisodeData(Episode deleteEpisode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleteEpisode);
        transaction.commit();
        session.close();
    }
}