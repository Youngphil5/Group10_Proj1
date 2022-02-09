package com.daclink.drew.sp22.cst438_project01_starter;

import com.daclink.drew.sp22.cst438_project01_starter.models.Food;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndpointInterface {
    @GET("/api/json/v1/1/search.php?s={strMeal}")
    Call<Food> getMeal(@Path("strMeal") String strMeal);

    @POST("/new")
    Call<Food> createMeal(@Body Food food);
}
