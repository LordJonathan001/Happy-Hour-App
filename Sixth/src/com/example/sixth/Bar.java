package com.example.sixth;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Bar extends Activity{
	String setBarTest = MainActivity.setBar;
	TextView t1;
	ImageView barPic;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bar);
		String r = "drawable/"+setBarTest;
		barPic = (ImageView) findViewById(R.id.barPic);
		//barPic.setImageResource(getImageId(this, setBarTest));
		
		int imageResource = getResources().getIdentifier(r, null, getPackageName());

		barPic.setImageResource(imageResource);
	}
	public static int getImageId(Context context, String imageName) {
	    return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
	}
}
