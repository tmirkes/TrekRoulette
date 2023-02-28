package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * SeriesSeason is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
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
    /**
     * No argument constructor
     */
    public SeriesSeason() {
    }

    /**
     * Parameterized constructor
     *
     * @param seriesName name of the series
     * @param season season number
     */
    public SeriesSeason(String seriesName, int season) {
        this.seriesName = seriesName;
        this.season = season;
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
     * @param id new id value
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * seriesName getter
     *
     * @return value of seriesName
     */
    public String getSeriesName() {
        return seriesName;
    }
    /**
     * seriesName setter
     *
     * @param seriesName new seriesName value
     */
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
    /**
     * season getter
     *
     * @return value of season
     */
    public int getSeason() {
        return season;
    }
    /**
     * season setter
     *
     * @param season new value of season
     */
    public void setSeason(int season) {
        this.season = season;
    }
    /**
     * episodes getter
     *
     * @return set of Episode objects
     */
    public Set<Episode> getEpisodes() {
        return episodes;
    }
    /**
     * episodes setter
     *
     * @param episodes new set of Episode objects
     */
    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }
    /**
     * owns getter
     *
     * @return set of Own objects
     */
    public Set<Own> getOwns() {
        return owns;
    }
    /**
     * owns setter
     *
     * @param owns new set of Own objects
     */
    public void setOwns(Set<Own> owns) {
        this.owns = owns;
    }

    // Entity Set<> managers
    /**
     * Add an Episode object to the episodes list and this SeriesSeason to the Episode object
     *
     * @param episode new Episode object
     */
    public void addEpisode(Episode episode) {
        episodes.add(episode);
        episode.setSeriesSeason(this);
    }
    /**
     * Remove an Episode object from the episodes list and dereference this SeriesSeason from the Episode object
     *
     * @param episode Episode object to remove
     */
    public void removeNoun(Episode episode) {
        episodes.remove(episode);
        episode.setSeriesSeason(null);
    }
    /**
     * Add an Own object to the owns list and this SeriesSeason to the Own object
     *
     * @param own new Own object
     */
    public void addOwn(Own own) {
        owns.add(own);
        own.setSeriesSeason(this);
    }
    /**
     * Remove an Own object from the owns list and dereference this SeriesSeason from the Own object
     *
     * @param own Own object to remove
     */
    public void removeOwn(Own own) {
        owns.remove(own);
        own.setSeriesSeason(null);
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
        SeriesSeason that = (SeriesSeason) o;
        return getId() == that.getId() && getSeason() == that.getSeason() && getSeriesName().equals(that.getSeriesName());
    }

    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSeriesName(), getSeason());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "SeriesSeason{" +
                "id=" + id +
                ", seriesName='" + seriesName + '\'' +
                ", season=" + season +
                '}';
    }
}
