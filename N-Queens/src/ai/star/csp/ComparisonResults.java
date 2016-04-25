package ai.star.csp;

import ai.star.enums.Algorithm;

public class ComparisonResults {
	Algorithm algorithmType;
	int numberOfQueens;
	int numberOFNodeComputed;
	public ComparisonResults() {
		// TODO Auto-generated constructor stub
		algorithmType = null;
		numberOFNodeComputed = 0;
		numberOfQueens = 0;
	}
	public ComparisonResults(Algorithm algoType, int numOfQueens, int nodecComputed) {
		algorithmType = algoType;
		numberOfQueens = numOfQueens;
		numberOFNodeComputed = nodecComputed;
	}
	public Algorithm getAlgorithmType() {
		return algorithmType;
	}
	public void setAlgorithmType(Algorithm algorithmType) {
		this.algorithmType = algorithmType;
	}
	public int getNumberOfQueens() {
		return numberOfQueens;
	}
	public void setNumberOfQueens(int numberOfQueens) {
		this.numberOfQueens = numberOfQueens;
	}
	public int getNumberOFNodeComputed() {
		return numberOFNodeComputed;
	}
	public void setNumberOFNodeComputed(int numberOFNodeComputed) {
		this.numberOFNodeComputed = numberOFNodeComputed;
	}
	@Override
	public String toString() {
		return "ComparisonResults [algorithmType=" + algorithmType
				+ ", numberOfQueens=" + numberOfQueens
				+ ", numberOFNodeComputed=" + numberOFNodeComputed + "]";
	}
	
}
