package com.vijendert.algorithms.dp.eggsproblem;

public class EggProblemRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EggProblemRecursive epr = new EggProblemRecursive();
		int res = epr.solveEggProblem(2, 100);
		System.out.println(res);
	}

	public int solveEggProblem(int n, int k) {
		if (k == 1 || k == 0) {
			return k;
		}
		if (n == 1) {
			return k;
		}
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int x = 1; x <= k; x++) {
			res = Math.max(solveEggProblem(n - 1, x - 1), solveEggProblem(n, k - x));
			if (res < min) {
				min = res;
			}
		}
		return 1 + min;
	}

}
