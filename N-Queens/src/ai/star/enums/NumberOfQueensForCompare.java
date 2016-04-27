package ai.star.enums;

public enum NumberOfQueensForCompare {
	

	
		FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), ELEVEN(11), TWELVE(12), THIRTEEN(13),FOURTEEN(14), FIFTEEN(15)
		,TWENTY(20);
		private int n;

		private NumberOfQueensForCompare(int n) {
			this.n = n;
		}

		public int getN() {
			return n;
		}


}
