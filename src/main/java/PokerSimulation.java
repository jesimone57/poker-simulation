import java.util.HashMap;
import java.util.Map;

public class PokerSimulation {

	private static Map<String, Float> expectedProbabilities = new HashMap<>();
	static {
		// for reference see:  http://en.wikipedia.org/wiki/List_of_poker_hands
		long numberOfPossibleFiveCardHands = (52 * 51 * 50 * 49 * 48) / (5 * 4 * 3 * 2 * 1);
		expectedProbabilities.put("Straight Flush",    40F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put("Flush",           5108F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put("Straight",       10200F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put("Four of a Kind",   624F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put("Three of a Kind",54912F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put("Two Pair",      123552F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put("One Pair",     1098240F/numberOfPossibleFiveCardHands);
		expectedProbabilities.put("Full House",      3744F/numberOfPossibleFiveCardHands);
	}
	private static int HANDS = 100000;


	public static void main(String[] args) {
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

		int flushCount = 0;
		int straightCount = 0;
		int straightFlushCount = 0;
		int fourOfAKindCount = 0;
		int threeOfAKindCount = 0;
		int fullHouseCount = 0;
		int twoPairCount = 0;
		int onePairCount = 0;

		System.out.println("Start simulating "+HANDS+" random poker hands:\n");
		for (int i = 0; i < HANDS; i++) {
			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck.dealHand(5));

			if (i>0 && i%100000 == 0) System.out.println("simulated "+i+" random poker hands ...");

			//  First we want to see if Aces can play low in straignts and straignt-flushes
			if (hand.isStraightFlush()) {
				//System.out.println("STRAIGHT-FLUSH  "+hand);
				straightFlushCount++;
			} else if (hand.isFlush()) {
				//System.out.println("FLUSH           "+hand);
				flushCount++;
			} else if (hand.isStraight()) {
				//System.out.println("STRAIGHT        "+hand);
				straightCount++;
			} else {

				if (hand.isFourOfAKind()) {
					//System.out.println("FOUR-OF-A-KIND  "+hand);
					fourOfAKindCount++;
				} else if (hand.isFullHouse()) {
					//System.out.println("FULL HOUSE      "+hand);
					fullHouseCount++;
				} else if (hand.isThreeOfAKind()) {
					//System.out.println("THREE-OF-A-KIND "+hand);
					threeOfAKindCount++;
				} else if (hand.isTwoPair()) {
					//System.out.println("TWO PAIR        "+hand);
					twoPairCount++;
				} else if (hand.isOnePair()) {
					//System.out.println("ONE PAIR        "+hand);
					onePairCount++;
				}
			}

			//  Now we want to see if Aces can play high in straignts and straignt-flushes
			if (hand.hasAces()) {
				for (Card card: hand.getCards()) {
					if (card.isAce()) {
						card.swapTheRankOfHowAceIsPlayed();
					}
				}
				hand.order(); // reorder

				if (hand.isStraightFlush()) {
					//System.out.println("STRAIGHT-FLUSH  "+hand);
					straightFlushCount++;
				} else if (hand.isStraight()) {
					//System.out.println("STRAIGHT        "+hand);
					straightCount++;
				}
			}
		}
		System.out.println("simulated "+HANDS+" random poker hands ...");
		System.out.println("Done\n");

		System.out.println("Probabilities:\n");

		printResultsToConsole("Straight Flush", straightFlushCount);
		printResultsToConsole("Flush",          flushCount);
		printResultsToConsole("Straight",       straightCount);
		printResultsToConsole("Four of a Kind", fourOfAKindCount);
		printResultsToConsole("Three of a Kind",threeOfAKindCount);
		printResultsToConsole("Two Pair",       twoPairCount);
		printResultsToConsole("One Pair",       onePairCount);
		printResultsToConsole("Full House",     fullHouseCount);

		System.out.println("\nA full description is available here:  http://en.wikipedia.org/wiki/List_of_poker_hands");
	}

	public static void printResultsToConsole(String result, int resultCount) {
		float actualProbability = ((float) resultCount) / (float) HANDS;
		float expectedProbability = expectedProbabilities.get(result);
		float deviation = (actualProbability - expectedProbability)/expectedProbability;
		System.out.println("\t"+result+"\t\t:   " + resultCount + " of  " + HANDS + ":  actual=" + 100 * actualProbability + "%    " +
				"expected=" + 100 * expectedProbability+"%   deviation="+ 100 * deviation+"%");
	}

}
