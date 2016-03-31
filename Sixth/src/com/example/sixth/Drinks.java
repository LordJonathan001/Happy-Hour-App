package com.example.sixth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ListView;
import android.widget.Toast;

public class Drinks extends Activity {
	// TextView drinkHolder;
	public static String drinkType = DBHelper.drinkType;
	String drinkTestHolder = "";
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drinks);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			drinkType = bundle.getString("sample_name");
		}
		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		prepareListData();

		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);

	}

	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		
		 listDataHeader.add("Beer"); 
		 listDataHeader.add("Mixed Drinks");
		 listDataHeader.add("Other Drinks"); 
		 listDataHeader.add("Shots");
		 listDataHeader.add("Wine");
		 

		// Adding child data
		List<String> beer = new ArrayList<String>();
		/*
		 * beer.add("The Shawshank Redemption"); beer.add("The Godfather");
		 * beer.add("The Godfather: Part II"); beer.add("Pulp Fiction");
		 * beer.add("The Good, the Bad and the Ugly"); beer.add(
		 * "The Dark Knight"); beer.add("12 Angry Men");
		 */

		List<String> wine = new ArrayList<String>();
		/*
		 * wine.add("The Conjuring"); wine.add("Despicable Me 2");
		 * wine.add("Turbo"); wine.add("Grown Ups 2"); wine.add("Red 2");
		 * wine.add("The Wolverine");
		 */

		List<String> shots = new ArrayList<String>();
		/*
		 * shots.add("2 Guns"); shots.add("The Smurfs 2"); shots.add(
		 * "The Spectacular Now"); shots.add("The Canyons"); shots.add(
		 * "Europa Report");
		 */

		List<String> mixedDrinks = new ArrayList<String>();
		/*
		 * mixedDrinks.add("2 Guns"); mixedDrinks.add("The Smurfs 2");
		 * mixedDrinks.add("The Spectacular Now"); mixedDrinks.add("The Canyons"
		 * ); mixedDrinks.add("Europa Report");
		 */

		List<String> otherDrinks = new ArrayList<String>();
		/*
		 * otherDrinks.add("2 Guns"); otherDrinks.add("The Smurfs 2");
		 * otherDrinks.add("The Spectacular Now"); otherDrinks.add("The Canyons"
		 * ); otherDrinks.add("Europa Report");
		 */

		listDataChild.put(listDataHeader.get(0), beer); // Header, Child data
		listDataChild.put(listDataHeader.get(1), wine);
		listDataChild.put(listDataHeader.get(2), shots);
		listDataChild.put(listDataHeader.get(3), mixedDrinks);
		listDataChild.put(listDataHeader.get(4), otherDrinks);
	}
}
