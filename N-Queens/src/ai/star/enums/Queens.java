package ai.star.enums;

public enum Queens {
	FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), ELEVEN(11), TWELVE(12);

	private int n;

	private Queens(int n) {
		this.n = n;
	}

	public int getN() {
		return n;
	}
}
