package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * POJO representing credited role data within the Trek Roulette application
 *
 * @author tlmirkes
 * @version 1.0
 */
@Entity(name = "View")
@Table(name = "viewing", schema = "testing")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "series_season_id")
    private int seriesSeasonId;
    @Column(name = "episode_id")
    private int episodeId;
    @Column(name = "status_id")
    private int statusId;

    public View() { }

    public View(int userId, int seriesSeasonId, int episodeId, int statusId) {
        this.userId = userId;
        this.seriesSeasonId = seriesSeasonId;
        this.episodeId = episodeId;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSeriesSeasonId() {
        return seriesSeasonId;
    }

    public void setSeriesSeasonId(int seriesSeasonId) {
        this.seriesSeasonId = seriesSeasonId;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "View{" +
                "userId=" + userId +
                ", seriesSeasonId=" + seriesSeasonId +
                ", episodeId=" + episodeId +
                ", statusId=" + statusId +
                '}';
    }
}
