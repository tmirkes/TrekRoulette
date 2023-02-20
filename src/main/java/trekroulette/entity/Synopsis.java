package trekroulette.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity(name = "Synopsis")
@Table(name = "synopsis")
public class Synopsis {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "summary")
    private String summary;
    @OneToMany(mappedBy = "synopsisBySynopsisId")
    private Collection<Episode> episodesById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Synopsis synopsis = (Synopsis) o;
        return id == synopsis.id && Objects.equals(summary, synopsis.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, summary);
    }

    public Collection<Episode> getEpisodesById() {
        return episodesById;
    }

    public void setEpisodesById(Collection<Episode> episodesById) {
        this.episodesById = episodesById;
    }
}
