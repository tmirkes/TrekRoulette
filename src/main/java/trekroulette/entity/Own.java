package trekroulette.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Own")
@Table(name = "own")
public class Own {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id", insertable = false, updatable = false)
    private int userId;
    @Basic
    @Column(name = "series_season_id", insertable = false, updatable = false)
    private int seriesSeasonId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;
    @ManyToOne
    @JoinColumn(name = "series_season_id", referencedColumnName = "id", nullable = false)
    private SeriesSeason seriesSeasonBySeriesSeasonId;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Own own = (Own) o;
        return id == own.id && userId == own.userId && seriesSeasonId == own.seriesSeasonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, seriesSeasonId);
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public SeriesSeason getSeriesSeasonBySeriesSeasonId() {
        return seriesSeasonBySeriesSeasonId;
    }

    public void setSeriesSeasonBySeriesSeasonId(SeriesSeason seriesSeasonBySeriesSeasonId) {
        this.seriesSeasonBySeriesSeasonId = seriesSeasonBySeriesSeasonId;
    }
}
