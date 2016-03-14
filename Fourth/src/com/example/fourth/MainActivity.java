package com.example.fourth;

import android.support.v7.app.ActionBarActivity;

import java.io.IOException;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	DBHelper myDB;
	EditText editBarName, editBarCity, editDrinkName;
	Button btnLandos, btnChangos, btnViewAll;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myDB = new DBHelper(this);

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

		btnViewAll = (Button) findViewById(R.id.btnViewAllBars);
		btnLandos = (Button) findViewById(R.id.btnLandos);
		btnChangos = (Button) findViewById(R.id.btnChangos);

		ViewAll();
		ViewLandos();
		ViewChangos();
	}

	public void ViewAll() {
		btnViewAll.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Cursor res = myDB.getAllData();
				if (res.getCount() == 0) {
					// show message
					showMessage("Error", "No Data Found");
					return;
				}

				StringBuffer buffer = new StringBuffer();
				while (res.moveToNext()) {
					buffer.append("ID :" + res.getString(0) + "\n");
					buffer.append("Bar Name :" + res.getString(1) + "\n");
					buffer.append("Bar City :" + res.getString(2) + "\n");

				}
				// Show All Data
				showMessage("Data", buffer.toString());
			}
		});
	}

	public void ViewLandos() {
		btnLandos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Cursor res = myDB.getLandos();
				if (res.getCount() == 0) {
					// show message
					showMessage("Error", "No Data Found");
					return;
				}

				StringBuffer buffer = new StringBuffer();
				while (res.moveToNext()) {
					buffer.append("ID :" + res.getString(0) + "\n");
					buffer.append("Drink Name :" + res.getString(1) + "\n");
					buffer.append("Drink Price :" + res.getString(2) + "\n");

				}
				// Show All Data
				showMessage("Data", buffer.toString());
			}
		});
	}

	public void ViewChangos() {
		btnChangos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Cursor res = myDB.getChangos();
				if (res.getCount() == 0) {
					// show message
					showMessage("Error", "No Data Found");
					return;
				}

				StringBuffer buffer = new StringBuffer();
				while (res.moveToNext()) {
					buffer.append("ID :" + res.getString(0) + "\n");
					buffer.append("Drink Name :" + res.getString(1) + "\n");
					buffer.append("Drink Price :" + res.getString(2) + "\n");

				}
				// Show All Data
				showMessage("Data", buffer.toString());
			}
		});
	}

	public void showMessage(String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setCancelable(true);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
