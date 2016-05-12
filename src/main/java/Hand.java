import java.util.Collections;
import java.util.List;


public class Hand {
	
	private List<Card> cards;
	private int [] kinds = new int[14];
	
	public Hand(List<Card> cards) {		
		this.cards = cards;
		order();
		howManyOfAKind();
	}
	
	public boolean isFlush() {
		for (int i=1; i<cards.size(); i++) {
			if (cards.get(0).suit() != cards.get(i).suit()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isStraight() {
		for (int i=0; i<cards.size()-1; i++) {
			if (cards.get(i+1).rank() != cards.get(i).rank()+1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isStraightFlush() {
		return isStraight() && isFlush();
	}
	
	private void howManyOfAKind() {
		for (Card card: cards) {
			kinds[card.rank] = kinds[card.rank] + 1;
		}
	}
	
	public boolean isFourOfAKind() {
		for (int i=0; i<kinds.length; i++) {
			if (kinds[i] == 4) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isThreeOfAKind() {
		for (int i=0; i<kinds.length; i++) {
			if (kinds[i] == 3) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isFullHouse() {
		boolean threeKindFound = false;
		boolean pairFound = false;
		for (int i=0; i<kinds.length; i++) {
			if (kinds[i] == 3) {
				threeKindFound = true;
			} else if (kinds[i] == 2) {
				pairFound = true;
			}
		}
		return threeKindFound && pairFound;
	}
	
	public boolean isTwoPair() {
		int pairCount = 0;
		for (int i=0; i<kinds.length; i++) {
			if (kinds[i] == 2) {
				pairCount++;
			}
		}
		return pairCount == 2;
	}
	
	public boolean isOnePair() {
		int pairCount = 0;
		for (int i=0; i<kinds.length; i++) {
			if (kinds[i] == 2) {
				pairCount++;
			}
		}
		return pairCount == 1;
	}
	
	private List<Card> order() {
		Collections.sort(cards);
		return cards;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<cards.size(); i++) {
			sb.append(cards.get(i)).append(" ");
		}
		return sb.toString();
	}

}
