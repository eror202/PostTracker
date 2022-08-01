package ru.smirnov.PostOffice.PostOffice.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Recipients")
public class Recipients implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "index")
    @NotNull
    private int index;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "is_delivered")

    private boolean isDelivered;

    @Column(name = "time_of_delivered")
    private String timeOfDelivered;

    @Column(name = "identification")
    private int identification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public String getTimeOfDelivered() {
        return timeOfDelivered;
    }

    public void setTimeOfDelivered(String timeOfDelivered) {
        this.timeOfDelivered = timeOfDelivered;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }
}
