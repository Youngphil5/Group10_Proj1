package com.daclink.drew.sp22.cst438_project01_starter.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealResponse {
    @SerializedName("meals")
    @Expose
    List<Meal> meals = null;

    public List<Meal> getMeals() {
        return meals;
    }
}
