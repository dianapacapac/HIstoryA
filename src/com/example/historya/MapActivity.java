package com.example.historya;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MapActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.ph/maps/place/Taal,+Batangas/@13.8876182,120.9345389,15z/data=!4m2!3m1!1s0x33bd0a1efabef203:0x4ef524d256f82617?hl=en"));
        startActivity(browserIntent);
    }
}
