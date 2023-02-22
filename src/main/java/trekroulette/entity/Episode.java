package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Episode")
@Table(name = "episode")
public class Episode {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String title;

    // 1-* associations
    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Credit> credits = new HashSet<>();
    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<View> views = new HashSet<>();

    // *-1 associations
    @ManyToOne
    @JoinColumn(name = "synopsis_id", referencedColumnName = "id", nullable = false)
    private Synopsis synopsis;
    @ManyToOne
    @JoinColumn(name = "series_season_id", referencedColumnName = "id", nullable = false)
    private SeriesSeason seriesSeason;

    // Constructors
    public Episode() {
    }

    public Episode(String title) {
        this.title = title;
    }

    // Getters and setters
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

    public Set<Credit> getCredits() {
        return credits;
    }

    public void setCredits(Set<Credit> credits) {
        this.credits = credits;
    }

    public Set<View> getViews() {
        return views;
    }

    public void setViews(Set<View> views) {
        this.views = views;
    }

    public Synopsis getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(Synopsis synopsis) {
        this.synopsis = synopsis;
    }

    public SeriesSeason getSeriesSeason() {
        return seriesSeason;
    }

    public void setSeriesSeason(SeriesSeason seriesSeason) {
        this.seriesSeason = seriesSeason;
    }

    // Entity Set<> managers
    public void addCredits(Credit credit) {
        credits.add(credit);
        credit.setEpisode(this);
    }

    public void removeCredit(Credit credit) {
        credits.remove(credit);
        credit.setEpisode(null);
    }
    
    public void addView(View view) {
        views.add(view);
        view.setEpisode(this);
    }

    public void removeView(View view) {
        views.remove(view);
        view.setEpisode(null);
    }
    
    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode = (Episode) o;
        return getId() == episode.getId() && getTitle().equals(episode.getTitle()) && getSynopsis().equals(episode.getSynopsis()) && getSeriesSeason().equals(episode.getSeriesSeason());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getSynopsis(), getSeriesSeason());
    }

    // toString()
    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
