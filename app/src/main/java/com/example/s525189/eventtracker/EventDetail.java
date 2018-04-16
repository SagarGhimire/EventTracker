package com.example.s525189.eventtracker;

/**
 * Created by S524878 on 4/2/2018.
 */

public class EventDetail {
    private static String id;
    private  static  String name;
    private static  String email;
   private static  String eventName;
    private static String phoneNumber;

    private static String Abstract;

    public EventDetail(){

    }
    public EventDetail(String id,String name, String email,
                        String phoneNumber,String eventName, String Abstract ){
        this.id =id;
        this.name =name;
        this.email =email;
        this.phoneNumber = phoneNumber;
        this.eventName=eventName;
        this.Abstract= Abstract;
}

   // public String getId() {
        //return id;
    //}

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public static String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        this.Abstract = anAbstract;
    }
}
