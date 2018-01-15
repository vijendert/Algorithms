package com.vijendert.algorithms.backtracking.nqueens;

/**
 * 
 * @author vijender
 *This is a program which will tell that how many queens can 
 *be placed on the chess board safely means
 *that no queen should be in path of the other
 */
public class NQueen {

    private int numberOfQueens;
    private int[][] chessBoard;

    public NQueen(int numberOfQueens) {
	// TODO Auto-generated constructor stub
	this.numberOfQueens = numberOfQueens;
	this.chessBoard = new int[numberOfQueens][numberOfQueens];
    }

    public static void main(String[] args) {
	NQueen nQueen = new NQueen(4);
	nQueen.solve(0);
    }

    public void solve(int startingIndex) {
	if (nQueenSolution(startingIndex)) {
	    printSolution();
	} else {
	    System.out.println("There is no solution");
	}
    }

    private boolean nQueenSolution(int columnIndex) {
	if (columnIndex == numberOfQueens) {
	    return true;
	}
	for (int i = 0; i < numberOfQueens; i++) {
	    if (isSquareValid(i, columnIndex)) {
		chessBoard[i][columnIndex] = 1;

		if (nQueenSolution(columnIndex + 1)) {
		    return true;
		}
		// Here I am backtracking
		chessBoard[i][columnIndex] = 0;
	    }
	}
	return false;
    }

    private boolean isSquareValid(int rowIndex, int columnIndex) {
	// Here I need to check the row. It starts from 0 and end to the position
	// currently in context
	for (int i = 0; i < columnIndex; i++) {
	    if (chessBoard[rowIndex][i] == 1) {
		return false;
	    }
	}

	// Here we see the above diagnol till the current postion
	// No matter what be the case it will end when column is 0
	for (int i = rowIndex, j = columnIndex; i >= 0 && j >= 0; i--, j--) {
	    if (chessBoard[i][j] == 1) {
		return false;
	    }
	}

	// Now the lower diagnol. In this no matter what happens it will end up in the
	// last row
	for (int i = rowIndex, j = columnIndex; i < chessBoard.length && j >= 0; i++, j--) {
	    if (chessBoard[i][j] == 1) {
		return false;
	    }
	}
	return true;
    }

    private void printSolution() {
	for (int i = 0; i < chessBoard.length; i++) {
	    for (int j = 0; j < chessBoard.length; j++) {
		if (chessBoard[i][j] == 1) {
		    System.out.print(" * ");
		} else {
		    System.out.print(" - ");
		}
	    }
	    System.out.println("");
	}

    }

    // We start the application with n

}
