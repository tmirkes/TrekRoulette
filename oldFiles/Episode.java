package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * POJO representing episode data within the Trek Roulette application
 *
 * @author tlmirkes
 * @version 1.0
 */
@Entity(name = "Episode")
@Table(name = "episode", schema = "testing")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "ep_title")
    private String epTitle;
    @Column(name = "series_season_id")
    private int seriesSeasonId;

    /**
     * Constructor accepting no arguments
     */
    public Episode() {}

    /**
     * Constructor accepting arguments for instance variables
     *
     * @param epTitle User's first name
     * @param seriesSeasonId User's last name
     */
    public Episode(String epTitle, int seriesSeasonId) {
        this.epTitle = epTitle;
        this.seriesSeasonId = seriesSeasonId;
    }

    /**
     * id getter
     *
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * epTitle getter
     *
     * @return value of epTitle
     */
    public String getEpTitle() {
        return epTitle;
    }

    /**
     * epTitle setter
     *
     * @param epTitle title of episode
     */
    public void setEpTitle(String epTitle) {
        this.epTitle = epTitle;
    }

    /**
     * seriesSeasonId getter
     *
     * @return value of seriesSeasonId
     */
    public int getSeriesSeasonId() {
        return seriesSeasonId;
    }

    /**
     * seriesSeasonId setter
     *
     * @param seriesSeasonId series_season id value from series_season table
     */
    public void setSeriesSeasonId(int seriesSeasonId) {
        this.seriesSeasonId = seriesSeasonId;
    }

    /**
     * Print current value of instance variables to console
     */
    public String toString() {
        return "id: " + this.id +
                "\nepTitle: " + this.epTitle +
                "\nseriesSeasonId: " + this.seriesSeasonId;
    }
}
