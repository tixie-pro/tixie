package pro.tixie.model;

import javax.persistence.*;

@Entity
@Table(name = "priority")
public class Priority {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Priority(String name) {
        this.name = name;
    }

    public Priority() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
