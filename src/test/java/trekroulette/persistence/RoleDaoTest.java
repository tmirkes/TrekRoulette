package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {
    /**
    GenericDao<Role> testingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        testingDao = new GenericDao(Role.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getRolesById() {
        Role testRole = (Role)testingDao.getById(1);
        assertNotNull(testRole);
        assertEquals(testRole, testingDao.getById(1));
    }

    @Test
    void getByPropertyEqual() {
        List<Role> roleList = testingDao.getByPropertyEqual("roleName", "Writer");
        assertNotNull(roleList);
        assertEquals(1, roleList.size());
        Role resultRole = (Role)roleList.get(0);
        assertNotNull(resultRole);
        assertEquals(roleList, testingDao.getByPropertyEqual("roleName", "Writer"));
        assertEquals(resultRole, roleList.get(0));
    }

    @Test
    void getByPropertyLike() {
        List<Role> roleList = testingDao.getByPropertyLike("roleName", "er");
        assertNotNull(roleList);
        assertEquals(2, roleList.size());
        Role resultRole = (Role)roleList.get(0);
        assertNotNull(resultRole);
        assertEquals(resultRole, roleList.get(0));
    }

    @Test
    void getAllRoles() {
        List<Role> roleList = testingDao.getAll();
        assertNotNull(roleList);
        assertEquals(roleList, testingDao.getAll());
    }

    @Test
    void addRole() {
        Role testRole = new Role("Lightbulb Changer");
        assertNotNull(testRole);
        int id = (int)testingDao.addEntity(testRole);
        assertNotEquals(0, id);
        Role newRole = (Role)testingDao.getById(id);
        assertNotNull(testRole);
        assertNotNull(newRole);
        assertEquals(testRole, newRole);
    }

    @Test
    void editExistingRole() {
        Role original = (Role)testingDao.getById(2);
        Role testRole = (Role)testingDao.getById(2);
        assertNotNull(testRole);
        assertEquals(testRole,(Role)testingDao.getById(2));
        testRole.setRoleName("Barry");
        assertNotEquals(original,testRole);
        testingDao.editEntity(testRole);
        assertEquals(testRole,(Role)testingDao.getById(2));
        assertNotEquals(original,(Role)testingDao.getById(2));
    }

    @Test
    void deleteRole() {
        Role testRole = (Role)testingDao.getById(4);
        assertNotNull(testRole);
        testingDao.deleteEntity(testRole);
        assertNull(testingDao.getById(4));
    }**/
}