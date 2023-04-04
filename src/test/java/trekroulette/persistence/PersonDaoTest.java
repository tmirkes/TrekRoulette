package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PersonDaoTest {
    /**
    GenericDao<Person> testingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        testingDao = new GenericDao(Person.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getPersonsById() {
        Person testPerson = (Person)testingDao.getById(1);
        assertNotNull(testPerson);
        assertEquals(testPerson, testingDao.getById(1));
    }

    @Test
    void getByPropertyEqual() {
        List<Person> personList = testingDao.getByPropertyEqual("firstName", "Alice");
        assertNotNull(personList);
        assertEquals(1, personList.size());
        Person resultPerson = (Person)personList.get(0);
        assertNotNull(resultPerson);
        assertEquals(personList, testingDao.getByPropertyEqual("firstName", "Alice"));
        assertEquals(resultPerson, personList.get(0));
    }

    @Test
    void getByPropertyLike() {
        List<Person> personList = testingDao.getByPropertyLike("firstName", "al");
        assertNotNull(personList);
        assertEquals(2, personList.size());
        Person resultPerson = (Person)personList.get(0);
        assertNotNull(resultPerson);
        assertEquals(resultPerson, personList.get(0));
    }

    @Test
    void getAllPersons() {
        List<Person> personList = testingDao.getAll();
        assertNotNull(personList);
        assertEquals(personList, testingDao.getAll());
    }

    @Test
    void addPerson() {
        Person testPerson = new Person("Jerry","Ryann");
        assertNotNull(testPerson);
        int id = (int)testingDao.addEntity(testPerson);
        assertNotEquals(0, id);
        Person newPerson = (Person)testingDao.getById(id);
        assertNotNull(testPerson);
        assertNotNull(newPerson);
        assertEquals(testPerson, newPerson);
    }

    @Test
    void editExistingPerson() {
        Person original = (Person)testingDao.getById(4);
        Person testPerson = (Person)testingDao.getById(4);
        assertNotNull(testPerson);
        assertEquals(testPerson,(Person)testingDao.getById(4));
        testPerson.setFirstName("Barry");
        assertNotEquals(original,testPerson);
        testingDao.editEntity(testPerson);
        assertEquals(testPerson,(Person)testingDao.getById(4));
        assertNotEquals(original,(Person)testingDao.getById(4));
    }

    @Test
    void deletePerson() {
        Person testPerson = (Person)testingDao.getById(3);
        assertNotNull(testPerson);
        testingDao.deleteEntity(testPerson);
        assertNull(testingDao.getById(3));
    }**/
}