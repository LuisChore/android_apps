package com.example.learningapp;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.learningapp.model.Course;

import java.util.ArrayList;

public class CourseDiffCallback extends DiffUtil.Callback {

    ArrayList<Course> oldCourseList;
    ArrayList<Course> newCoursesList;

    public CourseDiffCallback(ArrayList<Course> oldCourseList, ArrayList<Course> newCoursesList) {
        this.oldCourseList = oldCourseList;
        this.newCoursesList = newCoursesList;
    }

    @Override
    public int getOldListSize() {
        return oldCourseList == null ? 0: oldCourseList.size();
    }

    @Override
    public int getNewListSize() {
        return newCoursesList == null ? 0: newCoursesList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCourseList.get(oldItemPosition).getCourseId() ==
                newCoursesList.get(newItemPosition).getCourseId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCourseList.get(oldItemPosition).equals(newCoursesList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
