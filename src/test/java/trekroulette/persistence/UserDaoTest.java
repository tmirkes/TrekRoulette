package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.User;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    GenericDao<User> testingDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
        testingDao = new GenericDao<>(User.class);
    }

    @Test
    void getById() {
        User testUser = (User)testingDao.getById(1);
        assertNotNull(testUser);
        assertEquals(1, testUser.getId());
        assertEquals("First1", testUser.getFirstName());
        assertEquals("Last1", testUser.getLastName());
        assertEquals("fl1@test.com", testUser.getEmail());
        assertEquals("fl1", testUser.getUserName());
        assertEquals("password", testUser.getPassword());
        assertEquals("user", testUser.getPrivileges());
        assertNotNull(testUser.getCreated());
        assertEquals(1, testUser.getActive());
    }

    @Test
    void getByPropertyEqual() {
        List<User> userList = testingDao.getByPropertyEqual("userName", "fl6");
        assertNotNull(userList);
        assertEquals(1, userList.size());
        User resultUser = (User)userList.get(0);
        assertNotNull(resultUser);
        assertEquals("First6", resultUser.getFirstName());
        assertEquals("Last6", resultUser.getLastName());
        assertEquals("fl6@test.com", resultUser.getEmail());
        assertEquals("fl6", resultUser.getUserName());
        assertEquals("password", resultUser.getPassword());
        assertEquals("user", resultUser.getPrivileges());
        assertNotNull(resultUser.getCreated());
        assertEquals(1, resultUser.getActive());
    }

    @Test
    void getByPropertyLike() {
        List<User> userList = testingDao.getByPropertyLike("firstName", "rst4");
        assertNotNull(userList);
        assertEquals(1, userList.size());
        User resultUser = (User)userList.get(0);
        assertNotNull(resultUser);
        assertEquals("First4", resultUser.getFirstName());
        assertEquals("Last4", resultUser.getLastName());
        assertEquals("fl4@test.com", resultUser.getEmail());
        assertEquals("fl4", resultUser.getUserName());
        assertEquals("password", resultUser.getPassword());
        assertEquals("user", resultUser.getPrivileges());
        assertNotNull(resultUser.getCreated());
        assertEquals(1, resultUser.getActive());
    }

    @Test
    void getAll() {
        List<User> userList = testingDao.getAll();
        assertNotNull(userList);
        assertEquals(9, userList.size());
    }

    @Test
    void addEntity() {
        User testUser = new User("First10","Last10","fl10@test.com","fl10","password","user");
        assertNotNull(testUser);
        int id = testingDao.addEntity(testUser);
        assertNotEquals(0, id);
        User newUser = (User)testingDao.getById(id);
        assertNotNull(newUser);
        assertEquals("First10", newUser.getFirstName());
        assertEquals("Last10", newUser.getLastName());
        assertEquals("fl10@test.com", newUser.getEmail());
        assertEquals("fl10", newUser.getUserName());
        assertEquals("password", newUser.getPassword());
        assertEquals("user", newUser.getPrivileges());
        assertNotNull(newUser.getCreated());
        assertEquals(1, newUser.getActive());
    }

    @Test
    void editEntity() {
        User testUser = (User)testingDao.getById(7);
        assertNotNull(testUser);
        String originalName = testUser.getFirstName();
        String newName = "Barry";
        User editUser = testUser;
        assertNotNull(editUser);
        editUser.setFirstName(newName);
        assertEquals(newName, editUser.getFirstName());
        testingDao.editEntity(editUser);
        User updatedUser = (User)testingDao.getById(7);
        assertNotEquals(originalName, updatedUser.getFirstName());
    }

    @Test
    void deleteEntity() {
        User testUser = (User)testingDao.getById(9);
        assertNotNull(testUser);
        testingDao.deleteEntity(testUser);
        assertNull(testingDao.getById(9));
    }
}