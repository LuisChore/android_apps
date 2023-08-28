package com.example.learningmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.learningmanagementapp.databinding.ActivityMainBinding;
import com.example.learningmanagementapp.databinding.ContentMainBinding;
import com.example.learningmanagementapp.model.Category;
import com.example.learningmanagementapp.model.Course;
import com.example.learningmanagementapp.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /** Room Database
     *    Add the dependencies of the JetPack for Room:
     *    https://developer.android.com/jetpack/androidx/releases/room
     */

    /** Data binding
     *    Enable data binding
     *    https://developer.android.com/jetpack/androidx/releases/databinding
     */
    //(1) ViewModel
    private MainActivityViewModel mainActivityViewModel;
    //(2) Data Source
    private ArrayList<Category> categoryList;
    //(3) Data Binding
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler handlers;
    // For Spinner Event
    private Category categorySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //(1) ViewModel
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        //(3) Data Binding
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        handlers = new MainActivityClickHandler();
        activityMainBinding.setClickHandlers(handlers);
        // Observer Pattern via LiveData
        mainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoryList = (ArrayList<Category>) categories;
                for(Category c: categories){
                    Log.i("TAG",c.getCategoryName());
                }
                showOnSpinner();
            }
        });

        mainActivityViewModel.getCoursesOfSelectedCategory(1).observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                for(Course c: courses){
                    Log.v("TAG",c.getCourseName());
                }
            }
        });
    }

    private void showOnSpinner() {
        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,
                categoryList
        );
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityMainBinding.setSpinnerAdapter(categoryArrayAdapter);
    }

    public class MainActivityClickHandler{
        public void onFabClicked(View view){
            Toast.makeText(getApplicationContext(),"Fab clicked", Toast.LENGTH_SHORT).show();
        }
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            categorySelected = (Category) parent.getItemAtPosition(pos);
            String message = "id is: " + categorySelected.getId() + " " +
                    categorySelected.getCategoryName();
            Toast.makeText(parent.getContext(),message,Toast.LENGTH_LONG).show();
        }

    }
}