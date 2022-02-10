package com.daclink.drew.sp22.cst438_project01_starter.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.daclink.drew.sp22.cst438_project01_starter.api.ApiEndpointInterface;
import com.daclink.drew.sp22.cst438_project01_starter.models.Meal;
import com.daclink.drew.sp22.cst438_project01_starter.models.MealResponse;

import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.OkHttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealRepository {
    private static final String MEAL_SEARCH_SERVICE_BASE_URL = "https://www.themealdb.com/api.php/";

    private ApiEndpointInterface apiEndpointInterface;
    private MutableLiveData<MealResponse> mealResponseLiveData;

    public MealRepository() {
        mealResponseLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        apiEndpointInterface = new retrofit2.Retrofit.Builder()
                .baseUrl(MEAL_SEARCH_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiEndpointInterface.class);
    }

    public void searchMeals(String meals) {
        apiEndpointInterface.searchMeal(meals)
                .enqueue(new Callback<MealResponse>() {
                    @Override
                    public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                        if (response.body() != null) {
                            mealResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<MealResponse> call, Throwable t) {
                        mealResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<MealResponse> getMealResponseLiveData() {
        return mealResponseLiveData;
    }
}
