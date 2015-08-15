package com.example.historya;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends Activity{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Button submitButton;
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        submitButton = (Button)(findViewById(R.id.submitButton));
        
        submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this).create();
				alertDialog.setTitle("Registration");
				alertDialog.setMessage("You are successfully registered. You may now log-in.");
				alertDialog.show();
			}
		});
    }
}
