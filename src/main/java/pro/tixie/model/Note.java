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
    private Ticket ticket_id;

    @Column(nullable = false )
    private String description;

    @OneToOne
    private User user_id;

    @Column(nullable = false)
    private Date created;

    public Note(Ticket ticket_id, String description, User user_id, Date created) {
        this.ticket_id = ticket_id;
        this.description = description;
        this.user_id = user_id;
        this.created = created;
    }

//    getters

    public Long getId() {
        return id;
    }

    public Ticket getTicket_id() {
        return ticket_id;
    }

    public String getDescription() {
        return description;
    }

    public User getUser_id() {
        return user_id;
    }

    public Date getCreated() {
        return created;
    }

//    setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setTicket_id(Ticket ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
