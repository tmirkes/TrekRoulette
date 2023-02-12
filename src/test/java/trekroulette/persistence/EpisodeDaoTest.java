package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import trekroulette.entity.Episode;
import trekroulette.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EpisodeDaoTest {

    EpisodeDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandbseries.sql");
        database.runSQL("cleandbepisode.sql");
        dao = new EpisodeDao();
    }

    @Test
    void getEpisodeByNameAndSeasonSuccess() {
        Episode result = dao.getEpisodeByEpisodeNameAndSeason("Episode 1", 3);
        assertNotNull(result);
        assertEquals("Episode 1", result.getEpTitle());
        assertEquals(3, result.getSeriesSeasonId());
    }

    @Test
    void addEpisodeToDatabaseSuccess() {
        Episode testEpisode = new Episode("Episode 3",3);
        int id = dao.addNewEpisode(testEpisode);
        assertNotEquals(0, id);
        Episode episodeFound = dao.getEpisodeByEpisodeNameAndSeason("Episode 3",3);
        assertNotNull(episodeFound);
        assertEquals("Episode 3", episodeFound.getEpTitle());
        assertEquals(3, episodeFound.getSeriesSeasonId());
    }

    @Test
    void deleteEpisodeDataSuccess() {
        Episode deleteEpisode = dao.getEpisodeByEpisodeNameAndSeason("Episode 2",3);
        assertNotNull(deleteEpisode);
        dao.deleteEpisodeData(deleteEpisode);
        assertNull(dao.getEpisodeByEpisodeNameAndSeason("Episode 2",3));
    }
}