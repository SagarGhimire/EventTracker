package com.example.s525189.eventtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class EventSubmitActivity extends AppCompatActivity {
    private Button submitBtn;
    Button upload;
    String valid_email;
    EditText name;
    EditText email;
    EditText eventName;
    EditText phone;
    EditText Summary;
    EditText date1;
    EditText time1;
    EditText place;
    DatabaseReference databaseEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_submit);
        Log.d("second access", "starting web action");

        databaseEvents= FirebaseDatabase.getInstance().getReference("events");
        submitBtn = (Button) findViewById(R.id.submitButton);
        upload = (Button) findViewById(R.id.upload);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.emailgiven);
        eventName = (EditText) findViewById(R.id.eventName);
        phone = (EditText) findViewById(R.id.phone);
        Summary = (EditText) findViewById(R.id.Summary);
        date1 =(EditText) findViewById(R.id.date1);
        time1 =(EditText)findViewById(R.id.time1);
        place =(EditText)findViewById(R.id.place1);



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEvent();
                Intent  a = new Intent(EventSubmitActivity.this,homeActivity.class);
                startActivity(a);

            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EventSubmitActivity.this, uploadimg.class);
                startActivity(i);

            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

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
    }





    public void addEvent(){
        String getname = name.getText().toString().trim();
        String getemail = email.getText().toString();
        String geteventName = eventName.getText().toString();
        String getphone = phone.getText().toString();
        String getSummary = Summary.getText().toString();
        String getDate = date1.getText().toString();
        String getTime = time1.getText().toString();
        String getplace = place.getText().toString();



        if(!TextUtils.isEmpty(getname) && !TextUtils.isEmpty(getemail)&&!TextUtils.isEmpty(geteventName)
                && !TextUtils.isEmpty(getphone) && !TextUtils.isEmpty(getSummary)){

            String id =databaseEvents.push().getKey();
            EventDetail event1 = new EventDetail(id,getname, getemail,geteventName,getDate,getphone,getSummary,getTime,getplace);


            databaseEvents.child(id).setValue(event1);
            Log.d("New", "added1");
            Toast.makeText(this,"EventAdded",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "The Field should not be empty! Please Fill all the " +
                    "blank fields!", Toast.LENGTH_LONG).show();
        }
    }
}



