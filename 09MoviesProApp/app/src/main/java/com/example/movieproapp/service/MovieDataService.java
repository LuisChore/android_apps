package com.example.movieproapp.service;

import com.example.movieproapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {
    /* Retrofit Interface
      * It defines the possible HTTP operations
      * The return values wrap the response in a Call object with the type of the expected response
      * Each method must have
      *    a) HTTP annotation
      *    b) Relative URL
     */


    //https://api.themoviedb.org/3/movie/popular?api_key=XXXXXXXXXXXXXXXXX
    @GET("3/movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);
}
