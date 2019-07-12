package pro.tixie.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String Email;

    @Column(nullable = false)
    private String Password;

    private String profileImage;

    @OneToOne
    private Specialization specialization;

    public User() {

    }

    public User(Long id, String username, String firstName, String lastName, String email, String password, String profileImage, Specialization specialization) {
        this.id = id;
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Email = email;
        this.Password = password;
        this.profileImage = profileImage;
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public String getuserName() {
        return userName;
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
        return profileImage;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
