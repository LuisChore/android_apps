package com.example.worldcupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CountryModelClass> {
    // (1)Data Source
    private ArrayList<CountryModelClass> countries;
    Context context;
    public CustomAdapter(ArrayList<CountryModelClass> data, Context context){
        super(context,R.layout.items_list_layout,data);
        this.countries = data;
        this.context = context;
    }

    // (2) ViewHolder class
    /*ViewHolder
     * - A ViewHolder describes an item view and metadata about its place within the AdapterView.
     *   (ListView, RecyclerView, etc...)
     *
     * - Adapter implementation should subclass viewHolder and add fields for catching potentially
     *  expensive findViewById results
     *
     * - A ViewHolder is a wrapper around a View that contains the layout for an individual item
     *   in the list
     *
     * -It works a View Lookup Cache. It enables you to access each list item view without the need
     *  for the look up.
     */
    private static class ViewHolder{
        TextView countryName,numberOfWins;
        ImageView flagImg;
    }

    //(3) Override Methods
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //(1) Get the data item for this position
         CountryModelClass dataModel = getItem(position);

        //(2) Check if and existing view is reused, otherwise inflate the View
        // (Inflate the view is "make display the view")
        ViewHolder viewHolder;

        /*convertView
        * The convertView argument will have a non-null value when the ListView is asking you
        * recycle the row layout, so when the convertView is non-null you should simple update
        * its contents instead of inflate a new row layout
         */
        if(convertView == null){

            /* Layout Inflater
             *   Class used to instantiate a layout XML into its corresponding View object.
             *   There are two ways to create a UI in Android:
             *      1. Static: setContentView
             *      2. Dynamic (programmatically): It means that the view is not mentioned in the main
             *         XML,but we want to show it during the runtime.
             *    Inflating means reading the XML file that describes a layout or UI element and
             *    create the actual object that corresponds to it and thus making the object visible
             *    within the android app.
             */
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.items_list_layout,
                    parent,
                    false
            );

            // Initialize the widgets of the items
            viewHolder = new ViewHolder();
            viewHolder.countryName = (TextView) convertView.findViewById(R.id.countryName);
            viewHolder.numberOfWins = (TextView) convertView.findViewById(R.id.numberOfWins);
            viewHolder.flagImg = (ImageView) convertView.findViewById(R.id.flagImg);

            //Store the holder with the view
            convertView.setTag(viewHolder);
        }else{
            //to save memory and time loading
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // (3) Get the data from Model Class
        viewHolder.countryName.setText(dataModel.getCountryName());
        viewHolder.numberOfWins.setText(dataModel.getNumberOfWins());
        viewHolder.flagImg.setImageResource(dataModel.getFlagImg());
        return convertView;
    }
}
