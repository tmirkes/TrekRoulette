package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * POJO representing series data within the Trek Roulette application
 *
 * @author tlmirkes
 * @version 1.0
 */
@Entity(name = "Series")
@Table(name = "series_season")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "series_name")
    private String seriesName;
    @Column(name = "season")
    private int season;

    /**
     * Constructor accepting no arguments
     */
    public Series() {}

    /**
     * Constructor accepting arguments for instance variables
     * @param seriesName name of series
     * @param season series season
     */
    public Series(String seriesName, int season) {
        this.seriesName = seriesName;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    /**
     * Print current value of instance variables to console
     */
    public String toString() {
        String printer = "id: " + this.id +
                "\nseriesName: " + this.seriesName +
                "\nseason: " + this.season;
        return printer;
    }
}
