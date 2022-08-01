package ru.smirnov.PostOffice.PostOffice.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post_path")
public class PostPath implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "registration_time")
    private String registration_time;


    @Column(name = "date_of_arrival_at_the_post_office")
    private String date_of_arrival_at_the_post_office;

    @ManyToOne
    @JoinColumn(name = "post_office_name", referencedColumnName = "name")
    private PostOffice post_office_name;

    @Column(name = "date_of_departure_from_the_post_office")
    private String date_of_departure_from_the_post_office;

    @OneToOne
    @JoinColumn(name = "recipient_identification", referencedColumnName = "identification")
    private Recipients recipient_identification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(String registration_time) {
        this.registration_time = registration_time;
    }

    public String getDate_of_arrival_at_the_post_office() {
        return date_of_arrival_at_the_post_office;
    }

    public void setDate_of_arrival_at_the_post_office(String date_of_arrival_at_the_post_office) {
        this.date_of_arrival_at_the_post_office = date_of_arrival_at_the_post_office;
    }

    public PostOffice getPost_office_name() {
        return post_office_name;
    }

    public void setPost_office_name(PostOffice post_office_name) {
        this.post_office_name = post_office_name;
    }

    public String getDate_of_departure_from_the_post_office() {
        return date_of_departure_from_the_post_office;
    }

    public void setDate_of_departure_from_the_post_office(String date_of_departure_from_the_post_office) {
        this.date_of_departure_from_the_post_office = date_of_departure_from_the_post_office;
    }

    public Recipients getRecipient_identification() {
        return recipient_identification;
    }

    public void setRecipient_identification(Recipients recipient_identification) {
        this.recipient_identification = recipient_identification;
    }
}
