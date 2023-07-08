package com.example.worldcupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*AdapterView*/
    ListView listView;
    /*Custom Adapter*/
    /*
    *  The default Adapter class can be used for simple static data, but for a more complex
    *  View for the items (including ImageVies, Buttons, etc...) it is necessary to create a
    *  Custom Adapter
     */

    /* STEPS
    * 1. Create the Adapter View
    *    In this case is a ListView
    *
    * 2. Create a Custom Layout for the items of the ListView
    *     (items_list_layout.xml)
    *
    * 3. Create a Model Class
    *   We need to create a class that creates custom object for every item in the ListView
    *   All images and other non XML assets are represented as integers
    *
    * 4. Create a Custom Adapter Class
    *   It has to extends and Adapter (e.g. ArrayAdapter<ModelClass>)
    *   It contains
    *       a) Data Source
    *       b) a ViewHolder class
    *       c) Override Methods
     */
    private CustomAdapter adapter;
    ArrayList<CountryModelClass> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //(1) AdapterView
        listView = findViewById(R.id.listView);
        //(2) Data Source
        data = new ArrayList<>();
        data.add(new CountryModelClass ("Brazil","5",R.drawable.brazil));
        data.add(new CountryModelClass("Germany","4",R.drawable.germany));
        data.add(new CountryModelClass("France","2",R.drawable.france));
        data.add(new CountryModelClass("Spain","1",R.drawable.spain));
        data.add(new CountryModelClass("England","1",R.drawable.unitedkingdom));
        data.add(new CountryModelClass("United States","0",R.drawable.unitedstates));
        //(3) Adapter
        adapter = new CustomAdapter(data,getApplicationContext());
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String countryName = adapter.getItem(i).getCountryName();
                String numberOfWins = adapter.getItem(i).getNumberOfWins();
                Toast.makeText(MainActivity.this,
                        "Country: " + countryName + "\n" +
                        "Wins: " + numberOfWins,
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }


}