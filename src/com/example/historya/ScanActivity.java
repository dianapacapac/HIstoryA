package com.example.historya;

import java.io.FileOutputStream;

import com.example.historya.utis.Constants;

import android.app.TabActivity;
import android.widget.Toast;

public class ScanActivity extends TabActivity{
	/*
	public static String mainLocation(String contents){
		String strMainLocation = "";
		StringTokenizer st = new StringTokenizer(contents, "-");
		
		while (st.hasMoreElements()){
			String mainkey = st.nextToken();
			String speckey = st.nextToken();
		}
		strMainLocation = mainkey;
		return strMainLocation;
	}*/
	
	//get main location
	public static String mainlocation(String contents){
		//string to return
		
		String currToken;
		
		//contents is the whole QR code read
		
		String[] tokens = contents.split("-");
		for (String token : tokens)
		{
		    //System.out.println(token);
			currToken = token;
		}
		currToken = tokens[0];
		
		return currToken;
	}
	
	
	//get specific location
	public static String speclocation(String contents){
		//string to return
		
		String currToken;
		
		//contents is the whole QR code read
		
		String[] tokens = contents.split("-");
		for (String token : tokens)
		{
		    //System.out.println(token);
			currToken = token;
		}
		currToken = tokens[1];
		
		return currToken;
		
	}
	
	//get file type
	public static String fileName(String contents) {
		// TODO Auto-generated method stub
		int fileIndex = contents.lastIndexOf("-");
		String fileType = contents.substring(fileIndex+1);
		return fileType;
	}
}
