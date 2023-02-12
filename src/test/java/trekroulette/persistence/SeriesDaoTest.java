package trekroulette.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trekroulette.entity.Episode;
import trekroulette.entity.Series;
import trekroulette.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeriesDaoTest {

    SeriesDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandbseries.sql");
        dao = new SeriesDao();
    }

    @Test
    void getSeriesByNameAndSeasonSuccess() {
        Series result = dao.getSeriesBySeriesNameAndSeason("Third", 3);
        assertEquals("Third", result.getSeriesName());
        assertEquals(3, result.getSeason());
    }

    @Test
    void addUserToDatabaseSuccess() {
        Series testSeries = new Series("Fourth",1);
        int id = dao.addNewSeries(testSeries);
        assertNotEquals(0, id);
        Series seriesFound = dao.getSeriesBySeriesNameAndSeason("Fourth",1);
        assertEquals("Fourth", seriesFound.getSeriesName());
        assertEquals(1, seriesFound.getSeason());
    }

    @Test
    void editSeriesAndSeasonDataSuccess() {
        Series originalSeries = dao.getSeriesBySeriesNameAndSeason("First",2);
        Series editedSeries = originalSeries;
        editedSeries.setSeriesName("WACKY");
        dao.editSeriesData(editedSeries);
        Series resultSeries = dao.getSeriesBySeriesNameAndSeason("WACKY",1);
        assertNotEquals(originalSeries, resultSeries);
    }
}