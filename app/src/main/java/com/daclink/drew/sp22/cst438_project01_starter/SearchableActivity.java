package com.daclink.drew.sp22.cst438_project01_starter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

public class SearchableActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    /* Make an api food list here */

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        //ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //SearchView
        setUpSearchView();

        recyclerView = findViewById(R.id.recyclerView);
    }

    //calling method in whatever "Main" Activity to get the api
    /* This is a possible example
        private void searchFoodApi(String query, int pageNumber){
            foodListViewModel.searchFoodApi(query,pageNumebr);
         }
     */

    //We set this up and then add data to it!
    private void ConfigureRecyclerView(){
        //this just needs api stuff in it so I can't do much currently
    }

    //Getting data from searchview and query the api to get the result(I don't need to do this now but later!)
    private void setUpSearchView() {
        final SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //place the api view model in this
                //then query the search, basically look up the stuff
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //
                return false;
            }
        });
    }
} // I have no idea why this needs two close brackets but its the only way it works