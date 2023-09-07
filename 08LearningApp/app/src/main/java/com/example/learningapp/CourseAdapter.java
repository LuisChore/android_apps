package com.example.learningapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningapp.databinding.CourseListItemBinding;
import com.example.learningapp.model.Course;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {



    //(1) Data Source
    private ArrayList<Course> courses = new ArrayList<>();
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
        // Steps to update RecyclerView using Room Database
        /*
            1. Call the database to do the operation
            2. Update the array that is shown in the UI
            3. Notify to the adapter it changed
         */
        notifyDataSetChanged();
    }


    //(2) View Holder class
    class ViewHolder extends RecyclerView.ViewHolder{
        private CourseListItemBinding courseListItemBinding;
        public ViewHolder(CourseListItemBinding courseListItemBinding) {
            super(courseListItemBinding.getRoot());
            this.courseListItemBinding = courseListItemBinding;
            courseListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickedPosition = getAdapterPosition();
                    if(listener != null && clickedPosition != RecyclerView.NO_POSITION){
                        listener.onItemClick(courses.get(clickedPosition));
                    }
                }
            });
        }



    }



    // (3) Implement Methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CourseListItemBinding courseListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.course_list_item,
                parent,
                false);
        return new ViewHolder(courseListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.courseListItemBinding.setCourse(course);
    }

    @Override
    public int getItemCount() {
        return courses == null ? 0: courses.size();
    }

    //(4) Click Event
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Course course);
    }

    public void setListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
