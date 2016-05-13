import java.util.HashMap;
import java.util.Map;

public class PokerSimulation {

	// statically initialize all the expected (theoretical) probabilities for each type of hand
	private static Map<HandType, Float> expectedProbabilities = new HashMap<>();
	static {
		// for reference see:  http://en.wikipedia.org/wiki/List_of_poker_hands
		long numberOfPossibleFiveCardHands = (52 * 51 * 50 * 49 * 48) / (5 * 4 * 3 * 2 * 1);
		expectedProbabilities.put(HandType.STRAIGHT_FLUSH,    40F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put(HandType.FLUSH,           5108F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put(HandType.STRAIGHT,       10200F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put(HandType.FOUR_OF_A_KIND,   624F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put(HandType.FULL_HOUSE,      3744F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put(HandType.THREE_OF_A_KIND,54912F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put(HandType.TWO_PAIR,      123552F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put(HandType.ONE_PAIR,     1098240F/numberOfPossibleFiveCardHands);
	}

	private static int HANDS = 100000;

	public static void main(String[] args) {

		// some examples of creating, shuffling and drawing a 5 card hand from a deck of cards
		Deck deck = new Deck();
		System.out.println("A newly opened deck:\n" + deck);
		System.out.println("\n");

		deck.shuffle();
		System.out.println("Let's shuffle the deck:\n" + deck);
		System.out.println("\n");

		Hand hand = new Hand(deck.dealHand(5));
		System.out.println("A 5 card hand dealt from the top of the deck (ordered low to high):\n" + hand);
		System.out.println("\n");
		System.out.println("What remains in deck:\n" + deck);
		System.out.println("\n");

		System.out.println("Number of cards left in deck:\n" + deck.cards.size());
		System.out.println("\n");


		// Begin the poker simulation and compute the results ...
		System.out.println("Start simulating "+HANDS+" random poker hands:");


		Map<HandType, Integer> handTypeCountMap = new HashMap<>();
		for (int i = 0; i < HANDS; i++) {

			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck.dealHand(5));  // deal a 5 card hand from the top of the deck

			if (i>100000 && i%100000 == 0) System.out.println("simulated "+i+" random poker hands ...");
			if (i>0 && i<100000 && i%10000 == 0) System.out.println("simulated "+i+" random poker hands ...");

			if (hand.isFourOfAKind()) {
				//System.out.println("FOUR-OF-A-KIND  "+hand);
				incrementHandTypeCount(HandType.FOUR_OF_A_KIND, handTypeCountMap);
			} else if (hand.isFullHouse()) {
				//System.out.println("FULL HOUSE      "+hand);
				incrementHandTypeCount(HandType.FULL_HOUSE, handTypeCountMap);
			} else if (hand.isThreeOfAKind()) {
				//System.out.println("THREE-OF-A-KIND "+hand);
				incrementHandTypeCount(HandType.THREE_OF_A_KIND, handTypeCountMap);
			} else if (hand.isTwoPair()) {
				//System.out.println("TWO PAIR        "+hand);
				incrementHandTypeCount(HandType.TWO_PAIR, handTypeCountMap);
			} else if (hand.isOnePair()) {
				//System.out.println("ONE PAIR        "+hand);
				incrementHandTypeCount(HandType.ONE_PAIR, handTypeCountMap);

			} else {

				//  First we want to see if Aces can play low in straights and straight-flushes
				if (hand.isStraightFlush()) {
					//System.out.println("STRAIGHT-FLUSH  "+hand);
					incrementHandTypeCount(HandType.STRAIGHT_FLUSH, handTypeCountMap);
				} else if (hand.isFlush()) {
					//System.out.println("FLUSH           "+hand);
					incrementHandTypeCount(HandType.FLUSH, handTypeCountMap);
				} else if (hand.isStraight()) {
					//System.out.println("STRAIGHT        "+hand);
					incrementHandTypeCount(HandType.STRAIGHT, handTypeCountMap);
				}

				//  Now we want to see if Aces can play high in straights and straight-flushes
				if (hand.hasAces()) {
					for (Card card: hand.getCards()) {
						if (card.isAce()) {
							card.swapTheRankOfHowAceIsPlayed();
						}
					}

					hand.order(); // reorder using the new rank of ace

					if (hand.isStraightFlush()) {
						//System.out.println("STRAIGHT-FLUSH  "+hand);
						incrementHandTypeCount(HandType.STRAIGHT_FLUSH, handTypeCountMap);
					} else if (hand.isStraight()) {
						//System.out.println("STRAIGHT        "+hand);
						incrementHandTypeCount(HandType.STRAIGHT, handTypeCountMap);
					}
				}
			}
		}

		System.out.println("simulated "+HANDS+" random poker hands");
		System.out.println("Done\n");

		printResultsToConsole(handTypeCountMap);

		System.out.println("\nA full description is available here:  http://en.wikipedia.org/wiki/List_of_poker_hands");
	}

	private static void printResultsToConsole(Map<HandType, Integer> handTypeCountMap) {
		System.out.println("Probabilities:\n");
		for (HandType handType:  HandType.values()) {
			String handTypeLabel = handType.getLabel();
			Integer handTypeCount = handTypeCountMap.get(handType);
			if (handTypeCount == null) {  // we never actually got any hands of this type
				handTypeCount = 0;
			}
			float actualProbability = ((float) handTypeCount) / (float) HANDS;
			float expectedProbability = expectedProbabilities.get(handType);
			float deviation = (actualProbability - expectedProbability)/expectedProbability;
			System.out.println("\t"+handTypeLabel+"\t\t:   " + handTypeCount + " of  " + HANDS + ":  actual= " + 100 * actualProbability + "%    " +
					"expected= " + 100 * expectedProbability+"%   deviation= "+ 100 * deviation+"%");
		}
	}

	private static void incrementHandTypeCount(HandType handType, Map<HandType, Integer> handTypeCountMap) {
		Integer count = handTypeCountMap.get(handType);
		if (count == null) {
			handTypeCountMap.put(handType, 1);
		} else {
			handTypeCountMap.put(handType, ++count);
		}
	}

}
