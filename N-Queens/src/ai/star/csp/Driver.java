package ai.star.csp;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	public static void main(String[] args){
		Driver d = new Driver();
		ForwardChecking f = new ForwardChecking();
		f.forwardCheck(4, true);
		
		System.out.println("Only one Solution");
		d.printNqueenSolutions(f.solutions);
		f = new ForwardChecking();
		f.forwardCheck(4, false);
		System.out.println("Below is the actual solution");
		d.printNqueenSolutions(f.solutions);
		
	}
	public void printNqueenSolutions(ArrayList<int[]> solutions){
		for(int i=0;i<solutions.size();i++){
			int[] solution = solutions.get(i);
			String sol = Arrays.toString(solution);
			System.out.println(sol.replace(" ", "").replace("[", "").replace("]", ""));
			System.out.println(Arrays.toString(solution));
		}
	}
}
