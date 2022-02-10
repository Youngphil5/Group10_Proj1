package com.daclink.drew.sp22.cst438_project01_starter.api;

import com.daclink.drew.sp22.cst438_project01_starter.models.Meal;
import com.daclink.drew.sp22.cst438_project01_starter.models.MealResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpointInterface {
    @GET("/api/json/v1/1/search.php?s={strMeal}")
    Call<MealResponse> searchMeal(
            @Query("s") String query
            );
//    @GET("/api/json/v1/1/search.php?s={strMeal}")
//    void getMeal(@Path("strMeal") String meal, Callback<MealResponse> mealCallback);
}
