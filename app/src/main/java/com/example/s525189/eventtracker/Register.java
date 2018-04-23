package com.example.s525189.eventtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;


public class Register extends AppCompatActivity {
    Button btnRegister;
    EditText txtemail;
    EditText txtpassword;
    EditText txtconfirmpassword;
    EditText txtFname;
    EditText txtLname;

    String gotemail, gotpassword, gotconfirmpassword,gotFname, gotLname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister = (Button) findViewById(R.id.registerBtn);

        txtemail = (EditText) findViewById(R.id.emailgiven);
        txtpassword = (EditText) findViewById(R.id.passwordgiven);
        //txtconfirmpassword = (EditText) findViewById(R.id.Confirmpasswordgiven);
        txtFname = (EditText) findViewById(R.id.FirstName);
        txtLname = (EditText) findViewById(R.id.LastName);







        btnRegister.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                gotemail = txtemail.getText().toString();



                gotpassword = txtpassword.getText().toString();
                //gotconfirmpassword = txtconfirmpassword.getText().toString();
                gotFname = txtFname.getText().toString();
                gotLname = txtLname.getText().toString();
                Log.d("The value is ",""+gotemail.trim().length()+" "+gotpassword.trim().length()+"" +gotFname.trim().length()+""+gotLname.trim().length());

                if(gotemail.trim().length()==0 && gotpassword.trim().length()==0 && gotFname.trim().length()==0 && gotLname.trim().length()==0 ){

                    Toast.makeText(Register.this, "Empty Field!", Toast.LENGTH_LONG).show();


                }
                else {
                    if (!EmailValidator.getInstance().validate(txtemail.getText().toString().trim())) {
                        Toast.makeText(Register.this, "Invalid Email Address!", Toast.LENGTH_LONG).show();;
                    } else {

                /*} else {
                    Toast.makeText(Register.this, "Password Mismatch!!", Toast.LENGTH_LONG).show();

                }*/

                        BackendlessUser user = new BackendlessUser();
                        user.setProperty("email", gotemail);
                        user.setProperty("name", gotFname);
                        user.setProperty("surname", gotLname);
                        user.setPassword(gotpassword);

                        Log.d("email", gotemail);
                        Log.d("email", gotFname);
                        Log.d("email", gotLname);
                        Log.d("email", gotpassword);

                        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                Toast.makeText(Register.this, "New User Registered!", Toast.LENGTH_LONG).show();
                                 Intent i = new Intent(Register.this, LoginActivity.class);
                        startActivity(i);
                                //dialog.dismiss();
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                Toast.makeText(Register.this, fault.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }

            }
        });


    }

    /*public boolean isPasswordMatch(CharSequence password, CharSequence passwordConfirm) {
        if (!TextUtils.equals(password, passwordConfirm)) {
            //Toast.makeText(this, "Password donot match", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }*/
}
