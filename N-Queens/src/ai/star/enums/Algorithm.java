package ai.star.enums;

public enum Algorithm {
	BACKTRACKING("backtracking"), FORWARD_CHECKING("forward checking"), MINIMUM_CONFLICTS("minimum conflicts"), MRV(
			"MRV"), COMPARE("compare all");

	private final String type;

	private Algorithm(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
