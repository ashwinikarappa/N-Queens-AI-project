package ai.star.enums;

public enum Algorithm {
	BACKTRACKING("BACKTRACK"), FORWARD_CHECKING("FORWARD CHECK"), MINIMUM_CONFLICTS("MINIMUM CONFLICTS"), FORWARD_MRV(
			"Forward checking with MRV"), COMPARE_NUMBER_OF_NODES_COMPUTED("COMPARE ALL FOR NUMBER OF NODES COMPUTED"), COMPARE_TIME_REQUIRED("COMPARE ALL TIME REQUIRED") ;

	private final String type;

	private Algorithm(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
