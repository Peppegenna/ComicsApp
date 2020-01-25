package com.example.coomicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class SlidingRM extends AppCompatActivity {

    private Button buttonListRM;
    private Button buttonInsertRM;
    private VideoView videoRM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_rm);

        buttonListRM = (Button) findViewById(R.id.btnListRM);
        buttonListRM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCollezioneRatMan();
            }
        });

        buttonInsertRM = (Button) findViewById(R.id.btnInsertRM);
        buttonInsertRM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInsertOnePiece();
            }
        });

        videoRM = (VideoView) findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ratmanvideo;
        Uri uri = Uri.parse(videoPath);
        videoRM.setVideoURI(uri);
        videoRM.start();

        MediaController mediaController = new MediaController(this);
        videoRM.setMediaController(mediaController);
    }

    public void openCollezioneRatMan(){
        Intent intent = new Intent(this, RatManList.class);
        startActivity(intent);
    }

    public void openInsertOnePiece(){
        Intent intent = new Intent (this, InsertRM.class);
        startActivity(intent);
    }
}
