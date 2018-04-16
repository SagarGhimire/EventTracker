package com.example.s525189.eventtracker;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class homeActivity extends AppCompatActivity {
    private TextView infoTextView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //infoTextView =(TextView) findViewById(R.id.infoTextView);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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

                }

                 else if (item.getItemId() == R.id.venue) {
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
