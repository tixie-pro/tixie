package pro.tixie.model;

import javax.persistence.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@Entity
public class User{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String confirmPassword;

    private String profileImage;

    @OneToOne
    private Specialization specialization;

    @OneToOne
    private Role role;



    public User() {

    }



    public User(Long id, String username, String firstName, String lastName, String email, String password, String confirmPassword, String profileImage, Specialization specialization, Role role) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.profileImage = profileImage;
        this.specialization = specialization;
        this.role = role;

    }
    public User(User copy){
        id = copy.id;
        username = copy.username;
        email = copy.email;
        password = copy.password;
        profileImage = copy.profileImage;
        role = copy.role;
    }

    private void checkPassword() {
        if (this.password == null || this.confirmPassword == null) {
            return;
        } else if (!this.password.equals(confirmPassword)) {
            this.confirmPassword = null;
        }
    }


    public Long getId() {
        return id;
    }

    public String getuserName() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;

    }



    public String getProfileImage() {
        return profileImage;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public Role getRole() {return role;}

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        checkPassword();

    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public void setRole(Role role) {this.role = role;}

//    other methods

    public int tixCount(List<Ticket> allTix){
        int x = 0;
        long id = this.id;
        for (Ticket ticket:allTix){
            if (ticket.getOwnerId()==null)
            {
//                    skip
                ticket.setOwnerId(this);
            }else
            if (ticket.getOwnerId().id.equals(id)){
                x++;
            }
        }
        return x;
    }

}