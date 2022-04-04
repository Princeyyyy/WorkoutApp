package com.example.workoutapp.models;

import com.example.workoutapp.results.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Workout {



    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("results")
    @Expose
    private ArrayList<Result> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}
