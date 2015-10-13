package com.example.craigslistitemfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NoResults extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_no_results);
		Button b = (Button)findViewById(R.id.btnGPS);
		Button c = (Button)findViewById(R.id.btnNewSearch);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(NoResults.this, MainActivity.class));
				
			};
		});
	}
}
