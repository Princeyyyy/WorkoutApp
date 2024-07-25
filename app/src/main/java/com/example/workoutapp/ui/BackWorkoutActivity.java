package com.example.workoutapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.workoutapp.R;
import com.example.workoutapp.adapters.RecyclerViewAdapter;
import com.example.workoutapp.models.Workout;
import com.example.workoutapp.network.WgerApi;
import com.example.workoutapp.network.WgerClient;
import com.example.workoutapp.results.Result;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BackWorkoutActivity extends AppCompatActivity {
    public static final String TAG = BackWorkoutActivity.class.getSimpleName();

    private TextView mErrorTextView;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private RecyclerViewAdapter mAdapter;
    public ArrayList<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        // Initialize views
        mErrorTextView = findViewById(R.id.errorTextView);
        mRecyclerView = findViewById(R.id.RecyclerView);
        mProgressBar = findViewById(R.id.progressBar);

        WgerApi client = WgerClient.getClient();
        Call<Workout> call = client.getWorkouts(12);

        call.enqueue(new Callback<Workout>() {
            @Override
            public void onResponse(Call<Workout> call, Response<Workout> response) {
                hideProgressBar();
                Log.d(TAG, "onResponse: Server Response" + response.toString());

                if (response.isSuccessful()) {
                    results = response.body().getResults();
                    mAdapter = new RecyclerViewAdapter(BackWorkoutActivity.this, results);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BackWorkoutActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showWorkouts();

                } else {
                    IOException e = new IOException();
                    showUnsuccessfulMessage();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Workout> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong" + t.getMessage());
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showWorkouts() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}