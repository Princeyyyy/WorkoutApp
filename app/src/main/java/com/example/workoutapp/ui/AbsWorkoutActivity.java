package com.example.workoutapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.workoutapp.R;
import com.example.workoutapp.models.Workout;
import com.example.workoutapp.network.WgerApi;
import com.example.workoutapp.network.WgerClient;
import com.example.workoutapp.results.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsWorkoutActivity extends AppCompatActivity {
    public static final String TAG = AbsWorkoutActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        WgerApi client = WgerClient.getClient();
        Call<Workout> call = client.getWorkouts(10);

        call.enqueue(new Callback<Workout>() {
            @Override
            public void onResponse(Call<Workout> call, Response<Workout> response) {
                Log.d(TAG, "onResponse: Server Response" + response.toString());

                ArrayList<Result> resultsList = response.body().getResults();
                for (int i = 0; i < resultsList.size(); i++) {
                    Log.d(TAG, "onResponse: \n" +
                            "Name: " + resultsList.get(i).getName() + "\n" +
                            "Description: " + resultsList.get(i).getDescription());

                }
            }

            @Override
            public void onFailure(Call<Workout> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong"+ t.getMessage() );
            }
        });

    }
}