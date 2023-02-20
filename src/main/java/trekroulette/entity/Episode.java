package trekroulette.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity(name = "Episode")
@Table(name = "episode")
public class Episode {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "synopsis_id", insertable = false, updatable = false)
    private int synopsisId;
    @Basic
    @Column(name = "series_season_id", insertable = false, updatable = false)
    private int seriesSeasonId;
    @OneToMany(mappedBy = "episodeByEpisodeId")
    private Collection<Credit> creditsById;
    @ManyToOne
    @JoinColumn(name = "synopsis_id", referencedColumnName = "id", nullable = false)
    private Synopsis synopsisBySynopsisId;
    @ManyToOne
    @JoinColumn(name = "series_season_id", referencedColumnName = "id", nullable = false)
    private SeriesSeason seriesSeasonBySeriesSeasonId;
    @OneToMany(mappedBy = "episodeByEpisodeId")
    private Collection<View> viewsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSynopsisId() {
        return synopsisId;
    }

    public void setSynopsisId(int synopsisId) {
        this.synopsisId = synopsisId;
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
        Episode episode = (Episode) o;
        return id == episode.id && synopsisId == episode.synopsisId && seriesSeasonId == episode.seriesSeasonId && Objects.equals(title, episode.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, synopsisId, seriesSeasonId);
    }

    public Collection<Credit> getCreditsById() {
        return creditsById;
    }

    public void setCreditsById(Collection<Credit> creditsById) {
        this.creditsById = creditsById;
    }

    public Synopsis getSynopsisBySynopsisId() {
        return synopsisBySynopsisId;
    }

    public void setSynopsisBySynopsisId(Synopsis synopsisBySynopsisId) {
        this.synopsisBySynopsisId = synopsisBySynopsisId;
    }

    public SeriesSeason getSeriesSeasonBySeriesSeasonId() {
        return seriesSeasonBySeriesSeasonId;
    }

    public void setSeriesSeasonBySeriesSeasonId(SeriesSeason seriesSeasonBySeriesSeasonId) {
        this.seriesSeasonBySeriesSeasonId = seriesSeasonBySeriesSeasonId;
    }

    public Collection<View> getViewsById() {
        return viewsById;
    }

    public void setViewsById(Collection<View> viewsById) {
        this.viewsById = viewsById;
    }
}
