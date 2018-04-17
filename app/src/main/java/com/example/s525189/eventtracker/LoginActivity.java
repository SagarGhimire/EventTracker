package com.example.s525189.eventtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;

/**
 * A login screen that offers  login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    ArrayList<String> dummyData = new ArrayList<>();
    boolean checkInfo;
    TextView txt;

    EditText txtemail;
    EditText txtpassword;
    String gotemail;
    String gotpassword;
    Button btnLogin, btnReset,btnRegister,AdminSignInButton;

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
        /*dummyData.add("919512551");
        dummyData.add("919508569");
        dummyData.add("919593265");
        dummyData.add("919511639");
        txt = (TextView) findViewById(R.id.labelTV);
        txt.setVisibility(View.GONE);*/


        btnLogin= (Button) findViewById(R.id.email_sign_in_button);
        btnReset =(Button)findViewById(R.id.ResetBtn);
        AdminSignInButton = (Button) findViewById(R.id.admin_sign_in_button);
        btnRegister = (Button) findViewById(R.id.btntoregister);


        txtemail =(EditText) findViewById(R.id.emailgiven);
        txtpassword=(EditText)findViewById(R.id.passwordgiven);


        /*mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dummyNum = (EditText) findViewById(R.id.email);
                String dummyValue = dummyNum.getText().toString();
                checkInfo = checkAuthentication(dummyData, dummyValue);

                if (checkInfo == true) {

                    Intent i = new Intent(LoginActivity.this, homeActivity.class);
                    startActivity(i);
                } else {
                    txt.setVisibility(View.VISIBLE);
                    txt.setText("Incorrect Credentials");


                }
            }
        });*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                gotemail = txtemail.getText().toString();
                gotpassword =txtpassword.getText().toString();
                Log.d("",""+ gotpassword+""+gotemail);

                Backendless.UserService.login(gotemail, gotpassword, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Log.d("good inside", "gooood");
                        Intent i = new Intent(LoginActivity.this, homeActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.d("Error inside", "errr");
                        Toast.makeText(LoginActivity.this, fault.getMessage(), Toast.LENGTH_LONG).show();
                    }
                },true);

            }
        });


        btnReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(LoginActivity.this, ResetPassword.class);
                startActivity(x);
            }
        });

<<<<<<< HEAD
=======



        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(LoginActivity.this, Register.class);
                startActivity(m);
                }
                });




                AdminSignInButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent x = new Intent(LoginActivity.this, AdminLogin.class);
                        startActivity(x);
                    }
                });


>>>>>>> 5fceb8aa0b11cf97a7b7ba0d2286da1d8432cc82
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

