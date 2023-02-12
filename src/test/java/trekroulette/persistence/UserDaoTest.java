package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
        // Get user by original username
        User originalUser = dao.getUserByUserName("fl3");
        logger.debug("original user loaded");
        // Assign returned user to user object
        // Copy the returned user to a new user object
        User editedUser = originalUser;
        logger.debug("edited set to equal original");
        // Change the copied user's username
        editedUser.setUserName("WACKY");
        logger.debug("edited user_name updated");
        // Push the edit to the database
        dao.editUserData(editedUser);
        logger.debug("edited user written to database");
        // Get user by new username
        User resultUser = dao.getUserByUserName("fl3");
        logger.debug("edited user loaded");
        // Assign returned user to user object
        // Compare new and old users
        assertNotEquals(originalUser, resultUser);
    }
}