package trekroulette.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * POJO representing user data within the Trek Roulette application
 *
 * @author tlmirkes
 * @version 1.0
 */
@Entity(name = "User")
@Table(name = "user", schema = "testing")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private String privileges;
    @Column(name = "created", insertable = false)
    private LocalDate created;
    @Column(name = "last_login", insertable = false)
    private LocalDate lastLogin;
    @Column(name = "deactivated", insertable = false)
    private LocalDate deactivated;
    @Column(name = "active", insertable = false)
    private int active;

    /**
     * Constructor accepting no arguments
     */
    public User() {}

    /**
     * Constructor accepting arguments for instance variables
     *
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email user's email address
     * @param userName user's user name
     * @param password user's password
     * @param privileges user's access level
     */
    public User(String firstName, String lastName, String email, String userName, String password, String privileges) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.privileges = privileges;
    }

    /**
     * id getter
     *
     * @return value of id
     */
    public int getId() {
        return id;
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
     * @param firstName user's first name
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
     * @param lastName user's last name
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
     * @param email user's email address
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
     * @param userName user's user name
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
     * @param password user's password
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
     * @param privileges user's access level
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
     * @param lastLogin user's last login date
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
     * @param deactivated date of account deactivation
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
     * @param active active state of account
     */
    public void setActive(int active) {
        this.active = active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    /**
     * Print current value of instance variables to console
     */
    public String toString() {
        return "id: " + this.id +
            "\nfirstName: " + this.firstName +
            "\nlastName: " + this.lastName +
            "\nemail: " + this.email +
            "\nuserName: " + this.userName +
            "\npassword: " + this.password +
            "\nprivileges" + this.privileges +
            "\ncreated" + this.created +
            "\nlastLogin" + this.lastLogin +
            "\ndeactivated" + this.deactivated +
            "\nactive" + this.active;
    }
}
