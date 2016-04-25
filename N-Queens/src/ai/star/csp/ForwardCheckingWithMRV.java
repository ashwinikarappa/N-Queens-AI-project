package ai.star.csp;

import java.util.ArrayList;


public class ForwardCheckingWithMRV {
	public ArrayList<int[]> solutions = new ArrayList<int[]>();
	public int nodesComputed = 0;
	public void forwardCheckMRV(int numberOfQueens, boolean compare){
		PuzzleBoard puzzleBoard = new PuzzleBoard(numberOfQueens);
		forwardCheckingWithMRV(numberOfQueens, 0, puzzleBoard, compare);
		
	}
	public int forwardCheckingWithMRV(int numberOfQueens, int currentqueenIndex, PuzzleBoard puzzleBoard, boolean compare){
		int returnValue = 0;
		return returnValue;
	}
}
