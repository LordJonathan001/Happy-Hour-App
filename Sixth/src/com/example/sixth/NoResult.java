package com.example.sixth;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NoResult extends Activity {
	ImageView randPic;
	String picHolder, picName, specialsHolder;
	TextView setHappyHourSpecials;
	String setSpecials = Bar.hhSpecialTest;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_no_results);

		Random rand = new Random();
		int n = rand.nextInt(3);

		if (n == 0) {
			picName = "pan";
		} else if (n == 1) {
			picName = "key";
		} else {
			picName = "cat";
		}
		System.out.println(n);
		if (setSpecials.equals("maleys")) {
			specialsHolder = setSpecials;
		} else if (setSpecials.equals("oaks")) {
			specialsHolder = setSpecials;
		} else if (setSpecials.equals("capn")) {
			specialsHolder = setSpecials;
		} else if (setSpecials.equals("central")) {
			specialsHolder = setSpecials;
		} else if (setSpecials.equals("changos")) {
			specialsHolder = setSpecials;
		} else if (setSpecials.equals("mchales")) {
			specialsHolder = setSpecials;
		} else if (setSpecials.equals("erwinna")) {
			specialsHolder = setSpecials;
		} else if (setSpecials.equals("beamhouse")) {
			specialsHolder = setSpecials;
		} else if (setSpecials.equals("captain")) {
			specialsHolder = setSpecials;
		}

		else {
			specialsHolder = "noResults";
			randPic = (ImageView) findViewById(R.id.randPic);
			picHolder = "drawable/" + picName;
			int imageInt = getResources().getIdentifier(picHolder, null, getPackageName());
			randPic.setImageResource(imageInt);
		}

		setHappyHourSpecials = (TextView) findViewById(R.id.taxiName);
		String hhsHolder = "@string/" + specialsHolder + "Specials";
		int textInt1 = getResources().getIdentifier(hhsHolder, null, getPackageName());
		setHappyHourSpecials.setText(textInt1);

	}
}
