package com.example.s525189.eventtracker;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

                } else if (item.getItemId() == R.id.event) {

                    Intent i = new Intent(homeActivity.this,event.class);
                    startActivity(i);
                }


                else if (item.getItemId() == R.id.ven) {

                } else if (item.getItemId() == R.id.pro) {

                }

                return false;
            }
        });
    }

}
