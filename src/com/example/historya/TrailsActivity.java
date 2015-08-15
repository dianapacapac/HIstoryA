package com.example.historya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.historya.utis.Constants;

public class TrailsActivity extends Activity{
    private CheckBox chkTrail1, chkTrail2, chkTrail3;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trails);

        Constants.tag1 = 1;
        //read file
        readFromFile();
        
        if (Constants.tag1 == 1){
        //traverse read strings, get 2nd token after first "-"
        chkTrail1 = (CheckBox)findViewById(R.id.trail1);
        chkTrail2 = (CheckBox)findViewById(R.id.trail2);
        chkTrail3 = (CheckBox)findViewById(R.id.trail3);
        
        
		/*AlertDialog alertDialog = new AlertDialog.Builder(TrailsActivity.this).create();
		alertDialog.setTitle("READ FILE FINAL");
		alertDialog.setMessage(Constants.readFromFile + " " + Constants.numLinesRead);
		alertDialog.show();*/

		String[] semSpecLocation = Constants.readFromFile.split("\n");
		int specLocCount = 0;
		
		ArrayList<String> aList = new ArrayList();
		
		//for (int i = 0; i < Constants.numLinesRead; i++){
		for (int i = 0; i < Constants.numLines; i++){
			aList.add(semSpecLocation[i]);
			String finSpecLocation = ScanActivity.speclocation(aList.get(i));
			//Toast.makeText(this, aList.get(i), Toast.LENGTH_LONG).show();
			if (finSpecLocation.equals("TAAL1")){
				chkTrail1.setChecked(true);
				specLocCount = specLocCount++;
			}else if (finSpecLocation.equals("TAAL2")){
				chkTrail2.setChecked(true);
				specLocCount = specLocCount++;
			}else{
				chkTrail3.setChecked(true);
				specLocCount = specLocCount++;
			}
			
		}
		
		//temp - if all tracks already checked, tag specPlace as completed
		if(specLocCount >= Constants.intTrailsTag){
			Constants.finMainLoc = "COMPLETED";
		}
       }else{
    	   return;
       }
        
    }
	
	public void readFromFile(){
		Constants.readFromFile = null;
        Constants.numLinesRead = 0;
        Constants.numLines = 0;
        String finSpecLocation;
        int iTaal1 = 0;
        int iTaal2 = 0;
        int iTaal3 = 0;
        //String ret = "";
        final String TAG = TrailsActivity.class.getName();
        	try {
            	
                InputStream inputStream = openFileInput(Constants.FILENAME);
                 
                if ( inputStream != null ) {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    
                    while ((receiveString = bufferedReader.readLine()) != null ) {
                    	String readSpecLoc = ScanActivity.speclocation(receiveString);
                    	if (readSpecLoc.equals("TAAL1")){
                    		iTaal1 = 1;
                    	}else if (readSpecLoc.equals("TAAL2")){
                    		iTaal2 = 1;
                    	}else{
                    		iTaal3 = 1;
                    	}

                        Constants.numLines = Constants.numLines + 1;
                        //Constants.numLinesRead = Constants.numLinesRead + 1; 
                    	Constants.numLinesRead = iTaal1 + iTaal2 + iTaal3;
                        stringBuilder.append(receiveString + "\n");
                    }
                    
                    inputStream.close();
                    Constants.readFromFile = stringBuilder.toString();
                }
            }
            catch (FileNotFoundException e) {
                //Log.e(TAG, "File not found: " + e.toString());
                Constants.tag1 = 0;
                return;
            } catch (IOException e) {
                //Log.e(TAG, "Can not read file: " + e.toString());
                Constants.tag1 = 0;
                return;
            }

	}
	
	
	public void marker1(View v){
		Constants.markerlog = 1;
		Intent infoIntent = new Intent(this, MarkerActivity.class);
		startActivity(infoIntent);
	}
	public void marker2(View v){
		Constants.markerlog = 2;
		Intent infoIntent = new Intent(this, MarkerActivity.class);
		startActivity(infoIntent); 
	}
	public void marker3(View v){
		Constants.markerlog = 3;
		Intent infoIntent = new Intent(this, MarkerActivity.class);
		startActivity(infoIntent);
	}
	
	public void iP1Action(View v){
		Constants.interestlog = 1;
		Intent infoIntent = new Intent(this, InterestActivity.class);
		startActivity(infoIntent);
	}
	
	public void iP2Action(View v){	
		Constants.interestlog = 2;
		Intent infoIntent = new Intent(this, InterestActivity.class);
		startActivity(infoIntent);
	}
	
	public void iP3Action(View v){	
		Constants.interestlog = 3;
		Intent infoIntent = new Intent(this, InterestActivity.class);
		startActivity(infoIntent);
	}
	
	public void iP4Action(View v){	
		Constants.interestlog = 4;
		Intent infoIntent = new Intent(this, InterestActivity.class);
		startActivity(infoIntent);
	}
	
	public void iP5Action(View v){	
		Constants.interestlog = 5;
		Intent infoIntent = new Intent(this, InterestActivity.class);
		startActivity(infoIntent);
	}
	
	
}
