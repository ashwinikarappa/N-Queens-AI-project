package ai.star.csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;


public class ForwardCheckingWithMRV {
	public ArrayList<int[]> solutions = new ArrayList<int[]>();
	public int nodesComputed = 0;
	public void forwardCheckingWithMRV(int numberOfQueens, boolean compare){
		PuzzleBoard puzzleBoard = new PuzzleBoard(numberOfQueens);
		// Initially shuffle all the queens, since each has same MRV,
		// instead of going sequentially, go in randomized order
		int[] queenIndeces = new int[numberOfQueens];
		for(int i=0;i< numberOfQueens;i++)
			queenIndeces[i] = i;
		shuffleArray(queenIndeces); // random complete assignment
		
		// shuffled queens are added to priority queue based on MRV
		PriorityQueue<QueenMRV> queue =new PriorityQueue<QueenMRV>(numberOfQueens);// prioritize queens according to the number of conflicts
		for(int i=0;i<numberOfQueens;i++){
			queue.add(new QueenMRV(queenIndeces[i],numberOfQueens));
		}
		
		MRV(puzzleBoard,  queue);
		
	}
	public int getFirstSafePlace(PuzzleBoard c, int qi){
		for(int i=0;i<c.numberOfQueens; i++){
			if(c.safePlaces[qi][i])
				return i;
		}
		return -1;
	}
	
	public int MRV(PuzzleBoard puzzleBoard, PriorityQueue<QueenMRV> queenQueue) {
		int returnValue = 0;
		nodesComputed++;
		if(queenQueue.isEmpty())
		{
			System.out.println("Done placement");
			//System.out.println(Arrays.toString(puzzleBoard.queenPlacement));
			return 0;
		}
		if(queenQueue.peek().mininumRemainingValues == 0)
			return -1;
		QueenMRV currentQueen = queenQueue.poll();
		
		do{
			int safePlace = getFirstSafePlace(puzzleBoard, currentQueen.queenIndex);
			if(safePlace == -1){ // no remaining values
				queenQueue.add(currentQueen);
				return -1;
			}else{
				puzzleBoard.safePlaces[currentQueen.queenIndex][safePlace] = false;
				PuzzleBoard newPuzzleBoard = new PuzzleBoard(puzzleBoard);
				updateSafePlaces(newPuzzleBoard,currentQueen.queenIndex, safePlace);
				newPuzzleBoard.queenPlacement[currentQueen.queenIndex] = safePlace;
				System.out.println(Arrays.toString(newPuzzleBoard.queenPlacement));
				updateMRVs(newPuzzleBoard, queenQueue);
				if(!queenQueue.isEmpty()){
					returnValue = MRV (newPuzzleBoard, queenQueue);
					if(returnValue == -1)
					{
						currentQueen.mininumRemainingValues -= 1;
//						queenQueue.add(currentQueen);
					}
				}else{
					System.out.println("Done placement");
					System.out.println(Arrays.toString(newPuzzleBoard.queenPlacement));
					solutions.add(newPuzzleBoard.queenPlacement);
					return 0;
				}
			}
		}while(returnValue == -1);
		return 0;
	}
	
	public void updateMRVs(PuzzleBoard puzzleBoard, PriorityQueue<QueenMRV> queenQueue){
		QueenMRV q;
		ArrayList<QueenMRV> queue = new ArrayList<QueenMRV>();
		while((q = queenQueue.poll()) != null){
			int newMRV = computeMRV(q.queenIndex,puzzleBoard.safePlaces[q.queenIndex]);
			q.mininumRemainingValues = newMRV;
			queue.add(q);
		}
		for(int i=0; i<queue.size(); i++){
			queenQueue.add(queue.get(i));
		}
	}
	
	public int computeMRV(int queenIndex, boolean[] safePlaces){
		int MRV = 0;
		for(int i=0; i<safePlaces.length;i++){
			if(safePlaces[i])
				MRV++;
		}
		return MRV;
	}
	public void updateSafePlaces(PuzzleBoard c, int queen, int placedIndex){
		int row = queen + 1;
		int column = placedIndex + 1;
		
		// updating all rows
		for(int i=0;i< c.numberOfQueens;i++){
				c.safePlaces[i][placedIndex] = false;
		}
		
		// updating all column
		for(int i=0;i< c.numberOfQueens;i++){
				c.safePlaces[queen][i] = false;
		}
		
		// updating rightDownside diagonal elements
		row = queen + 1;
		while((row < c.numberOfQueens) && (column < c.numberOfQueens)){
			c.safePlaces[row][column] = false;
			row += 1;
			column += 1;
		}
		// updating leftDownside diagonal elements
		row = queen + 1;
		column = placedIndex - 1;
		while((row < c.numberOfQueens) && (column >= 0 )){
			c.safePlaces[row][column] = false;
			row += 1;
			column -= 1;
		}
		
		// updating rightUpside diagonal elements
		row = queen - 1;
		column = placedIndex + 1;
		while((row >=0 ) && (column < c.numberOfQueens)){
			c.safePlaces[row][column] = false;
			row -= 1;
			column += 1;
		}
		// updating leftUpside diagonal elements
		row = queen - 1;
		column = placedIndex - 1;
		while((row >= 0) && (column >= 0 )){
			c.safePlaces[row][column] = false;
			row -= 1;
			column -= 1;
		}
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
		/*queenPlacement = {1,2,0,3};
		queenPlacement[0] = 1;
		queenPlacement[1] = 2;
		queenPlacement[2] = 0;
		queenPlacement[3] = 3;*/
		
	  }
	
	public void MRV(){
		
	}

	public static void main(String[] args) {
		ForwardCheckingWithMRV fMRV = new ForwardCheckingWithMRV();
		fMRV.forwardCheckingWithMRV(4, true);
		
	}
}
