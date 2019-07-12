package pro.tixie.model;

import javax.persistence.*;
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

    @Column(nullable = false)
    private String issue_details;

    @Column(nullable = false)
    private int specialization_id;

    @Column(nullable = false)
    private int status_id;

    @OneToOne
    private User author_id;

    @OneToOne
    private User owner_id;

    @Column(nullable = false)
    private Date issue_date;

    @Column(nullable = false)
    private Date comp_date;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private int priority_id;

    public Ticket(int biohazard, String location_1, String location_2, String issue_details, int specialization_id, int status_id, User author_id, User owner_id, Date issue_date, Date comp_date, String imgUrl, int priority_id) {
        this.biohazard = biohazard;
        this.location_1 = location_1;
        this.location_2 = location_2;
        this.issue_details = issue_details;
        this.specialization_id = specialization_id;
        this.status_id = status_id;
        this.author_id = author_id;
        this.owner_id = owner_id;
        this.issue_date = issue_date;
        this.comp_date = comp_date;
        this.imgUrl = imgUrl;
        this.priority_id = priority_id;
    }

    public Ticket() {
    }

//  getters


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

    public int getSpecialization_id() {
        return specialization_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public User getAuthor_id() {
        return author_id;
    }

    public User getOwner_id() {
        return owner_id;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public Date getComp_date() {
        return comp_date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getPriority_id() {
        return priority_id;
    }

//  setters


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

    public void setSpecialization_id(int specialization_id) {
        this.specialization_id = specialization_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public void setAuthor_id(User author_id) {
        this.author_id = author_id;
    }

    public void setOwner_id(User owner_id) {
        this.owner_id = owner_id;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public void setComp_date(Date comp_date) {
        this.comp_date = comp_date;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }
}
