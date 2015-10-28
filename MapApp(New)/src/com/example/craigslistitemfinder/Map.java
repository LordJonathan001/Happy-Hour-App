package com.example.craigslistitemfinder;

import java.util.ArrayList;
import java.util.Random;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Map extends Activity {
	//public static TextView categoryList;
	private final LatLng CITY_LOCATION = new LatLng(MainActivity.citylatitudeText, MainActivity.citylongitudeText);
	private LatLng GPS_LOCATION, RANDOM_LOCATION,HOLDING_LOCATION;
	private double randomLat, minLat, maxLat, randomLng, minLng, maxLng, gps_lat, gps_long;
	public static ArrayList<String> categoryList = NewSearch.categoryList;
	
	Random randomDouble  = new Random();
	
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		gps_lat = Double.parseDouble(MainActivity.yourLat);//location of user
		gps_long = Double.parseDouble(MainActivity.yourLong);
		GPS_LOCATION = new LatLng(gps_lat, gps_long);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		Button b = (Button)findViewById(R.id.btnGPS);
		Button c = (Button)findViewById(R.id.btnNewSearch);
		//String selectedLocation = getIntent().getExtras().getString("key");
		
		if(MainActivity.citylatitudeText == 1000){
			HOLDING_LOCATION = GPS_LOCATION;
			minLat = gps_lat - 0.02;
			maxLat = gps_lat + 0.02;
			minLng = gps_long - 0.02;
			maxLng = gps_long + 0.02;
		}
		else{
			HOLDING_LOCATION = CITY_LOCATION;
			minLat = MainActivity.citylatitudeText - 0.02;
			maxLat = MainActivity.citylatitudeText + 0.02;
			minLng = MainActivity.citylongitudeText - 0.02;
			maxLng = MainActivity.citylongitudeText + 0.02;
		}
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Map.this, MainActivity.class));
				
			};
		});
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		for(int i=1; i<10; i++){
			randomLat = minLat + (maxLat - minLat) * randomDouble.nextDouble();
			randomLng = minLng + (maxLng - minLng)* randomDouble.nextDouble();
			RANDOM_LOCATION = new LatLng(randomLat, randomLng);
			map.addMarker(new MarkerOptions().position(RANDOM_LOCATION).title(categoryList.get(i)));
			
		}
		

		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(HOLDING_LOCATION,13);
		map.animateCamera(update);
	}
}



/* 
 * REMINDER JONATHAN!!!
 * look up if there is some kind of onclick method for the markers
 * also try to see if you can pass entire arrays through with the putExtra method instead of just one variable
 * ^^^^ pretty sure you can try looking here: http://developer.android.com/reference/android/content/Intent.html#putExtra(java.lang.String, java.lang.String)
 * ^^^^use the control+F to find the stuff by entering putExtra
 */