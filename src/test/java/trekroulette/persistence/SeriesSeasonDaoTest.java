package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SeriesSeasonDaoTest {
    GenericDao<SeriesSeason> testingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        testingDao = new GenericDao(SeriesSeason.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getSeriesSeasonsById() {
        SeriesSeason testSeriesSeason = (SeriesSeason)testingDao.getById(1);
        assertNotNull(testSeriesSeason);
        assertEquals(testSeriesSeason, testingDao.getById(1));
    }

    @Test
    void getByPropertyEqual() {
        List<SeriesSeason> seriesSeasonList = testingDao.getByPropertyEqual("seriesName", "TOS");
        assertNotNull(seriesSeasonList);
        assertEquals(3, seriesSeasonList.size());
        SeriesSeason resultSeriesSeason = (SeriesSeason)seriesSeasonList.get(0);
        assertNotNull(resultSeriesSeason);
        assertEquals(seriesSeasonList, testingDao.getByPropertyEqual("seriesName", "TOS"));
        assertEquals(resultSeriesSeason, seriesSeasonList.get(0));
    }

    @Test
    void getByPropertyLike() {
        List<SeriesSeason> seriesSeasonList = testingDao.getByPropertyLike("seriesName", "T");
        assertNotNull(seriesSeasonList);
        assertEquals(4, seriesSeasonList.size());
        SeriesSeason resultSeriesSeason = (SeriesSeason)seriesSeasonList.get(0);
        assertNotNull(resultSeriesSeason);
        assertEquals(resultSeriesSeason, seriesSeasonList.get(0));
    }

    @Test
    void getAllSeriesSeasons() {
        List<SeriesSeason> seriesSeasonList = testingDao.getAll();
        assertNotNull(seriesSeasonList);
        assertEquals(seriesSeasonList, testingDao.getAll());
    }

    @Test
    void addSeriesSeason() {
        SeriesSeason testSeriesSeason = new SeriesSeason("DS9",1);
        assertNotNull(testSeriesSeason);
        int id = (int)testingDao.addEntity(testSeriesSeason);
        assertNotEquals(0, id);
        SeriesSeason newSeriesSeason = (SeriesSeason)testingDao.getById(id);
        assertNotNull(testSeriesSeason);
        assertNotNull(newSeriesSeason);
        assertEquals(testSeriesSeason, newSeriesSeason);
    }

    @Test
    void editExistingSeriesSeason() {
        SeriesSeason original = (SeriesSeason)testingDao.getById(3);
        SeriesSeason testSeriesSeason = (SeriesSeason)testingDao.getById(3);
        assertNotNull(testSeriesSeason);
        assertEquals(testSeriesSeason,(SeriesSeason)testingDao.getById(3));
        testSeriesSeason.setSeriesName("Barry");
        assertNotEquals(original,testSeriesSeason);
        testingDao.editEntity(testSeriesSeason);
        assertEquals(testSeriesSeason,(SeriesSeason)testingDao.getById(3));
        assertNotEquals(original,(SeriesSeason)testingDao.getById(3));
    }

    @Test
    void deleteSeriesSeason() {
        SeriesSeason testSeriesSeason = (SeriesSeason)testingDao.getById(2);
        assertNotNull(testSeriesSeason);
        testingDao.deleteEntity(testSeriesSeason);
        assertNull(testingDao.getById(2));
    }
}