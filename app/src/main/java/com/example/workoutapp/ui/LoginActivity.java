package com.example.workoutapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.workoutapp.R;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    Button signUpScreen;
//    @BindView(R.id.signup_screen) Button mSignUpScreenButton;
    @BindView(R.id.logo_image) ImageView mLogoImage;
    @BindView(R.id.logo_name) TextView mLogoName;
    @BindView(R.id.slogan_name) TextView mSloganImage;
    @BindView(R.id.login_btn) Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
//        ButterKnife.bind(this);

        signUpScreen = findViewById(R.id.signup_screen);

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

//    @Override
//    public void onClick(View v) {
//        if(v == mSignUpScreenButton) {
//            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
//            startActivity(intent);
//        }
//
//    }

}