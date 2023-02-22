package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SynopsisDaoTest {
    GenericDao<Synopsis> testingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        testingDao = new GenericDao(Synopsis.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getSynopsesById() {
        Synopsis testSynopsis = (Synopsis)testingDao.getById(1);
        assertNotNull(testSynopsis);
        assertEquals(testSynopsis, testingDao.getById(1));
    }

    @Test
    void getByPropertyEqual() {
        List<Synopsis> synopsisList = testingDao.getByPropertyEqual("summary", "Events");
        assertNotNull(synopsisList);
        assertEquals(1, synopsisList.size());
        Synopsis resultSynopsis = (Synopsis)synopsisList.get(0);
        assertNotNull(resultSynopsis);
        assertEquals(synopsisList, testingDao.getByPropertyEqual("summary", "Events"));
        assertEquals(resultSynopsis, synopsisList.get(0));
    }

    @Test
    void getByPropertyLike() {
        List<Synopsis> synopsisList = testingDao.getByPropertyLike("summary", "happen");
        assertNotNull(synopsisList);
        assertEquals(1, synopsisList.size());
        Synopsis resultSynopsis = (Synopsis) synopsisList.get(0);
        assertNotNull(resultSynopsis);
        assertEquals(resultSynopsis, synopsisList.get(0));
    }

    @Test
    void getAllSynopses() {
        List<Synopsis> synopsisList = testingDao.getAll();
        assertNotNull(synopsisList);
        assertEquals(synopsisList, testingDao.getAll());
    }

    @Test
    void addSynopsis() {
        Synopsis testSynopsis = new Synopsis("This sure is an episode");
        assertNotNull(testSynopsis);
        int id = (int)testingDao.addEntity(testSynopsis);
        assertNotEquals(0, id);
        Synopsis newSynopsis = (Synopsis)testingDao.getById(id);
        assertNotNull(testSynopsis);
        assertNotNull(newSynopsis);
        assertEquals(testSynopsis, newSynopsis);
    }

    @Test
    void editExistingSynopsis() {
        Synopsis original = (Synopsis)testingDao.getById(2);
        Synopsis testSynopsis = (Synopsis)testingDao.getById(2);
        assertNotNull(testSynopsis);
        assertEquals(testSynopsis,(Synopsis)testingDao.getById(2));
        testSynopsis.setSummary("Barry");
        assertNotEquals(original,testSynopsis);
        testingDao.editEntity(testSynopsis);
        assertEquals(testSynopsis,(Synopsis)testingDao.getById(2));
        assertNotEquals(original,(Synopsis)testingDao.getById(2));
    }

    @Test
    void deleteSynopsis() {
        Synopsis testSynopsis = (Synopsis)testingDao.getById(3);
        assertNotNull(testSynopsis);
        testingDao.deleteEntity(testSynopsis);
        assertNull(testingDao.getById(3));
    }
}