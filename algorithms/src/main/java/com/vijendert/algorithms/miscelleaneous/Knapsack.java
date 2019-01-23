package com.vijendert.algorithms.miscelleaneous;

public class Knapsack {
	private int[] values = { 1, 2, 3 };
	private int weight = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack k = new Knapsack();
		int answer = k.solve(k.weight, k.values, 0);
		System.out.println(answer);
	}

	public int solve(int M, int[] v, int index) {
		if (M == 0) {
			return 1;
		}

		if (M < 0)
			return 0;
		if (index == v.length) {
			return 0;
		}
		return solve(M - v[index], v, index) + solve(M, v, index + 1);
	}

}
