package cl.telematica.locationexample;

import cl.telematica.locationexample.interfaces.LocationListenerHandler;
import cl.telematica.locationexample.location.ActiveLocationManagerActivity;


import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActiveLocationManagerActivity {
	
	private TextView latitudText;
	private TextView longitudText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		Button b = (Button)findViewById(R.id.btnTestNoResults);
		Button c = (Button)findViewById(R.id.btnGPSSearch);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, NoResults.class));
			};
		});
		c.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, NewSearch.class));
			};
		});
		
		latitudText = (TextView) findViewById(R.id.textView4);
		longitudText = (TextView) findViewById(R.id.textView5);
		
		listener = new LocationListenerHandler() {
			@Override
			public void OnLocationReceived(Location loc) {
				//latitudText.setText("" + loc.getLatitude());
				//longitudText.setText("" + loc.getLongitude());
			}
        };
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
