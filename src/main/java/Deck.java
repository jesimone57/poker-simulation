import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

	List<Card> cards = new ArrayList<Card>();
	char[] suits = {'H', 'C', 'D', 'S'}; // hearts, clubs, diamonds, spades

	public Deck() {
		init();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public List<Card> dealHand(int n) {
		List<Card> hand = new ArrayList<Card>(n);
		for (int i = 0; i < n; i++) {
			hand.add(cards.get(0)); // top card
			cards.remove(0); // top card
		}
		return hand;
	}

	private void init() {
		for (int i = 0; i < suits.length; i++) {
			char suit = suits[i];

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

}
