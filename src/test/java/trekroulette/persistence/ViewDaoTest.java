package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trekroulette.entity.View;
import trekroulette.test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewDaoTest {
    ViewDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        database.runSQL("cleandbseries.sql");
        database.runSQL("cleandbepisode.sql");
        database.runSQL("cleandbstatus.sql");
        database.runSQL("cleandbview.sql");
        dao = new ViewDao();
    }

    @Test
    void getViewByID() {
        View result = dao.getViewById(1);
        assertNotNull(result);
        assertEquals(1, result.getUserId());
        assertEquals(3, result.getSeriesSeasonId());
        assertEquals(1, result.getEpisodeId());
        assertEquals(1, result.getStatusId());
    }

    @Test
    void getViewByUserId() {
        List<View> result = dao.getViewByUserId(1);
        View firstResult = result.get(0);
        assertEquals(1, firstResult.getUserId());
    }

    @Test
    void getViewBySeriesSeasonId() {
        List<View> result = dao.getViewBySeriesSeasonId(1);
        View firstResult = result.get(0);
        assertEquals(1, firstResult.getSeriesSeasonId());
    }

    @Test
    void getViewByEpisodeId() {
        List<View> result = dao.getViewByEpisodeId(1);
        View firstResult = result.get(0);
        assertEquals(1, firstResult.getEpisodeId());
    }

    @Test
    void getViewByStatusId() {
        List<View> result = dao.getViewByStatusId(1);
        View firstResult = result.get(0);
        assertEquals(1, firstResult.getStatusId());
    }

    @Test
    void addNewView() {
        View testView = new View(1,2,3,4);
        int addId = dao.addNewView(testView);
        assertNotEquals(0, addId);
        View viewFound = dao.getViewById(addId);
        assertNotNull(viewFound);
        assertEquals(1, viewFound.getUserId());
        assertEquals(2, viewFound.getSeriesSeasonId());
        assertEquals(3, viewFound.getEpisodeId());
        assertEquals(4, viewFound.getStatusId());
    }

    @Test
    void editViewData() {
        View originalView = dao.getViewById(4);
        View editedView = originalView;
        editedView.setStatusId(1);
        dao.editViewData(editedView);
        View finalView = dao.getViewById(4);
        assertNotNull(finalView);
        assertEquals(1, finalView.getStatusId());
    }

    @Test
    void deleteViewData() {
        View deleteView = dao.getViewById(3);
        assertNotNull(deleteView);
        dao.deleteViewData(deleteView);
        assertNull(dao.getViewById(3));
    }
}