package com.example.workoutapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.workoutapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.startWorkoutButton) Button mStartWorkoutButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
//    Animation topAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
//        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
//
//        mAppNameTextView.setAnimation(bottomAnim);

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