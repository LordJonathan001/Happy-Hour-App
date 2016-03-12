package com.example.fourth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	
	public static final String DATABASE_NAME = "Bars.db";
	public static final String TABLE_NAME = "Bar_info";
	public static final String ID = "ID";
	public static final String BAR_NAME = "Bar_Name";
	public static final String BAR_CITY = "Bar_City";
	public static final String DRINK_NAME = "Drink_Name";
	//public static final String DRINK_PRICE = "Drink Price";
	//public static final String DRINK_TYPE = "Drink Type";
	

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+ BAR_NAME + "TEXT ,"
                + BAR_CITY+ "TEXT," + DRINK_NAME + "TEXT");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
		onCreate(db);
		
	}
	public boolean insertData(String bar_name, String bar_city, String drink_name){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues	= new ContentValues();
		contentValues.put(BAR_NAME,bar_name);
		contentValues.put(BAR_CITY ,bar_city);
		contentValues.put(DRINK_NAME,drink_name);
		long result = db.insert(TABLE_NAME, null, contentValues);

		if(result == -1)
			return false;
		else 
			return true;
		}
	public Cursor getAllData() {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor res  = db.rawQuery("select * from "+TABLE_NAME, null);
		return res;
	}
		
	}


