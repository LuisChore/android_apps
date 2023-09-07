package com.example.learningapp.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Category.class, Course.class},version = 1,exportSchema = false)
public abstract class CourseDatabase extends RoomDatabase {
    /*Database steps
     * 1. Abstract Class
     * 2. Extends RoomDatabase
     * 3. Room annotations
     *    - @Database(entities={...},version = )
     * 4. DAO abstract methods
     * 5. Create the database using Singleton Pattern
     * 6. Add callbacks
     */
    public abstract CategoryDAO categoryDAO();
    public abstract CourseDAO courseDAO();

    //Singleton pattern
    /**
     * > We cannot deal with many objects of databases if we want to avoid problems while
     *   synchronizing the database.
     * > We will create a single instance of database inside the app during its runtime
     * > Prevents information and memory leak.
     */
    private static CourseDatabase instance;
    public static synchronized CourseDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CourseDatabase.class,"courses_database")
                    .fallbackToDestructiveMigration() // if we need to make migration of the data in order to preserve them
                    .addCallback(roomCallback) // to add some data when the user launches the app for the first time
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            initializeData();
        }
    };

    private static void initializeData() {
        CourseDAO courseDAO = instance.courseDAO();
        CategoryDAO categoryDAO = instance.categoryDAO();

        ExecutorService executor  = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {

                //Category
                Category category1 = new Category();
                category1.setCategoryName("Front End");
                category1.setCategoryDescription("Web Development Interface");


                Category category2 = new Category();
                category2.setCategoryName("Back End");
                category2.setCategoryDescription("Web Development Database");

                categoryDAO.insert(category1);
                categoryDAO.insert(category2);

                //Courses
                Course course1 = new Course();
                course1.setCourseName("HTML");
                course1.setUnitPrice("100$");
                course1.setCategoryId(1);

                Course course2 = new Course();
                course2.setCourseName("CSS");
                course2.setUnitPrice("99$");
                course2.setCategoryId(1);

                Course course3 = new Course();
                course3.setCourseName("PHP");
                course3.setUnitPrice("150$");
                course3.setCategoryId(2);

                Course course4 = new Course();
                course4.setCourseName("AJAX");
                course4.setUnitPrice("99$");
                course4.setCategoryId(2);

                courseDAO.insert(course1);
                courseDAO.insert(course2);
                courseDAO.insert(course3);
                courseDAO.insert(course4);


            }
        });
    }
}
