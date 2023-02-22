package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EpisodeDaoTest {
    GenericDao<Episode> testingDao;
    GenericDao<Synopsis> synopsisTestingDao;
    GenericDao<SeriesSeason> seriesSeasonTestingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        testingDao = new GenericDao(Episode.class);
        synopsisTestingDao = new GenericDao(Synopsis.class);
        seriesSeasonTestingDao = new GenericDao(SeriesSeason.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getEpisodeById() {
        Episode testEpisode = (Episode)testingDao.getById(1);
        assertNotNull(testEpisode);
        assertEquals(testEpisode, testingDao.getById(1));
    }

    @Test
    void getAllEpisodes() {
        List<Episode> episodeList = testingDao.getAll();
        assertNotNull(episodeList);
        assertEquals(episodeList, testingDao.getAll());
    }

    @Test
    void addEpisodeWithSynopsisAndSeasonSeries() {
        Synopsis newSynopsis = new Synopsis("Yeah, I guess stuff happens.");
        assertNotNull(newSynopsis);
        synopsisTestingDao.addEntity(newSynopsis);

        SeriesSeason existingSeriesSeason = (SeriesSeason)seriesSeasonTestingDao.getById(3);
        assertNotNull(existingSeriesSeason);
        assertEquals(existingSeriesSeason,(SeriesSeason)seriesSeasonTestingDao.getById(3));

        Episode newEpisode = new Episode("The One with the Enterprise");
        newEpisode.setSynopsis(newSynopsis);
        newEpisode.setSeriesSeason(existingSeriesSeason);
        newSynopsis.addEpisode(newEpisode);
        existingSeriesSeason.addEpisode(newEpisode);

        int id = testingDao.addEntity(newEpisode);
        Episode insertedEpisode = (Episode)testingDao.getById(id);
        assertNotNull(insertedEpisode);
        assertEquals(newEpisode, insertedEpisode);
        assertEquals(newSynopsis, insertedEpisode.getSynopsis());
        assertEquals(existingSeriesSeason, insertedEpisode.getSeriesSeason());
    }

    @Test
    void editExistingEpisode() {
        Episode original = (Episode)testingDao.getById(1);

        Episode testEpisode = (Episode)testingDao.getById(1);
        assertNotNull(testEpisode);
        assertEquals(testEpisode,(Episode)testingDao.getById(1));

        SeriesSeason updateSeriesSeason = (SeriesSeason)seriesSeasonTestingDao.getById(2);
        assertNotNull(updateSeriesSeason);
        assertEquals(updateSeriesSeason,(SeriesSeason)seriesSeasonTestingDao.getById(2));

        testEpisode.setSeriesSeason(updateSeriesSeason);
        assertNotEquals(original,testEpisode);
        testingDao.editEntity(testEpisode);
        assertEquals(testEpisode,(Episode)testingDao.getById(1));
        assertNotEquals(original,(Episode)testingDao.getById(1));
    }

    @Test
    void deleteEpisode() {
        Episode testEpisode = (Episode)testingDao.getById(3);
        assertNotNull(testEpisode);
        testingDao.deleteEntity(testEpisode);
        assertNull(testingDao.getById(3));
    }
}