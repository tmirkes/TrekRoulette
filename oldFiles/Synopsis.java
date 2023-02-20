package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * POJO representing synopsis data within the Trek Roulette application
 *
 * @author tlmirkes
 * @version 1.0
 */
@Entity(name = "Synopsis")
@Table(name = "synopsis", schema = "testing")
public class Synopsis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String summary;
    @Column(name = "episode_id")
    private int episodeId;


    public Synopsis() {
    }

    public Synopsis(String summary, int episodeId) {
        this.summary = summary;
        this.episodeId = episodeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    @Override
    public String toString() {
        return "Synopsis{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", episodeId=" + episodeId +
                '}';
    }
}
