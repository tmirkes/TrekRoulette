package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "SeriesSeason")
@Table(name = "series_season")
public class SeriesSeason {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "series_name")
    private String seriesName;
    private int season;

    // 1-* associations
    @OneToMany(mappedBy = "seriesSeason", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Episode> episodes = new HashSet<>();
    @OneToMany(mappedBy = "seriesSeason", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Own> owns = new HashSet<>();

    // Constructors
    public SeriesSeason() {
    }

    public SeriesSeason(String seriesName, int season) {
        this.seriesName = seriesName;
        this.season = season;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    public Set<Own> getOwns() {
        return owns;
    }

    public void setOwns(Set<Own> owns) {
        this.owns = owns;
    }

    // Entity Set<> managers
    public void addEpisode(Episode episode) {
        episodes.add(episode);
        episode.setSeriesSeason(this);
    }

    public void removeNoun(Episode episode) {
        episodes.remove(episode);
        episode.setSeriesSeason(null);
    }

    public void addOwn(Own own) {
        owns.add(own);
        own.setSeriesSeason(this);
    }

    public void removeOwn(Own own) {
        owns.remove(own);
        own.setSeriesSeason(null);
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesSeason that = (SeriesSeason) o;
        return getId() == that.getId() && getSeason() == that.getSeason() && getSeriesName().equals(that.getSeriesName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSeriesName(), getSeason());
    }

    // toString()
    @Override
    public String toString() {
        return "SeriesSeason{" +
                "id=" + id +
                ", seriesName='" + seriesName + '\'' +
                ", season=" + season +
                '}';
    }
}
