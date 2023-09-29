package com.example.movieproapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    /*Singleton Pattern
    * 1. Private static reference variable to hold the instance
    * 2. Public static method that returns the instance
     */
    private  static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.themoviedb.org";

    public static MovieDataService getServive(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }
        return retrofit.create(MovieDataService.class);
    }
}
