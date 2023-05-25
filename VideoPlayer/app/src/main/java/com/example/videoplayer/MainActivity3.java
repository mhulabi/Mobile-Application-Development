package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity3 extends AppCompatActivity {
    String url;
    public VideoView videoView;
    public MediaController MC;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bundle = this.getIntent().getExtras();
//        url = bundle.getString("ar");
        configureVideoView();
    }

    private void configureVideoView() {
        videoView = (VideoView)findViewById(R.id.videoView1);
        videoView.setVideoURI(Uri.parse(bundle.getString("ar")));
        MC = new MediaController(this);
        MC.setAnchorView(videoView);
        videoView.setMediaController(MC);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(i);
            }
        });
        videoView.start();
    }
}