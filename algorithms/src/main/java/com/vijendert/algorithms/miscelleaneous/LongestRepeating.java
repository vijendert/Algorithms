package com.vijendert.algorithms.miscelleaneous;

public class LongestRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestRepeating lr = new LongestRepeating();
		String input = "abbbbbbaaa";
		char[] charInput = input.toCharArray();
		lr.findLongestRepeating(charInput);
	}

	public LongestRepeating() {
		// TODO Auto-generated constructor stub
	}

	public void findLongestRepeating(char[] word) {
		char[] l_word = word;
		int count = 1;
		int index_loc = 0;
		int answer_index_loc = 0;
		int answer = 0;
		for (int i = 0; i < l_word.length - 1; i++) {
			if (l_word[i] == l_word[i + 1]) {
				count = count + 1;
				if (i == 0) {
					index_loc = i;
				}
			} else if (l_word[i] != l_word[i + 1]) {
				if (answer <= count) {
					answer = count;
					answer_index_loc = index_loc;
				}
				index_loc = i + 1;
				count = 1;

			}
		}
		if (answer <= count) {
			answer = count;
			answer_index_loc = index_loc;
		}
		System.out.println(answer + " , " + answer_index_loc);
	}

}
