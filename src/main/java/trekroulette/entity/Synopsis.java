package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Synopsis")
@Table(name = "synopsis")
public class Synopsis {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String summary;

    // 1-* associations
    @OneToMany(mappedBy = "synopsis", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Episode> episodes = new HashSet<>();

    // Constructors
    public Synopsis() {
    }

    public Synopsis(String summary) {
        this.summary = summary;
    }

    // Getters and setters
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

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    // Entity Set<> managers
    public void addEpisode(Episode episode) {
        episodes.add(episode);
        episode.setSynopsis(this);
    }

    public void removeEpisode(Episode episode) {
        episodes.remove(episode);
        episode.setSynopsis(null);
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Synopsis synopsis = (Synopsis) o;
        return getId() == synopsis.getId() && getSummary().equals(synopsis.getSummary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSummary());
    }

    // toString()
    @Override
    public String toString() {
        return "Synopsis{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                '}';
    }
}
