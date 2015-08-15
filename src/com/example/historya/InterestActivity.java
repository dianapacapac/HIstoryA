package com.example.historya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.historya.utis.Constants;

public class InterestActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        TextView tv_interest_info = (TextView)findViewById(R.id.interest_textview);
        RelativeLayout rl_interest_info = (RelativeLayout)findViewById(R.id.rl_interest_trails);
        
        if (Constants.interestlog==1){
        	rl_interest_info.setBackgroundResource(R.drawable.ananias_diokno);
        	tv_interest_info.setText
        	("\tOne of Gen. Emilio Aguinaldo’s most trusted generals, Ananias Diokno led campaigns" +
        			"against the Spanish in the Visayas region during the Philippine Revolution. \n" +
        			"Gen. Ananias Diokno is the father of soldier and senator, Ramon Diokno and the grandfather" +
        			"of lawyer and senator, Jose W. Diokno.");
        }else if (Constants.interestlog==2){
        	rl_interest_info.setBackgroundResource(R.drawable.galleria_taal);
        	tv_interest_info.setText
        	("\tA quaint museum featuring vintage cameras dating back as far as the late 1800’s.");
        }else if (Constants.interestlog==3){
        	rl_interest_info.setBackgroundResource(R.drawable.escuelapia);
        	tv_interest_info.setText
        	("\tIf you were the child of an eminent Taaleño in the 1850s, you might have had your primary education here.\n " +
        			"Administered by the Augustinian friars, Taal’s Escuela Pia was constructed in 1853, a year after a " +
        			"major earthquake destroyed most of the town’s buildings. Located west of the Image of the Virgin Casaysay, " +
        			"it was also a makeshift site for Holy Masses while the Basilica of St. Martin was being built.");
        }
        else if (Constants.interestlog==4){
        	rl_interest_info.setBackgroundResource(R.drawable.basilicaoftaal);
        	tv_interest_info.setText
        	("\tTall and magnificent, the Minor Basilica of St. Martin of Tours, or the Taal Basilica as it is more " +
        			"commonly known, is one of the country’s biggest and oldest Catholic Church. \n" +
        			"Built on a plateau overlooking the town of Taal, the construction of the Basilica" +
        			"began in 1756, with improvements added to it through the decades. \n" +
        			"But then a major earthquake destroyed all of these structures, leading the Augustinian " +
        			"friars to build anew. \n" + 
        			"The new structure was designed and the construction directed by famous architect Don Luciano Oliver, and was inaugurated, unfinished, in 1865.\n" +
        			"Nowadays, the Taal Basilica remains an imposing structure that welcomes all visitors to Taal.");
        	
        }
        else if (Constants.interestlog==5){
        	rl_interest_info.setBackgroundResource(R.drawable.museo_orlina);
        	tv_interest_info.setText
        	("\tThe ancestral home of famed glass sculptor Ramon Orlina, Galleria Orlina now houses" +
        			"an art gallery and a café overlooking the Pansipit River.");
        	
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

}
