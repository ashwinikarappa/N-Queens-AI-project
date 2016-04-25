package ai.star.csp;

public class QueenConflicts implements Comparable<QueenConflicts>{
	int queenIndex;
	int numberOfConflicts;
	int mininumRemainingValues;
	public QueenConflicts() {
		// TODO Auto-generated constructor stub
		queenIndex = 0;
		numberOfConflicts = 0;
	}
	public QueenConflicts(int qIndex, int conflicts) {
		queenIndex = qIndex;
		numberOfConflicts = conflicts;
	}
	@Override
	public int compareTo(QueenConflicts obj) {
		// TODO Auto-generated method stub
		
		if(numberOfConflicts < obj.numberOfConflicts)
			return -1;
		else if(numberOfConflicts > obj.numberOfConflicts)
			return 1;
		return 0;
	}
	
}
