package ru.smirnov.PostOffice.PostOffice.DTO;

import ru.smirnov.PostOffice.PostOffice.models.Recipients;

public class TypesOfPostDTO {

    private String type;

    private Recipients recipient_identification;

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
