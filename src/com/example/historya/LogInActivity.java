package com.example.historya;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends Activity{
	
	private Context context;
	private EditText username, password;
	private Button loginButton, registerButton;
	private ProgressDialog progressDialog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);
        
		progressDialog = new ProgressDialog(this);
		progressDialog.setCancelable(false);

        username = (EditText)(findViewById(R.id.username));
        password = (EditText)(findViewById(R.id.password));
        loginButton = (Button)(findViewById(R.id.loginButton));
        registerButton = (Button)(findViewById(R.id.registerButton));
        
        loginButton.setOnClickListener(new View.OnClickListener() {
        	
        	AlertDialog alertDialog = new AlertDialog.Builder(LogInActivity.this).create();
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//check if username and password are entered
				if(username.getText().toString().trim().length() > 0 && password.getText().toString().trim().length() > 0){
					//check if correct username
					if(username.getText().toString().trim().equals("user") && password.getText().toString().trim().equals("usertest")){
						//go to main activity
						Intent mainActivity = new Intent(LogInActivity.this, MainActivity.class);
						startActivity(mainActivity);
					}else{
						alertDialog.setTitle("Failed Log In");
						alertDialog.setMessage("Invalid username or password.");
						alertDialog.show();
					}
				}else{
					alertDialog.setTitle("Failed Log In");
					alertDialog.setMessage("Invalid username or password.");
					alertDialog.show();
				}
			}
		});
        
        registerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent registerIntent = new Intent(LogInActivity.this, RegisterActivity.class);
				startActivity(registerIntent);
			}
		});
    }
    @Override
    public void onBackPressed() {
    	Intent a = new Intent(Intent.ACTION_MAIN);
    	a.addCategory(Intent.CATEGORY_HOME);
    	a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	startActivity(a);
    }
    	
}
