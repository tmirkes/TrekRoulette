package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * POJO representing credited role data within the Trek Roulette application
 *
 * @author tlmirkes
 * @version 1.0
 */
@Entity(name = "Possession")
@Table(name = "ownership", schema = "testing")
public class Possession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "series_season_id")
    private int seriesSeasonId;


    public Possession() { }

    public Possession(int userId, int seriesSeasonId) {
        this.userId = userId;
        this.seriesSeasonId = seriesSeasonId;
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

    @Override
    public String toString() {
        return "Possession{" +
                "userId=" + userId +
                ", seriesSeasonId=" + seriesSeasonId +
                '}';
    }
}
