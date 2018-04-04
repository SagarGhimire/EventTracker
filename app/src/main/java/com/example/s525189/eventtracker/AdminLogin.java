package com.example.s525189.eventtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.s525189.eventtracker.LoginActivity.checkAuthentication;

public class AdminLogin extends AppCompatActivity {
    ArrayList<String> adminData = new ArrayList<>();
    boolean checkInfo;
    boolean pswInfo;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        adminData.add("admin@nwmissouri.edu");
        adminData.add("nimda");
        txt = (TextView) findViewById(R.id.labelTV);
        txt.setVisibility(View.GONE);


        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dummyEmail = (EditText) findViewById(R.id.email);
                String dummyADminEmail = dummyEmail.getText().toString();
                EditText dummyPswd = (EditText) findViewById(R.id.password);
                String dummyAdminPswd = dummyPswd.getText().toString();
                checkInfo = checkAuthentication(adminData, dummyADminEmail);
                pswInfo = checkAuthentication(adminData, dummyAdminPswd);;
                if ((checkInfo == true) && (pswInfo == true)) {

                    Intent i = new Intent(AdminLogin.this, AdminActivity.class);
                    startActivity(i);
                } else {
                    txt.setVisibility(View.VISIBLE);
                    txt.setText("Incorrect Credentials");

                }
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
