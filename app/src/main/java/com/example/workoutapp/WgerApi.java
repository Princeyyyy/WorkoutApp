package com.example.workoutapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WgerApi {

    @GET("exerciseinfo")
    Call<List<Workout>> getWorkouts(
            @Query("category") int category
    );

}
