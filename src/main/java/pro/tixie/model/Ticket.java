package pro.tixie.model;

import javax.persistence.*;
import org.springframework.context.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int biohazard;

    @Column(nullable = false)
    private String location_1;

    @Column(nullable = false)
    private String location_2;

    @Column(nullable = false, columnDefinition = "text")
    private String issue_details;

    @OneToOne
    private Specialization specialization;

    @OneToOne
    private Status status;

    @OneToOne
    private User author;

    @OneToOne

    private User owner;

    @Column(nullable = false)
    private String issue_date;

    @Column(nullable = true)
    private Date comp_date;

    @Column(nullable = false)
    private String imgUrl;

    @OneToOne
    private Priority priority;

    public Ticket(){};

    public Ticket( long id, int biohazard, String location_1, String location_2, String issue_details, Specialization specialization, Status status, User author, User owner, String issue_date, Date comp_date, String imgUrl, Priority priority) {
        this.biohazard = biohazard;
        this.location_1 = location_1;
        this.location_2 = location_2;
        this.issue_details = issue_details;
        this.specialization = specialization;
        this.status = status;
        this.author = author;
        this.owner = owner;
        this.issue_date = issue_date;
        this.comp_date = comp_date;
        this.imgUrl = imgUrl;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public int getBiohazard() {
        return biohazard;
    }

    public String getLocation_1() {
        return location_1;
    }

    public String getLocation_2() {
        return location_2;
    }

    public String getIssue_details() {
        return issue_details;
    }

    public Specialization getSpecialization_id() {
        return specialization;
    }

    public Status getStatusId() {
        return status;
    }

    public User getAuthorId() {
        return author;
    }

    public User getOwnerId() {
        return owner;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public Date getComp_date() {
        return comp_date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Priority getPriorityId() {
        return priority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBiohazard(int biohazard) {
        this.biohazard = biohazard;
    }

    public void setLocation_1(String location_1) {
        this.location_1 = location_1;
    }

    public void setLocation_2(String location_2) {
        this.location_2 = location_2;
    }

    public void setIssue_details(String issue_details) {
        this.issue_details = issue_details;
    }

    public void setSpecialization_id(Specialization specialization) {
        this.specialization = specialization;
    }

    public void setStatusId(Status status) {
        this.status = status;
    }

    public void setAuthorId(User author) {
        this.author = author;
    }

    public void setOwnerId(User owner) {
        this.owner = owner;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public void setComp_date(Date comp_date) {
        this.comp_date = comp_date;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setPriorityId(Priority priority) {
        this.priority = priority;
    }
}
