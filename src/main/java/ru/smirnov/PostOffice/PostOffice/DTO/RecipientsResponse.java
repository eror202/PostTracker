package ru.smirnov.PostOffice.PostOffice.DTO;


import org.springframework.stereotype.Component;

import java.util.List;

public class RecipientsResponse {
    private List<RecipientsDTO> recipientsDTOList;

    public RecipientsResponse(List<RecipientsDTO> recipientsDTOList) {
        this.recipientsDTOList = recipientsDTOList;
    }

    public List<RecipientsDTO> getRecipientsDTOList() {
        return recipientsDTOList;
    }

    public void setRecipientsDTOList(List<RecipientsDTO> recipientsDTOList) {
        this.recipientsDTOList = recipientsDTOList;
    }
}
