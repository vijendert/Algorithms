package com.vijendert.algorithms.bruteforce.knapsack;

public class KnapSackAnagram {

	private int[] weight = { 10, 7, 4, 3, 2, 1 };
	private int[] value = { 30, 30, 2, 8, 5, 9 };
	private int count;
	private int wsize;
	private int knapsackWeight = 10;

	public static void main(String[] args) {
		KnapSackAnagram k = new KnapSackAnagram();
		k.findAllSets(k.weight.length);
	}

	public KnapSackAnagram() {
		// TODO Auto-generated constructor stub
		this.wsize = this.weight.length;
	}

	public void findAllSets(int size) {
		if (size == 1) {
			return;
		}
		// Go through each array of the number
		for (int i = 0; i < size; i++) {
			findAllSets(size - 1);
			if (size == 2) {
				displayWord();
			}
			rotate(size);
		}
	}

	public void displayWord() {
		if (count < 99)
			System.out.print(" ");
		if (count < 9)
			System.out.print(" ");
		System.out.print(++count + " ");
		for (int j = 0; j < wsize; j++)
			System.out.print(weight[j] + ",");
		System.out.print("   ");
		System.out.flush();
		if (count % 6 == 0)
			System.out.println("");
	}

	public void rotate(int size) {
		int j;
		int position = this.weight.length - size;
		int temp = weight[position];
		for (j = position + 1; j < this.weight.length; j++) {
			weight[j - 1] = weight[j];
		}
		weight[j - 1] = temp;
	}
}
