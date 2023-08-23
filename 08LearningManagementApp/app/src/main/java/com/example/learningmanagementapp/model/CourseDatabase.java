package com.example.learningmanagementapp.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Category.class, Course.class},version = 1)
public abstract class CourseDatabase extends RoomDatabase {
    //(1) Create the DAO abstract methods
    public abstract CategoryDAO categoryDAO();
    public abstract CourseDAO courseDAO();

    //(2) Singleton Pattern
    /**
     * > You cannot deal with many objects of databases in order to prevent any mistakes and
     *   synchronization problems.
     *
     * > Working with singleton pattern prevents further information and memory leak from databases
     */
    private static CourseDatabase instance;
    // to prevent any creation of other objects
    public static synchronized CourseDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            CourseDatabase.class,"courses_database").
                    fallbackToDestructiveMigration().addCallback(callback).build();
        }
        return instance;
    }


    //(3) Callback
    /**
     * > To add some data to the database when the user launches the app for the first time.
     */
    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

}
