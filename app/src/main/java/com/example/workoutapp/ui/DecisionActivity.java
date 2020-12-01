package com.example.workoutapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.workoutapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DecisionActivity extends AppCompatActivity {
    Button mdecisionAccountButton, mdecisionWorkoutButton;
//    @BindView(R.id.decisionAccountButton) Button mdecisionAccountButton;
//    @BindView(R.id.decisionWorkoutButton) Button mdecisionWorkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);
        ButterKnife.bind(this);

//        mdecisionAccountButton.setOnClickListener(this);
//        mdecisionWorkoutButton.setOnClickListener(this);
        mdecisionAccountButton = findViewById(R.id.decisionAccountButton);
        mdecisionWorkoutButton = findViewById(R.id.decisionWorkoutButton);

        mdecisionAccountButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v == mdecisionAccountButton) {
                    Intent intent = new Intent(DecisionActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }

            }
        });

        mdecisionWorkoutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v == mdecisionWorkoutButton) {
                    Intent intent = new Intent(DecisionActivity.this, WorkoutActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}