package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    trekDao<User> testingDao;
    trekDao<View> viewTestingDao;
    trekDao<Season> SeasonTestingDao;
    trekDao<Own> ownTestingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());
/**
    @BeforeEach
    void setUp() {
        testingDao = new trekDao(User.class);
        viewTestingDao = new trekDao(View.class);
        SeasonTestingDao = new trekDao(Season.class);
        ownTestingDao = new trekDao(Own.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getUsersById() {
        User testUser = (User)testingDao.getById(1);
        assertNotNull(testUser);
        assertEquals(testUser, testingDao.getById(1));
    }

    @Test
    void getByPropertyEqual() {
        List<User> userList = testingDao.getByPropertyEqual("userName", "fl6");
        assertNotNull(userList);
        assertEquals(1, userList.size());
        User resultUser = (User)userList.get(0);
        assertNotNull(resultUser);
        assertEquals(userList, testingDao.getByPropertyEqual("userName", "fl6"));
        assertEquals(resultUser, userList.get(0));
    }

    @Test
    void getByPropertyLike() {
        List<User> userList = testingDao.getByPropertyLike("firstName", "rst4");
        assertNotNull(userList);
        assertEquals(1, userList.size());
        User resultUser = (User)userList.get(0);
        assertNotNull(resultUser);
        assertEquals(resultUser, userList.get(0));
    }

    @Test
    void getAllUsers() {
        List<User> userList = testingDao.getAll();
        assertNotNull(userList);
        assertEquals(userList, testingDao.getAll());
    }

    @Test
    void addUser() {
        User testUser = new User("First10","Last10","fl10@test.com","fl10","password","user");
        assertNotNull(testUser);
        int id = (int)testingDao.addEntity(testUser);
        assertNotEquals(0, id);
        User newUser = (User)testingDao.getById(id);
        assertNotNull(testUser);
        assertNotNull(newUser);
        assertEquals(testUser, newUser);
    }

    @Test
    void editExistingUser() {
        User original = (User)testingDao.getById(7);
        User testUser = (User)testingDao.getById(7);
        assertNotNull(testUser);
        assertEquals(testUser,(User)testingDao.getById(7));
        testUser.setFirstName("Barry");
        assertNotEquals(original,testUser);
        testingDao.editEntity(testUser);
        assertEquals(testUser,(User)testingDao.getById(7));
        assertNotEquals(original,(User)testingDao.getById(7));
    }

    @Test
    void deleteUser() {
        User testUser = (User)testingDao.getById(9);
        assertNotNull(testUser);
        testingDao.deleteEntity(testUser);
        assertNull(testingDao.getById(9));
    }**/
}