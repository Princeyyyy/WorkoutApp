package com.example.workoutapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.workoutapp.R;
import com.example.workoutapp.UserHelperClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {
    Button signUp, toLogin;
    TextInputLayout regName, regUsername, regEmail, regNumber, regPassword;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        signUp = findViewById(R.id.sign_up_btn);
        regName = findViewById(R.id.name);
        regUsername = findViewById(R.id.username);
        regEmail = findViewById(R.id.email);
        regNumber = findViewById(R.id.phoneNumber);
        regPassword = findViewById(R.id.password);
        toLogin = findViewById(R.id.to_login_btn);



        toLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v == toLogin) {
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String name = regName.getEditText().getText().toString();
                String username = regUsername.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String number = regNumber.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name,username,email,number,password);

                reference.child(number).setValue(helperClass);

                Intent intent = new Intent(SignUpActivity.this, WorkoutActivity.class);
                startActivity(intent);
                Toast.makeText(SignUpActivity.this, "Your Account has Been Created" , Toast.LENGTH_SHORT).show();
            }
        });
        }
}