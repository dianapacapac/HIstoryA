package com.example.historya;

import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.historya.utis.Constants;
import com.google.zxing.client.android.CaptureActivity;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   
    }
   
    @Override
    public void onBackPressed() {
    	//do nothing
    }
    
	public void profile(View v){
		Intent profileIntent = new Intent(this, ProfileActivity.class);
		startActivity(profileIntent);
	}
    
	public void settings(View v){
		Intent settingsIntent = new Intent(this, SettingsActivity.class);
		startActivity(settingsIntent);
	}
	
    public void scanQR(View v) {
    	
    	Intent scanIntent = new Intent(MainActivity.this, CaptureActivity.class);
    	scanIntent.setAction("com.google.zxing.client.android.SCAN");
    	scanIntent.putExtra("SAVE_HISTORY", false);
    	startActivityForResult(scanIntent, 0);		
	}
    
    
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				//String contents = intent.getStringExtra("SCAN_RESULT");
				//String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				
				//reset
				Constants.contents = null;
				Constants.mainLocation = null;
				Constants.specificLocation = null;
				Constants.fileType = null; 				
				
				//set new values
				Constants.contents = intent.getStringExtra("SCAN_RESULT");
				Constants.mainLocation = ScanActivity.mainlocation(Constants.contents);
				Constants.specificLocation = ScanActivity.speclocation(Constants.contents);
				Constants.fileType = ScanActivity.fileName(Constants.contents);
				
				//write to file 
				//20150530 commented out, to uncomment
				
				writeToFile();
				
				Intent locationIntent = new Intent(this, LocationActivity.class);
				startActivity(locationIntent);
				
				/*june 1 
				Constants.activitylog = 1;
				Intent scanTypeIntent = new Intent(this, ScanTypeActivity.class);
				startActivity(scanTypeIntent);*/
				//in ScanTypeActivity, LocationActivity is started. 
				
				
			}else{
				AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
				alertDialog.setTitle("Cancel Scanning");
				alertDialog.setMessage("QR Code Scanning aborted.");
				alertDialog.show();
			}
		}
	}
	
	public void writeToFile(){
		String contentsToWrite = Constants.contents;
		final String TAG = LocationActivity.class.getName();
        try {
            //OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(Constants.FILENAME, Context.MODE_PRIVATE));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(Constants.FILENAME, Context.MODE_APPEND));
            outputStreamWriter.write(contentsToWrite);
            outputStreamWriter.write("\n");
            outputStreamWriter.close();
            //Toast.makeText(getApplicationContext(), "File successfully saved!", Toast.LENGTH_LONG).show();
            //readFromFile();
        }
        catch (IOException e) {
           e.printStackTrace();
        }		
	}
	
	
	public void tracks(View v){
		Intent tracksIntent = new Intent(this, TrailTypeActivity.class);
		startActivity(tracksIntent);
	}

}
