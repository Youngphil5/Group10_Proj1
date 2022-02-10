package com.daclink.drew.sp22.cst438_project01_starter.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealResponse {
    @SerializedName("meals")
    @Expose
    private String meals;

    public String getMeals() {
        return meals;
    }
}
