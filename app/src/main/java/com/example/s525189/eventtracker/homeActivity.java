package com.example.s525189.eventtracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class homeActivity extends AppCompatActivity {
    private TextView infoTextView;
    private BottomNavigationView bottomNavigationView;
    DatabaseReference databaseEvents;
     final List<String> eventLister = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ArrayAdapter<String> detailEvents = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,eventLister);
        setContentView(R.layout.activity_home);

        databaseEvents = FirebaseDatabase.getInstance().getReference();
        databaseEvents.child("events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                    for (DataSnapshot ds : children) {
                        EventDetail detail = ds.getValue(EventDetail.class);
                        String eventName = detail.getEventName();
                        eventLister.add(eventName);
                    }
                    final ListView myList3 = (ListView)findViewById(R.id.list1);
                    myList3.setAdapter(detailEvents);
                    myList3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String eN = myList3.getItemAtPosition(position).toString();
                           Intent u = new Intent(homeActivity.this,description.class);
                           u.putExtra("EventName",eN);
                           startActivity(u);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        BottomNavigationView  bottomNavigationView1 = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.map) {
                    Log.d("web access", "starting web action");
                    String uri = "https://www.nwmissouri.edu/maps/index.htm";
                    Intent webit = new Intent(Intent.ACTION_VIEW);
                    Uri weburi = Uri.parse(uri);
                    webit.setData(weburi);
                    startActivity(webit);
                    Log.d("web access", "returned from start activity");

<<<<<<< HEAD
                } else if (item.getItemId() == R.id.venue) {
=======
                }

                 else if (item.getItemId() == R.id.venue) {
>>>>>>> 5fceb8aa0b11cf97a7b7ba0d2286da1d8432cc82
                    Intent x = new Intent(homeActivity.this, VenuActivity.class);
                    startActivity(x);

                } else if (item.getItemId() == R.id.profile) {
                    Intent prfle = new Intent(homeActivity.this, ProfileActivity.class);
                    startActivity(prfle);


                }else if(item.getItemId() ==R.id.events){
                    Intent y = new Intent(homeActivity.this, event_layout.class);
                    startActivity(y);
                }

                return false;
            }
        });
    }
}
