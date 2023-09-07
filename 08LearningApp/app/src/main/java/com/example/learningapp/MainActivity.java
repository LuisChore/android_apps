package com.example.learningapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.learningapp.databinding.ActivityMainBinding;
import com.example.learningapp.model.Category;
import com.example.learningapp.model.Course;
import com.example.learningapp.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*MVVM App Development Steps
    * 1. Add the room dependency of Jetpack
    * 2. Create Entity classes
    * 3. Create Data Access Objects
    * 4. Create Database (Singleton Pattern)
    * 5. Repository
    * 6. ViewModel
    * 7. MainActivity
    *    a) Spinner
    *    b) RecyclerView
    *
     */


    /* MainActivity Steps
    * // View Model
    * 1. MainActivityViewModel
    * 2. Add observers to the LiveData objects in the ViewModel
    *
    * // Data Binding
    * 1. Create ClickHandler class and an instance
    * 2. Create layout with Data Binding tags
    * 3. Create a ActivityMainBinding object and connect it with the ClickHandler instance
    *
    * //Connect Activities
    * 1. Main Activity (Start Activity for Result in FAB Clicked method)
    * 2. Main Activity (Start Activity for Result in RecyclerView Item Selected)
    * 3. AddEditActivity (Return Values in Submit button)
    * 4. Main Activity (Collect value in onActivityResult method)
    *
    * // CRUD operations
    * 1. Create new course (In onActivityResult)
    * 2. Edit a course (In onActivityResult)
    * 3. Delete Course (In ItemTouchHelper)
     */

    // ViewModel
    private MainActivityViewModel mainActivityViewModel;

    // Data Binding
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler clickHandler;
    // Data Source (spinner)
    private ArrayList<Category> categoriesList;

    private Category selectedCategory;



    // RecyclerView
    // 1. Data Source
    private ArrayList<Course> coursesList;
    // 2. AdapterView
    private RecyclerView courseRecyclerView;
    // 3. Adapter
    private CourseAdapter courseAdapter;


    // Result Activity
    private  static final int ADD_COURSE_REQUEST_CODE = 1;
    private  static final int EDIT_COURSE_REQUEST_CODE = 2;
    public int selectedCourseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //View Model
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoriesList = (ArrayList<Category>) categories;
                for (Category c: categories){
                    Log.i("TAG",c.getCategoryName());
                }
                showOnSpinner();
            }
        });

        // Data Binding
        clickHandler = new MainActivityClickHandler();
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setClickHandlers(clickHandler);
    }

    private void showOnSpinner() {
        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,
                categoriesList
        );
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityMainBinding.setSpinnerAdapter(categoryArrayAdapter);
    }

    public class MainActivityClickHandler{
        public void onFABClicked(View view){
            //Create Course (call AddEditActivity)
            Intent i = new Intent(MainActivity.this, AddEditActivity.class);
            startActivityForResult(i,ADD_COURSE_REQUEST_CODE);
        }
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            selectedCategory = (Category) parent.getItemAtPosition(pos);
            String message = selectedCategory.getId() + ": " + selectedCategory.getCategoryName();
            Toast.makeText(parent.getContext(),message,Toast.LENGTH_SHORT).show();

            // update Recycler View
            loadCoursesArrayList(selectedCategory.getId());
        }

    }

    public void loadCoursesArrayList(int categoryId){
        mainActivityViewModel.getCourseOfSelectedCategory(categoryId).observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                coursesList = (ArrayList<Course>) courses;
                loadRecyclerView();
            }
        });
    }

    private void loadRecyclerView() {
        courseRecyclerView = activityMainBinding.secondaryLayout.recyclerView;
        courseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseRecyclerView.setHasFixedSize(true);

        courseAdapter = new CourseAdapter();
        courseAdapter.setCourses(coursesList);
        courseRecyclerView.setAdapter(courseAdapter);

        //Edit Course (call AddEditActivity)
        courseAdapter.setListener(new CourseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Course course) {
                selectedCourseId = course.getCourseId();
                Intent i = new Intent(MainActivity.this, AddEditActivity.class);
                i.putExtra(AddEditActivity.COURSE_ID,selectedCourseId);
                i.putExtra(AddEditActivity.COURSE_NAME,course.getCourseName());
                i.putExtra(AddEditActivity.UNIT_PRICE,course.getUnitPrice());
                startActivityForResult(i,EDIT_COURSE_REQUEST_CODE);
            }
        });

        //Delete a Course
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Course courseToDelete = coursesList.get(viewHolder.getAdapterPosition());
                mainActivityViewModel.deleteCourse(courseToDelete);

            }
        }).attachToRecyclerView(courseRecyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int selectedCategoryId = selectedCategory.getId();
        //Add Course
        if(requestCode == ADD_COURSE_REQUEST_CODE && resultCode == RESULT_OK){
            Course course = new Course();
            course.setCategoryId((selectedCategoryId));
            course.setCourseName(data.getStringExtra(AddEditActivity.COURSE_NAME));
            course.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));
            mainActivityViewModel.addNewCourse(course);
        }

        //Edit Course
        if(requestCode == EDIT_COURSE_REQUEST_CODE && resultCode == RESULT_OK){
            Course course = new Course();
            course.setCategoryId((selectedCategoryId));
            course.setCourseName(data.getStringExtra(AddEditActivity.COURSE_NAME));
            course.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));
            course.setCourseId(selectedCourseId);
            mainActivityViewModel.updateCourse(course);
        }
    }
}