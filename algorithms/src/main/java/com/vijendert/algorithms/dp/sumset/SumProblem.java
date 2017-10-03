package com.vijendert.algorithms.dp.sumset;

public class SumProblem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumProblem sp = new SumProblem();
		int[] inputarray = { 5, 2, 3, 1 };
		sp.isSumAttainable(inputarray, 2);
	}

	public void isSumAttainable(int[] arrayOfNum, int requiredSum) {
		/**
		 * let us take an example of sum as 9 and input of {5,2,3,1} in general i can
		 * use anagram algorithm and generate all the pairs and check if they match the
		 * sum. but the above approach is O 2^n because I am taking all the subset of
		 * the given set of numbers so this is going to be 2^n. So in such cases we can
		 * use DP programming DP approach Let us create our grid first the column
		 * represent the sum to be attainable 0 1 .... 9 the rows represent the number
		 * we have in as the input as customery with dp we have an extra row which is 0
		 * They basically represent the base cases column 0 represent if sum of 0 is
		 * attainable Now this is our last result for eg if we have the 5,2 we are
		 * looking for sum as 7 and we are using 2 so we subtract this from 7-2 and get
		 * 5 now we need to check if sum 5 is attainable using 5 so we so 5-5 and get 0
		 * so 0 should always be true. Ok lets create the grid
		 */

		boolean[][] dpTable = new boolean[arrayOfNum.length + 1][requiredSum + 1];
		/*
		 * We consider two base cases here can we attain a sum without using a number ?
		 * of course not so we mark eveything in the first row as false
		 */
		for (int i = 0; i <= arrayOfNum.length; i++) {
			for (int j = 0; j <= requiredSum; j++) {
				dpTable[0][j] = false;
			}
		}
		/**
		 * Can we attain sum of 0 using any value of the array We can attain the sum of
		 * 0 by not including any value in the array Hence first column goes as true
		 */
		for (int i = 0; i <= arrayOfNum.length; i++) {
			for (int j = 0; j <= requiredSum; j++) {
				dpTable[i][0] = true;
			}
		}

		/**
		 * Now our base cases are set Here we check if the given sum is attainable by
		 * using the above value for eg if so we have the same solution. Because with
		 * every row we check if the sum is attainable by values till that row so our
		 * first case is sum 0 attainable by 5 yes by not including 5 is sum 1
		 * attainable using 5 ofcourse not. But we formulate it that id the above value
		 * is false then we check the above row with j-S[i-1] So we need to put a check
		 * also if j-S[i-1] > 0
		 */

		for (int i = 1; i <= arrayOfNum.length; i++) {
			for (int j = 1; j <= requiredSum; j++) {
				if (dpTable[i - 1][j] == false) {
					if (j - arrayOfNum[i - 1] >= 0) {
						dpTable[i][j] = dpTable[i - 1][j - arrayOfNum[i - 1]];
					}
				} else {
					dpTable[i][j] = dpTable[i - 1][j];
				}
			}
		}

		System.out.println("The sum of " + requiredSum + " is "
				+ ((dpTable[arrayOfNum.length][requiredSum]) ? "attainable" : "not attainable"));

		/**
		 * The above code can be easily understood considering an example of 7 so when I
		 * am in 3 row which represents that I am using value 2 so I check whether the
		 * sum was attainable using the previous value that is 5 and the result is false
		 * so now I nned to check So the sum of 7 I am at 2 so I need to see if 7-2 = 5
		 * can be attained using any previous value That is why I have the formulation
		 * of [i-1][j-currentvalue] so if that particular cell says true so defiantely
		 * the current value of i,j is true.
		 */

	}

}
