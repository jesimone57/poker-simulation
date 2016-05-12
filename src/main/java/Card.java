import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {

	public Card(char suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	private char suit;
	private int rank;

	private static Map<Integer, String> faceMap = new HashMap();
	static {
		faceMap.put(1,  "A");  // Ace played as low
		faceMap.put(11, "J");  // Jack
		faceMap.put(12, "Q");  // Queen
		faceMap.put(13, "K");  // King
		faceMap.put(14, "A");  // Ace played as high
	}

	public char suit() {
		return suit;
	}

	public int rank() {
		return rank;
	}


	public boolean isAceRankLow() {
		return rank == 1;
	}

	public boolean isAceRankHigh() {
		return rank == 14;
	}

	public boolean isAce() {
		return isAceRankLow() || isAceRankHigh();
	}

	public void swapTheRankOfHowAceIsPlayed() {
		if (isAceRankLow()) {
			rank = 14;
		} else {
			rank = 1;
		}
	}

	@Override
	public String toString() {
		String face = String.valueOf(rank);
		if (faceMap.containsKey(rank)) {
			face = faceMap.get(rank);
		}
		return face + "-" + suit;
	}

	@Override
	public int compareTo(Card card) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		if (card.rank == rank)
			return EQUAL;
		if (card.rank < rank) {
			return AFTER;
		} else {
			return BEFORE;
		}
	}


}
