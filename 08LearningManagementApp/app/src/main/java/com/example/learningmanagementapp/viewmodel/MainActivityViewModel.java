package com.example.learningmanagementapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.learningmanagementapp.model.Category;
import com.example.learningmanagementapp.model.Course;
import com.example.learningmanagementapp.model.CourseShopRepository;

import java.util.List;

/**View Model
 * A view model needs to be created for each Activity that needs to communicate with Data Source
 */
public class MainActivityViewModel extends AndroidViewModel {
    //(1) Repository
    private CourseShopRepository repository;

    //(2) Live Data objects
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Course>> coursesOfSelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new CourseShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories(){
        allCategories = repository.getCategories();
        return allCategories;
    }

    public LiveData<List<Course>> getCoursesOfSelectedCategory(int categoryId) {
        coursesOfSelectedCategory = repository.getCourses(categoryId);
        return coursesOfSelectedCategory;
    }

    public void addNewCourse(Course course){
        repository.insertCourse(course);
    }

    public  void updateCourse(Course course){
        repository.updateCourse(course);
    }

    public  void deleteCourse(Course course){
        repository.deleteCourse(course);
    }
}
