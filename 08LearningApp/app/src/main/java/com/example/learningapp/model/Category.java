package com.example.learningapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories_table")
public class Category extends BaseObservable {
/*Entity Steps
* ROOM
* 1. Room Annotations
*    - Entity
*    - PrimaryKey
*    - ColumnInfo
*    - Ignore
*
* BINDING
* 1. Add Data Binding dependency
* 2. Extends BaseObservable
* 3. Bind getters
* 4. Notify changes in setters
 */
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "category_name")
    private String categoryName;
    @ColumnInfo(name = "category_description")
    private String categoryDescription;

    public Category(int id, String categoryName, String categoryDescription) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    @Ignore
    public Category() {
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        notifyPropertyChanged(BR.categoryName);
    }

    @Bindable
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
        notifyPropertyChanged(BR.categoryDescription);
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
