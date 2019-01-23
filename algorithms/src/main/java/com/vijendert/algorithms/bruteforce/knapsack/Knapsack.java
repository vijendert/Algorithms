package com.vijendert.algorithms.bruteforce.knapsack;

public class Knapsack {

	private int[] weight = { 10, 7, 4, 3, 2, 1 };
	private int[] value = { 30, 30, 2, 8, 5, 9 };
	private int knapsackWeight = 10;

	public static void main(String[] args) {
		Knapsack k = new Knapsack();
		int maxResult = Integer.MIN_VALUE;
		/*for (int i = 0; i < k.weight.length; i++) {
			int result = k.solve(i, k.knapsackWeight, Integer.MIN_VALUE);
			if (result > maxResult) {
				maxResult = result;
			}
		}*/
		int result = k.solve(1, k.knapsackWeight, 0);
		System.out.println(result);
	}

	private int solve(int indx, int kw, int maxval) {
		if (indx == this.weight.length || kw < 0) {
			return maxval;
		}
		int val = maxval;
		int remainingWt = kw;
		for (int i = indx; i < this.weight.length; i++) {
			if (remainingWt - this.weight[i] > 0) {
				// consider the current weight
				val = val + this.value[i];
				remainingWt = remainingWt - this.weight[i];
				// System.out.println("Remainingweight " + remainingWt);
				maxval = solve(indx + 1, remainingWt, val);
				// System.out.println(maxval);
			} else if (remainingWt - this.weight[i] == 0) {
				val = val + this.value[i];
				maxval = val;
				// System.out.println(maxval);
			}
		}
		return maxval;
	}

}
