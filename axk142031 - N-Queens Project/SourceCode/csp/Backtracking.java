package ai.star.csp;

import java.util.ArrayList;

public class Backtracking {
	public int nodesComputed = 0;
	public int numberOfSolutions = 0;
	public ArrayList<int[]> solutions ;
	private int phase = 0;
	private long startTime, endTime, elapsedTime;

	public void timer()
	   {
	       if(phase == 0) {
		    startTime = System.currentTimeMillis();
		    phase = 1;
		} else {
		    endTime = System.currentTimeMillis();
	           elapsedTime = endTime-startTime;
	           System.out.println(":" + elapsedTime + " msec.");
	            phase = 0;
	       }
	   }
	public int getNodesComputed() {
		return nodesComputed;
	}

	public Backtracking() {
		nodesComputed = 0;
		numberOfSolutions = 0;
		solutions = new ArrayList<int[]>();
	}

	public void setNodesComputed(int nodesComputed) {
		this.nodesComputed = nodesComputed;
	}

	public int getNumberOfSolutions() {
		return numberOfSolutions;
	}

	public void setNumberOfSolutions(int numberOfSolutions) {
		this.numberOfSolutions = numberOfSolutions;
	}

	public ArrayList<int[]> getSolutions() {
		return solutions;
	}

	public void setSolutions(ArrayList<int[]> solutions) {
		this.solutions = solutions;
	}

	private static boolean checkIfSafePlaceForQueen(int columnIndex,
			int queenIndex, int[] board) {
		for (int i = 0; i < queenIndex; i++) {
			// Cannot place two queens in same column
			if (board[i] == columnIndex) {
				return false;
			}
			// Cannot place queens on diagonals of any other queens already
			// placed
			if (Math.abs(board[i] - columnIndex) == Math.abs(i - queenIndex)) {
				return false;
			}
		}
		return true;
	}

	public void backtrack(int n, boolean compare) {
		int[] board = new int[n];
//		solutions = new ArrayList<int[]>();
		placeQueen(0, board, compare);
		//System.out.println(Arrays.toString(solutions.get(0)));

	}

	public void placeQueen(int queenIndex, int[] placement, boolean compare) {
		int numberOfQueens = placement.length;

		if (queenIndex == numberOfQueens) {
			solutions.add(placement);
			numberOfSolutions++;
		} else {
			for (int column = 0; column < numberOfQueens; column++) {
				nodesComputed++;
				if (checkIfSafePlaceForQueen(column, queenIndex, placement)) {
					placement[queenIndex] = column;
					placeQueen(queenIndex + 1, placement, compare);
					if ((numberOfSolutions == 1) && compare)
						return;
					else
					{
						int[] newPlacement = new int[numberOfQueens];
						for(int i=0;i<numberOfQueens;i++){
							if(i==queenIndex)
								newPlacement[i] = -1;
							else
								newPlacement[i] = placement[i];
						}
						placement = newPlacement;
					}

				}
			}

		}

	}

	public static void main(String args[]) {
		Backtracking b = new Backtracking();
		b = new Backtracking();
		b.backtrack(4, false);
	}

}
