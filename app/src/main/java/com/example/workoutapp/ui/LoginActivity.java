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
    }

}