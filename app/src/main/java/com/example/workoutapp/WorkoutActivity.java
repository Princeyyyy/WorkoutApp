package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;

public class WorkoutActivity extends AppCompatActivity {
    @BindView(R.id.titlepage) TextView mtitlepage;
    @BindView(R.id.subtitlepage) TextView msubtitlepage;
    @BindView(R.id.intropage) TextView mintropage;
    @BindView(R.id.subintropage) TextView msubintropage;
    @BindView(R.id.divpage) View mdivpage;
    @BindView(R.id.absButton) RadioButton mabsButton;
    @BindView(R.id.armsButton) RadioButton marmsButton;
    @BindView(R.id.backButton) RadioButton mbackButton;
    @BindView(R.id.calvesButton) RadioButton mcalvesButton;
    @BindView(R.id.chestButton) RadioButton mchestButton;
    @BindView(R.id.legsButton) RadioButton mlegsButton;
    @BindView(R.id.shouldersButton) RadioButton mshouldersButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        //Abs Toast//
        mabsButton = (RadioButton) findViewById(R.id.absButton);
        mabsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mabsButton) {
                    Toast.makeText(WorkoutActivity.this, "You have selected " + mabsButton.getText(), Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(WorkoutActivity.this, AbsWorkoutActivity.class);
                startActivity(intent);
            }

        });

        //Arms Toast//
        marmsButton = (RadioButton) findViewById(R.id.armsButton);
        marmsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == marmsButton) {
                    Toast.makeText(WorkoutActivity.this, "You have selected " + marmsButton.getText(), Toast.LENGTH_SHORT).show();
                }
                    Intent intent = new Intent(WorkoutActivity.this, AbsWorkoutActivity.class);
                    startActivity(intent);
                }

            });

        //Back Toast//
        mbackButton = (RadioButton) findViewById(R.id.backButton);
        mbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkoutActivity.this, "You have selected " + mbackButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //Calves Toast//
        mcalvesButton = (RadioButton) findViewById(R.id.calvesButton);
        mcalvesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkoutActivity.this, "You have selected " + mcalvesButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //Chest Toast//
        mchestButton = (RadioButton) findViewById(R.id.chestButton);
        mchestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkoutActivity.this, "You have selected " + mchestButton.getText(), Toast.LENGTH_LONG).show();
            }
        });

        //Legs Toast//
        mlegsButton = (RadioButton) findViewById(R.id.legsButton);
        mlegsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkoutActivity.this, "You have selected " + mlegsButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //Shoulders Toast//
        mshouldersButton = (RadioButton) findViewById(R.id.shouldersButton);
        mshouldersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkoutActivity.this, "You have selected " + mshouldersButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

