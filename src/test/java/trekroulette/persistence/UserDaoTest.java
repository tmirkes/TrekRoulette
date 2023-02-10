package trekroulette.persistence;

import trekroulette.entity.User;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
    }

    @Test
    void getAllUsers() {
        List<User> users = dao.getAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    void getUsersByLastName() {
    }

    @Test
    void getUsersByFirstName() {
    }

    @Test
    void getUsersByUserName() {
    }

    @Test
    void testGetUsersByLastName() {
    }
}