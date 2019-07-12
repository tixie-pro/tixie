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

    public User() {

    }

    public User(Long id, String username, String firstName, String lastName, String email, String password, String profileImage, Specialization specialization) {
        this.id = id;
        this.Username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Email = email;
        this.Password = password;
        this.ProfileImage = profileImage;
        this.Specialization = specialization;
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
}
