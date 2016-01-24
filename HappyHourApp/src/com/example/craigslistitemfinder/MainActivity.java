package com.example.craigslistitemfinder;

import cl.telematica.locationexample.location.ActiveLocationManagerActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActiveLocationManagerActivity {

	public static String locationSet, yourLat, yourLong;
	public static TextView latitudeText, longitudeText;
	public static double gps_lat, gps_long;
	public static double citylongitudeText, citylatitudeText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		Button useSelectedCityBtn = (Button) findViewById(R.id.btnSetCity);

		final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());

		useSelectedCityBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, NewSearch.class);
				locationSet = String.valueOf(spinner.getSelectedItem());
				if (locationSet.equals("Blossburg, PA")) {
					//info to pass to database to call info for that town
					startActivity(i);
				} else if (locationSet.equals("Mansfield, PA")) 
				{					
	                //info to pass to database to call info for that town
					startActivity(i);
				} 
				else if (locationSet.equals("Corning, NY")) 
				{//info to pass to database to call info for that town
					startActivity(i);
				} 
				else if (locationSet.equals("Wellsboro, PA")) 
				{//info to pass to database to call info for that town
					startActivity(i);
				} 
				else if (locationSet.equals("Tioga, PA")) 
				{//info to pass to database to call info for that town
					startActivity(i);
				} 
				else if (locationSet.equals("Troy, PA")) 
				{//info to pass to database to call info for that town
					startActivity(i);
				} 
				else {
					//info to pass to database to call info for that town
					startActivity(i);
				}

			};
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}