package trekroulette.persistence;

import org.hibernate.query.Query;
import trekroulette.entity.Episode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class EpisodeDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Using search parameter of episode's episode name, query the database and return all results matching that episode name.
     *
     * @param episodeNameSearch episode-provided search episode name
     * @return all results matching the search string
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

    public int addNewEpisode(Episode newEpisode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(newEpisode);
        transaction.commit();
        session.close();
        return id;
    }

    public void deleteEpisodeData(Episode deleteEpisode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deleteEpisode);
        transaction.commit();
        session.close();
    }
}