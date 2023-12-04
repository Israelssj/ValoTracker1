package com.example.valotracker1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;

public class LineupSova extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineup_sova);
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView1 = findViewById(R.id.youtube_player_view_1);
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView2 = findViewById(R.id.youtube_player_view_2);
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView3 = findViewById(R.id.youtube_player_view_3);
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView4 = findViewById(R.id.youtube_player_view_4);
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView5 = findViewById(R.id.youtube_player_view_5);
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView6 = findViewById(R.id.youtube_player_view_6);
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView7 = findViewById(R.id.youtube_player_view_7);
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView8 = findViewById(R.id.youtube_player_view_8);
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView9 = findViewById(R.id.youtube_player_view_9);


        getLifecycle().addObserver(youTubePlayerView1);
        youTubePlayerView1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "K0DRiro-CYU";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        getLifecycle().addObserver(youTubePlayerView2);
        youTubePlayerView2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "K_AdG856rX8";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        getLifecycle().addObserver(youTubePlayerView3);
        youTubePlayerView3.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "hnLQlVqJtGQ";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        getLifecycle().addObserver(youTubePlayerView4);
        youTubePlayerView4.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "Ejz3T8TTSKA";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        getLifecycle().addObserver(youTubePlayerView5);
        youTubePlayerView5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "fi6FrL-SS3g";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        getLifecycle().addObserver(youTubePlayerView6);
        youTubePlayerView6.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "wDhw2s8ooKg";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        getLifecycle().addObserver(youTubePlayerView7);
        youTubePlayerView7.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "Wwi5t7MdmFQ";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        getLifecycle().addObserver(youTubePlayerView8);
        youTubePlayerView8.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "70WR5J8EY5w";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        getLifecycle().addObserver(youTubePlayerView9);
        youTubePlayerView9.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "qagO1UAchfU";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });


        Button btnInicio = findViewById(R.id.btn1);
        Button btnTops = findViewById(R.id.btn2);
        Button btnLineups = findViewById(R.id.btn3);
        Button btnAgentes = findViewById(R.id.btn4);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LineupSova.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnTops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LineupSova.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btnLineups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LineupSova.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        btnAgentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LineupSova.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}
