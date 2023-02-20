package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Status")
@Table(name = "status")
public class Status {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "statusByStatusId")
    private Set<View> viewsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return id == status1.id && Objects.equals(status, status1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    public Set<View> getViewsById() {
        return viewsById;
    }

    public void setViewsById(Set<View> viewsById) {
        this.viewsById = viewsById;
    }
}
