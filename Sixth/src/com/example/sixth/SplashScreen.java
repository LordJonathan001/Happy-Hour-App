package com.example.sixth;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;

 
public class SplashScreen extends Activity{
	MediaPlayer player;
	static String strDate,featureBar;
 
    // Splash screen timer  extends ActiveLocationManagerActivity 
    private static int SPLASH_TIME_OUT = 5500;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Calendar c = Calendar.getInstance();
       
        SimpleDateFormat sdf = new SimpleDateFormat("EEE");
        strDate = sdf.format(c.getTime());
       
        System.out.println(strDate);
        
        
        featureSetter();
        player = new MediaPlayer();
        player = MediaPlayer.create(getBaseContext(), R.raw.glug); /*Gets soundfile from res/raw/glug.mp3 */
        player.start(); //Starts your sound
        
        
 
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                releaseResources();
                // close this activity
                finish();
            }
            
        }, SPLASH_TIME_OUT);
    }
    public void releaseResources()
    {
        player.release();
    }
    
    private void featureSetter(){
    	strDate = strDate.toLowerCase(Locale.US);
		
		if (strDate.equals("mon")) {
			featureBar = "maleys";
		} else if (strDate.equals("tue")) {
			featureBar = "oaks";
		} else if (strDate.equals("wed")) {
			featureBar = "capn";
		} else if (strDate.equals("thu")) {
			featureBar = "central";
		} else if (strDate.equals("fri")) {
			featureBar = "changos";
		} else if (strDate.equals("sat")) {
			featureBar = "mchales";
		} else {
			featureBar = "erwinna";
		}
		
	}
 
}
