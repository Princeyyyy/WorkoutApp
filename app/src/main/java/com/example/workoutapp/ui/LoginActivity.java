package com.example.workoutapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.workoutapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText mloginEmail;
    private EditText mloginPassword;
    private Button mloginButton;
    private Button msignupScreen;

    private FirebaseAuth mAuth;
    private ProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mloginEmail = findViewById(R.id.loginEmail);
        mloginPassword = findViewById(R.id.loginPassword);
        mloginButton = findViewById(R.id.loginButton);
        msignupScreen = findViewById(R.id.signupScreen);

        mAuth = FirebaseAuth.getInstance();
        loader = new ProgressDialog(this);

        if (mAuth.getCurrentUser() != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        msignupScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        mloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mloginEmail.getText().toString().trim();
                String password = mloginPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mloginEmail.setError("Email is Required");
                }
                if (TextUtils.isEmpty(password)) {
                    mloginPassword.setError("Password is Required");
                } else {
                    loader.setMessage("LogIn in Progress");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();

                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                loader.dismiss();
                            } else {
                                String error = task.getException().toString();
                                Toast.makeText(LoginActivity.this, "Login Failed " + error, Toast.LENGTH_SHORT).show();
                                loader.dismiss();
                            }
                        }
                    });
                }
            }
        });
    }
}