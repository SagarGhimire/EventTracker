package com.example.s525189.eventtracker;

/**
 * Created by s525189 on 3/9/2018.
 */

public class AdminClass {
    private String name;
    private String email;
    private String EventName;
    private String Phone;
    private String Abstract;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }
}
