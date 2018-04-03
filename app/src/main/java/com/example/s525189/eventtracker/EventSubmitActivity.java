package com.example.s525189.eventtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventSubmitActivity extends AppCompatActivity {


    private Button submitButton;
    EditText name;
    EditText email;
    EditText eventName;
    EditText phone;
    EditText Abstract;

    DatabaseReference databaseEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_submit);
        Log.d("second access", "starting web action");

        databaseEvents= FirebaseDatabase.getInstance().getReference("events");
    Button submitBtn = (Button) findViewById(R.id.submitButton);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        eventName = (EditText) findViewById(R.id.eventName);
        phone = (EditText) findViewById(R.id.phone);
        Abstract = (EditText) findViewById(R.id.Abstract);


submitBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        addEvent();

    }
});

    }

    public void addEvent(){
        String getname = name.getText().toString().trim();
        String getemail = email.getText().toString();
        String geteventName = eventName.getText().toString();
        String getphone = phone.getText().toString();
        String getabstract = Abstract.getText().toString();

        if(!TextUtils.isEmpty(getname) && !TextUtils.isEmpty(getemail)&&!TextUtils.isEmpty(geteventName)
                && !TextUtils.isEmpty(getphone) && !TextUtils.isEmpty(getabstract)){

            String id =databaseEvents.push().getKey();
            EventDetail event1 = new EventDetail(id,getname, getemail,geteventName,getphone,getabstract);
            databaseEvents.child(id).setValue(event1);
            Toast.makeText(this,"EventAdded",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "The Field shoul not be empty! Please Fill all the " +
                    "blank fields!", Toast.LENGTH_LONG).show();
        }
    }
}
