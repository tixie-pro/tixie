package pro.tixie.model;

import javax.persistence.*;
import java.awt.*;
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
    private TextArea issue_details;

    @Column(nullable = false)
    private int specialization_id;

    @Column(nullable = false)
    private int status_id;

    @Column(nullable = false)
    private int author_id;

    @Column(nullable = false)
    private int owner_id;

    @Column(nullable = false)
    private Date issue_date;

    @Column(nullable = false)
    private Date comp_date;

    @Column(nullable = false)
    private int priority_id;

    public Ticket(int biohazard, String location_1, String location_2, TextArea issue_details, int specialization_id, int status_id, int author_id, int owner_id, Date issue_date, Date comp_date, int priority_id) {
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
        this.priority_id = priority_id;
    }

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBiohazard() {
        return biohazard;
    }

    public void setBiohazard(int biohazard) {
        this.biohazard = biohazard;
    }

    public String getLocation_1() {
        return location_1;
    }

    public void setLocation_1(String location_1) {
        this.location_1 = location_1;
    }

    public String getLocation_2() {
        return location_2;
    }

    public void setLocation_2(String location_2) {
        this.location_2 = location_2;
    }

    public TextArea getIssue_details() {
        return issue_details;
    }

    public void setIssue_details(TextArea issue_details) {
        this.issue_details = issue_details;
    }

    public int getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(int specialization_id) {
        this.specialization_id = specialization_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getComp_date() {
        return comp_date;
    }

    public void setComp_date(Date comp_date) {
        this.comp_date = comp_date;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }
}
