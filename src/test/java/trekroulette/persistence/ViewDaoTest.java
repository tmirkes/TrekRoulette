package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ViewDaoTest {
    GenericDao<View> testingDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
        testingDao = new GenericDao<>(View.class);
    }

    @Test
    void getById() {
        View testView = (View)testingDao.getById(1);
        assertNotNull(testView);
        assertEquals(1, testView.getId());
        assertEquals(1, testView.getStatusId());
        assertEquals(1, testView.getUserId());
        assertEquals(1, testView.getEpisodeId());
    }

    @Test
    void getByPropertyEqual() {
        List<View> ViewList = testingDao.getByPropertyEqual("userId", "4");
        assertNotNull(ViewList);
        assertEquals(1, ViewList.size());
        View resultView = (View)ViewList.get(0);
        assertNotNull(resultView);
        assertEquals(5, resultView.getId());
        assertEquals(1, resultView.getStatusId());
        assertEquals(5, resultView.getEpisodeId());
    }

    @Test
    void getAll() {
        List<View> ViewList = testingDao.getAll();
        assertNotNull(ViewList);
        assertEquals(5, ViewList.size());
    }

    @Test
    void addEntity() {
        View testView = new View(3,2,4);
        assertNotNull(testView);
        int id = testingDao.addEntity(testView);
        assertNotEquals(0, id);
        View newView = (View)testingDao.getById(id);
        assertNotNull(newView);
        assertEquals(3, newView.getStatusId());
        assertEquals(2, newView.getUserId());
        assertEquals(4, newView.getEpisodeId());
    }

    @Test
    void editEntity() {
        View testView = (View)testingDao.getById(5);
        logger.error("Orig id: " + testView.getId());
        logger.error("Orig epId: " + testView.getEpisodeId());
        logger.error("Orig status: " + testView.getStatusId());
        logger.error("Orig userId: " + testView.getUserId());
        assertNotNull(testView);
        int originalStatus = testView.getStatusId();
        logger.error("Orig status extract: " + originalStatus);
        int newStatus = 3;
        View editView = testView;
        logger.error("Copy id: " + editView.getId());
        logger.error("Copy epId: " + editView.getEpisodeId());
        logger.error("Copy status: " + editView.getStatusId());
        logger.error("Copy userId: " + editView.getUserId());
        assertNotNull(editView);
        editView.setStatusId(newStatus);
        logger.error("Edited id: " + editView.getId());
        logger.error("Edited epId: " + editView.getEpisodeId());
        logger.error("Edited status: " + editView.getStatusId());
        logger.error("Edited userId: " + editView.getUserId());
        assertEquals(newStatus, editView.getStatusId());
        testingDao.editEntity(editView);
        View updatedView = (View)testingDao.getById(5);
        logger.error("Queried id: " + updatedView.getId());
        logger.error("Queried epId: " + updatedView.getEpisodeId());
        logger.error("Queried status: " + updatedView.getStatusId());
        logger.error("Queried userId: " + updatedView.getUserId());
        assertNotEquals(originalStatus, updatedView.getStatusId());
    }

    @Test
    void deleteEntity() {
        View testView = (View)testingDao.getById(4);
        assertNotNull(testView);
        testingDao.deleteEntity(testView);
        assertNull(testingDao.getById(4));
    }
}