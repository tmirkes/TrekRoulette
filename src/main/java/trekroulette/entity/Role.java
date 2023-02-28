package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Role is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "role_name")
    private String roleName;

    // 1-* associations
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Credit> credits = new HashSet<>();

    // Constructors
    /**
     * No argument constructor
     */
    public Role() {
    }
    /**
     * Parameterized constructor
     *
     * @param roleName credited title of the role
     */
    public Role(String roleName) {
        this.roleName = roleName;
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
     * roleName getter
     *
     * @return value of roleName
     */
    public String getRoleName() {
        return roleName;
    }
    /**
     * roleName setter
     * @param roleName new value of roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    // Entity Set<> managers
    /**
     * Add a Credit object to the credits list and this user to the Credit object
     *
     * @param credit new Credit object
     */
    public void addCredit(Credit credit) {
        credits.add(credit);
        credit.setRole(this);
    }
    /**
     * Remove a Credit object from the credits list and dereference this Role from the Credit object
     *
     * @param credit
     */
    public void removeCredit(Credit credit) {
        credits.remove(credit);
        credit.setRole(null);
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
        Role role = (Role) o;
        return getId() == role.getId() && getRoleName().equals(role.getRoleName());
    }
    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoleName());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
