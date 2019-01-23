package com.vijendert.algorithms.dp.knapsack;

public class Knapsack {

	private int numOfItems;
	private int capacityOfKnapsack;
	private int[][] knapsackTable;
	private int totalBenefits;
	private int[] weights;
	private int[] values;

	public Knapsack(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
		// TODO Auto-generated constructor stub
		this.numOfItems = numOfItems;
		this.capacityOfKnapsack = capacityOfKnapsack;
		this.weights = weights;
		this.values = values;
		this.knapsackTable = new int[numOfItems + 1][capacityOfKnapsack + 1];

	}

	public void solve() {
		for (int i = 1; i < numOfItems + 1; i++) {
			for (int w = 1; w < capacityOfKnapsack + 1; w++) {
				int notTakingItem = knapsackTable[i - 1][w];
				int takingItem = 0;
				if (w <= weights[i]) {
					takingItem = values[i] + knapsackTable[i - 1][w - weights[i]];
				}
				knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
			}
		}
		totalBenefits = knapsackTable[numOfItems][capacityOfKnapsack];

	}

	public void showResults() {
		System.out.println("Total Benefits " + totalBenefits);
		for (int n = numOfItems, w = capacityOfKnapsack; n > 0; n--) {
			if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n - 1][w]) {
				System.out.println("We take item " + n);
				w = w - weights[n];
			}
		}
	}

	public static void main(String[] args) {

	}

}
