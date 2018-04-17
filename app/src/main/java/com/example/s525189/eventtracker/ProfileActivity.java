package com.example.s525189.eventtracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.local.UserIdStorageFactory;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    String data;
    Button btnLogout;
    String val;

TextView emailtxt, Fnametxt, Lnametxt,errortxt;
String gotemail, gotFname, gotLname, gotError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent i = getIntent();
        val = i.getStringExtra("EventName");

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


//                } else if (item.getItemId() == R.id.profile) {
//                    Intent prfle = new Intent(ProfileActivity.this,event.class);
//                    startActivity(prfle);


                return false;
            }
        });



        String userObjectId = UserIdStorageFactory.instance().getStorage().get();
        Backendless.Data.of(BackendlessUser.class).findById(userObjectId, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                emailtxt = (TextView) findViewById(R.id.emailview);
                Fnametxt = (TextView) findViewById(R.id.FName);
                Lnametxt = (TextView) findViewById(R.id.LName);


                gotemail = response.getEmail().toString();
                gotFname = response.getProperty("name").toString();
                gotLname = response.getProperty("surname").toString();

                Log.d("email", gotemail);
                Log.d("email", gotFname);
                Log.d("email", gotLname);

                emailtxt.setText("Email: " +gotemail);
                Fnametxt.setText("First Name: "+gotFname);
                Lnametxt.setText("Last Name: "+ gotLname);


                //Toast.makeText(ProfileActivity.this, response.getEmail() +"" +response.getProperty("name"),Toast.LENGTH_LONG).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {

                errortxt = (TextView) findViewById(R.id.Errormsg);
                gotError= fault.getMessage().toString();
                Log.d("rerror", gotError);

                errortxt.setText(gotError);
                //Toast.makeText(ProfileActivity.this, fault.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        final ArrayList<String> item = new ArrayList<>();
        item.add(val);


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


