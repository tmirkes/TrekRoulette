package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * POJO representing user data within the Trek Roulette application
 *
 * @author tlmirkes
 * @version 1.0
 */
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String passWord;
    @Column(name = "email")
    private String email;

    /**
     * Constructor accepting no arguments
     */
    public User() {}

    /**
     * Constructor accepting arguments for instance variables
     * @param firstName User's first name
     * @param lastName User's last name
     * @param userName User's user name
     * @param password User's password
     * @param email User's email address
     */
    public User(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = password;
        this.email = email;
    }

    /**
     * firstName getter
     * @return value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * firstName setter
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * lastName getter
     * @return value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * lastName setter
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * userName getter
     * @return value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * userName setter
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * passWord getter
     * @return value of passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * passWord setter
     * @param passWord new value of passWord
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * email getter
     * @return value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * email setter
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * id getter
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Print current value of instance variables to console
     */
    public String toString() {
        String printer = "firstName: " + this.firstName +
                        "\nlastName: " + this.lastName +
                        "\nuserName: " + this.userName +
                        "\npassWord: " + this.passWord +
                        "\nemail: " + this.email +
                        "\nid: " + this.id;
        return printer;
    }
}
