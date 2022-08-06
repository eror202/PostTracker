package ru.smirnov.PostOffice.PostOffice.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecipientsDTO {
    @JsonProperty("index")
    private int index;
    @JsonProperty("address")
    private String address;
    @JsonProperty("name")
    private String name;
    @JsonProperty("isDelivered")
    private boolean isDelivered;
    @JsonProperty("identification")
    private int identification;

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

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }
}
