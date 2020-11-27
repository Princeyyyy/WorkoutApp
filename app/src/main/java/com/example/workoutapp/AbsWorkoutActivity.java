package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.workoutapp.models.Workout;
import com.example.workoutapp.results.Result;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsWorkoutActivity extends AppCompatActivity {
    public static final String TAG = AbsWorkoutActivity.class.getSimpleName();
    RecyclerView rvMain;


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
                            "kind: " + resultsList.get(i).getName() +
                            "kind: " + resultsList.get(i).getDescription());

                }
            }

            @Override
            public void onFailure(Call<Workout> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong"+ t.getMessage() );
            }
        });

    }
}