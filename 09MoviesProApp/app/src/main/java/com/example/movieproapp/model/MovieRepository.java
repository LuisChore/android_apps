package com.example.movieproapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movieproapp.R;
import com.example.movieproapp.service.MovieDataService;
import com.example.movieproapp.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    /**
     * Method created to:
     * 1. Get the instance of the interface Movie Data Service
     * 2. Make the call of retrofit
     *
     */
    public MutableLiveData<List<Movie>> getMutableLiveData(){

        MovieDataService movieDataService = RetrofitInstance.getServive();
        Call<Result> call = movieDataService.getPopularMovies
                (application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if(result != null && result.getResults() != null){
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
