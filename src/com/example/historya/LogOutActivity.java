package com.example.historya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LogOutActivity extends Activity{

	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        Intent intentLogout = new Intent(this, LogInActivity.class);
	        startActivity(intentLogout);
	 }
	    
}
