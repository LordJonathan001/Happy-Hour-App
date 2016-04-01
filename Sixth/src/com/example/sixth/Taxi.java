package com.example.sixth;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Taxi extends Activity {
	String cityState = MainActivity.cityState;
	String location, taxiNameHolder, taxiPhoneHolder,taxiHoursHolder;
	TextView setTaxiName, setTaxiHours, setTaxiPhone;
	int textInt1, textInt2, textInt3;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taxi);
		
		if(cityState.equals("Corning, NY")){
			location = "corning";
		}
		else if (cityState.equals("Troy, PA")){
			location = "bradford";
		}
		else{
			location ="tioga";
		}
		
		setTaxiName = (TextView)findViewById(R.id.happyHourSpecials);
		//taxiNameHolder = cityState; // Used to verify the correct cityState is being passed in
		taxiNameHolder = "@string/"+location+"TaxiName";
		textInt1 = getResources().getIdentifier(taxiNameHolder, null, getPackageName());
		setTaxiName.setText(textInt1);
		
		setTaxiPhone = (TextView)findViewById(R.id.taxiPhone);
		taxiPhoneHolder = "@string/"+location+"TaxiPhone";
		textInt2 = getResources().getIdentifier(taxiPhoneHolder, null, getPackageName());
		setTaxiPhone.setText(textInt2);
		
		setTaxiHours = (TextView)findViewById(R.id.taxiHours);
		taxiHoursHolder = "@string/"+location+"TaxiHours";
		textInt3 = getResources().getIdentifier(taxiHoursHolder, null, getPackageName());
		setTaxiHours.setText(textInt3);
		
		
	}
}
