package com.example.topgamesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    //(1) Data Source
    private Context context;
    private ArrayList<GameModel> data;

    public CustomAdapter(Context context, ArrayList<GameModel> data) {
        this.context = context;
        this.data = data;
    }

    //(2) ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView gameImage;
        private TextView gameName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImage = itemView.findViewById(R.id.cardImage);
            gameName = itemView.findViewById(R.id.cardText);
        }
    }

    //(3) Implement methods

    /**
     * Method that instantiate and create the view
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view);
    }

    /**
     * It display things to the widgets
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GameModel gameModel = data.get(position);
        holder.gameName.setText(gameModel.getGameName());
        holder.gameImage.setImageResource(gameModel.getGameImage());

        //Click Event
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,gameModel.getGameName()+ "!!",Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
