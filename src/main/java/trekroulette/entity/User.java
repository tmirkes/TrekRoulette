package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
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
    @OneToMany(mappedBy = "userByUserId", cascade = CascadeType.ALL)
    private Set<Own> ownsById;
    @OneToMany(mappedBy = "userByUserId", cascade = CascadeType.ALL)
    private Set<View> viewsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && active == user.active && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(privileges, user.privileges) && Objects.equals(created, user.created) && Objects.equals(lastLogin, user.lastLogin) && Objects.equals(deactivated, user.deactivated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, userName, password, privileges, created, lastLogin, deactivated, active);
    }

    public Set<Own> getOwnsById() {
        return ownsById;
    }

    public void setOwnsById(Set<Own> ownsById) {
        this.ownsById = ownsById;
    }

    public Set<View> getViewsById() {
        return viewsById;
    }

    public void setViewsById(Set<View> viewsById) {
        this.viewsById = viewsById;
    }

    public void addOwn(Own own) {}
}
