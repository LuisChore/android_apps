package com.example.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    //Widgets
    TextView timeLeftView,songTitleView;
    Button forwardButton,playButton,pauseButton,rewindButton;
    SeekBar seekBar;

    //Media Player
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();

    double startTime = 0,finalTime = 0;
    int forwardTime = 10000,backwardTime = 10000;
    static int oneTimeOnly = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeLeftView = findViewById(R.id.timeLeftView);
        songTitleView = findViewById(R.id.songTitleView);
        forwardButton = findViewById(R.id.forwardButton);
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        rewindButton = findViewById(R.id.rewindButton);
        seekBar = findViewById(R.id.seekBar);

        songTitleView.setText(getResources().getIdentifier("song","raw",getPackageName()));
        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        /*MediaPlayer allows us to play media files from
        * - application resources files
        * - standalone files in the file system
        * - data stream arriving over a network connection
        */
        finalTime = mediaPlayer.getDuration();
        timeLeftView.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long)finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long)finalTime) -
                        TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes((long)finalTime)
                        )));

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playMusic();
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = (int) startTime;
                if(temp + forwardTime <= finalTime){
                    startTime += forwardTime;
                    mediaPlayer.seekTo((int)startTime);
                }else{
                    startTime = 0;
                    mediaPlayer.pause();
                }
                seekBar.setProgress((int)startTime);
            }
        });
        rewindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = (int) startTime;
                if(temp - backwardTime >= 0){
                    startTime -= backwardTime;
                    mediaPlayer.seekTo((int)startTime);
                }else{
                    startTime = 0;
                    mediaPlayer.pause();
                }
                seekBar.setProgress((int)startTime);
            }
        });
    }

    private void playMusic(){
        mediaPlayer.start();
        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();
        if(oneTimeOnly == 0){
            seekBar.setMax((int)finalTime);
            oneTimeOnly = 1;
        }
        timeLeftView.setText("0 min, 0 sec");
        seekBar.setProgress((int)startTime) ;
        /*Handler
        * Allows you to send and process Message and Runnable objects
        * associated with a thread's message queue. Each handler instance
        * is associated with a single Thread and that Thread's  message queue
        */
        handler.postDelayed(UpdateSongTime,1000);
    }

    private  Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            timeLeftView.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long)startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long)startTime) -
                            TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes((long)startTime)
                            )));
            seekBar.setProgress((int)startTime);
            handler.postDelayed(this,100);
        }
    };
}