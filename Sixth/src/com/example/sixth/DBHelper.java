package com.example.sixth;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static String DB_PATH = "/data/data/com.example.sixth/databases/";
	private static String DB_NAME = "BarSample.db";	
	private final Context myContext;	
	public static String tableName = "BARS";
	public static String barTableName = MainActivity.firstPart;
	public static String drinkType;//Use this to pass in selected drink type to SQL query	
	public static final String KEY_ROWID = "_id";
	public static final String BARNAME = "Bar Name";
	public static final String BARCITY = "Bar City";
	private SQLiteDatabase myDataBase;
	
	
	public DBHelper(Context context) {

		super(context, DB_NAME, null, 1);
		this.myContext = context;
	}

	/**
	 * Creates a empty database on the system and rewrites it with your own
	 * database.
	 */
	public void createDataBase() throws IOException {

		boolean dbExist = checkDataBase();

		if (dbExist) {
			// do nothing - database already exist
		} else {

			// By calling this method and empty database will be created into
			// the default system path
			// of your application so we are gonna be able to overwrite that
			// database with our database.
			this.getReadableDatabase();

			try {
				this.close();
				copyDataBase();

			} catch (IOException e) {

				throw new Error("Error copying database");
			}
		}
	}

	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn't
	 */
	private boolean checkDataBase() {

		SQLiteDatabase checkDB = null;

		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {
			// database does't exist yet.
		}
		if (checkDB != null) {
			checkDB.close();
		}
		return checkDB != null ? true : false;
	}

	/**
	 * Copies your database from your local assets-folder to the just created
	 * empty database in the system folder, from where it can be accessed and
	 * handled. This is done by transfering bytestream.
	 */
	private void copyDataBase() throws IOException {

		// Open your local db as the input stream
		InputStream myInput = myContext.getAssets().open(DB_NAME);

		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();

	}

	public void openDataBase() throws SQLException {

		// Open the database
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

	}

	@Override
	public synchronized void close() {

		if (myDataBase != null)
			myDataBase.close();

		super.close();

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public List<String> getAllLabels(){
		List<String> labels = new ArrayList<String>();
        
        // Select All Query
        String selectQuery = "SELECT  * FROM " + tableName;
      
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
      
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	labels.add(cursor.getString(1) + " " + cursor.getString(2)+ ", " + cursor.getString(3));
            } while (cursor.moveToNext());
        }
         
        // closing connection
        cursor.close();
        db.close();
         
        // returning lables
        return labels;
		
	} // will returns all labels stored in database
	public List<String> getAllDrinkLabels(){
		List<String> allDrinkLabels = new ArrayList<String>();
        
        // Select All Query
        String sqlquery="SELECT * FROM "+barTableName + " WHERE DRINKTYPE='" + drinkType + "';";
		String selectQuery = "SELECT  * FROM " + barTableName;
      
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
      
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	allDrinkLabels.add(cursor.getString(1) + ", " + cursor.getString(2));
            } while (cursor.moveToNext());
        }
         
        // closing connection
        cursor.close();
        db.close();
         
        // returning lables
        return allDrinkLabels;
		
	} // will returns all labels stored in database
}
