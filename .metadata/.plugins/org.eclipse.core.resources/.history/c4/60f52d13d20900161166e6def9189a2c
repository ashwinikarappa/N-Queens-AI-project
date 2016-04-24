package ai.star.csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class MinConflicts {
	private int nodesComputed = 0;
	private ArrayList<int[]> solutions = new ArrayList<int[]>();
	private ArrayList<Integer> randomNumbers = new ArrayList<Integer>(); 
//	private int[] conflicts;
	public boolean conflictsExist(int[] conflicts){
		for(int i=0;i<conflicts.length;i++){
			if(conflicts[i]!=0)
				return true;
		}
		return false;
	}
	public void minConflicts(int numberOfQueens){
		NqueenPuzzleSolver puzzleBoard = new NqueenPuzzleSolver(numberOfQueens);
		int[] conflicts = new int[numberOfQueens];
		for(int i=0;i< numberOfQueens;i++)
			puzzleBoard.queenPlacement[i] = i;
		shuffleArray(puzzleBoard.queenPlacement); // random complete assignment
		conflicts = computeConflicts(puzzleBoard);
		
		do{
			PriorityQueue<QueenConflicts> queue = new PriorityQueue<>(puzzleBoard.numberOfQueens, Collections.reverseOrder());
			if(conflictsExist(conflicts)){
				queue = prioritizeQueensBasedOnConflicts(queue,conflicts);
				QueenConflicts q = new QueenConflicts();
				boolean changedPlacementIndex = false;
				while( ((q = queue.poll()) != null) && (!changedPlacementIndex)) {
				   // System.out.println("Queen Index = "+ q.queenIndex + " Conflicts= "+ q.numberOfConflicts);
				    int[] newConflicts = computeNewPositionConflicts(q.queenIndex, puzzleBoard);
				    int newPlacementIndex = getNewPlacementIndex(conflicts[q.queenIndex],newConflicts);
				    if(changedPlacementIndex(newPlacementIndex,puzzleBoard.queenPlacement[q.queenIndex])){
				    	changedPlacementIndex = true;
				    	puzzleBoard.queenPlacement[q.queenIndex] = newPlacementIndex;
				    }
				}
				conflicts = computeConflicts(puzzleBoard);
				System.out.println(Arrays.toString(puzzleBoard.queenPlacement));
			}
		}while(conflictsExist(conflicts));
		System.out.println("\n\n Solution");
		System.out.println(Arrays.toString(puzzleBoard.queenPlacement));
	}
	boolean changedPlacementIndex(int oldIndex, int newIndex){
		if(oldIndex != newIndex)
			return true;
		return false;
	}	
	int getNewPlacementIndex(int oldNumberOfConflicts, int[] newConflicts){
		int newPlacementIndex = 0;
		int newChosenNumberOfconflicts =Integer.MAX_VALUE;
		for(int i=newConflicts.length -1; i>=0;i--){
			if((newConflicts[i]<= oldNumberOfConflicts) && (newConflicts[i] <= newChosenNumberOfconflicts) ){
				newPlacementIndex = i;
				newChosenNumberOfconflicts = newConflicts[i];
			}
		}
		return newPlacementIndex;
	}
	private PriorityQueue<QueenConflicts> prioritizeQueensBasedOnConflicts(PriorityQueue<QueenConflicts> queue, int[] conflicts){
		for(int i=0;i<conflicts.length;i++)
		{
			QueenConflicts q = new QueenConflicts(i, conflicts[i]);
			queue.add(q);
		}
		return queue;
	}
	private int[] computeConflicts(NqueenPuzzleSolver puzzleBoard){
		int[] conflicts = new int[puzzleBoard.numberOfQueens];
		for(int i=0;i< puzzleBoard.numberOfQueens;i++){
			conflicts[i] = computeNumberOfAttackingQueens(puzzleBoard.queenPlacement[i],i,puzzleBoard.queenPlacement);
		}
		return conflicts;
	}
	private int[] computeNewPositionConflicts(int queenIndex, NqueenPuzzleSolver puzzleBoard){
		int[] conflicts = new int[puzzleBoard.numberOfQueens];
		for(int i=0;i< conflicts.length;i++){
			conflicts[i] = computeNumberOfAttackingQueens(i,queenIndex,puzzleBoard.queenPlacement);
		}
		return conflicts;
	}
	private int computeNumberOfAttackingQueens(int columnIndex, int queenIndex,
			int[] board) {
		int conflicts = 0;
		for (int i = 0; i < board.length; i++) {
			// Cannot place two queens in same column
			if(i != queenIndex){
			if (board[i] == columnIndex) {
				conflicts++;
			}
			// Cannot place queens on diagonals of any other queens already placed
			else if (Math.abs(board[i] - columnIndex) == Math.abs(i - queenIndex)) {
				conflicts++;
			}
			}
		}
		return conflicts;
	}
	void shuffleArray(int[] queenPlacement)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = new Random();
	    for (int i = queenPlacement.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = queenPlacement[index];
	      queenPlacement[index] = queenPlacement[i];
	      queenPlacement[i] = a;
	    }
	  }
	public static void main(String[] args) {
		MinConflicts m = new MinConflicts();
		m.minConflicts(4);
	}
}
