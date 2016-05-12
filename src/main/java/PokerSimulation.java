
public class PokerSimulation {
	
	
	public static void main(String []args) {
		Deck deck = new Deck();
		System.out.println("A newly opened deck:\n"+deck);
		
		deck.shuffle();
		System.out.println("Let's shuffle the deck:\n"+deck);
		
		Hand hand = new Hand(deck.dealHand(5));
		System.out.println("A 5 card hand dealt from the top of the deck:\n"+hand);
		System.out.println("What remains in deck:\n"+deck);
		System.out.println("Number of cards left in deck:\n"+deck.cards.size());
		
		int HANDS = 10000;
		int flushCount = 0;
		int straightCount = 0;
		int straightFlushCount = 0;
		int fourOfAKindCount = 0;
		int threeOfAKindCount = 0;
		int fullHouseCount = 0;
		int twoPairCount = 0;
		int onePairCount = 0;
		
		for (int i=0; i<HANDS; i++) {
			deck = new Deck();	
			deck.shuffle();
			hand = new Hand(deck.dealHand(5));
			
			if (hand.isFlush()) {
				//System.out.println("FLUSH           "+hand);
				flushCount++;
			}
			if (hand.isStraight()) {
				//System.out.println("STRAIGHT        "+hand);
				straightCount++;
			}	
			if (hand.isStraightFlush()) {
				//System.out.println("STRAIGHT-FLUSH  "+hand);
				straightFlushCount++;
			}
			if (hand.isFourOfAKind()) {
				//System.out.println("FOUR-OF-A-KIND  "+hand);
				fourOfAKindCount++;	
			}
			if (hand.isThreeOfAKind()) {
				//System.out.println("THREE-OF-A-KIND "+hand);
				threeOfAKindCount++;	
			}
			if (hand.isFullHouse()) {
				//System.out.println("FULL HOUSE      "+hand);
				fullHouseCount++;	
			}
			if (hand.isTwoPair()) {
				//System.out.println("TWO PAIR        "+hand);
				twoPairCount++;	
			}
			if (hand.isOnePair()) {
				//System.out.println("ONE PAIR        "+hand);
				onePairCount++;	
			}
		}
		
		System.out.println("Flushes:     "+flushCount+" of  "+HANDS+", "+100*((float)flushCount)/((float)HANDS)+"%");
		System.out.println("Straights:   "+straightCount+" of  "+HANDS+", "+100*((float)straightCount)/((float)HANDS)+"%");
		System.out.println("Three Of A Kind:     "+threeOfAKindCount+" of  "+HANDS+", "+100*((float)threeOfAKindCount)/((float)HANDS)+"%");
		System.out.println("Four Of A Kind:     "+fourOfAKindCount+" of  "+HANDS+", "+100*((float)fourOfAKindCount)/((float)HANDS)+"%");
		System.out.println("Full House:     "+fullHouseCount+" of  "+HANDS+", "+100*((float)fullHouseCount)/((float)HANDS)+"%");
		System.out.println("Straight Flush:   "+straightFlushCount+" of  "+HANDS+", "+100*((float)straightFlushCount)/((float)HANDS)+"%");
		System.out.println("Two Pair:   "+twoPairCount+" of  "+HANDS+", "+100*((float)twoPairCount)/((float)HANDS)+"%");
		System.out.println("One Pair:   "+onePairCount+" of  "+HANDS+", "+100*((float)onePairCount)/((float)HANDS)+"%");
		
		System.out.println("\nA full description is available here:  http://en.wikipedia.org/wiki/List_of_poker_hands");
	}

}
