package pokersimulation;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {

    public Card(SuitType suit, int rank) {
        if (suit == null) {
            throw new IllegalArgumentException("Suit is null");
        }
        if (rank < 1 || rank > 13) {
            throw new IllegalArgumentException(String.format("Rank %d is not a valid rank of 1 through 13", rank));
        }
        this.suit = suit;
        this.rank = rank;
    }

    private SuitType suit;
    private int rank;

    private static final Map<Integer, String> faceMap = new HashMap<>();

    static {
        faceMap.put(1, "A");  // Ace played as low.  example A-D 2-D 3-D 4-D 5-D
        faceMap.put(11, "J");  // Jack
        faceMap.put(12, "Q");  // Queen
        faceMap.put(13, "K");  // King
        faceMap.put(14, "A");  // Ace played as high.  example 10-D J-D Q-D K-D A-D
    }

    public SuitType suit() {
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj) return false;
        if (!(obj instanceof Card)) {
            return false;
        } else {
            Card other = (Card) obj;
            return other.suit == this.suit && other.rank == this.rank;
        }
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
