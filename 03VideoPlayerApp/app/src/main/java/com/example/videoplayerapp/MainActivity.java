package com.example.videoplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoViewLocal,videoViewWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Display video from local storage
        videoViewLocal = findViewById(R.id.videoViewLocal);
        videoViewLocal.setVideoPath("android.resource://"+getPackageName() + "/" + R.raw.video);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoViewLocal);
        videoViewLocal.setMediaController(mc);

        //Display video from Web
        videoViewWeb = findViewById(R.id.videoViewWeb);
        Uri uri = Uri.parse("https://static.videezy.com/system/resources/previews/000/011/573/original/Beach_01_-_4K_res.mp4");
        videoViewWeb.setVideoURI(uri);
        MediaController mcWeb = new MediaController(this);
        mcWeb.setAnchorView(videoViewWeb);
        videoViewWeb.setMediaController(mcWeb);
        videoViewWeb.start();

    }
}