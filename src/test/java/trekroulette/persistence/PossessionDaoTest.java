package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.Possession;
import trekroulette.test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PossessionDaoTest {
    PossessionDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandbuser.sql");
        database.runSQL("cleandb.sql");
        database.runSQL("cleandbpossession.sql");
        dao = new PossessionDao();
    }

    @Test
    void getPossessionById() {
        Possession result = dao.getPossessionById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals(2, result.getUserId());
        assertEquals(1, result.getSeriesSeasonId());
    }

    @Test
    void getPossessionByUserId() {
        List<Possession> result = dao.getPossessionByUserId(2);
        assertNotNull(result);
        Possession firstResult = result.get(0);
        assertEquals(1, firstResult.getId());
        assertEquals(2, firstResult.getUserId());
        assertEquals(1, firstResult.getSeriesSeasonId());
    }

    @Test
    void getPossesionBySeriesSeasonId() {
        List<Possession> result = dao.getPossessionBySeriesSeasonId(1);
        assertNotNull(result);
        Possession firstResult = result.get(0);
        assertEquals(1, firstResult.getId());
        assertEquals(2, firstResult.getUserId());
        assertEquals(1, firstResult.getSeriesSeasonId());
    }

    @Test
    void addNewPossession() {
        Possession testPossession = new Possession(3,3);
        int id = dao.addNewPossession(testPossession);
        assertNotEquals(0, id);
        Possession possessionFound = dao.getPossessionById(id);
        assertNotNull(possessionFound);
        assertEquals(id, possessionFound.getId());
        assertEquals(3, possessionFound.getUserId());
        assertEquals(3, possessionFound.getSeriesSeasonId());
    }

    @Test
    void editPossessionData() {
        Possession originalPossession = dao.getPossessionById(2);
        Possession editedPossession = originalPossession;
        editedPossession.setUserId(4);
        dao.editPossessionData(editedPossession);
        Possession finalPossession = dao.getPossessionById(2);
        assertNotNull(finalPossession);
        assertEquals(2, finalPossession.getId());
        assertEquals(4, finalPossession.getUserId());
        assertEquals(2, finalPossession.getSeriesSeasonId());
    }

    @Test
    void deletePossessionData() {
        Possession testPossession = new Possession(3,3);
        int id = dao.addNewPossession(testPossession);
        assertNotEquals(0, id);
        Possession deletePossession = dao.getPossessionById(id);
        assertNotNull(deletePossession);
        dao.deletePossessionData(deletePossession);
        assertNull(dao.getPossessionById(id));
    }
}