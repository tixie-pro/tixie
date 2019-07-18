package pro.tixie.model;

import javax.persistence.*;

@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Specialization() {
    }

    public Specialization(String name) {
        this.name = name;
    }

    public Specialization(String name, long id) {
        this.name = name;
        this.id = id;
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
