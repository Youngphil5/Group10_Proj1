package com.daclink.drew.sp22.cst438_project01_starter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daclink.drew.sp22.cst438_project01_starter.models.Meal;

import java.util.ArrayList;
import java.util.List;



public class MealSearchResultsAdapter extends RecyclerView.Adapter<MealSearchResultsAdapter.MealSearchResultsHolder> {
    private List<Meal> results = new ArrayList<>();

    @NonNull
    @Override
    public MealSearchResultsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_searchbak, parent, false);
        return new MealSearchResultsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MealSearchResultsHolder holder, int position) {
        Meal meal = results.get(position);

        holder.mealTextView.setText(meal.getStrMeal());
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

        public MealSearchResultsHolder(@NonNull View itemView) {
            super(itemView);

            mealTextView = itemView.findViewById(R.id.search_view);
        }
    }
}


