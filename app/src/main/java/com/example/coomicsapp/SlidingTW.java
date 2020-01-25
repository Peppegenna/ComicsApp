package com.example.coomicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class SlidingTW extends AppCompatActivity {

    private Button buttonListTW;
    private Button buttonInsertTW;
    private VideoView videoTW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tw);

        buttonListTW = (Button) findViewById(R.id.btnListTW);
        buttonListTW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCollezioneTexWiller();
            }
        });

        buttonInsertTW = (Button) findViewById(R.id.btnInsertTW);
        buttonInsertTW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInsertTexWiller();
            }
        });

        videoTW = (VideoView) findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.texwillervideo;
        Uri uri = Uri.parse(videoPath);
        videoTW.setVideoURI(uri);
        videoTW.start();

        MediaController mediaController = new MediaController(this);
        videoTW.setMediaController(mediaController);
    }

    public void openCollezioneTexWiller(){
        Intent intent = new Intent(this, TexWillerList.class);
        startActivity(intent);
    }

    public void openInsertTexWiller(){
        Intent intent = new Intent (this, InsertTW.class);
        startActivity(intent);
    }
}
