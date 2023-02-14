package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.Role;
import trekroulette.test.util.Database;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    RoleDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandbrole.sql");
        dao = new RoleDao();
    }

    @Test
    void getRoleByIdSuccess() {
        Role result = dao.getRoleById(2);
        assertEquals(2, result.getId());
    }

    @Test
    void getRoleByNameSuccess() {
        Role result = dao.getRoleByName("Clown");
        assertNotNull(result);
        assertEquals("Clown", result.getRoleName());
    }

    @Test
    void addNewRole() {
        Role testRole = new Role("Grip");
        int id = dao.addNewRole(testRole);
        assertNotEquals(0, id);
        Role roleFound = dao.getRoleByName("Grip");
        assertNotNull(roleFound);
        assertEquals("Grip", roleFound.getRoleName());
    }

    @Test
    void editRoleData() {
        Role originalRole = dao.getRoleByName("Clown");
        Role editedRole = originalRole;
        editedRole.setRoleName("Executive");
        dao.editRoleData(editedRole);
        Role resultRole = dao.getRoleByName("Executive");
        assertNotEquals("Clown", resultRole.getRoleName());
    }

    @Test
    void deleteRoleData() {
        Role deleteRole = dao.getRoleByName("Producer");
        assertNotNull(deleteRole);
        dao.deleteRoleData(deleteRole);
        assertNull(dao.getRoleByName("Producer"));
    }
}