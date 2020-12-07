package com.example.wannavisit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    EditText mEmail, mPassword1, mPassword2;
    Button mLoginBtn, mRegisterBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mEmail = findViewById(R.id.email);
        mPassword1 = findViewById(R.id.pwd1);
        mPassword2 = findViewById(R.id.pwd2);
        mLoginBtn = findViewById(R.id.signup1);
        mRegisterBtn = findViewById(R.id.login1);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),dashboard.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String pwd1 = mPassword1.getText().toString().trim();
                String pwd2 = mPassword2.getText().toString().trim();

                //Deciding appropriate data
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(pwd1)){
                    mPassword1.setError("Please enter the password.");
                    return;
                }

                if(TextUtils.isEmpty(pwd2)){
                    mPassword2.setError("Confirm Password!");
                    return;
                }

                if(pwd1.length() < 6){
                    mPassword1.setError("Password length must be 6 or more.");
                    return;
                }

                if(!pwd1.equals(pwd2)){
                    mPassword2.setError("Passwords don't match.");
                    return;
                }

                //Registration
                fAuth.createUserWithEmailAndPassword(email, pwd1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signup.this, "Account created successfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),dashboard.class));

//                            String msg = "Welcome to WannaVisit. Feel free to explore.";

                        }else{
                            Toast.makeText(signup.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });




            }

        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });
    }
}