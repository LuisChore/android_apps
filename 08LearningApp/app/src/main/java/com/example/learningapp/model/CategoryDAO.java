package com.example.learningapp.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDAO {
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
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("SELECT * FROM categories_table")
    LiveData<List<Category>> getAllCategories();
}
