package star.objectoriented;

import java.util.ArrayList;


public class ForwardChecking {
	ArrayList<int[]> solutions = new ArrayList<int[]>();
	public static int nodesComputed = 0;
	public ArrayList<int[]> computeNqueensSolution(int numberOfQueens){
		
		NqueenPuzzleBoard puzzleBoard = new NqueenPuzzleBoard(numberOfQueens);
		forwardChecking(numberOfQueens, 0, puzzleBoard);
		return solutions;
	}
	public int getFirstSafePlace(NqueenPuzzleBoard c, int qi){
		for(int i=0;i<c.numberOfQueens; i++){
			if(c.safePlaces[qi][i])
				return i;
		}
		return -1;
	}
	
	public void updateSafePlaces(NqueenPuzzleBoard c, int queen, int placedIndex){
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
	public int forwardChecking(int n, int qi,NqueenPuzzleBoard c){
		int returnValue = 0;
		nodesComputed++;
		NqueenPuzzleBoard newChessBoard;
			if(qi<n){
				do{
					newChessBoard = new NqueenPuzzleBoard(c);
					int safePlace = getFirstSafePlace(c,qi);
					if(safePlace == -1){
						return -1;
					}else{
						
						newChessBoard.queenPlacement[qi] = safePlace;
						updateSafePlaces(newChessBoard,qi,safePlace);
						
						returnValue = forwardChecking(n, qi + 1,newChessBoard);
						
					}
				c.safePlaces[qi][safePlace] = false;
				
				}while(returnValue == -1);
			}
			if(qi==n){
				
				solutions.add(c.queenPlacement);
				System.out.println(nodesComputed);
				//qi--;
				//return -1;
			}

			
			return 0;
	}
}
