package com.example.s525189.eventtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class event_layout extends AppCompatActivity {
    private static final String TAF ="ViewDatabase";
    private FirebaseDatabase mFirebaseDatabse;

    ListView listViewEvents;
    List<EventDetail> EventList;

    private DatabaseReference databaseEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_layout);

        listViewEvents = (ListView) findViewById(R.id.listViewEvents);
        EventList = new ArrayList<>();
        databaseEvents= FirebaseDatabase.getInstance().getReference("events");
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                EventList.clear();
                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    EventDetail events = eventSnapshot.getValue(EventDetail.class);
                    EventList.add(events);
                }
                EventList adapter =new EventList(event_layout.this,EventList);
                listViewEvents.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

  /*  @Override
    protected void onStart() {
        super.onStart();
        ChildEventListener childEventListener = databaseEvents.addChildEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eventList.clear();

                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    EventDetail events = eventSnapshot.getValue(EventDetail.class);
                    eventList.add(events);
                }
                EventList adapter =new EventList(event_layout.this, eventList);
                listViewEvents.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseerror) {

            }
        });
    }
}*/




