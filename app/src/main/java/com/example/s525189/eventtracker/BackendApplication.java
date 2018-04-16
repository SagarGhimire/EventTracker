package com.example.s525189.eventtracker;

import android.app.Application;

import com.backendless.Backendless;

public class BackendApplication extends Application {

    public static  final String APPLICATION_ID ="6945BA93-3DD3-06F2-FF9E-E61FBCEDA600";
    public  static final String API_KEY="8C92B647-29C1-64B6-FFE9-40DA604CA300";
    public static  final String SERVER_URL ="https://api.backendless.com";


    @Override
    public void onCreate() {
        super.onCreate();

        Backendless.setUrl(SERVER_URL);
        Backendless.initApp(getApplicationContext(),APPLICATION_ID,API_KEY);

    }

}