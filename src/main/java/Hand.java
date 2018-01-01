import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;


public class Hand {

	private List<Card> cards;
	private int[] kinds = new int[14];

	public List<Card> getCards() {
		return this.cards;
	}

	public Hand(List<Card> cards) {
		this.cards = cards;
		order();
		howManyOfAKind();
	}

	public boolean hasAces() {
		return cards.stream().anyMatch(card -> card.isAce());
	}

	/**
	 * All cards have the same suit (as the first card)
	 */
	public boolean isFlush() {
		return cards.stream().allMatch(card -> card.suit() == cards.get(0).suit());
	}

	public boolean isStraight() {
		for (int i = 0; i < cards.size() - 1; i++) {
			if (cards.get(i + 1).rank() != cards.get(i).rank() + 1) {
				return false;
			}
		}
		return true;
	}

	public boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	private void howManyOfAKind() {
		for (Card card : cards) {
			kinds[card.rank()] = kinds[card.rank()] + 1;
		}
	}

	private boolean isOfAKind(int n) {
		for (int i = 0; i < kinds.length; i++) {
			if (kinds[i] == n) {
				return true;
			}
		}
		return false;
	}

	private int pairCount() {
		int pairCount = 0;
		for (int i = 0; i < kinds.length; i++) {
			if (kinds[i] == 2) {
				pairCount++;
			}
		}
		return pairCount;
	}

	public boolean isFourOfAKind() {
		return isOfAKind(4);
	}

	public boolean isThreeOfAKind() {
		return isOfAKind(3);
	}

	public boolean isFullHouse() {
		return isOfAKind(3) && pairCount() == 1;
	}

	public boolean isTwoPair() {
		return pairCount() == 2;
	}

	public boolean isOnePair() {
		return pairCount() == 1;
	}

	public void order() {
		Collections.sort(cards);
	}

	@Override
	public String toString() {
		return cards.stream().map(Card::toString).collect(joining(" "));
	}

}
