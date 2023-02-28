package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Person is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
@Entity(name = "Person")
@Table(name = "person")
public class Person {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    // 1-* associations
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Credit> credits = new HashSet<>();

    // Constructors
    /**
     * No argument constructor
     */
    public Person() {
    }
    /**
     * Parameterized constructor
     *
     * @param firstName credited first name
     * @param lastName credited last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
     * firstName getter
     *
     * @return value of firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * firstName setter
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * lastName getter
     *
     * @return value of lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * lastName setter
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * Add a Credit object to the credits list and this Person to the Credit object
     *
     * @param credit new Credit object
     */
    public void addCredit(Credit credit) {
        credits.add(credit);
        credit.setPerson(this);
    }
    /**
     * Remove a Credit object from the credits list and dereference this Person from the Credit object
     *
     * @param credit Credit object to remove
     */
    public void removeCredit(Credit credit) {
        credits.remove(credit);
        credit.setPerson(null);
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
        Person person = (Person) o;
        return getId() == person.getId() && getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName());
    }
    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
