package com.example.historya;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MusicActivity extends Activity{
	
	private MediaPlayer mediaPlayer;
	public TextView songName, duration;
	private double timeElapsed = 0, finalTime = 0;
	private int forwardTime = 2000, backwardTime = 2000;
	private Handler durationHandler = new Handler();
	private SeekBar seekbar;

	
	public static void musicName(String musName){
		
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        initializeViews();
    }
    
	public void initializeViews(){
		songName = (TextView) findViewById(R.id.songName);
		mediaPlayer = MediaPlayer.create(this, R.raw.tagaytay1);
		finalTime = mediaPlayer.getDuration();
		duration = (TextView) findViewById(R.id.songDuration);
		seekbar = (SeekBar) findViewById(R.id.seekBar);
		songName.setText("luneta.mp3");
		
		seekbar.setMax((int) finalTime);
		seekbar.setClickable(false);
	}
	
	// play mp3 song
	public void play(View view) {
		mediaPlayer.start();
		timeElapsed = mediaPlayer.getCurrentPosition();
		seekbar.setProgress((int) timeElapsed);
		durationHandler.postDelayed(updateSeekBarTime, 100);
	}

	//handler to change seekBarTime
	private Runnable updateSeekBarTime = new Runnable() {
		public void run() {
			//get current position
			timeElapsed = mediaPlayer.getCurrentPosition();
			//set seekbar progress
			seekbar.setProgress((int) timeElapsed);
			//set time remaing
			double timeRemaining = finalTime - timeElapsed;
			//duration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining), TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));
			
			//repeat yourself that again in 100 miliseconds
			durationHandler.postDelayed(this, 100);
		}
	};

	// pause mp3 song
	public void pause(View view) {
		mediaPlayer.pause();
	}

	// go forward at forwardTime seconds
	public void forward(View view) {
		//check if we can go forward at forwardTime seconds before song endes
		if ((timeElapsed + forwardTime) > 0) {
			timeElapsed = timeElapsed - backwardTime;
			
			//seek to the exact second of the track
			mediaPlayer.seekTo((int) timeElapsed);
		}
	}

    //handling destroy to release media player
    @Override
    protected void onDestroy(){
    	if(mediaPlayer!=null){
    		mediaPlayer.stop();
    		mediaPlayer.release();
    		mediaPlayer = null;
    	}
    	super.onDestroy();
    }
    
    @Override 
    public void onBackPressed(){
      if (mediaPlayer != null){
          if(mediaPlayer.isPlaying())
        	  mediaPlayer.stop();

          mediaPlayer.release();
      }

      //there is no reason to call super.finish(); here
      //call super.onBackPressed(); and it will finish that activity for you
      super.onBackPressed(); 
    }
}
