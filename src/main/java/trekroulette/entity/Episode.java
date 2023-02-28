package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Episode is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
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
    /**
     * No argument constructor
     */
    public Episode() {
    }
    /**
     * Parameterized constructor
     *
     * @param title title of the episode
     */
    public Episode(String title) {
        this.title = title;
    }

    // Getters and setters
    /**
     * id getter
     *
     * @return value of id
     */
    public int getId() {
        return id;
    }
    /**
     * id setter
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * title getter
     *
     * @return value of title
     */
    public String getTitle() {
        return title;
    }
    /**
     * title setter
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * credits getter
     *
     * @return set of Credit objects
     */
    public Set<Credit> getCredits() {
        return credits;
    }
    /**
     * credits setter
     *
     * @param credits new set of Credit objects
     */
    public void setCredits(Set<Credit> credits) {
        this.credits = credits;
    }
    /**
     * views getter
     *
     * @return set of View objects
     */
    public Set<View> getViews() {
        return views;
    }
    /**
     * views setter
     *
     * @param views new set of View objects
     */
    public void setViews(Set<View> views) {
        this.views = views;
    }
    /**
     * synopsis getter
     *
     * @return Synopsis object
     */
    public Synopsis getSynopsis() {
        return synopsis;
    }
    /**
     * synopsis setter
     *
     * @param synopsis new Synopsis object
     */
    public void setSynopsis(Synopsis synopsis) {
        this.synopsis = synopsis;
    }
    /**
     * seriesSeason getter
     *
     * @return SeriesSeason object
     */
    public SeriesSeason getSeriesSeason() {
        return seriesSeason;
    }
    /**
     * seriesSeason setter
     *
     * @param seriesSeason new SeriesSeason object
     */
    public void setSeriesSeason(SeriesSeason seriesSeason) {
        this.seriesSeason = seriesSeason;
    }

    // Entity Set<> managers
    /**
     * Add a Credit object to the credits list and this Episode to the Credit object
     *
     * @param credit
     */
    public void addCredits(Credit credit) {
        credits.add(credit);
        credit.setEpisode(this);
    }
    /**
     * Remove a Credit object from the credits list and dereference this Episode from the Credit object
     *
     * @param credit
     */
    public void removeCredit(Credit credit) {
        credits.remove(credit);
        credit.setEpisode(null);
    }
    /**
     * Add a View object to the views list and this Episode to the View object
     *
     * @param view
     */
    public void addView(View view) {
        views.add(view);
        view.setEpisode(this);
    }
    /**
     * Remove a View object from the views list and dereference this Episode from the View object
     *
     * @param view
     */
    public void removeView(View view) {
        views.remove(view);
        view.setEpisode(null);
    }
    
    // equals() and hashCode() methods
    /**
     * Override of equals method for use in object comparison
     *
     * @param o object to be compared
     * @return comparison result boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode = (Episode) o;
        return getId() == episode.getId() && getTitle().equals(episode.getTitle()) && getSynopsis().equals(episode.getSynopsis()) && getSeriesSeason().equals(episode.getSeriesSeason());
    }
    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getSynopsis(), getSeriesSeason());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
