package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Synopsis is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
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
    /**
     * No argument constructor
     */
    public Synopsis() {
    }
    /**
     * Parameterized constructor
     *
     * @param summary episode summary text
     */
    public Synopsis(String summary) {
        this.summary = summary;
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
     * summary getter
     *
     * @return value of summary
     */
    public String getSummary() {
        return summary;
    }
    /**
     * summary setter
     *
     * @param summary new value of summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
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

    // Entity Set<> managers
    /**
     * Add a Episode object to the episodes list and this Synopsis to the Episode object
     *
     * @param episode new Episode object
     */
    public void addEpisode(Episode episode) {
        episodes.add(episode);
        episode.setSynopsis(this);
    }
    /**
     * Remove a Episode object from the episodes list and dereference this Synopsis from the Episode object
     *
     * @param episode Episode object to remove
     */
    public void removeEpisode(Episode episode) {
        episodes.remove(episode);
        episode.setSynopsis(null);
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
        Synopsis synopsis = (Synopsis) o;
        return getId() == synopsis.getId() && getSummary().equals(synopsis.getSummary());
    }
    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSummary());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "Synopsis{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                '}';
    }
}
