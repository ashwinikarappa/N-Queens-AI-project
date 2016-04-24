package ai.star.enums;

public enum Algorithm {
	BACKTRACKING("BACKTRACK"), FORWARD_CHECKING("FORWARD CHECK"), MINIMUM_CONFLICTS("MINIMUM CONFLICTS"), MRV(
			"MRV"), COMPARE("COMPARE ALL");

	private final String type;

	private Algorithm(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
