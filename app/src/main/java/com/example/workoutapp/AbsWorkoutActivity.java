package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
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
        rvMain = findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(AbsWorkoutActivity.this));


        WgerApi client = WgerClient.getClient();
        Call<List<Workout>> call = client.getWorkouts(10);

        call.enqueue(new Callback<List<Workout>>() {
            @Override
            public void onResponse(Call<List<Workout>> call, Response<List<Workout>> response) {
                parseData(response.body());
            }

            @Override
            public void onFailure(Call<List<Workout>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });

    }

    private void parseData(List<Workout> body) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(body);
        rvMain.setAdapter(recyclerViewAdapter);

    }
}