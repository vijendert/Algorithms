package com.vijendert.rf.simplesort.bubblesort;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 10, 4, 3, 5, 1, 6 };
		BubbleSort bs = new BubbleSort(input);
		bs.bubbleSort();
		bs.display();
	}

	private int[] input;

	public BubbleSort(int[] input) {
		// TODO Auto-generated constructor stub
		this.input = input;
	}

	public void bubbleSort() {
		int out = input.length - 1;
		int in = 0;
		for (int i = out; i > 0; i--) {
			for (int j = in; j < i; j++) {
				int tmp = 0;
				if (input[j] > input[j + 1]) {
					tmp = input[j + 1];
					input[j + 1] = input[j];
					input[j] = tmp;
				}
			}
		}

	}

	public void display() {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

}
