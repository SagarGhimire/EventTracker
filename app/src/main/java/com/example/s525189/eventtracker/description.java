package com.example.s525189.eventtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class description extends AppCompatActivity {
    ImageView imgV;
    DatabaseReference data;
    StorageReference storageReference;
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent i = getIntent();
        val = i.getStringExtra("EventName");
        final TextView detail = (TextView)findViewById(R.id.detail);
        final TextView eventName = (TextView) findViewById(R.id.eventName);
        final TextView contactAt = (TextView) findViewById(R.id.contactAt);
        final TextView abstractDetail = (TextView) findViewById(R.id.abstractDetail);

        data = FirebaseDatabase.getInstance().getReference().child("events").getRef();
        Query q = data.orderByChild("eventName").equalTo(val);
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    for (DataSnapshot friend : dataSnapshot.getChildren()) {
                       EventDetail ed = friend.getValue(EventDetail.class);
                        Log.d("skd",ed.getEventName()+""+ed.getSummary()+""+ed.getName());
                        eventName.setText(ed.getEventName());
                        abstractDetail.setText(ed.getSummary());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        System.out.println("The value is "+val+" ");
        imgV = (ImageView)findViewById(R.id.eventImg);

        Button button = (Button) findViewById(R.id.interest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( description.this, ProfileActivity.class);
                i.putExtra("EventName",val);
                startActivity(i);
            }
        });
        Button butt =(Button) findViewById(R.id.noInterest);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(description.this, homeActivity.class);
                startActivity(x);
            }
        });


    }

}