package cl.telematica.locationexample;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import cl.telematica.locationexample.interfaces.LocationListenerHandler;
import cl.telematica.locationexample.location.ActiveLocationManagerActivity;

public class NewSearch extends ActiveLocationManagerActivity {
	
	public TextView citylat;
	public TextView citylong;
	public TextView yourlat;
	public TextView yourlong;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_search);
		
		//Toast message to delay while retrieving map
		Context context = getApplicationContext();
		CharSequence text = "Please wait while we perform your search";
		int duration = Toast.LENGTH_LONG;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		
		yourlat = (TextView) findViewById(R.id.yourLat);
		yourlong = (TextView) findViewById(R.id.yourLong);
		//yourlat.setText("Your Latitude: "+ MainActivity.yourLat);
		//yourlong.setText("Your Longitude: " + MainActivity.yourLong);
		
		citylat = (TextView) findViewById(R.id.cityLong);
		citylong = (TextView) findViewById(R.id.cityLat);
		citylat.setText("City Latitude: "+ MainActivity.citylatitudeText);
		citylong.setText("City Longitude: " + MainActivity.citylongitudeText);
		
		
		//yourlat = (TextView) findViewById(R.id.cityLong);
		//yourlong = (TextView) findViewById(R.id.cityLat);
		listener = new LocationListenerHandler() {
			@Override
			public void OnLocationReceived(Location loc) {
				yourlat.setText("Your Latitude: " + loc.getLatitude());
				yourlong.setText("Your Longitude: " + loc.getLongitude());
			}
        };
		
		
	}

}
