package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.Credit;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CreditDaoTest {

    CreditDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandbrole.sql");
        database.runSQL("cleandbepisode.sql");
        database.runSQL("cleandbcredit.sql");
        dao = new CreditDao();
    }

    @Test
    void getCreditsByEpisodeIdSuccess() {
        List<Credit> resultList = dao.getCreditsByEpisodeId(2);
        assertEquals(3, resultList.size());
    }
    
    @Test
    void getCreditsByIdSuccess() {
        Credit result = dao.getCreditsById(3);
        assertEquals("Bobby", result.getFirstName());
        assertEquals("Bindle", result.getLastName());
        assertEquals(4, result.getEpisodeId());
        assertEquals(3, result.getRoleId());
    }

    @Test
    void getCreditsByPersonSuccess() {
        List<Credit> result = dao.getCreditsByPerson("Andy", "Alerson");
        assertNotNull(result);
        assertEquals("Andy", result.get(0).getFirstName());
        assertEquals("Alerson", result.get(0).getLastName());
    }

    @Test
    void getCreditsByRoleId() {
        List<Credit> result = dao.getCreditsByRoleId(2);
        assertNotNull(result);
        assertEquals("Kelly", result.get(0).getFirstName());
        assertEquals("Kapowski", result.get(0).getLastName());
    }

    @Test
    void addNewCredit() {
        Credit testCredit = new Credit("Tommy", "Two-Tone", 3, 1);
        int id = dao.addNewCredit(testCredit);
        assertNotEquals(0, id);
        Credit creditFound = dao.getCreditsById(id);
        assertNotNull(creditFound);
        assertEquals("Tommy", creditFound.getFirstName());
        assertEquals("Two-Tone", creditFound.getLastName());
        assertEquals(3, creditFound.getEpisodeId());
        assertEquals(1, creditFound.getRoleId());
    }

    @Test
    void editCreditData() {
        List<Credit> originalCredit = dao.getCreditsByPerson("Dave", "Davidson");
        Credit firstCredit = (Credit) originalCredit.get(0);
        Credit editedCredit = firstCredit;
        editedCredit.setFirstName("Callahan");
        dao.editCreditData(editedCredit);
        List<Credit> resultCredit = dao.getCreditsByPerson("Callahan", "Davidson");
        Credit secondCredit = (Credit) resultCredit.get(0);
        assertNotEquals("Dave", secondCredit.getFirstName());
    }

    @Test
    void deleteCreditData() {
        Credit deleteCredit = dao.getCreditsById(2);
        assertNotNull(deleteCredit);
        dao.deleteCreditData(deleteCredit);
        assertNull(dao.getCreditsById(2));
    }
}