package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CreditDaoTest {
    /**
    GenericDao<Credit> testingDao;
    GenericDao<Role> roleTestingDao;
    GenericDao<Person> personTestingDao;
    GenericDao<Episode> episodeTestingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        testingDao = new GenericDao(Credit.class);
        roleTestingDao = new GenericDao(Role.class);
        personTestingDao = new GenericDao(Person.class);
        episodeTestingDao = new GenericDao(Episode.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getCreditsById() {
        Credit testCredit = (Credit)testingDao.getById(1);
        assertNotNull(testCredit);
        assertEquals(testCredit, testingDao.getById(1));
    }

    @Test
    void getAllCredits() {
        List<Credit> creditList = testingDao.getAll();
        assertNotNull(creditList);
        assertEquals(creditList, testingDao.getAll());
    }

    @Test
    void addCreditWithRolePersonAndEpisode() {
        Person existingPerson = (Person)personTestingDao.getById(1);
        assertNotNull(existingPerson);
        assertEquals(existingPerson,(Person)personTestingDao.getById(1));

        Role existingRole = (Role)roleTestingDao.getById(2);
        assertNotNull(existingPerson);
        assertEquals(existingRole,(Role)roleTestingDao.getById(2));

        Episode existingEpisode = (Episode)episodeTestingDao.getById(3);
        assertNotNull(existingEpisode);
        assertEquals(existingEpisode,(Episode)episodeTestingDao.getById(3));

        Credit newCredit = new Credit();
        newCredit.setPerson(existingPerson);
        newCredit.setRole(existingRole);
        newCredit.setEpisode(existingEpisode);
        existingPerson.addCredit(newCredit);
        existingRole.addCredit(newCredit);
        existingEpisode.addCredits(newCredit);
        int id = testingDao.addEntity(newCredit);
        Credit insertedCredit = (Credit)testingDao.getById(id);
        assertNotNull(insertedCredit);
        assertEquals(newCredit, insertedCredit);
        assertEquals(existingPerson, insertedCredit.getPerson());
        assertEquals(existingRole, insertedCredit.getRole());
        assertEquals(existingEpisode, insertedCredit.getEpisode());
    }

    @Test
    void editExistingCredit() {
        Credit original = (Credit)testingDao.getById(3);

        Credit testCredit = (Credit)testingDao.getById(3);
        assertNotNull(testCredit);
        assertEquals(testCredit,(Credit)testingDao.getById(3));

        Person personUpdate = (Person)personTestingDao.getById(4);
        assertNotNull(personUpdate);
        assertEquals(personUpdate,(Person)personTestingDao.getById(4));

        testCredit.setPerson(personUpdate);
        assertNotEquals(original,testCredit);
        testingDao.editEntity(testCredit);
        assertEquals(testCredit,(Credit)testingDao.getById(3));
        assertNotEquals(original,(Credit)testingDao.getById(3));
    }

    @Test
    void deleteCredit() {
        Credit testCredit = (Credit)testingDao.getById(1);
        assertNotNull(testCredit);
        testingDao.deleteEntity(testCredit);
        assertNull(testingDao.getById(1));
    }**/
}