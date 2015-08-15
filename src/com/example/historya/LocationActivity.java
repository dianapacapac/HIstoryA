package com.example.historya;

import com.example.historya.utis.Constants;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LocationActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        
        FrameLayout fl_locImage = (FrameLayout)findViewById(R.id.loc_frameLayout);
        
		//set which image to show
		if(Constants.specificLocation.equals("TAAL1")){
			fl_locImage.setBackgroundResource(R.drawable.agoncillo_house);
		}else if(Constants.specificLocation.equals("TAAL2")){
			fl_locImage.setBackgroundResource(R.drawable.apacible_house);	
		}else{
			fl_locImage.setBackgroundResource(R.drawable.marcelaagoncillo_house);	
		} 
        
    }
	
	public void viewImageQR(View v){
		//write to file 
		//writeToFile();
		Intent imageIntent = new Intent(this, ImageActivity.class);
		startActivity(imageIntent);
		
	}
	
	public void viewMusicQR(View v){
		//write to file
		//writeToFile();
		//play music based on constant string
		Intent musicIntent = new Intent(this, MusicActivity.class);
		startActivity(musicIntent);
	}
	
	public void viewVideoQR(View v){
		//write to file
		//writeToFile();
		//play video based on constant string
		Intent videoIntent = new Intent(this, VideoActivity.class);
		startActivity(videoIntent);
	}
	
	/*
	public void writeToFile(){
		String contentsToWrite = Constants.contents;
		//final String FILENAME = "myMap.txt";
		final String TAG = LocationActivity.class.getName();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(Constants.FILENAME, Context.MODE_APPEND));
            outputStreamWriter.write(contentsToWrite);
            outputStreamWriter.write("\n");
            outputStreamWriter.close();
            Toast.makeText(getApplicationContext(), "File successfully saved!", Toast.LENGTH_LONG).show();
        }
        catch (IOException e) {
           e.printStackTrace();
        }		
	}
	
	public void readFromFile(){
        
        String ret = "";
        final String TAG = LocationActivity.class.getName();
        try {
            InputStream inputStream = openFileInput(Constants.FILENAME);
             
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                 
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString + "\n");
                }
                 
                inputStream.close();
                ret = stringBuilder.toString();
                //Toast.makeText(getApplicationContext(), ret, Toast.LENGTH_LONG).show();
    			AlertDialog alertDialog = new AlertDialog.Builder(LocationActivity.this).create();
    			alertDialog.setTitle("READ FILE");
    			alertDialog.setMessage(ret);
    			alertDialog.show();
            }
        }
        catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }
	}*/
	
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
