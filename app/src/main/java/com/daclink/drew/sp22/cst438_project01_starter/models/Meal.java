package com.daclink.drew.sp22.cst438_project01_starter.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Meal {

    @SerializedName("idMeal")
    @Expose
    private String idMeal;

    @SerializedName("strMeal")
    @Expose
    private String strMeal;

    @SerializedName("strCategory")
    @Expose
    private String strCategory;

    @SerializedName("strArea")
    @Expose
    private String strArea;

    @SerializedName("strTags")
    @Expose
    private String strTags;

    public String getIdMeal() {
        return idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public String getStrTags() {
        return strTags;
    }
}

