package com.example.workoutapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Workout {

    @SerializedName("name")
    String wname;

    @SerializedName("description")
    String wdescription;

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWdescription() {
        return wdescription;
    }

    public void setWdescription(String wdescription) {
        this.wdescription = wdescription;
    }
}
