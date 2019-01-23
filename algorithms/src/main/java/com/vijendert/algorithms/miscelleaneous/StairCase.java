package com.vijendert.algorithms.miscelleaneous;

public class StairCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StairCase sc = new StairCase();
		sc.printStairCaseRight(6);
		sc.printStairCaseUpsideDown(6);
	}

	public void printStairCaseRight(int n) {
		int[][] arr = new int[n][n];
		int j = arr.length;
		for (int i = 0; i < arr.length; i++) {
			j--;
			for (int k = j; k < arr.length; k++) {
				arr[i][k] = 1;
			}

		}
		printArray(arr);
	}

	public void printStairCaseUpsideDown(int n) {
		int[][] arr = new int[n][n];
		int j = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			for (int k = j; k >= 0; k--) {
				arr[i][k] = 1;
			}
			j--;
		}
		printArray(arr);
	}

	private void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
