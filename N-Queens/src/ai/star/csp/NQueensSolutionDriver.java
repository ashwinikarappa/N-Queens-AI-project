package ai.star.csp;
import java.util.ArrayList;
import java.util.Arrays;

import ai.star.enums.Algorithm;

public class NQueensSolutionDriver {
	public static void main(String[] args){
		/*NQueensSolutionDriver d = new NQueensSolutionDriver();
		ForwardChecking f = new ForwardChecking();
		f.forwardCheck(4, true);
		
		System.out.println("Only one Solution");
		d.printNqueenSolutions(f.solutions);
		f = new ForwardChecking();
		f.forwardCheck(4, false);
		System.out.println("Below is the actual solution");
		d.printNqueenSolutions(f.solutions);*/
	/*	
		ForwardCheckingWithMRV fM = new ForwardCheckingWithMRV();
		fM.forwardCheckMRV(4, true);
		System.out.println("***FW with MRV output ***");
		d.printNqueenSolutions(fM.solutions);*/
		NQueensSolutionDriver driver = new NQueensSolutionDriver();
		ArrayList<String> solutions = driver.computeNqueensSolution(4, Algorithm.FORWARD_MRV);
		driver.printNqueenSolutions(solutions);
		ArrayList<ComparisonResults> results = driver.compareNqueensSolutions(5);
		driver.printNqueensComparison(results);
	}
	public void printNqueenSolutions(ArrayList<String> solutions){
		for(int i=0;i<solutions.size();i++){
			System.out.println(solutions.get(i));
		}
	}
	
	public void printNqueensComparison(ArrayList<ComparisonResults> comparisonResults){
		for(int i=0;i<comparisonResults.size();i++){
			System.out.println(comparisonResults.get(i).toString());
		}
	}
	
	 public ArrayList<String> computeNqueensSolution(int numberOfQueens, Algorithm algorithm){
			ArrayList<String> result = new ArrayList<String>();
			ArrayList<int[]> intSolutions = new ArrayList<int[]>();
			switch (algorithm) {
				case BACKTRACKING:
					System.out.println("Backtracking initiated");
					Backtracking bT = new Backtracking();
					bT.backtrack(numberOfQueens, false);
					intSolutions = bT.solutions;
					break;
				case FORWARD_CHECKING:
					ForwardChecking fC = new ForwardChecking();
					fC.forwardCheck(numberOfQueens, false);
					intSolutions = fC.solutions;
					break;
				case MINIMUM_CONFLICTS:
					MinConflicts mC = new MinConflicts();
					mC.minConflicts(numberOfQueens);
					intSolutions = mC.solutions;
					break;
				// add here FW with MRV if completed
				case FORWARD_MRV:
					ForwardCheckingWithMRV fMRV = new ForwardCheckingWithMRV();
					fMRV.forwardCheckingWithMRV(numberOfQueens, false);
					intSolutions = fMRV.solutions;
					break;
				default:
					break;
			}	
			for(int i=0;i<intSolutions.size();i++){
				int[] solution = intSolutions.get(i);
				String sol = Arrays.toString(solution);
				String strSolution = sol.replace(" ", "").replace("[", "").replace("]", "");
				result.add(strSolution);
			}
				return result;
		 }
		 public ArrayList<ComparisonResults> compareNqueensSolutions(int numberOfQueens){
			 ComparisonResults comparisonResult;
			 ArrayList<ComparisonResults> results = new ArrayList<ComparisonResults>();
			 for(int i=4;i<=numberOfQueens;i++){
				
				 Backtracking bT = new Backtracking();
				 bT.backtrack(i, true);
				 comparisonResult = new ComparisonResults(Algorithm.BACKTRACKING, i, bT.nodesComputed);
				 results.add(comparisonResult);
				
				 ForwardChecking fC = new ForwardChecking();
				 fC.forwardCheck(i, true);
				 comparisonResult = new ComparisonResults(Algorithm.FORWARD_CHECKING, i, fC.nodesComputed);
				 results.add(comparisonResult);
				
				 MinConflicts mC = new MinConflicts();
				 mC.minConflicts(i);
				 comparisonResult = new ComparisonResults(Algorithm.MINIMUM_CONFLICTS, i, mC.nodesComputed);
				 results.add(comparisonResult);
				 
				 ForwardCheckingWithMRV fMRV = new ForwardCheckingWithMRV();
				 fMRV.forwardCheckingWithMRV(numberOfQueens, false);
				 comparisonResult = new ComparisonResults(Algorithm.FORWARD_MRV, i, fMRV.nodesComputed);
				 results.add(comparisonResult);
				
			 }
			 return results;
		 }
		 
}
