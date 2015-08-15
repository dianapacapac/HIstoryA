package com.example.historya;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class TrailTypeActivity extends TabActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailstype);
        TabHost tabHost = getTabHost();
        
        // Tab for Trails
        TabSpec trailspec = tabHost.newTabSpec("Trails");

        //trailspec.setIndicator("Trails", getResources().getDrawable(R.drawable.icon_photos_tab));
        trailspec.setIndicator("Trails", getResources().getDrawable(R.drawable.tabstrails));
        Intent trailIntent = new Intent(this, TrailsActivity.class);
        trailspec.setContent(trailIntent);
        
        // Tab for Maps
        TabSpec mapspec = tabHost.newTabSpec("Map");
        //mapspec.setIndicator("Map", getResources().getDrawable(R.drawable.icon_videos_tab));
        mapspec.setIndicator("Map", getResources().getDrawable(R.drawable.tabsmaps));
        Intent mapIntent = new Intent(this, MapActivity.class);
        mapspec.setContent(mapIntent);
        // Adding all TabSpec to TabHost
        tabHost.addTab(trailspec); // Adding photos tab
        tabHost.addTab(mapspec); // Adding videos tab
        
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
}
