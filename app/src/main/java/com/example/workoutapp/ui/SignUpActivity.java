package com.example.workoutapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.workoutapp.R;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {
    @BindView(R.id.sign_up_btn) TextInputLayout mSignUpBtn;
    @BindView(R.id.username) TextInputLayout mUserName;
    @BindView(R.id.password) TextInputLayout mPassword;
    @BindView(R.id.name) TextInputLayout mName;
    @BindView(R.id.email) TextInputLayout mEmail;
    @BindView(R.id.phoneNumber) TextInputLayout mPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }
}