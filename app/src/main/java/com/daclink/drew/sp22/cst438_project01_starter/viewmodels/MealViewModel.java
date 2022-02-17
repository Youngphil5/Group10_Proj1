package com.daclink.drew.sp22.cst438_project01_starter.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.daclink.drew.sp22.cst438_project01_starter.models.MealResponse;
import com.daclink.drew.sp22.cst438_project01_starter.repositories.MealRepository;

public class MealViewModel extends AndroidViewModel {
    private MealRepository mealRepository;
    private LiveData<MealResponse> mealResponseLiveData;

    public MealViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        mealRepository = new MealRepository();
        mealResponseLiveData = mealRepository.getMealResponseLiveData();
    }

    public void searchMeals(String keyword) {
        mealRepository.searchMeals(keyword);
    }

    public LiveData<MealResponse> getMealResponseLiveData() {
        return mealResponseLiveData;
    }
}
