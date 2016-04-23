package ai.star.csp;
// Backtracking with forward checking // No MRV 
public class ForwardChecking {
	public int forwardChecking(int n, int qi,ChessBoard c){
		int returnValue = 0;
		ChessBoard newChessBoard;
			if(qi<n){
				do{
					newChessBoard = new ChessBoard(c);
					int safePlace = newChessBoard.getFirstSafePlace(qi);
					if(safePlace == -1){
						return -1;
					}else{
						newChessBoard.queenPlacement[qi] = safePlace;
						newChessBoard.updateSafePlaces(qi,safePlace);
						returnValue = forwardChecking(n, qi + 1,newChessBoard);
					}
				c.safePlaces[qi][safePlace] = false;
				
				}while(returnValue == -1);
			}
			if(qi==n){
				System.out.println();
				for(int i=0;i< 5;i++){
				System.out.print(c.queenPlacement[i]);
				}
				System.out.println("\nSafe Places");
				for(int j=0;j<5;j++){
					for(int k=0;k<5;k++){
						System.out.print(c.safePlaces[j][k]+ " ");
					}
					System.out.println();
				}
				qi--;
				return -1;
			}
			return 0;
		
	}
	public static void main(String[] args){
		ForwardChecking f = new ForwardChecking();
		ChessBoard c = new ChessBoard(5);
		f.forwardChecking(5, 0, c);
	}
}