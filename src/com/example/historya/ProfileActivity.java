package com.example.historya;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.historya.utis.Constants;

public class ProfileActivity extends ActionBarActivity{
	Spinner spinnerTrails;
	int pfNumLinesRead;
	 private String[] state = { "Taal Heritage Trail" + " " + Constants.numLinesRead + "/" + Constants.intTrailsTag};
	//private String[] state = { "Taal Heritage Trail" + " " + pfNumLinesRead + "/" + Constants.intTrailsTag};
	 
    public void onCreate(Bundle savedInstanceState) {
    	
        //read file
        pfreadFromFile();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        pfreadFromFile();
        spinnerTrails = (Spinner) findViewById(R.id.pf_trophies);
        
        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
          //android.R.layout.simple_spinner_item, R.array.trail_array);
          android.R.layout.simple_spinner_item, state);
        adapter_state
          .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTrails.setAdapter(adapter_state);
        
    }
    

	public void pfreadFromFile(){
		Constants.readFromFile = null;
        //Constants.numLinesRead = 0;
		pfNumLinesRead = 0;
        String finSpecLocation;
        final String TAG = ProfileActivity.class.getName();
        try {
            InputStream inputStream = openFileInput(Constants.FILENAME);
             
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                
                while ((receiveString = bufferedReader.readLine()) != null ) {
                    //Constants.numLinesRead = Constants.numLinesRead + 1; 
                	pfNumLinesRead = pfNumLinesRead + 1;
                    stringBuilder.append(receiveString + "\n");
                }
                 
                inputStream.close();
                Constants.readFromFile = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }
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
    
    @Override
    public void onBackPressed() {
    	//do nothing
    }

    
}
