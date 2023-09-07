package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.learningapp.databinding.ActivityAddEditBinding;
import com.example.learningapp.model.Course;

public class AddEditActivity extends AppCompatActivity {
    /* AddEditActivity Steps
     * // Data Binding
     * 1. Create ClickHandler class and an instance
     * 2. Create layout with Data Binding tags
     * 3. Create a ActivityAddEditBinding object and connect it with the ClickHandler instance
     */
    private Course course;
    public static final String COURSE_ID = "courseId";
    public static final String COURSE_NAME = "courseName";
    public static final String UNIT_PRICE = "unitPrice";

    //Data Binding
    private ActivityAddEditBinding activityAddEditBinding;
    private AddEditActivityClickHandler clickHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        //Data Binding
        course = new Course();
        clickHandler = new AddEditActivityClickHandler(this);
        activityAddEditBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_edit);
        activityAddEditBinding.setCourse(course);
        activityAddEditBinding.setClickHandler(clickHandler);

        Intent i = getIntent();
        if (i.hasExtra(COURSE_ID)){
            // Recycler View Item Clicked
            setTitle("Edit Course");
            course.setCourseName(i.getStringExtra(COURSE_NAME));
            course.setUnitPrice(i.getStringExtra(UNIT_PRICE));
        }else{
            // FAB clicked
            setTitle("Create New Course");
        }
    }

    public class AddEditActivityClickHandler{
        Context context;

        public AddEditActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onSubmitButtonClicked(View view){
            if(course.getCourseName() == null){
                Toast.makeText(context,"Course Name Empty",Toast.LENGTH_SHORT).show();
            }else{
                Intent i = new Intent();
                i.putExtra(COURSE_NAME,course.getCourseName());
                i.putExtra(UNIT_PRICE,course.getUnitPrice());
                setResult(RESULT_OK,i);
                finish();
            }
        }
    }
}