package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.List;

public class NowPlayingActivity extends AppCompatActivity {

    Button playBtn;
    SeekBar positionBar;
    MediaPlayer mp;
    SongAdapter songAdapter;
    private List<Song> songList;
    Song music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();
        music = (Song) intent.getSerializableExtra("music");

        mp = MediaPlayer.create(NowPlayingActivity.this, Uri.parse(music.getTitle()));

        playBtn = (Button) findViewById(R.id.playBtn);
        mp.setVolume(0.5f, 0.5f);

        positionBar = (SeekBar) findViewById(R.id.positionBar);
        positionBar.setMax(mp.getDuration());

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlaying();
            }
        });

    }

    public void startPlaying(){
        if(mp!=null && mp.isPlaying()){
            mp.stop();
        }

        if(music!=null){
            mp = MediaPlayer.create(NowPlayingActivity.this, Uri.parse(music.getTitle()));
            mp.start();

        }
    }
}