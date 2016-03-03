package mucis.util;

//Validator.java prompts and validates console input.
//Based on code from Murach's Java with a few changes.
//Ranges are inclusive. Changes by Phillips on 9/3/12.
//20131102 added getString(Scanner sc, String prompt, String regex)

import java.util.Scanner;

public class Validator {
	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read the first string on the line
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	public static String getLine(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine();
		return s;
	}

	public static String getLine(Scanner sc, String prompt, String regex) {
		boolean isValid = false;
		String s = "";
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextLine()) {
				s = sc.nextLine();
				if (s.matches(regex)) {
					isValid = true;
				} else {
					System.out.println("\nError! Invalid value. Try again.\n");
				}
			}
		}
		return s;
	}

	public static int getInt(Scanner sc, String prompt) {
		boolean isValid = false;
		int i = 0;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Must be greater than or equal to "
						+ min);
			else if (i > max)
				System.out.println("Error! Must be less than or equal to "
						+ max);
			else
				isValid = true;
		}
		return i;
	}

	public static double getDouble(Scanner sc, String prompt) {
		boolean isValid = false;
		double d = 0;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine();
		}
		return d;
	}

	public static double getDouble(Scanner sc, String prompt, double min,
			double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d < min)
				System.out.println("Error! Must be greater than or equal to "
						+ min);
			else if (d > max)
				System.out.println("Error! Must be less than or equal to "
						+ max);
			else
				isValid = true;
		}
		return d;
	}
}
