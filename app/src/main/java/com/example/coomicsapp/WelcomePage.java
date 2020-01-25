package com.example.coomicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class WelcomePage extends AppCompatActivity {

    private static int SPALSH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        ImageView imageView = (ImageView) findViewById(R.id.imgView);
        ImageView imageView2 = (ImageView) findViewById(R.id.imgView2);
        // sfuma: imageView.animate().alpha(0f).setDuration(4000);

        //zoomma: imageView.animate().scaleX(30).setDuration(80000);
        //imageView.animate().scaleY(30).setDuration(80000);

        imageView.animate().translationX(-1000).setStartDelay(3500);
        imageView2.animate().translationX(1000).setStartDelay(3500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(WelcomePage.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPALSH_TIME_OUT);
    }
}
