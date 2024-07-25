package com.example.workoutapp.results;

import android.text.Html;
import android.os.Build;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String Description;

    private static String removeHtmlTags(String html) {
        if (html == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString().trim();
        } else {
            return Html.fromHtml(html).toString().trim();
        }
    }

    public String getName() {
        return removeHtmlTags(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return removeHtmlTags(Description);
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + getName() + '\'' +
                ", Description='" + getDescription() + '\'' +
                '}';
    }
}