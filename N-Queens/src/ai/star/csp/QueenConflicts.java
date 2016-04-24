package ai.star.csp;

public class QueenConflicts implements Comparable{
	int queenIndex;
	int numberOfConflicts;
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
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		QueenConflicts obj2 = (QueenConflicts) obj;
		if(numberOfConflicts < obj2.numberOfConflicts)
			return -1;
		else if(numberOfConflicts > obj2.numberOfConflicts)
			return 1;
		return 0;
	}
	
}