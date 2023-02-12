package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trekroulette.entity.Series;
import trekroulette.entity.User;
import trekroulette.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new UserDao();
    }

    @Test
    void getUserByUserNameSuccess() {
        User result = dao.getUserByUserName("fl4");
        assertEquals("fl4", result.getUserName());
    }

    @Test
    void addUserToDatabaseSuccess() {
        User testUser = new User("First7","Last7","fl7@test.com","fl7","password","user");
        int id = dao.addNewUser(testUser);
        assertNotEquals(0, id);
        User userFound = dao.getUserByUserName("fl7");
        assertEquals("First7", userFound.getFirstName());
    }

    @Test
    void editUserDataSuccess() {
        User originalUser = dao.getUserByUserName("fl3");
        User editedUser = originalUser;
        editedUser.setUserName("WACKY");
        dao.editUserData(editedUser);
        User resultUser = dao.getUserByUserName("fl3");
        assertNotEquals(originalUser, resultUser);
    }

    @Test
    void deleteUserDataSuccess() {
        User deleteUser = dao.getUserByUserName("fl3");
        assertNotNull(deleteUser);
        dao.deleteUserData(deleteUser);
        assertNull(dao.getUserByUserName("fl3"));
    }
}