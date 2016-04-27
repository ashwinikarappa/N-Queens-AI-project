package ai.star.csp;

import java.util.Arrays;


public class PuzzleBoard {
	int numberOfQueens;
	boolean safePlaces[][];
	int queenPlacement[];
	public PuzzleBoard(int n){
		numberOfQueens = n;
		safePlaces = new boolean[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(safePlaces[i], Boolean.TRUE);
		queenPlacement = new int[n];
		for(int i=0; i<numberOfQueens; i++)
			queenPlacement[i] = -1;
	}
	
	 public PuzzleBoard(PuzzleBoard c){
		numberOfQueens = c.numberOfQueens;
		safePlaces = new boolean[numberOfQueens][numberOfQueens];
		for(int i=0; i<numberOfQueens; i++)
			for(int j=0; j< numberOfQueens; j++)
			safePlaces[i][j] = c.safePlaces[i][j];
		queenPlacement = new int[numberOfQueens];
		for(int i=0; i<numberOfQueens; i++)
			queenPlacement[i] = c.queenPlacement[i];
	}
	
	
	
}
