package com.daclink.drew.sp22.cst438_project01_starter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daclink.drew.sp22.cst438_project01_starter.models.Meal;

import java.util.ArrayList;
import java.util.List;



public class MealSearchResultsAdapter extends RecyclerView.Adapter<MealSearchResultsAdapter.MealSearchResultsHolder> {
    private List<Meal> results = new ArrayList<>();

    @NonNull
    @Override
    public MealSearchResultsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new MealSearchResultsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MealSearchResultsHolder holder, int position) {
        // Volume volume = results.get(position);
        Meal meal = results.get(position);

        holder.mealTextView.setText(meal.getStrMeal());

        if (meal.getStrMealThumb() != null) {
            String imageUrl = meal.getStrMealThumb()
                    .replace("http://", "https://");

            Glide.with(holder.itemView)
                    .load(imageUrl)
                    .into(holder.mealImageView);
        }
        //placeholder for if statements
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<Meal> results) {
        this.results = results;
        notifyDataSetChanged();
    }


    class MealSearchResultsHolder extends RecyclerView.ViewHolder {
        private TextView mealTextView;
        private ImageView mealImageView;

        public MealSearchResultsHolder(@NonNull View itemView) {
            super(itemView);
            mealTextView = itemView.findViewById(R.id.meal_item_title);
            mealImageView = itemView.findViewById(R.id.meal_item_smallThumbnail);
        }
    }
}


