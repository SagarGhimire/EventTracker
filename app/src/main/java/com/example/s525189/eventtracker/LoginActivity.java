package com.example.s525189.eventtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A login screen that offers  login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    ArrayList<String> dummyData = new ArrayList<>();
    boolean checkInfo;
    TextView txt;


    /**
     * Id to identity READ_CONTACTS permission request.
     */


    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */


    // UI references.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dummyData.add("919512551");
        dummyData.add("919508569");
        dummyData.add("919593265");
        dummyData.add("919511639");
        txt = (TextView) findViewById(R.id.labelTV);




        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dummyNum = (EditText) findViewById(R.id.email);
                String dummyValue = dummyNum.getText().toString();
                checkInfo = checkAuthentication(dummyData, dummyValue);
                if (checkInfo == true) {

                    Intent i = new Intent(LoginActivity.this, homeActivity.class);
                    startActivity(i);
                } else {
                    txt.setText("Incorrect Credentials");

                }
            }
        });


        Button AdminSignInButton = (Button) findViewById(R.id.admin_sign_in_button);
        AdminSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(LoginActivity.this, AdminActivity.class);
                startActivity(x);

            }
        });

    }

    public static boolean checkAuthentication(ArrayList<String> a, String data) {
        boolean val = true;
        for (int i = 0; i < a.size(); i++) {
            if (data.contains(a.get(i))) {
                val = true;
                break;
            } else {
                val = false;
            }

        }
        return val;

    }
}

