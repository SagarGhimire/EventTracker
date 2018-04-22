package com.example.s525189.eventtracker;

public class EventDetail {
    String id;
    String name;
   String email;
   String eventName;
   String phoneNumber;
   String date;

   String time;
   String place;


    String summary;


    public EventDetail() {

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

    public EventDetail(String id, String name, String email, String eventName,String date, String phoneNumber, String summary, String time,String place) {


        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.eventName = eventName;
        this.summary = summary;
        this.date =date;
        this.time =time;
        this.place =place;
    }


    // public String getId() {
    //return id;
    //}


    public String getId() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public  String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public  String getSummary() {
        return summary;
    }

    public void setSummary(String aSummary) {
        summary = aSummary;
    }
}
