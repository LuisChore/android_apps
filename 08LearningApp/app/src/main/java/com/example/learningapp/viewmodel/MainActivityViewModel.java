package com.example.learningapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.learningapp.model.Category;
import com.example.learningapp.model.Course;
import com.example.learningapp.model.CourseShopRepository;

import java.util.List;

public class MainActivityViewModel  extends AndroidViewModel {
    /* ViewModel
    * 1. Extends AndroidViewModel & required constructor
    * 2. Include the requited Repository
    * 3. Include the required LiveData objects
    * 4. Add requited methods for the UI
     */

    /* ViewModel
     * Class that is responsible for managing and preparing the data for the UI. It handles the
     * communication of the Activity/Fragment with the rest of the app.
     *
     * Persistence: It caches state and persist it through configuration changes.
     *
     * We need to create a ViewModel for each activity that needs to communicate with data source
     * The activity/fragment should be able to observe changes in the ViewModel, ViewModel exposes
     * this information with LiveData
     */

    /*LiveData

     */
    private CourseShopRepository repository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Course>> courseOfSelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new CourseShopRepository(application);
    }
    public LiveData<List<Category>> getAllCategories(){
        allCategories = repository.getAllCategories();
        return allCategories;
    }

    public LiveData<List<Course>> getCourseOfSelectedCategory(int categoryId){
        courseOfSelectedCategory = repository.getCourses(categoryId);
        return courseOfSelectedCategory;
    }

    public void addNewCourse(Course course){
        repository.insertCourse(course);
    }

    public void updateCourse(Course course){
        repository.updateCourse(course);
    }

    public void deleteCourse(Course course){
        repository.deleteCourse(course);
    }


}
