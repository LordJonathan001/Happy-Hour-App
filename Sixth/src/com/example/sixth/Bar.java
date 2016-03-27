package com.example.sixth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Bar extends Activity{
	String setBarTest = MainActivity.setBar;
	String barNameHolder, picHolder, barContactHolder, barPhoneHolder; 
	int imageInt, textInt1,textInt2, textInt3;
	TextView setBarName, setBarContact,setBarPhone;
	ImageView barPic;
	Button viewAll, beer, wine, mixedDrinks, other, getTaxi;
	static String setDrinkType;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bar);
		
		Button viewAll = (Button)findViewById(R.id.btnviewAll);
		Button beer = (Button)findViewById(R.id.btnBeer);
		Button wine = (Button)findViewById(R.id.btnWine);
		Button mixedDrinks = (Button)findViewById(R.id.btnMixedDrinks);
		Button other = (Button)findViewById(R.id.btnOther);
		Button getTaxi = (Button)findViewById(R.id.btnTaxi);
		
		barPic = (ImageView) findViewById(R.id.barPic);
		String picHolder = "drawable/"+setBarTest;		
		int imageInt = getResources().getIdentifier(picHolder, null, getPackageName());
		barPic.setImageResource(imageInt);
		
		setBarName = (TextView)findViewById(R.id.barName);
		String barNameHolder = "@string/"+setBarTest;
		int textInt1 = getResources().getIdentifier(barNameHolder, null, getPackageName());
		setBarName.setText(textInt1);
		
		setBarContact = (TextView)findViewById(R.id.barContact);
		String barContactHolder = "@string/"+setBarTest+"Contact";
		int textInt2 = getResources().getIdentifier(barContactHolder, null, getPackageName());
		setBarContact.setText(textInt2);
		
		setBarPhone = (TextView)findViewById(R.id.barPhone);
		String barPhoneHolder = "@string/"+setBarTest+"Phone";
		int textInt3 = getResources().getIdentifier(barPhoneHolder, null, getPackageName());
		setBarPhone.setText(textInt3);
		
		viewAll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = (new Intent(Bar.this, Drinks.class));
				startActivity(i); 			
			}
			
		});
		beer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String setDrinkType = "Beer";
				Intent intent = new Intent(getApplicationContext(), Drinks.class);
				intent.putExtra("sample_name", setDrinkType);
				startActivity(intent); 
				
			}
			
		});
		wine.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String setDrinkType = "Wine";
				Intent intent = new Intent(getApplicationContext(), Drinks.class);
				intent.putExtra("sample_name", setDrinkType);
				startActivity(intent);
			}
			
		});
		mixedDrinks.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String setDrinkType = "Mixed Drink";
				Intent intent = new Intent(getApplicationContext(), Drinks.class);
				intent.putExtra("sample_name", setDrinkType);
				startActivity(intent);
				
			}
			
		});
		
		other.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String setDrinkType = "Other";
				Intent intent = new Intent(getApplicationContext(), Drinks.class);
				intent.putExtra("sample_name", setDrinkType);
				startActivity(intent); 
				
			}
			
		});
		getTaxi.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = (new Intent(Bar.this, Taxi.class));
				startActivity(i); 			
			}
			
		});
			
	 
	}
}
