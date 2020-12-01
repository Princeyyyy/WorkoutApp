package com.example.workoutapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workoutapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    Button signUpScreen, login_btn;
    TextView logoText, sloganText;
    TextInputLayout username, password;
//    @BindView(R.id.signup_screen) Button mSignUpScreenButton;
//    @BindView(R.id.logo_image) ImageView mLogoImage;
//    @BindView(R.id.logo_name) TextView mLogoName;
//    @BindView(R.id.slogan_name) TextView mSloganImage;
//    @BindView(R.id.login_btn) Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
//        ButterKnife.bind(this);

        signUpScreen = findViewById(R.id.signup_screen);
        login_btn = findViewById(R.id.login_btn);
        logoText =  findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);

        signUpScreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v == signUpScreen) {
                    Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    private Boolean validateUserName() {
      String val = username.getEditText().getText().toString();

      if (val.isEmpty()){
          username.setError("Field cannot be Empty");
          return false;
      }else{
          username.setError(null);
          username.setErrorEnabled(false);
          return true;
      }
    }

    private Boolean validatePassword(){
        String val = password.getEditText().getText().toString();

        if (val.isEmpty()){
            password.setError("Field cannot be Empty");
            return false;
        }else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private void loginUser(View view){
        //Validate Login Info
        if (!validateUserName() | !validatePassword()) {
            return;
        }else {
            isUser();
        }
    }

    private void isUser() {

        String userEnteredUsername = username.getEditText().getText().toString().trim();
        String userEnteredPassword = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){

                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userEnteredPassword)){

                        username.setError(null);
                        username.setErrorEnabled(false);

//                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
//                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
//                        String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
//                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);

                        Intent intent =  new Intent(getApplicationContext(), WorkoutActivity.class);
                        startActivity(intent);

                    }else{
                        password.setError("Wrong Password");
                        password.requestFocus();

                    }
                }else{
                    username.setError("No Such User Exists");
                    username.requestFocus();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}