package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    public User() {
    }

    public User(String firstName, String lastName, String email, String userName, String password, String privileges) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.privileges = privileges;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDate getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(LocalDate deactivated) {
        this.deactivated = deactivated;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Own> getOwns() {
        return owns;
    }

    public void setOwns(Set<Own> owns) {
        this.owns = owns;
    }

    public Set<View> getViews() {
        return views;
    }

    public void setViews(Set<View> views) {
        this.views = views;
    }

    // Entity Set<> managers
    public void addOwn(Own own) {
        owns.add(own);
        own.setUser(this);
    }

    public void removeOwn(Own own) {
        owns.remove(own);
        own.setUser(null);
    }

    public void addView(View view) {
        views.add(view);
        view.setUser(this);
    }

    public void removeView(View view) {
        views.remove(view);
        view.setUser(null);
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && getActive() == user.getActive() && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getEmail().equals(user.getEmail()) && getUserName().equals(user.getUserName()) && getPassword().equals(user.getPassword()) && getPrivileges().equals(user.getPrivileges()) && Objects.equals(getDeactivated(), user.getDeactivated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getUserName(), getPassword(), getPrivileges(), getDeactivated(), getActive());
    }

    // toString()
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
