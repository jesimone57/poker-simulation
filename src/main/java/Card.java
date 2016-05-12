
public class Card implements Comparable<Card> {
	
	public Card(char suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	char suit ;
	int rank ;

	public char suit() {
		return suit;
	}

	public int rank() {
		return rank;
	}
	
	@Override
	public String toString() {
		return rank + "-" + suit;
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
