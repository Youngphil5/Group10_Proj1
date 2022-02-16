package com.daclink.drew.sp22.cst438_project01_starter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.daclink.drew.sp22.cst438_project01_starter.models.MealResponse;
import com.daclink.drew.sp22.cst438_project01_starter.viewmodels.MealViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class SearchableFragment extends Fragment {
    private MealViewModel viewModel;
    private MealSearchResultsAdapter adapter;

    private TextInputEditText keywordEditText;
    private Button searchButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new MealSearchResultsAdapter();

        //note here for error problem
        viewModel = ViewModelProviders.of(this).get(MealViewModel.class);
        viewModel.init();
        viewModel.getMealResponseLiveData().observe(this, new Observer<MealResponse>() {
            @Override
            public void onChanged(MealResponse mealResponse) {
                if (mealResponse != null) {
                    adapter.setResults(mealResponse.getMeals());
                }
            }
        });
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_searchbak, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.mealResults);
        recyclerView.setAdapter(adapter);

        keywordEditText = view.findViewById(R.id.search_view);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
            }
        });
        return view;
    }

    public void performSearch() {
        String keyword = keywordEditText.getEditableText().toString();

        viewModel.searchMeals(keyword);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
