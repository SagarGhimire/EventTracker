package com.example.s525189.eventtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class description extends AppCompatActivity {
    ImageView view = (ImageView)findViewById(R.id.eventImg);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        Button button = (Button) findViewById(R.id.interest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView detail = (TextView)findViewById(R.id.detail);

                TextView eventName = (TextView) findViewById(R.id.eventName);

                TextView contactAt = (TextView) findViewById(R.id.contactAt);

                TextView abstractDetail = (TextView) findViewById(R.id.abstractDetail);

                Intent i = new Intent( description.this, ProfileActivity.class);

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