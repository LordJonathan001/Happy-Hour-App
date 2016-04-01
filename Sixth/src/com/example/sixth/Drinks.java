package com.example.sixth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;


public class Drinks extends Activity {
	// TextView drinkHolder;
	String barName;
	//static String barNameHolder = MainActivity.upperCaseName;
	String drinkTestHolder = "";
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	//List<String> beer;
	//List<String> beerLables = MainActivity.beerLables;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drinks);
				
		expListView = (ExpandableListView) findViewById(R.id.lvExp);
		 System.out.println("Works to create original List");
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
		 listDataHeader.add("Wine");
		 listDataHeader.add("Shots"); 
		 listDataHeader.add("Mixed Drinks");
		 listDataHeader.add("Other");
		 System.out.println("Works to create headers");
		 
		 DBHelper db = new DBHelper(getApplicationContext());
		 
		 List<String> beer = new ArrayList<String>();
		 List<String> beerLables = db.getBeerDrinkLabels();
		 for (int i = 0; i < beerLables.size(); i++) {
			    beer.add(beerLables.get(i));
			    System.out.println(beerLables.get(i));
			}
		List<String> wine = new ArrayList<String>();
		List<String> wineLables = db.getWineDrinkLabels();
		 for (int i = 0; i < wineLables.size(); i++) {
			    wine.add(wineLables.get(i));
			    System.out.println(wineLables.get(i));
		 }

		List<String> shots = new ArrayList<String>();
		List<String> shotsLables = db.getShotsDrinkLabels();
		 for (int i = 0; i < shotsLables.size(); i++) {
			    shots.add(shotsLables.get(i));
			    System.out.println(shotsLables.get(i));
		 }

		List<String> mixedDrinks = new ArrayList<String>();
		List<String> mDLables = db.getMDDrinkLabels();
		 for (int i = 0; i < mDLables.size(); i++) {
			 mixedDrinks.add(mDLables.get(i));
			    System.out.println(mDLables.get(i));
		 }

		List<String> otherDrinks = new ArrayList<String>();
		List<String> otherLables = db.getOtherDrinkLabels();
		 for (int i = 0; i < otherLables.size(); i++) {
			 otherDrinks.add(otherLables.get(i));
			    System.out.println(otherLables.get(i));
		 }

		listDataChild.put(listDataHeader.get(0), beer); // Header, Child data
		listDataChild.put(listDataHeader.get(1), wine);
		listDataChild.put(listDataHeader.get(2), shots);
		listDataChild.put(listDataHeader.get(3), mixedDrinks);
		listDataChild.put(listDataHeader.get(4), otherDrinks);
	}
}
