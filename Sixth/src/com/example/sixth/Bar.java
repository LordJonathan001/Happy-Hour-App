package com.example.sixth;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Bar extends Activity {
	
	static String hhSpecialTest, barTableName;
	String setBarTest,barNameHolder, picHolder, barContactHolder, barPhoneHolder;
	int imageInt, textInt1, textInt2, textInt3, textInt4;
	TextView setBarName, setBarContact, setBarPhone, setBarHours;
	ImageView barPic;
	Button viewAll, specials, getTaxi;
		
	public void onCreate(Bundle savedInstanceState) {
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			setBarTest = bundle.getString("bar");
			
			// barName =barNameHolder;
		}
		
		hhSpecialTest = setBarTest;
		barTableName = setBarTest.toUpperCase(Locale.US);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bar);

		Button viewAll = (Button) findViewById(R.id.btnviewAll);
		Button specials = (Button) findViewById(R.id.btnSpecials);
		Button getTaxi = (Button) findViewById(R.id.btnTaxi);

		barPic = (ImageView) findViewById(R.id.barPic);
		String picHolder = "drawable/" + setBarTest;
		imageInt = getResources().getIdentifier(picHolder, null, getPackageName());
		barPic.setImageResource(imageInt);

		setBarName = (TextView) findViewById(R.id.barName);
		String barNameHolder = "@string/" + setBarTest;
		textInt1 = getResources().getIdentifier(barNameHolder, null, getPackageName());
		setBarName.setText(textInt1);

		setBarContact = (TextView) findViewById(R.id.barContact);
		String barContactHolder = "@string/" + setBarTest + "Contact";
		textInt2 = getResources().getIdentifier(barContactHolder, null, getPackageName());
		setBarContact.setText(textInt2);

		setBarPhone = (TextView) findViewById(R.id.barPhone);
		String barPhoneHolder = "@string/" + setBarTest + "Phone";
		textInt3 = getResources().getIdentifier(barPhoneHolder, null, getPackageName());
		setBarPhone.setText(textInt3);

		setBarHours = (TextView) findViewById(R.id.barHours);
		String barHoursHolder = "@string/" + setBarTest + "Hours";
		textInt4 = getResources().getIdentifier(barHoursHolder, null, getPackageName());
		setBarHours.setText(textInt4);

		viewAll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = (new Intent(Bar.this, Drinks.class));
				startActivity(i);
			}

		});

		specials.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = (new Intent(Bar.this, NoResult.class));
				startActivity(i);
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
