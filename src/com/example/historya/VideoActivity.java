package com.example.historya;

import com.example.historya.utis.Constants;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends Activity{
	
	static String initMusName, initMusName2, finMusName;
	
	public static void videoName(String musName){
		//for of video
		finMusName = musName;
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	//String vidId = "R.raw.tagaytay2"; //+ finMusName;
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);       
        
		VideoView videoView = (VideoView)findViewById(R.id.videoView);
		//videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.tiradpass));
		
		
		//determine which video to play
		if(Constants.specificLocation.equals("TAAL1")){
			//videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/" + R.raw.tagaytay2));
			videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/" + R.raw.taal1));	
		}else if(Constants.specificLocation.equals("TAAL2")){
			videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/" + R.raw.taal2));	
		}else{
			videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/" + R.raw.taal3));	
		}

		
		//videoView.setVideoPath("https://www.thenewboston.com/forum/project_files/006_testVideo.mp4");
		MediaController mediaController = new MediaController(this);
		mediaController.setAnchorView(videoView);
		videoView.setMediaController(mediaController);
		videoView.start();
    }
	
    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
      // action with ID action_refresh was selected
      case R.id.action_home:
        HomeActivity();
        return true;
      case R.id.action_profile:
    	ProfileActivity();
        return true;
      // action with ID action_settings was selected
      case R.id.action_settings:
    	SettingsActivity();
        return true;
      case R.id.action_trail:
    	TrailsActivity();
        return true;
      case R.id.action_scan:
    	  ScanActivity();
    	  Toast.makeText(getApplicationContext(), "Please press SCAN Button.", Toast.LENGTH_LONG).show();
          return true;
      case R.id.action_logout:
    	  LogoutActivity();
          return true;
      default:
    	  return super.onOptionsItemSelected(item);
      }

      //return true;
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        System.out.println("IN onConfigurationChanged()");
    }
    
    private void HomeActivity(){
    	Intent intentHome = new Intent(this, MainActivity.class);
    	startActivity(intentHome);
    }
    
    private void ProfileActivity(){
    	Intent intentProfile = new Intent(this, ProfileActivity.class);
    	startActivity(intentProfile);
    }
    
    private void SettingsActivity(){
    	Intent intentSettings = new Intent(this, SettingsActivity.class);
    	startActivity(intentSettings);
    }
    
    private void TrailsActivity(){
    	Intent intentTrails = new Intent(this, TrailTypeActivity.class);
    	startActivity(intentTrails);
    }
	
    private void ScanActivity(){
    	Intent intentScan = new Intent(this, MainActivity.class);
    	startActivity(intentScan);
    }
    
    private void LogoutActivity(){
    	Intent intentLogout = new Intent(this, LogOutActivity.class);
    	startActivity(intentLogout);
    }
}
