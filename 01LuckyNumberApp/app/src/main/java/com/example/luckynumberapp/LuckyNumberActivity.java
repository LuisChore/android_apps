package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView textViewNumber,textView;
    Button buttonShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        textViewNumber = findViewById(R.id.textViewNumber);
        buttonShare = findViewById(R.id.buttonShare);
        textView = findViewById(R.id.textView);

        String userName = getUserName();
        int rng = generateRandomNumber(1000);
        textViewNumber.setText(""+rng);

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,rng);
            }
        });
    }

    private String getUserName(){
        Intent intent = getIntent();
        return intent.getStringExtra("name");
    }

    private int generateRandomNumber(int limit){
        Random random = new Random();
        return random.nextInt(limit);
    }

    private void shareData(String userName,int rng){
        String number = String.valueOf(rng);
        //Implicit Intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,userName + " got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT,"Their lucky number is " + number);
        // to choose the platform
        Intent shareIntent = Intent.createChooser(intent, null);
        startActivity(shareIntent);
    }

}