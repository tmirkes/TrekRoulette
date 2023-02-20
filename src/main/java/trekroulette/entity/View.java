package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "View")
@Table(name = "view")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;
    @Column(name = "status_id", insertable = false, updatable = false)
    private int statusId;
    @Column(name = "user_id", insertable = false, updatable = false)
    private int userId;
    @Column(name = "episode_id", insertable = false, updatable = false)
    private int episodeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private Status statusByStatusId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false)
    private Episode episodeByEpisodeId;

    public View() {
    }

    public View(int statusId, int userId, int episodeId) {
        this.statusId = statusId;
        this.userId = userId;
        this.episodeId = episodeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        View view = (View) o;
        return id == view.id && statusId == view.statusId && userId == view.userId && episodeId == view.episodeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusId, userId, episodeId);
    }

    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Episode getEpisodeByEpisodeId() {
        return episodeByEpisodeId;
    }

    public void setEpisodeByEpisodeId(Episode episodeByEpisodeId) {
        this.episodeByEpisodeId = episodeByEpisodeId;
    }

    @Override
    public String toString() {
        return "View{" +
                "id=" + id +
                ", statusId=" + statusId +
                ", userId=" + userId +
                ", episodeId=" + episodeId +
                ", statusByStatusId=" + statusByStatusId +
                ", userByUserId=" + userByUserId +
                ", episodeByEpisodeId=" + episodeByEpisodeId +
                '}';
    }
}
