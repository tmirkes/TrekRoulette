package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

/**
 * Credit is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
@Entity(name = "Credit")
@Table(name = "credit")
public class Credit {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // *-1 associations
    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false)
    private Episode episode;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private Person person;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    // Constructors
    /**
     * No argument constructor
     */
    public Credit() {
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
    /**
     * person getter
     *
     * @return Person object
     */
    public Person getPerson() {
        return person;
    }
    /**
     * person setter
     *
     * @param person new Person object
     */
    public void setPerson(Person person) {
        this.person = person;
    }
    /**
     * role getter
     *
     * @return Role object
     */
    public Role getRole() {
        return role;
    }
    /**
     * role setter
     *
     * @param role new Role object
     */
    public void setRole(Role role) {
        this.role = role;
    }

    // equals() and hashCode() methods
    /**
     * Override of equals method for use in object comparison
     *
     * @param o object to be compared
     * @return comparison result boolean
     */    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return getId() == credit.getId() && getEpisode().equals(credit.getEpisode()) && getPerson().equals(credit.getPerson()) && getRole().equals(credit.getRole());
    }
    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEpisode(), getPerson(), getRole());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                '}';
    }
}
