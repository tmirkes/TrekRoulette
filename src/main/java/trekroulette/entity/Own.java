package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Own")
@Table(name = "own")
public class Own {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // *-1 associations
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "series_season_id", referencedColumnName = "id", nullable = false)
    private SeriesSeason seriesSeason;

    // Constructors
    public Own() {
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SeriesSeason getSeriesSeason() {
        return seriesSeason;
    }

    public void setSeriesSeason(SeriesSeason seriesSeason) {
        this.seriesSeason = seriesSeason;
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Own own = (Own) o;
        return getId() == own.getId() &&
                getUser().equals(own.getUser()) &&
                getSeriesSeason().equals(own.getSeriesSeason());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getSeriesSeason());
    }

    // toString()
    @Override
    public String toString() {
        return "Own{" +
                "id=" + id +
                '}';
    }
}
