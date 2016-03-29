package cl.telematica.locationexample;

import cl.telematica.locationexample.location.ActiveLocationManagerActivity;
import java.util.*;
import java.lang.*;
import java.io.*;
public class SingleItem extends ActiveLocationManagerActivity {
 
	//to calculate the distance between two GPS points
	public static String convertLat1 = MainActivity.yourLat;//converting location of user to double
	public static String convertLong1 = MainActivity.yourLong;
	public static String convertLat2 = MainActivity.yourLat;//converting location of item to double
	public static String convertLong2 = MainActivity.yourLong;
		
	
		private static double distance() {
			
			double lat1 = Double.parseDouble(convertLat1);//location of user
			double lon1 = Double.parseDouble(convertLong1);
			double lat2 = Double.parseDouble(convertLat2);//location of item
			double lon2 = Double.parseDouble(convertLong2);
			double theta = lon1 - lon2;
			double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
			dist = Math.acos(dist);
			dist = rad2deg(dist);
			dist = dist * 60 * 1.1515;
			

			return (dist);
		}

		/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		/*::	This function converts decimal degrees to radians						 
		/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		private static double deg2rad(double deg) {
			return (deg * Math.PI / 180.0);
		}

		/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		/*::	This function converts radians to decimal degrees						 
		/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		private static double rad2deg(double rad) {
			return (rad * 180 / Math.PI);
		}
	}


 
 

