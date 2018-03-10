package com.example.s525189.eventtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Button btn = (Button) findViewById(R.id.createEvent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("second access", "starting web action");
                Intent intent = new Intent(AdminActivity.this, EventSubmitActivity.class);
                intent.putExtra("Class", "A");
                startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });

    }
}
