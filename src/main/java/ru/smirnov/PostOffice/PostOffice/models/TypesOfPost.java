package ru.smirnov.PostOffice.PostOffice.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "type_of_post")
public class TypesOfPost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //@NotEmpty(message = "Назначьте тип посылки")
    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "recipient_identification", referencedColumnName = "identification")
    private Recipients recipient_identification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Recipients getRecipient_identification() {
        return recipient_identification;
    }

    public void setRecipient_identification(Recipients recipient_identification) {
        this.recipient_identification = recipient_identification;
    }
}
