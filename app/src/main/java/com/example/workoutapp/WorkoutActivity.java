package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;

public class WorkoutActivity extends AppCompatActivity {
    @BindView(R.id.nextButton) Button mnextButton;
    @BindView(R.id.titlepage) TextView mtitlepage;
    @BindView(R.id.subtitlepage) TextView msubtitlepage;
    @BindView(R.id.intropage) TextView mintropage;
    @BindView(R.id.subintropage) TextView msubintropage;
    @BindView(R.id.divpage) View mdivpage;
    @BindView(R.id.beginnerRadioButton) RadioButton mbeginnerExercise;
    @BindView(R.id.intermediateRadioButton) RadioButton mintermediateExercise;
    @BindView(R.id.advancedRadioButton) RadioButton madvancedExercise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
    }
}