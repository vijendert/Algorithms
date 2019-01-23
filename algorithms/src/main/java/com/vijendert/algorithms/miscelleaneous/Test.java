package com.vijendert.algorithms.miscelleaneous;

public class Test {

	public static void main(String[] args) {

		// String s = "07:05:45PM";
		// System.out.println(timeConversion(s));

		int dividend = 78949;
		int divisor = 245;
		int quotient = dividend / divisor;
		int remainder = dividend % divisor;
		System.out.println("Quotient : " + quotient + " remainder : " + remainder);
	}

	static String timeConversion(String s) {
		/*
		 * Write your code here.
		 */
		String[] hhmmss;
		String amorpm = "";
		String hhmmssSubString = "";
		amorpm = s.substring(s.length() - 1 - 1, s.length());
		hhmmssSubString = s.substring(0, s.length() - 2);
		hhmmss = hhmmssSubString.split(":");
		System.out.println(amorpm);
		if (amorpm.equals("PM")) {
			System.out.println("Something happend");
			int hh = Integer.parseInt(hhmmss[0]);
			if (hhmmss[0].equals("12")) {
				return hhmmss[0] + ":" + hhmmss[1] + ":" + hhmmss[2];
			} else {
				hh = 12 + hh;
			}
			return hh + ":" + hhmmss[1] + ":" + hhmmss[2];
		} else {
			String hh = "";
			if (hhmmss[0].equals("12")) {
				hh = "00";
				return hh + ":" + hhmmss[1] + ":" + hhmmss[2];
			}
			return hhmmss[0] + ":" + hhmmss[1] + ":" + hhmmss[2];
		}

	}

}
