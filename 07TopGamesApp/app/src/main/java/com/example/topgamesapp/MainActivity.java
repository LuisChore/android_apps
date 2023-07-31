package com.example.topgamesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /**CardView
     * Android Widget to display data providing a rounded layout with an 'elevation'
     * It can be used for creating items in ListView or inside RecyclerView
     */

    /**Steps
     * 1. Add the AdapterView in activity_main.xml (RecyclerView)
     * 2. Add the custom layout for the items (CardView)
     * 3. Add the ModelClass (GameModel)
     * 4. Create the Adapter (CustomAdapter) Since we are gonna add data from the data source(adaptee)
     *    and display them into an AdapterView (target) we need a bridge between them.
     *    a) Data Source
     *    b) View Holder class (for defining and instantiating  the custom layout for items)
     */

    //(1) Data Source
    ArrayList<GameModel> data;
    //(2) AdapterView
    RecyclerView recyclerView;
    //(3) Adapter
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Data Source
        data = new ArrayList<>();
        data.add(new GameModel("Horizon Chase",R.drawable.card1));
        data.add(new GameModel("PUBG",R.drawable.card2));
        data.add(new GameModel("Hooked on You",R.drawable.card4));
        data.add(new GameModel("Head Ball 2",R.drawable.card3));
        data.add(new GameModel("Fifa 2022",R.drawable.card5));
        data.add(new GameModel("Fortnite",R.drawable.card6));
        //AdapterView
        recyclerView = findViewById(R.id.recyclerView);
        //Adapter
        adapter = new CustomAdapter(this,data);

        // (4) Configuration
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}