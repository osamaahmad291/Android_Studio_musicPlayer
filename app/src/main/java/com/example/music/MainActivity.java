package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = null;
    }
    @SuppressLint("SetTextI18n")
    public void music(View view) {
        textView= findViewById(R.id.textView2);
        switch (view.getId()) {
            case R.id.button6:
                if (mediaPlayer==null){
                    mediaPlayer=MediaPlayer.create(this, R.raw.piano);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopMusic();
                    }
                });

                mediaPlayer.start();
                textView.setText("Current Playlist: Piano");
                break;

            case R.id.button5:
                if (mediaPlayer!=null){
                    mediaPlayer.pause();
                    textView.setText("Music Paused");

                }
                break;
            case R.id.button4:
                if (mediaPlayer!=null){
                    mediaPlayer.stop();
                    stopMusic();
                    textView.setText("Music Stopped");

                }
                break;

        }
    }

    private void stopMusic() {
        mediaPlayer.release();
        mediaPlayer=null;

    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }
}