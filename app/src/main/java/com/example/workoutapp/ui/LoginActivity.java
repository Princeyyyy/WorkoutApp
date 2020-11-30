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
    @BindView(R.id.signup_screen) Button mSignUpScreenButton;
    @BindView(R.id.logo_image) Button mLogoImage;
    @BindView(R.id.logo_name) TextInputLayout mLogoName;
    @BindView(R.id.slogan_name) TextInputLayout mSloganImage;
    @BindView(R.id.login_btn) Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        ButterKnife.bind(this);

        mSignUpScreenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v == mSignUpScreenButton) {
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