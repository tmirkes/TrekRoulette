package trekroulette.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * POJO representing credited status data within the Trek Roulette application
 *
 * @author tlmirkes
 * @version 1.0
 */
@Entity(name = "Status")
@Table(name = "status", schema = "testing")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String status;

    public Status() { }

    public Status(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
