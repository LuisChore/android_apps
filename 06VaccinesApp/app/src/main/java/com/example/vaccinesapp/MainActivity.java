package com.example.vaccinesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    /* Recycler View */
    /*
    * It makes it easier to display large sets of data
    * 1. You supply the data and define how each item looks
    * 2. The recycler view library dynamically creates the elements when they are needed
    *
    * When an item scrolls off the screen, RecyclerView does not destroy the view, instead it
    * reuses it for those new items that have scrolled on the screen.
    *
    *  - It improves performance
    *  - It improves app responsiveness
    *  - It reduce power consumption
     */

    //(1) AdapterView
    RecyclerView recyclerView;

    //(2) Data Source
    VaccineModel[] data;

    //(3) Adapter
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        data = new VaccineModel[]{
                new VaccineModel("Hepatitis B Vaccine",R.drawable.vaccine1),
                new VaccineModel("Tetanus",R.drawable.vaccine4),
                new VaccineModel("Pneumococcal Vaccine",R.drawable.vaccine1),
                new VaccineModel("Rotavirus Vaccine",R.drawable.vaccine4),
                new VaccineModel("Measles Virus",R.drawable.vaccine1),
                new VaccineModel("Covid 19 Virus",R.drawable.vaccine4),
                new VaccineModel("Cholera",R.drawable.vaccine1)
        };
        adapter = new CustomAdapter(data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}