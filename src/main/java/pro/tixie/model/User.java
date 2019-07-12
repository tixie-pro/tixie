package pro.tixie.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String Username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String Email;

    @Column(nullable = false)
    private String Password;

    private String ProfileImage;

    @OneToOne
    private Specialization Specialization;

    @OneToOne
    private Role role;

    public User() {

    }

    public User( long id,String username, String firstName, String lastName, String email, String password, String profileImage, pro.tixie.model.Specialization specialization, Role role) {
        this.id = id;
        Username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        Password = password;
        ProfileImage = profileImage;
        Specialization = specialization;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public Specialization getSpecialization() {
        return Specialization;
    }

    public Role getRole() {
        return role;
    }



    public void setUsername(String username) {
        Username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }

    public void setSpecialization(Specialization specialization) {
        Specialization = specialization;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
