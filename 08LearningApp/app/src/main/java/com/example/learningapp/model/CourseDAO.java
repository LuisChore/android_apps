package com.example.learningapp.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDAO {
    /* DAO steps
     * 1. Room Annotation (Dao)
     * 2. CRUD Methods
     *    - @Insert
     *    - @Update
     *    - @Delete
     * 3. Queries
     *    - @Query("..")
     */
    @Insert
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("SELECT * FROM course_table WHERE category_id==:categoryId")
    LiveData<List<Course>> getCourses(int categoryId);

}
