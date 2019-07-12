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
    private Ticket ticketId;

    @Column(nullable = false )
    private String description;

    @OneToOne
    private User userId;

    @Column(nullable = false)
    private Date created;

    public Note(Ticket ticketId, String description, User userId, Date created) {
        this.ticketId = ticketId;
        this.description = description;
        this.userId = userId;
        this.created = created;
    }

//    getters

    public Long getId() {
        return id;
    }

    public Ticket getTicket_id() {
        return ticketId;
    }

    public String getDescription() {
        return description;
    }

    public User getUser_id() {
        return userId;
    }

    public Date getCreated() {
        return created;
    }

//    setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setTicket_id(Ticket ticketId) {
        this.ticketId = ticketId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser_id(User userId) {
        this.userId = userId;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
