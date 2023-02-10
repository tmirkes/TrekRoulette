package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * POJO representing episode data within the Trek Roulette application
 *
 * @author tlmirkes
 * @version 1.0
 */
@Entity(name = "Episode")
@Table(name = "episode")
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
     * @param epTitle User's first name
     * @param seriesSeasonId User's last name
     */
    public Episode(String epTitle, int seriesSeasonId) {
        this.epTitle = epTitle;
        this.seriesSeasonId = seriesSeasonId;
    }

    public int getId() {
        return id;
    }

    public String getEpTitle() {
        return epTitle;
    }

    public void setEpTitle(String epTitle) {
        this.epTitle = epTitle;
    }

    public int getSeriesSeasonId() {
        return seriesSeasonId;
    }

    public void setSeriesSeasonId(int seriesSeasonId) {
        this.seriesSeasonId = seriesSeasonId;
    }

    /**
     * Print current value of instance variables to console
     */
    public String toString() {
        String printer = "id: " + this.id +
                "\nepTitle: " + this.epTitle +
                "\nseriesSeasonId: " + this.seriesSeasonId;
        return printer;
    }
}
