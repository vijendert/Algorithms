package com.vijendert.algorithms.backtracking.maze;

public class MazeSolution {

    private int[][] maze;
    private int[][] mazeSolution;
    private int mazeSize;

    public MazeSolution(int[][] maze) {
	this.maze = maze;
	this.mazeSolution = new int[maze.length][maze.length];
    }

    public static void main(String[] args) {
	// 0 means a block and 1 means its clear.
	int[][] maze = { { 1, 1, 1, 1, 1 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 }, { 1, 0, 1, 0, 1 },
		{ 0, 1, 1, 1, 1 } };
	MazeSolution ms = new MazeSolution(maze);
	ms.solve();
    }

    public void solve() {
	if (solveMaze(0, 0)) {
	    showMazeSoution();
	} else {
	    System.out.println("No solution");
	}
    }

    private void showMazeSoution() {
	for (int i = 0; i < mazeSolution.length; i++) {
	    for (int j = 0; j < mazeSolution.length; j++) {
		if (mazeSolution[i][j] == 1) {
		    System.out.print("S ");
		} else {
		    System.out.print("- ");
		}
	    }
	    System.out.println();
	}

    }

    /**Note in this method we have x and y which acts as the cordinates of the
     * axis. We consider x as rows so downwards we have x axis and moving along
     * columns we have y axis.
     * */

    private boolean solveMaze(int x, int y) {
	// we reach the solution
	if (x == maze.length - 1 && y == maze.length - 1) {
	    mazeSolution[x][y] = 1;
	    return true;
	}
	if (isValid(x, y)) {
	    // So after checking the position is valid we add to our solution matrix
	    mazeSolution[x][y] = 1;
	    // now we move further here downwards
	    if (solveMaze(x + 1, y)) {
		return true;
	    }
	    if (solveMaze(x, y + 1)) {
		return true;
	    }
	    // backtrack
	    mazeSolution[x][y] = 0;
	}
	return false;
    }

    private boolean isValid(int x, int y) {
	// TODO Auto-generated method stub
	if (x < 0 && x >= mazeSize)
	    return false;
	if (y < 0 && y >= mazeSize)
	    return false;
	if (maze[x][y] == 0)
	    return false;
	return true;
    }

}
