package pro.tixie.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String role;

    public Role(String role) {
        this.role = role;
    }

    public Role(long id , String role) {
        this.role = role;
        this.id = id;
    }

    public Role (){};

//    getters


    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

//    Setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
