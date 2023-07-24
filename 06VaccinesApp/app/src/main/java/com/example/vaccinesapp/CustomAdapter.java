package com.example.vaccinesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    // (1) Data Source
    private VaccineModel[] data;

    public CustomAdapter(VaccineModel[] data) {
        this.data = data;
    }

    //(2) ViewHolder class
    /*
    * It describes an ItemView and metadata about its place in the RecyclerView
    * Links the Custom Item Layout with the Class Model
    * "A class to initialize our widgets in the custom layout"
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView vaccineImage;
        public TextView vaccineName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.vaccineImage = itemView.findViewById(R.id.vaccineImage);
            this.vaccineName = itemView.findViewById(R.id.vaccineName);
        }
    }

    // (3) Implement the override methods

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * Called when you need a new View.
         * RecyclerView call this method whenever needs to create a new ViewHolder
         * The method creates and initializes the ViewHolder and its associated View
         * but does not fill the View's content. the ViewHolder has not yet been bound to
         * specific data.
         */
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerview_item,parent,false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        /**
         * RecyclerView calls this method to associate a ViewHolder with data.
         * The method fetches the appropriate data and uses the data to fill in the view
         * holder's layout
         */
        final VaccineModel vaccineModel = data[position];
        holder.vaccineName.setText(vaccineModel.getVaccineName());
        holder.vaccineImage.setImageResource(vaccineModel.getVaccineImage());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

}
