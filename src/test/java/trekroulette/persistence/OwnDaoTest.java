package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OwnDaoTest {
    /**
    GenericDao<User> userTestingDao;
    GenericDao<SeriesSeason> seriesSeasonTestingDao;
    GenericDao<Own> testingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        userTestingDao = new GenericDao(User.class);
        seriesSeasonTestingDao = new GenericDao(SeriesSeason.class);
        testingDao = new GenericDao(Own.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getOwnsById() {
        Own testOwn = (Own)testingDao.getById(1);
        assertNotNull(testOwn);
        assertEquals(testOwn, testingDao.getById(1));
    }

    @Test
    void getAllOwns() {
        List<Own> ownList = testingDao.getAll();
        assertNotNull(ownList);
        assertEquals(ownList, testingDao.getAll());
    }

    @Test
    void addOwnWithUserAndSeries() {
        User existingUser = (User)userTestingDao.getById(1);
        assertNotNull(existingUser);
        assertEquals(existingUser,(User)userTestingDao.getById(1));
        SeriesSeason existingSeriesSeason = (SeriesSeason)seriesSeasonTestingDao.getById(2);
        assertNotNull(existingUser);
        assertEquals(existingSeriesSeason,(SeriesSeason)seriesSeasonTestingDao.getById(2));
        Own newOwn = new Own();
        newOwn.setUser(existingUser);
        newOwn.setSeriesSeason(existingSeriesSeason);
        existingUser.addOwn(newOwn);
        existingSeriesSeason.addOwn(newOwn);
        int id = testingDao.addEntity(newOwn);
        Own insertedOwn = (Own)testingDao.getById(id);
        assertNotNull(insertedOwn);
        assertEquals(newOwn, insertedOwn);
        assertEquals(existingUser, insertedOwn.getUser());
        assertEquals(existingSeriesSeason, insertedOwn.getSeriesSeason());
    }

    @Test
    void editExistingOwn() {
        Own original = (Own)testingDao.getById(3);
        User testUser = (User)original.getUser();
        assertNotNull(testUser);
        assertEquals(testUser,(User)original.getUser());
        User userUpdate = (User)userTestingDao.getById(4);
        assertNotNull(userUpdate);
        assertEquals(userUpdate,(User)userTestingDao.getById(4));
        Own newOwn = (Own)testingDao.getById(3);
        newOwn.setUser(userUpdate);
        testingDao.editEntity(newOwn);
        assertEquals(newOwn,(Own)testingDao.getById(3));
        assertNotEquals(original,(Own)testingDao.getById(3));
    }

    @Test
    void deleteOwn() {
        Own testOwn = (Own)testingDao.getById(1);
        assertNotNull(testOwn);
        testingDao.deleteEntity(testOwn);
        assertNull(testingDao.getById(1));
    }**/
}