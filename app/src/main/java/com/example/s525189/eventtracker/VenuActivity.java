package com.example.s525189.eventtracker;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class VenuActivity extends AppCompatActivity {
    private TextView infoTextView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venu);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.map) {
                    Log.d("web access", "starting web action");
                    String uri = "https://www.nwmissouri.edu/maps/index.htm";
                    Intent webit = new Intent(Intent.ACTION_VIEW);
                    Uri weburi = Uri.parse(uri);
                    webit.setData(weburi);
                    startActivity(webit);
                    Log.d("web access", "returned from start activity");
                } else if (item.getItemId() == R.id.event) {
                    Intent i = new Intent(VenuActivity.this, event.class);
                    startActivity(i);
                }


//                else if (item.getItemId() == R.id.venue) {
//                    Intent x = new Intent(VenuActivity.this,.class);
//                    startActivity(x); }

                else if (item.getItemId() == R.id.profile) {
                    Intent prfle = new Intent(VenuActivity.this, ProfileActivity.class);
                    startActivity(prfle);


                }

                return false;
            }
        });

    }
    }

