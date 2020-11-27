package com.example.workoutapp.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String Description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
