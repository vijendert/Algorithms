package com.vijendert.algorithms.bruteforce.knapsack;

import java.util.HashMap;
import java.util.Map;

public class KnapsackBinary {

	private int[] weight = { 4, 2, 3, 1 };
	private int[] value = { 10, 4, 7, 5 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnapsackBinary ksb = new KnapsackBinary();
		ksb.findSubSets(ksb.weight);
	}

	public void findSubSets(int[] set) {
		int n = set.length;
		int maxVal = Integer.MIN_VALUE;
		Map<String, Integer> hm = new HashMap<String, Integer>();
		// Run a loop for printing all 2^n
		// subsets one by obe
		String setStart = "{";
		String setEnd = "}";
		String keyVal = "";
		for (int i = 0; i < (1 << n); i++) {
			// System.out.print("{ ");
			int sum = 0;
			int val = 0;
			String subset = "";
			// Print current subset
			for (int j = 0; j < n; j++) {
				// (1<<j) is a number with jth bit 1
				// so when we 'and' them with the
				// subset number we get which numbers
				// are present in the subset and which
				// are not
				if ((i & (1 << j)) > 0) {
					sum = sum + set[j];
					val = val + value[j];
					subset = subset + set[j] + ",";
				}
			}
			if (sum <= 5 && subset != "") {
				subset = subset.substring(0, subset.length() - 1);
				hm.put(subset, val);
			}
		}
		for (String val : hm.keySet()) {
			if (maxVal < hm.get(val)) {
				maxVal = hm.get(val);
				keyVal = val;
			}
		}
		System.out.println("Max Sum is " + maxVal + " from set " + keyVal);

	}

}
