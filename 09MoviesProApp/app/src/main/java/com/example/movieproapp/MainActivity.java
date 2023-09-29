package com.example.movieproapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.movieproapp.adapters.MovieAdapter;
import com.example.movieproapp.databinding.ActivityMainBinding;
import com.example.movieproapp.model.Movie;
import com.example.movieproapp.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    /** Databinding
     *  CONFIGURATION
     *  1. Add DataBinding dependency
     */


    /** Retrofit
     * CONFIGURATION:
     * 1. Add Retrofit dependency in build configuration files
     * 2. Add GSON Converter dependency in build configuration files
     * 3. Add INTERNET permission on Manifest
     *
     * BUILD
     * 1. Model Class (Parcelable & BaseObservable)
     *    a) Study API (themoviedb)
     *    b) Generate a POJO from JSON (jsonschema2pojo)
     *    c) Add Javax dependency
     *
     */

    /** Swipe Refresh Layout
     * 1. Add SwipeRefreshLayout dependency
     * 2. Create the Layout SwipeRefreshLayout
     * 3. Add the setOnRefreshListener to indicate the action to perform
     */

    /** Coordinator Layout
     *   https://blog.mindorks.com/using-coordinator-layout-in-android/
     * 1. Add the CoordinatorLayout dependency and the material design components dependency
     * 2. Implement the Scroll-Based Behavior using
     *      a) CoordinatorLayout
     *      b)    AppBarLayout
     *      c)       CollapsingToolbarLayout
     *      d)           ImageView
     *      e)           Toolbar
     */


    private ArrayList<Movie> data;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getSupportActionBar().setTitle("Movie Pro App");

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        getPopularMovies();

        swipeRefreshLayout = activityMainBinding.swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });
    }

    private void getPopularMovies() {
        mainActivityViewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                data = (ArrayList<Movie>) movies;
                showOnRecyclerView();
            }
        });
    }

    private void showOnRecyclerView() {
        recyclerView = activityMainBinding.rvMovies;
        adapter = new MovieAdapter(this,data);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}