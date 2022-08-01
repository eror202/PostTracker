package ru.smirnov.PostOffice.PostOffice.DTO;

import ru.smirnov.PostOffice.PostOffice.models.PostOffice;
import ru.smirnov.PostOffice.PostOffice.models.Recipients;

public class PostPathDTO {
    private PostOffice post_office_name;

    private Recipients recipient_identification;

    public PostOffice getPost_office_name() {
        return post_office_name;
    }

    public void setPost_office_name(PostOffice post_office_name) {
        this.post_office_name = post_office_name;
    }

    public Recipients getRecipient_identification() {
        return recipient_identification;
    }

    public void setRecipient_identification(Recipients recipient_identification) {
        this.recipient_identification = recipient_identification;
    }
}
