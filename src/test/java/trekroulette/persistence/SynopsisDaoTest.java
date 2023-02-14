package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.Synopsis;
import trekroulette.test.util.Database;

import static org.junit.jupiter.api.Assertions.*;

class SynopsisDaoTest {
    SynopsisDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandbepisode.sql");
        database.runSQL("cleandbsynopsis.sql");
        dao = new SynopsisDao();
    }

    @Test
    void getSynopsisByEpisodeId() {
        Synopsis result = dao.getSynopsisByEpisodeId(2);
        assertEquals(2, result.getId());
    }

    @Test
    void getSynopsisById() {
        Synopsis result = dao.getSynopsisById(2);
        assertEquals(2, result.getId());
        assertEquals("Other things happened", result.getSummary());
        assertEquals(2, result.getEpisodeId());
    }

    @Test
    void addNewSynopsis() {
        Synopsis testSynopsis = new Synopsis("A big bang and some stuff after", 4);
        int id = dao.addNewSynopsis(testSynopsis);
        assertNotEquals(0, id);
        Synopsis synopsisFound = dao.getSynopsisById(id);
        assertNotNull(synopsisFound);
        assertEquals("A big bang and some stuff after", synopsisFound.getSummary());
    }

    @Test
    void editSynopsisData() {
        Synopsis originalSynopsis = dao.getSynopsisById(5);
        logger.info(originalSynopsis.getSummary());
        Synopsis editedSynopsis = originalSynopsis;
        logger.info(editedSynopsis.getSummary());
        editedSynopsis.setSummary("They just chill for a while");
        logger.info(editedSynopsis.getSummary());
        dao.editSynopsisData(editedSynopsis);
        Synopsis resultSynopsis = dao.getSynopsisById(5);
        logger.info(resultSynopsis.getSummary());
        assertEquals(5, resultSynopsis.getId());
        assertNotEquals("So much happening", resultSynopsis.getSummary());
    }

    @Test
    void deleteSynopsisData() {
        Synopsis deleteSynopsis = dao.getSynopsisByEpisodeId(3);
        assertNotNull(deleteSynopsis);
        dao.deleteSynopsisData(deleteSynopsis);
        assertNull(dao.getSynopsisByEpisodeId(3));
    }
}