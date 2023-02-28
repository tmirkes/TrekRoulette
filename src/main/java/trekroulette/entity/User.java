package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * User is a POJO entity used by Hibernate for operations relating to the associated database table.
 *
 * @author tlmirkes
 */
@Entity(name = "User")
@Table(name = "user")
public class User {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "privileges")
    private String privileges;
    @Column(name = "created", insertable = false)
    private LocalDate created;
    @Column(name = "last_login", insertable = false)
    private LocalDate lastLogin;
    @Column(name = "deactivated", insertable = false)
    private LocalDate deactivated;
    @Column(name = "active", insertable = false)
    private int active;

    // 1-* associations
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Own> owns = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<View> views = new HashSet<>();

    // Constructors
    /**
     * No argument constructor
     */
    public User() {
    }
    /**
     * Parameterized constructor
     *
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email user's email
     * @param userName user's username
     * @param password user's password
     * @param privileges user's access setting
     */
    public User(String firstName, String lastName, String email, String userName, String password, String privileges) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.privileges = privileges;
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
     * email getter
     *
     * @return value of email
     */
    public String getEmail() {
        return email;
    }
    /**
     * email setter
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * userName getter
     *
     * @return value of userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * userName setter
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * password getter
     *
     * @return value of password
     */
    public String getPassword() {
        return password;
    }
    /**
     * password setter
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * privileges getter
     *
     * @return value of privileges
     */
    public String getPrivileges() {
        return privileges;
    }
    /**
     * privileges setter
     *
     * @param privileges new value of privileges
     */
    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
    /**
     * created getter
     *
     * @return value of created
     */
    public LocalDate getCreated() {
        return created;
    }
    /**
     * created setter
     *
     * @param created new value of created
     */
    public void setCreated(LocalDate created) {
        this.created = created;
    }
    /**
     * lastLogin getter
     *
     * @return value of lastLogin
     */
    public LocalDate getLastLogin() {
        return lastLogin;
    }
    /**
     * lastLogin setter
     *
     * @param lastLogin new value of lastLogin
     */
    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }
    /**
     * deactivated getter
     *
     * @return value of deactivated
     */
    public LocalDate getDeactivated() {
        return deactivated;
    }
    /**
     * deactivated setter
     *
     * @param deactivated new value of deactivated
     */
    public void setDeactivated(LocalDate deactivated) {
        this.deactivated = deactivated;
    }
    /**
     * active getter
     *
     * @return value of active
     */
    public int getActive() {
        return active;
    }
    /**
     * active setter
     *
     * @param active new value of active
     */
    public void setActive(int active) {
        this.active = active;
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
     * Add an Own object to the owns list and this user to the Own object
     *
     * @param own new Own object
     */
    public void addOwn(Own own) {
        owns.add(own);
        own.setUser(this);
    }
    /**
     * Remove an Own object from the owns list and dereference this User from the Own object
     *
     * @param own Own object to remove
     */
    public void removeOwn(Own own) {
        owns.remove(own);
        own.setUser(null);
    }
    /**
     * Add a View object to the views list and this User to the View object
     *
     * @param view new View object
     */
    public void addView(View view) {
        views.add(view);
        view.setUser(this);
    }
    /**
     * Remove a view object from the views list and dereference this user from the View object
     *
     * @param view View object to remove
     */
    public void removeView(View view) {
        views.remove(view);
        view.setUser(null);
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
        User user = (User) o;
        return getId() == user.getId() && getActive() == user.getActive() && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getEmail().equals(user.getEmail()) && getUserName().equals(user.getUserName()) && getPassword().equals(user.getPassword()) && getPrivileges().equals(user.getPrivileges()) && Objects.equals(getDeactivated(), user.getDeactivated());
    }
    /**
     * Hash comparison method
     *
     * @return integer result of hash algorithm
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getUserName(), getPassword(), getPrivileges(), getDeactivated(), getActive());
    }

    // toString()
    /**
     * Override of the toString method
     *
     * @return concatenated string of attribute values
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", privileges='" + privileges + '\'' +
                ", created=" + created +
                ", lastLogin=" + lastLogin +
                ", deactivated=" + deactivated +
                ", active=" + active +
                '}';
    }
}
