package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<View> getViews() {
        return views;
    }

    public void setViews(Set<View> views) {
        this.views = views;
    }

    // Entity Set<> managers
    public void addView(View view) {
        views.add(view);
        view.setStatus(this);
    }

    public void removeView(View view) {
        views.remove(view);
        view.setStatus(null);
    }

    // equals() and hashCode() methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return getId() == status1.getId() && getStatus().equals(status1.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus());
    }

    // toString()
    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
