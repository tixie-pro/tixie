package pro.tixie.model;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Ticket ticket;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @OneToOne
    private User user;

    @Column(nullable = false)
    private Date created;

    public Note(Ticket ticket, String description, User user, Date created) {
        this.ticket = ticket;
        this.description = description;
        this.user = user;
        this.created = created;
    }

//    getters

    public Long getId() {
        return id;
    }

    public Ticket getTicket_id() {
        return ticket;
    }

    public String getDescription() {
        return description;
    }

    public User getUser_id() {
        return user;
    }

    public Date getCreated() {
        return created;
    }

//    setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setTicket_id(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser_id(User user) {
        this.user = user;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
