package com.example.s525189.eventtracker;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class ProfileActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    String data;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
                }
                else if (item.getItemId() == R.id.venue) {
                    Intent x = new Intent(ProfileActivity.this, VenuActivity.class);
                    startActivity(x);
                }

//                } else if (item.getItemId() == R.id.profile) {
//                    Intent prfle = new Intent(ProfileActivity.this,event.class);
//                    startActivity(prfle);


                return false;
            }
        });

        final ArrayList<String> item = new ArrayList<>();
        item.add("id");
        item.add("First Name");
        item.add("Last Name");


        ListAdapter itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item) {
            @NonNull
            @Override
            public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
               View v =super.getView(position,convertView,parent);
               return v;
            }


        };
        ListView myList = (ListView) findViewById(R.id.myList);
        myList.setAdapter(itemAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        btnLogout=(Button) findViewById(R.id.logoutbtn);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backendless.UserService.logout(new AsyncCallback<Void>() {
                    @Override
                    public void handleResponse(Void response) {
                        Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(ProfileActivity.this, fault.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}


