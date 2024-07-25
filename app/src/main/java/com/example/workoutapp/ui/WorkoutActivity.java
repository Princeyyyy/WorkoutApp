package com.example.workoutapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workoutapp.R;

public class WorkoutActivity extends AppCompatActivity {
    private TextView mtitlepage;
    private TextView msubtitlepage;
    private TextView mintropage;
    private TextView msubintropage;
    private View mdivpage;
    private RadioButton mabsButton;
    private RadioButton marmsButton;
    private RadioButton mbackButton;
    private RadioButton mcalvesButton;
    private RadioButton mchestButton;
    private RadioButton mlegsButton;
    private RadioButton mshouldersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        // Initialize views
        mtitlepage = findViewById(R.id.titlepage);
        msubtitlepage = findViewById(R.id.subtitlepage);
        mintropage = findViewById(R.id.intropage);
        msubintropage = findViewById(R.id.subintropage);
        mdivpage = findViewById(R.id.divpage);
        mabsButton = findViewById(R.id.absButton);
        marmsButton = findViewById(R.id.armsButton);
        mbackButton = findViewById(R.id.backButton);
        mcalvesButton = findViewById(R.id.calvesButton);
        mchestButton = findViewById(R.id.chestButton);
        mlegsButton = findViewById(R.id.legsButton);
        mshouldersButton = findViewById(R.id.shouldersButton);

        // Set click listeners for all buttons
        setButtonClickListener(mabsButton, AbsWorkoutActivity.class);
        setButtonClickListener(marmsButton, ArmsWorkoutActivity.class);
        setButtonClickListener(mbackButton, BackWorkoutActivity.class);
        setButtonClickListener(mcalvesButton, CalvesWorkoutActivity.class);
        setButtonClickListener(mchestButton, ChestWorkoutActivity.class);
        setButtonClickListener(mlegsButton, LegsWorkoutActivity.class);
        setButtonClickListener(mshouldersButton, ShouldersWorkoutActivity.class);
    }

    private void setButtonClickListener(final RadioButton button, final Class<?> activityClass) {
        button.setOnClickListener(v -> {
            Toast.makeText(WorkoutActivity.this, "You have selected " + button.getText(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(WorkoutActivity.this, activityClass);
            startActivity(intent);
        });
    }
}