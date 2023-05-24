package com.ssafy.enjoytrip.mail.dto;

public class Message {
    private String email;
    private String uuid;

    public Message(String email, String uuid) {
        this.email = email;
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
