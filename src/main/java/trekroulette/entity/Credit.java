package trekroulette.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Credit")
@Table(name = "credit")
public class Credit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "episode_id", insertable = false, updatable = false)
    private int episodeId;
    @Basic
    @Column(name = "person_id", insertable = false, updatable = false)
    private int personId;
    @Basic
    @Column(name = "role_id", insertable = false, updatable = false)
    private int roleId;
    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false)
    private Episode episodeByEpisodeId;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private Person personByPersonId;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role roleByRoleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return id == credit.id && episodeId == credit.episodeId && personId == credit.personId && roleId == credit.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, episodeId, personId, roleId);
    }

    public Episode getEpisodeByEpisodeId() {
        return episodeByEpisodeId;
    }

    public void setEpisodeByEpisodeId(Episode episodeByEpisodeId) {
        this.episodeByEpisodeId = episodeByEpisodeId;
    }

    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }

    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
