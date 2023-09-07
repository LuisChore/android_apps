package com.example.learningapp.model;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CourseShopRepository {
    /*Repository Class Steps
    * 1.Constructor to get the database instance and the Data Access Objects
    * 2.Encapsulate required queries
    * 3.Encapsulate CRUD operations
     */

    /*Repository Pattern
     * Design pattern that isolates the data layer from the rest of the app. It resolves conflicts
     * between multiple data sources and centralizes changes to this data.
     *
     * Data Layer: It refers to the part of the app that handles the app's data and business logic
     *             exposing consistent APIs for the rest of your app
     *
     * The repository class: Isolates the data sources from the rest of the app and provides a
     *                       clean API for data access to the rest of the app. For complex projects
     *                       we create a repository class for each entity
     */
    private CategoryDAO categoryDAO;
    private CourseDAO courseDAO;

    //(1) Constructor
    public CourseShopRepository(Application application){
        CourseDatabase courseDatabase = CourseDatabase.getInstance(application.getApplicationContext());
        courseDAO = courseDatabase.courseDAO();
        categoryDAO = courseDatabase.categoryDAO();
    }


    //(2) Queries
    public LiveData<List<Category>> getAllCategories(){
        return categoryDAO.getAllCategories();
    }

    public LiveData<List<Course>> getCourses(int categoryId){
        return courseDAO.getCourses(categoryId);
    }

    //(3) CRUD operations
    public void insertCategory(Category category){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // to execute in the background
        Handler handler = new Handler(Looper.getMainLooper());
        // to handle post execution tasks
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDAO.insert(category);
            }
        });
    }

    public void updateCategory(Category category){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // to execute in the background
        Handler handler = new Handler(Looper.getMainLooper());
        // to handle post execution tasks
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDAO.update(category);
            }
        });
    }

    public void deleteCategory(Category category){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // to execute in the background
        Handler handler = new Handler(Looper.getMainLooper());
        // to handle post execution tasks
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDAO.delete(category);
            }
        });
    }

    public void insertCourse(Course course){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // to execute in the background
        Handler handler = new Handler(Looper.getMainLooper());
        // to handle post execution tasks
        executor.execute(new Runnable() {
            @Override
            public void run() {
                courseDAO.insert(course);
            }
        });
    }

    public void updateCourse(Course course){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // to execute in the background
        Handler handler = new Handler(Looper.getMainLooper());
        // to handle post execution tasks
        executor.execute(new Runnable() {
            @Override
            public void run() {
                courseDAO.update(course);
            }
        });
    }

    public void deleteCourse(Course course){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // to execute in the background
        Handler handler = new Handler(Looper.getMainLooper());
        // to handle post execution tasks
        executor.execute(new Runnable() {
            @Override
            public void run() {
                courseDAO.delete(course);
            }
        });
    }

}
