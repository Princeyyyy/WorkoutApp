package com.example.workoutapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.workoutapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.startWorkoutButton) Button mStartWorkoutButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mStartWorkoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mStartWorkoutButton) {
            Intent intent = new Intent(MainActivity.this, DecisionActivity.class);
            startActivity(intent);
        }

    }
}