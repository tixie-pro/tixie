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

    @OneToOne
    private Specialization specialization_id;

    @OneToOne
    private int statusId;

    @OneToOne
    private User authorId;

    @OneToOne
    private User ownerId;

    @Column(nullable = false)
    private Date issue_date;

    @Column(nullable = false)
    private Date comp_date;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private Priority priorityId;

    public Ticket( long id, int biohazard, String location_1, String location_2, String issue_details, Specialization specialization_id, int statusId, User authorId, User ownerId, Date issue_date, Date comp_date, String imgUrl, Priority priorityId) {
        this.biohazard = biohazard;
        this.location_1 = location_1;
        this.location_2 = location_2;
        this.issue_details = issue_details;
        this.specialization_id = specialization_id;
        this.statusId = statusId;
        this.authorId = authorId;
        this.ownerId = ownerId;
        this.issue_date = issue_date;
        this.comp_date = comp_date;
        this.imgUrl = imgUrl;
        this.priorityId = priorityId;
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
        return specialization_id;
    }

    public int getStatusId() {
        return statusId;
    }

    public User getAuthorId() {
        return authorId;
    }

    public User getOwnerId() {
        return ownerId;
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

    public Priority getPriorityId() {
        return priorityId;
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

    public void setSpecialization_id(Specialization specialization_id) {
        this.specialization_id = specialization_id;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
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

    public void setPriorityId(Priority priorityId) {
        this.priorityId = priorityId;
    }
}
