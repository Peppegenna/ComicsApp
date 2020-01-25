package com.example.coomicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButtonOP;
    private ImageButton imageButtonTW;
    private ImageButton imageButtonRM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonOP = (ImageButton) findViewById(R.id.imagebtnOnePiece);
        imageButtonOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCollezioneOnePiece();
            }
        });

        imageButtonTW = (ImageButton) findViewById(R.id.imagebtnTexWiller);
        imageButtonTW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCollezioneTexWiller();
            }
        });

        imageButtonRM = (ImageButton) findViewById(R.id.imagebtnRatMan);
        imageButtonRM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCollezioneRatMan();
            }
        });
    }

    public void openCollezioneOnePiece(){
        Intent intent = new Intent(this, SlidingOP.class);
        startActivity(intent);
    }

    public void openCollezioneTexWiller(){
        Intent intent = new Intent(this, SlidingTW.class);
        startActivity(intent);
    }

    public void openCollezioneRatMan(){
        Intent intent = new Intent(this, SlidingRM.class);
        startActivity(intent);
    }

}
