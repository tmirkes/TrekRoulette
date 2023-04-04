package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StatusDaoTest {
    /**
    GenericDao<Status> testingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        testingDao = new GenericDao(Status.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getStatusById() {
        Status testStatus = (Status)testingDao.getById(1);
        assertNotNull(testStatus);
        assertEquals(testStatus, testingDao.getById(1));
    }

    @Test
    void getByPropertyEqual() {
        List<Status> statusList = testingDao.getByPropertyEqual("status", "In Progress");
        assertNotNull(statusList);
        assertEquals(1, statusList.size());
        Status resultStatus = (Status)statusList.get(0);
        assertNotNull(resultStatus);
        assertEquals(statusList, testingDao.getByPropertyEqual("status", "In Progress"));
        assertEquals(resultStatus, statusList.get(0));
    }

    @Test
    void getByPropertyLike() {
        List<Status> statusList = testingDao.getByPropertyLike("status", "in");
        assertNotNull(statusList);
        assertEquals(2, statusList.size());
        Status resultStatus = (Status)statusList.get(0);
        assertNotNull(resultStatus);
        assertEquals(resultStatus, statusList.get(0));
    }

    @Test
    void getAllStatuss() {
        List<Status> statusList = testingDao.getAll();
        assertNotNull(statusList);
        assertEquals(statusList, testingDao.getAll());
    }

    @Test
    void addStatus() {
        Status testStatus = new Status("Here");
        assertNotNull(testStatus);
        int id = (int)testingDao.addEntity(testStatus);
        assertNotEquals(0, id);
        Status newStatus = (Status)testingDao.getById(id);
        assertNotNull(testStatus);
        assertNotNull(newStatus);
        assertEquals(testStatus, newStatus);
    }

    @Test
    void editExistingStatus() {
        Status original = (Status)testingDao.getById(2);
        Status testStatus = (Status)testingDao.getById(2);
        assertNotNull(testStatus);
        assertEquals(testStatus,(Status)testingDao.getById(2));
        testStatus.setStatus("Barry");
        assertNotEquals(original,testStatus);
        testingDao.editEntity(testStatus);
        assertEquals(testStatus,(Status)testingDao.getById(2));
        assertNotEquals(original,(Status)testingDao.getById(2));
    }

    @Test
    void deleteStatus() {
        Status testStatus = (Status)testingDao.getById(1);
        assertNotNull(testStatus);
        testingDao.deleteEntity(testStatus);
        assertNull(testingDao.getById(1));
    }**/
}