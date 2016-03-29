package com.example.sixth;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Drinks extends Activity{
	TextView drinkHolder;
	public static String drinkType = DBHelper.drinkType;
	String drinkTestHolder="";
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drinks);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			drinkType = bundle.getString("sample_name");
		}
		
		
		
		//drinkTestHolder = drinkType;
		drinkHolder = (TextView)findViewById(R.id.drinkTest);
		//String barNameHolder = "@string/"+drinkType;
		//int textInt1 = getResources().getIdentifier(barNameHolder, null, getPackageName());
		drinkHolder.setText(drinkType);
	}
}
