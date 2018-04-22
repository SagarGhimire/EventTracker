package com.example.s525189.eventtracker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventSubmitActivity extends AppCompatActivity {
<<<<<<< HEAD
    private Button submitBtn;
=======


   // private Button submitButton;
>>>>>>> 2aa2d16227fcda7b7f43d731d6cd9b3c0a4379e1
    EditText name;
    EditText email;
    EditText eventName;
    EditText phone;
    EditText Summary;
<<<<<<< HEAD
    EditText date1;
    EditText time1;
    EditText place;
    DatabaseReference databaseEvents;
=======
    private String valid_email;


    DatabaseReference databaseEvents;

>>>>>>> 2aa2d16227fcda7b7f43d731d6cd9b3c0a4379e1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_submit);
        Log.d("second access", "starting web action");

        databaseEvents = FirebaseDatabase.getInstance().getReference("events");
        Button submitBtn = (Button) findViewById(R.id.submitButton);
        Button upload1 = (Button) findViewById(R.id.upload);
        upload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EventSubmitActivity.this, uploadimg.class);
                startActivityForResult(i,12);
            }
        });


        name = (EditText) findViewById(R.id.name);

        eventName = (EditText) findViewById(R.id.eventName);
        phone = (EditText) findViewById(R.id.phone);
<<<<<<< HEAD
       Summary = (EditText) findViewById(R.id.Summary);
       date1 =(EditText) findViewById(R.id.date1);
       time1 =(EditText)findViewById(R.id.time1);
       place =(EditText)findViewById(R.id.place1);

=======
        Summary = (EditText) findViewById(R.id.Summary);
        email = (EditText) findViewById(R.id.email);
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
>>>>>>> 2aa2d16227fcda7b7f43d731d6cd9b3c0a4379e1

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Is_Valid_Email(email);
            }

            public void Is_Valid_Email(EditText edt) {
                if (edt.getText().toString() == null) {
                    edt.setError("Invalid Email Address");
                    valid_email = null;
                } else if (isEmailValid(edt.getText().toString()) == false) {
                    edt.setError("Invalid Email Address");
                    valid_email = null;
                } else {
                    valid_email = edt.getText().toString();
                }
            }

            boolean isEmailValid(CharSequence email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches();
            } // end of TextWatcher (email)

        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEvent();
                Intent  a = new Intent(EventSubmitActivity.this,homeActivity.class);
                startActivity(a);

            }
        });



        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidPhone(phone.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "Phone number is valid", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getApplicationContext(), "Phone number is not valid", Toast.LENGTH_SHORT).show();

                }

            }

            boolean isValidPhone(CharSequence phoe) {

                boolean check=false;
                if(!Pattern.matches("[a-zA-Z]+", phoe)) {
                    if(phone.length() < 6 || phone.length() > 13) {
                        // if(phone.length() != 10) {
                        check = false;
                        phone.setError("Not Valid Number");
                    } else {
                        check = true;
                    }
                } else {
                    check=false;
                }
                return check;
            }



        });
    }





    public void addEvent() {
        String getname = name.getText().toString().trim();
        String getemail = email.getText().toString();
        String geteventName = eventName.getText().toString();
        String getphone = phone.getText().toString();
        String getSummary = Summary.getText().toString();
<<<<<<< HEAD
        String getDate = date1.getText().toString();
        String getTime = time1.getText().toString();
        String getplace = place.getText().toString();



        if(!TextUtils.isEmpty(getname) && !TextUtils.isEmpty(getemail)&&!TextUtils.isEmpty(geteventName)
                && !TextUtils.isEmpty(getphone) && !TextUtils.isEmpty(getSummary)){

            String id =databaseEvents.push().getKey();
            EventDetail event1 = new EventDetail(id,getname, getemail,geteventName,getDate,getphone,getSummary,getTime,getplace);
=======
>>>>>>> 2aa2d16227fcda7b7f43d731d6cd9b3c0a4379e1

        if (!TextUtils.isEmpty(getname) && !TextUtils.isEmpty(getemail) && !TextUtils.isEmpty(geteventName)
                && !TextUtils.isEmpty(getphone) && !TextUtils.isEmpty(getSummary)) {

            String id = databaseEvents.push().getKey();
            EventDetail event1 = new EventDetail(id, getname, getemail, geteventName, getphone, getSummary);
            databaseEvents.child(id).setValue(event1);
            Toast.makeText(this, "EventAdded", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "The Field should not be empty! Please Fill all the " +
                    "blank fields!", Toast.LENGTH_LONG).show();
        }


    }

}








