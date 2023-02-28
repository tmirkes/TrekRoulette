package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

/**
 * View is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
@Entity(name = "View")
@Table(name = "view")
public class View {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // *-1 associations
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false)
    private Episode episode;

    // Constructors
    /**
     * No argument constructor
     */
    public View() {
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
     * status getter
     *
     * @return Status object
     */
    public Status getStatus() {
        return status;
    }

    /**
     * status setter
     *
     * @param status new Status object
     */
    public void setStatus(Status status) {
        this.status = status;
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
     * episode getter
     *
     * @return Episode object
     */
    public Episode getEpisode() {
        return episode;
    }

    /**
     * episode setter
     *
     * @param episode new Episode object
     */
    public void setEpisode(Episode episode) {
        this.episode = episode;
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
        View view = (View) o;
        return getId() == view.getId() &&
                getStatus().equals(view.getStatus()) &&
                getUser().equals(view.getUser()) &&
                getEpisode().equals(view.getEpisode());
    }
    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), getUser(), getEpisode());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "View{" +
                "id=" + id +
                '}';
    }
}
