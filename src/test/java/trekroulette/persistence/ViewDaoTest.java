package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.*;
import trekroulette.test.util.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ViewDaoTest {
    GenericDao<View> testingDao;
    GenericDao<User> userTestingDao;
    GenericDao<Episode> episodeTestingDao;
    GenericDao<Status> statusTestingDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        testingDao = new GenericDao(View.class);
        userTestingDao = new GenericDao(User.class);
        episodeTestingDao = new GenericDao(Episode.class);
        statusTestingDao = new GenericDao(Status.class);
        Database database = Database.getInstance();
        database.runSQL("cleandbtestdata.sql");
    }

    @Test
    void getViewsById() {
        View testView = (View)testingDao.getById(1);
        assertNotNull(testView);
        assertEquals(testView, testingDao.getById(1));
    }

    @Test
    void getAllViews() {
        List<View> viewList = testingDao.getAll();
        assertNotNull(viewList);
        assertEquals(viewList, testingDao.getAll());
    }

    @Test
    void addViewWithUserStatusAndEpisode() {
        User existingUser = (User)userTestingDao.getById(1);
        assertNotNull(existingUser);
        assertEquals(existingUser,(User)userTestingDao.getById(1));

        Episode existingEpisode = (Episode)episodeTestingDao.getById(2);
        assertNotNull(existingEpisode);
        assertEquals(existingEpisode,(Episode)episodeTestingDao.getById(2));

        Status existingStatus = (Status)statusTestingDao.getById(3);
        assertNotNull(existingStatus);
        assertEquals(existingStatus,(Status)statusTestingDao.getById(3));

        View newView = new View();
        newView.setUser(existingUser);
        newView.setEpisode(existingEpisode);
        newView.setStatus(existingStatus);
        existingUser.addView(newView);
        existingEpisode.addView(newView);
        existingStatus.addView(newView);

        int id = testingDao.addEntity(newView);
        View insertedView = (View)testingDao.getById(id);
        assertNotNull(insertedView);
        assertEquals(newView, insertedView);
        assertEquals(existingUser, insertedView.getUser());
        assertEquals(existingEpisode, insertedView.getEpisode());
        assertEquals(existingStatus, insertedView.getStatus());
    }

    @Test
    void editExistingView() {
        View original = (View)testingDao.getById(1);

        View testView = (View)testingDao.getById(1);
        assertNotNull(testView);
        assertEquals(testView,(View)testingDao.getById(1));

        Status updateStatus = (Status)statusTestingDao.getById(2);
        assertNotNull(testView);
        assertEquals(updateStatus,(Status)statusTestingDao.getById(2));

        testView.setStatus(updateStatus);
        assertNotEquals(original,testView);
        testingDao.editEntity(testView);
        assertEquals(testView,(View)testingDao.getById(1));
        assertNotEquals(original,(View)testingDao.getById(1));
    }

    @Test
    void deleteView() {
        View testView = (View)testingDao.getById(3);
        assertNotNull(testView);
        testingDao.deleteEntity(testView);
        assertNull(testingDao.getById(3));
    }
}