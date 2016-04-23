package ai.star.csp;

import java.util.ArrayList;


public class ForwardChecking {
	public ArrayList<int[]> solutions = new ArrayList<int[]>();
	public int nodesComputed = 0;
	public void forwardCheck(int numberOfQueens, boolean compare){
		NqueenPuzzleSolver puzzleBoard = new NqueenPuzzleSolver(numberOfQueens);
		forwardChecking(numberOfQueens, 0, puzzleBoard, compare);
		
	}
	public int getFirstSafePlace(NqueenPuzzleSolver c, int qi){
		for(int i=0;i<c.numberOfQueens; i++){
			if(c.safePlaces[qi][i])
				return i;
		}
		return -1;
	}
	
	public void updateSafePlaces(NqueenPuzzleSolver c, int queen, int placedIndex){
		int row = queen + 1;
		int column = placedIndex + 1;
		
		// updating all row 
		while( row < c.numberOfQueens){
			c.safePlaces[row][placedIndex] = false;
			row+=1;
		}
		// updating right diagonal elements
		row = queen + 1;
		while((row < c.numberOfQueens) && (column < c.numberOfQueens)){
			c.safePlaces[row][column] = false;
			row += 1;
			column += 1;
		}
		// updating left diagonal elements
		row = queen + 1;
		column = placedIndex - 1;
		while((row < c.numberOfQueens) && (column >= 0 )){
			c.safePlaces[row][column] = false;
			row += 1;
			column -= 1;
		}
	}
	public int forwardChecking(int n, int qi,NqueenPuzzleSolver c, boolean compare){
		int returnValue = 0;
		nodesComputed++;
		NqueenPuzzleSolver newChessBoard;
			if(qi<n){
				do{
					newChessBoard = new NqueenPuzzleSolver(c);
					int safePlace = getFirstSafePlace(c,qi);
					if(safePlace == -1){
						return -1;
					}else{
						
						newChessBoard.queenPlacement[qi] = safePlace;
						updateSafePlaces(newChessBoard,qi,safePlace);
						
						returnValue = forwardChecking(n, qi + 1,newChessBoard, compare);
						
					}
				c.safePlaces[qi][safePlace] = false;
				
				}while(returnValue == -1);
			}
			if(qi==n){
				
				solutions.add(c.queenPlacement);
				System.out.println(nodesComputed);
				if(!compare){
					qi--;
					return -1;
				}
			}

			
			return 0;
	}
}
