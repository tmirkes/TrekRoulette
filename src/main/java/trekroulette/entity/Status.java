package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Status is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
@Entity(name = "Status")
@Table(name = "status")
public class Status {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "status")
    private String status;

    // 1-* associations
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<View> views = new HashSet<>();

    // Constructors
    /**
     * No argument constructor
     */
    public Status() {
    }
    /**
     * Parameterized constructor
     *
     * @param status status message
     */
    public Status(String status) {
        this.status = status;
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
     * @return value of status
     */
    public String getStatus() {
        return status;
    }
    /**
     * status setter
     *
     * @param status new value of status
     */
    public void setStatus(String status) {
        this.status = status;
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

    // Entity Set<> managers
    /**
     * Add a View object to the views list and this Status to the View object
     *
     * @param view new View object
     */
    public void addView(View view) {
        views.add(view);
        view.setStatus(this);
    }
    /**
     * Remove a View object from the views list and dereference this Status from the View object
     *
     * @param view View object to remove
     */
    public void removeView(View view) {
        views.remove(view);
        view.setStatus(null);
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
        Status status1 = (Status) o;
        return getId() == status1.getId() && getStatus().equals(status1.getStatus());
    }
    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
