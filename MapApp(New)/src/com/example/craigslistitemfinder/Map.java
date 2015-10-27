package com.example.craigslistitemfinder;

import android.os.Bundle;
import android.widget.TextView;
import cl.telematica.locationexample.location.ActiveLocationManagerActivity;

public class Map extends ActiveLocationManagerActivity {
	public static TextView categoryList;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
	}
	
}
