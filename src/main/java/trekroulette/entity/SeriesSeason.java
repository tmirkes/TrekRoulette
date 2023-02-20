package trekroulette.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity(name = "SeriesSeason")
@Table(name = "series_season")
public class SeriesSeason {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "series_name")
    private String seriesName;
    @Basic
    @Column(name = "season")
    private int season;
    @OneToMany(mappedBy = "seriesSeasonBySeriesSeasonId")
    private Collection<Episode> episodesById;
    @OneToMany(mappedBy = "seriesSeasonBySeriesSeasonId")
    private Collection<Own> ownsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesSeason that = (SeriesSeason) o;
        return id == that.id && season == that.season && Objects.equals(seriesName, that.seriesName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seriesName, season);
    }

    public Collection<Episode> getEpisodesById() {
        return episodesById;
    }

    public void setEpisodesById(Collection<Episode> episodesById) {
        this.episodesById = episodesById;
    }

    public Collection<Own> getOwnsById() {
        return ownsById;
    }

    public void setOwnsById(Collection<Own> ownsById) {
        this.ownsById = ownsById;
    }
}
