package com.example.sixth;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class testing {

	/*public List<String> getAnthonysBeerDrinkLabels() {
		List<String> allBeerDrinkLabels = new ArrayList<String>();
		// Select All Query
		String sqlBeerquery = "SELECT * FROM ANTHONYS WHERE DRINKTYPE='Beer';";
		SQLiteDatabase bdb = this.getReadableDatabase();
		Cursor beerCursor = bdb.rawQuery(sqlBeerquery, null);

		// looping through all rows and adding to list
		if (beerCursor.moveToFirst()) {
			do {
				allBeerDrinkLabels.add(beerCursor.getString(1) + ", " + beerCursor.getString(2));
			} while (beerCursor.moveToNext());
		}

		// closing connection
		beerCursor.close();
		bdb.close();		

		// returning labels
		return allBeerDrinkLabels;

	} // will returns all labels stored in database

	public List<String> getAnthonysWineDrinkLabels() {
		List<String> allWineDrinkLabels = new ArrayList<String>();
		String sqlWinequery = "SELECT * FROM ANTHONYS WHERE DRINKTYPE='Wine';";
		SQLiteDatabase wdb = this.getReadableDatabase();
		Cursor wineCursor = wdb.rawQuery(sqlWinequery, null);

		// looping through all rows and adding to list
		if (wineCursor.moveToFirst()) {
			do {
				allWineDrinkLabels.add(wineCursor.getString(1) + ", " + wineCursor.getString(2));
			} while (wineCursor.moveToNext());
		}

		// closing connection
		wineCursor.close();
		wdb.close();
		return allWineDrinkLabels;
	}

	public List<String> getAnthonysShotsDrinkLabels() {
		List<String> allShotsDrinkLabels = new ArrayList<String>();
		String sqlShotsquery = "SELECT * FROM ANTHONYS WHERE DRINKTYPE='Shot';";
		SQLiteDatabase sdb = this.getReadableDatabase();
		Cursor shotCursor = sdb.rawQuery(sqlShotsquery, null);

		// looping through all rows and adding to list
		if (shotCursor.moveToFirst()) {
			do {
				allShotsDrinkLabels.add(shotCursor.getString(1) + ", " + shotCursor.getString(2));
			} while (shotCursor.moveToNext());
		}

		// closing connection
		shotCursor.close();
		sdb.close();
		return allShotsDrinkLabels;
	}

	public List<String> getAnthonysMDDrinkLabels() {
		List<String> allMDDrinkLabels = new ArrayList<String>();
		String sqlMDquery = "SELECT * FROM ANTHONYS WHERE DRINKTYPE='Mixed Drink';";
		SQLiteDatabase mddb = this.getReadableDatabase();
		Cursor mDCursor = mddb.rawQuery(sqlMDquery, null);

		// looping through all rows and adding to list
		if (mDCursor.moveToFirst()) {
			do {
				allMDDrinkLabels.add(mDCursor.getString(1) + ", " + mDCursor.getString(2));
			} while (mDCursor.moveToNext());
		}

		// closing connection
		mDCursor.close();
		mddb.close();
		return allMDDrinkLabels;
	}

	public List<String> getAnthonysOtherDrinkLabels() {
		List<String> allOtherDrinkLabels = new ArrayList<String>();
		String sqlOtherquery = "SELECT * FROM ANTHONYS WHERE DRINKTYPE='Other';";
		SQLiteDatabase odb = this.getReadableDatabase();
		Cursor otherCursor = odb.rawQuery(sqlOtherquery, null);

		// looping through all rows and adding to list
		if (otherCursor.moveToFirst()) {
			do {
				allOtherDrinkLabels.add(otherCursor.getString(1) + ", " + otherCursor.getString(2));
			} while (otherCursor.moveToNext());
		}

		// closing connection
		otherCursor.close();
		odb.close();
		return allOtherDrinkLabels;
	}*/
}
