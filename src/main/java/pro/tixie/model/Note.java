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

    @Column(nullable = false)
    private int ticket_id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private Date created;

    public Note(int ticket_id, String description, int user_id, Date created) {
        this.ticket_id = ticket_id;
        this.description = description;
        this.user_id = user_id;
        this.created = created;
    }

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
