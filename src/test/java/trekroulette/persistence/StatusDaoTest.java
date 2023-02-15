package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.Status;
import trekroulette.test.util.Database;
import static org.junit.jupiter.api.Assertions.*;

class StatusDaoTest {
    StatusDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandbviewing.sql");
        database.runSQL("cleandbstatus.sql");
        dao = new StatusDao();
    }

    @Test
    void getStatusById() {
        Status result = dao.getStatusById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Unviewed", result.getStatus());
    }

    @Test
    void getStatusByName() {
        Status result = dao.getStatusByName("In Progress");
        assertNotNull(result);
        assertEquals(3, result.getId());
        assertEquals("In Progress", result.getStatus());
    }

    @Test
    void addNewStatus() {
        Status testStatus = new Status("Inverted");
        int id = dao.addNewStatus(testStatus);
        assertNotEquals(0, id);
        Status statusFound = dao.getStatusById(id);
        assertNotNull(statusFound);
        assertEquals(5, statusFound.getId());
        assertEquals("Inverted", statusFound.getStatus());
    }

    @Test
    void editStatusData() {
        Status originalStatus = dao.getStatusById(2);
        Status editedStatus = originalStatus;
        editedStatus.setStatus("Qd");
        dao.editStatusData(editedStatus);
        Status finalStatus = dao.getStatusById(2);
        assertNotNull(finalStatus);
        assertEquals(2, finalStatus.getId());
        assertEquals("Qd", finalStatus.getStatus());
    }

    @Test
    void deleteStatusData() {
        Status testStatus = new Status("Inverted");
        int id = dao.addNewStatus(testStatus);
        assertNotEquals(0, id);
        Status deleteStatus = dao.getStatusById(id);
        assertNotNull(deleteStatus);
        dao.deleteStatusData(deleteStatus);
        assertNull(dao.getStatusById(id));
    }
}