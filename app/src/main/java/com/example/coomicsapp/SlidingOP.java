package com.example.coomicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class SlidingOP extends AppCompatActivity {

    private Button buttonListOP;
    private Button buttonInsertOP;
    private VideoView videoOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_op);

        buttonListOP = (Button) findViewById(R.id.btnListOP);
        buttonListOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCollezioneOnePiece();
            }
        });

        buttonInsertOP = (Button) findViewById(R.id.btnInsertOP);
        buttonInsertOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInsertOnePiece();
            }
        });

        videoOP = (VideoView) findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.onepiecevideo2;
        Uri uri = Uri.parse(videoPath);
        videoOP.setVideoURI(uri);
        videoOP.start();

        MediaController mediaController = new MediaController(this);
        videoOP.setMediaController(mediaController);


    }

    public void openCollezioneOnePiece(){
        Intent intent = new Intent(this, OnePieceList.class);
        startActivity(intent);
    }

    public void openInsertOnePiece(){
        Intent intent = new Intent (this, InsertOP.class);
        startActivity(intent);
    }
}
