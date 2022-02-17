package com.daclink.drew.sp22.cst438_project01_starter.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Food {

    @SerializedName("meals")
    @Expose
    private List<Meal> meals = null;

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public static final String BASE_URL = "https://www.themealdb.com/api.php/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @SerializedName("strMeal")
    String strMeal;

    @SerializedName("strCategory")
    String strCategory;

    @SerializedName("strTags")
    String strTags;

    @SerializedName("idMeal")
    String idMeal;

    public Food(String strMeal, String strCategory, String strTags, String idMeal) {
        this.strCategory = strCategory;
        this.strMeal = strMeal;
        this.strTags = strTags;
        this.idMeal = idMeal;
    }
}