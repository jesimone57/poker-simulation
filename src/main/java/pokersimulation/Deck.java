package pokersimulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

	private List<Card> cards = new ArrayList<>();

	public Deck() {
		init();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public List<Card> dealHand(int n) {
		List<Card> hand = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			hand.add(cards.get(0)); // top card
			cards.remove(0); // top card
		}
		return hand;
	}

	private void init() {
		for (SuitType suit : SuitType.values()) {
			for (int rank = 1; rank < 14; rank++) {
				Card card = new Card(suit, rank);
				cards.add(card);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cards.size(); i++) {
			sb.append(cards.get(i)).append(" ");
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof Deck)) {
			return false;
		} else {
			Deck other = (Deck) obj;
			if (!this.cards.equals(other.cards)) {
				return false;
			} else {
				return true;
			}
		}
	}

}
