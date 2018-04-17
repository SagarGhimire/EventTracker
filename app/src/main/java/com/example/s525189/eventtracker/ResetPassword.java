package com.example.s525189.eventtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class ResetPassword extends AppCompatActivity {
Button btnsend;
EditText txtemail;
String emailstr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);



        btnsend =(Button) findViewById(R.id.sendBtn);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                txtemail =(EditText) findViewById(R.id.emailinput);
                emailstr =txtemail.getText().toString();
                Backendless.UserService.restorePassword(emailstr, new AsyncCallback<Void>() {
                    @Override
                    public void handleResponse(Void response) {
                        Toast.makeText(ResetPassword.this, "Reset instruction sent to email", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(ResetPassword.this, fault.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}
