package com.example.sixth;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends Activity implements
OnItemSelectedListener {
	DBHelper myDB;
	Button selectBar;	
    Spinner spinner;
    static String pullBar,setBar,name, cityState, upperCaseName;
    
   static  List<String> beer, beerLables;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button selectBar = (Button)findViewById(R.id.btnSelectBar);
		myDB = new DBHelper(this);
		 // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);
     // Spinner click listener
        spinner.setOnItemSelectedListener(this);
    
		try {
			myDB.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
		try {
			myDB.openDataBase();
		} catch (SQLException sqle) {
			throw sqle;
		}

		
		// Loading spinner data from database
        loadSpinnerData();
        
        selectBar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				pullBar = String.valueOf(spinner.getSelectedItem());
				String[] parts = pullBar.split(" "); //returns an array with the 2 parts
				name = parts[0];
			
				String nlast = parts[parts.length-2];
				String last = parts[parts.length-1];
				
				cityState =  nlast+ " " + last;
				upperCaseName=name.toUpperCase();
				setBar = name.toLowerCase();
				
				 beer = new ArrayList<String>();
				 beerLables = new ArrayList<String>();
				 			 
				 Intent i = (new Intent(MainActivity.this, Bar.class));
				 i.putExtra("bar",upperCaseName);
				startActivity(i); 			
			}
			
		});	
	}

	
	 private void loadSpinnerData() {
	        // database handler
	        DBHelper db = new DBHelper(getApplicationContext());
	 
	        // Spinner Drop down elements
	        List<String> lables = db.getAllLabels();
	 
	        // Creating adapter for spinner
	        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
	                android.R.layout.simple_spinner_item, lables);
	 
	        // Drop down layout style - list view with radio button
	        dataAdapter
	                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	 
	        // attaching data adapter to spinner
	        spinner.setAdapter(dataAdapter);
	    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
