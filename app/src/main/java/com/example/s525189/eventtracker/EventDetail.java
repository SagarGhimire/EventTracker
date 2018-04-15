package com.example.s525189.eventtracker;

/**
 * Created by S524878 on 4/2/2018.
 */

public class EventDetail {
    String id;
    String name;
    String email;
    String eventName;
    String phoneNumber;

    String summary;

    public EventDetail(){

    }
    public EventDetail(String id,String name, String email,
                        String eventName,String phoneNumber, String summary ){
    this.id =id;
        this.name =name;
        this.email =email;
        this.phoneNumber = phoneNumber;
        this.eventName=eventName;
        this.summary= summary;
}

    public String getId() {
        return id;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String aSummary) {
        summary = aSummary;
    }
}
