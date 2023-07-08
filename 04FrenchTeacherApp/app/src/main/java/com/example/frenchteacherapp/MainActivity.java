package com.example.frenchteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void soundColor(View view){
        Button btn = (Button) view;
        int fileId = getResources().getIdentifier(
                btn.getTag().toString(),
                "raw",
                getPackageName()
        );
        MediaPlayer mediaPlayer = MediaPlayer.create(this,fileId);
        mediaPlayer.start();
      }
}