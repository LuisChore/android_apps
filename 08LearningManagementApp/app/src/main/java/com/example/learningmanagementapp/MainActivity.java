package com.example.learningmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    /** Room Database
     *    Add the dependencies of the JetPack for Room:
     *    https://developer.android.com/jetpack/androidx/releases/room
     */

    /** Data binding
     *    Enable data binding
     *    https://developer.android.com/jetpack/androidx/releases/databinding
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}