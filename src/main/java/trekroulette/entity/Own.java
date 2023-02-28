package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

/**
 * Own is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
@Entity(name = "Own")
@Table(name = "own")
public class Own {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // *-1 associations
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "series_season_id", referencedColumnName = "id", nullable = false)
    private SeriesSeason seriesSeason;

    // Constructors
    /**
     * No argument constructor
     */
    public Own() {
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
     * user getter
     *
     * @return User object
     */
    public User getUser() {
        return user;
    }
    /**
     * user setter
     *
     * @param user new User object
     */
    public void setUser(User user) {
        this.user = user;
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
        Own own = (Own) o;
        return getId() == own.getId() &&
                getUser().equals(own.getUser()) &&
                getSeriesSeason().equals(own.getSeriesSeason());
    }
    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getSeriesSeason());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "Own{" +
                "id=" + id +
                '}';
    }
}
