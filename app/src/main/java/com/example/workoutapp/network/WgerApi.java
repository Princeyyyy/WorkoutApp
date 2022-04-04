package com.example.workoutapp.network;

import com.example.workoutapp.models.Workout;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WgerApi {

    @GET("exerciseinfo")
    Call<Workout> getWorkouts(
            @Query("category") int category
    );

}
