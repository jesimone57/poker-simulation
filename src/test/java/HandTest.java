import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HandTest {

	@Test
	public void testPair1() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.H, 1));
		cards.add(new Card(SuitType.D, 1));
		Hand hand = new Hand(cards);
		assertTrue(hand.isOnePair());
		assertEquals("A-H A-D ", hand.toString());
	}

	@Test
	public void testPair2() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.H, 2));
		cards.add(new Card(SuitType.D, 3));
		cards.add(new Card(SuitType.S, 4));
		cards.add(new Card(SuitType.C, 3));
		Hand hand = new Hand(cards);
		assertTrue(hand.isOnePair());
	}

	@Test
	public void testPair3() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.H, 1));
		cards.add(new Card(SuitType.D, 2));
		Hand hand = new Hand(cards);
		assertFalse(hand.isOnePair());
	}

	@Test
	public void testTwoPair1() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.H, 1));
		cards.add(new Card(SuitType.D, 1));
		cards.add(new Card(SuitType.S, 2));
		cards.add(new Card(SuitType.C, 2));
		Hand hand = new Hand(cards);
		assertTrue(hand.isTwoPair());
	}

	@Test
	public void testTwoPair2() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.H, 1));
		cards.add(new Card(SuitType.D, 1));
		cards.add(new Card(SuitType.H, 2));
		cards.add(new Card(SuitType.D, 2));
		Hand hand = new Hand(cards);
		assertTrue(hand.isTwoPair());
	}

	@Test
	public void testTwoPair3() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.H, 5));
		cards.add(new Card(SuitType.D, 1));
		cards.add(new Card(SuitType.H, 2));
		cards.add(new Card(SuitType.D, 4));
		cards.add(new Card(SuitType.D, 2));
		cards.add(new Card(SuitType.H, 1));
		Hand hand = new Hand(cards);
		assertTrue(hand.isTwoPair());
	}

	@Test
	public void testTwoPair4() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.H, 5));
		cards.add(new Card(SuitType.D, 1));
		cards.add(new Card(SuitType.H, 2));
		cards.add(new Card(SuitType.D, 4));
		cards.add(new Card(SuitType.D, 2));
		cards.add(new Card(SuitType.H, 3));
		Hand hand = new Hand(cards);
		assertFalse(hand.isTwoPair());
	}

	@Test
	public void testFullHouse1() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.H, 2));
		cards.add(new Card(SuitType.D, 2));
		cards.add(new Card(SuitType.S, 2));
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.S, 3));
		Hand hand = new Hand(cards);
		assertTrue(hand.isFullHouse());
		assertTrue(hand.isThreeOfAKind());
		assertTrue(hand.isOnePair());
	}

	@Test
	public void testFullHouse2() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.H, 2));
		cards.add(new Card(SuitType.D, 2));
		cards.add(new Card(SuitType.S, 3));
		cards.add(new Card(SuitType.S, 2));
		Hand hand = new Hand(cards);
		assertTrue(hand.isFullHouse());
		assertTrue(hand.isThreeOfAKind());
		assertTrue(hand.isOnePair());
	}

	@Test
	public void testFullHouse3() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.H, 1));
		cards.add(new Card(SuitType.D, 2));
		cards.add(new Card(SuitType.S, 3));
		cards.add(new Card(SuitType.S, 2));
		Hand hand = new Hand(cards);
		assertFalse(hand.isFullHouse());
		assertFalse(hand.isThreeOfAKind());
		assertFalse(hand.isOnePair());
		assertTrue(hand.isTwoPair());
	}

	@Test
	public void testFourOfAKind1() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.H, 3));
		cards.add(new Card(SuitType.D, 3));
		cards.add(new Card(SuitType.S, 3));
		cards.add(new Card(SuitType.S, 2));
		Hand hand = new Hand(cards);
		assertTrue(hand.isFourOfAKind());
		assertFalse(hand.isThreeOfAKind());
		assertFalse(hand.isOnePair());
		assertFalse(hand.isTwoPair());
	}

	@Test
	public void testFourOfAKind2() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.H, 3));
		cards.add(new Card(SuitType.S, 2));
		cards.add(new Card(SuitType.D, 3));
		cards.add(new Card(SuitType.S, 3));
		Hand hand = new Hand(cards);
		assertTrue(hand.isFourOfAKind());
		assertFalse(hand.isThreeOfAKind());
		assertFalse(hand.isOnePair());
		assertFalse(hand.isTwoPair());
	}

	@Test
	public void testFourOfAKind3() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.H, 7));
		cards.add(new Card(SuitType.S, 2));
		cards.add(new Card(SuitType.D, 3));
		cards.add(new Card(SuitType.S, 3));
		Hand hand = new Hand(cards);
		assertFalse(hand.isFourOfAKind());
		assertTrue(hand.isThreeOfAKind());
		assertFalse(hand.isOnePair());
		assertFalse(hand.isTwoPair());
	}

	@Test
	public void testHasAces1() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 1));
		Hand hand = new Hand(cards);
		assertTrue(hand.hasAces());
	}

	@Test
	public void testHasAces2() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 2));
		Hand hand = new Hand(cards);
		assertFalse(hand.hasAces());
	}

	@Test
	public void testIsFlush1() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 2));
		cards.add(new Card(SuitType.C, 5));
		cards.add(new Card(SuitType.C, 9));
		cards.add(new Card(SuitType.C, 10));
		cards.add(new Card(SuitType.C, 11));
		Hand hand = new Hand(cards);
		assertTrue(hand.isFlush());
		assertFalse(hand.isStraight());
		assertFalse(hand.isStraightFlush());
	}

	@Test
	public void testIsFlush2() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 2));
		cards.add(new Card(SuitType.C, 5));
		cards.add(new Card(SuitType.D, 9));
		cards.add(new Card(SuitType.C, 10));
		cards.add(new Card(SuitType.C, 11));
		Hand hand = new Hand(cards);
		assertFalse(hand.isFlush());
		assertFalse(hand.isStraight());
		assertFalse(hand.isStraightFlush());
	}

	@Test
	public void testIsStright1() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 2));
		cards.add(new Card(SuitType.D, 3));
		cards.add(new Card(SuitType.S, 4));
		cards.add(new Card(SuitType.H, 5));
		cards.add(new Card(SuitType.C, 6));
		Hand hand = new Hand(cards);
		assertFalse(hand.isFlush());
		assertTrue(hand.isStraight());
		assertFalse(hand.isStraightFlush());
	}

	@Test
	public void testIsStright2() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 2));
		cards.add(new Card(SuitType.D, 3));
		cards.add(new Card(SuitType.S, 4));
		cards.add(new Card(SuitType.H, 5));
		cards.add(new Card(SuitType.C, 7));
		Hand hand = new Hand(cards);
		assertFalse(hand.isFlush());
		assertFalse(hand.isStraight());
		assertFalse(hand.isStraightFlush());
	}

	@Test
	public void testIsStraightFlush1() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 2));
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.C, 4));
		cards.add(new Card(SuitType.C, 5));
		cards.add(new Card(SuitType.C, 6));
		Hand hand = new Hand(cards);
		assertTrue(hand.isFlush());
		assertTrue(hand.isStraight());
		assertTrue(hand.isStraightFlush());
	}

	@Test
	public void testIsStraightFlush2() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 2));
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.C, 4));
		cards.add(new Card(SuitType.C, 5));
		cards.add(new Card(SuitType.D, 6));
		Hand hand = new Hand(cards);
		assertFalse(hand.isFlush());
		assertTrue(hand.isStraight());
		assertFalse(hand.isStraightFlush());
	}

	@Test
	public void testIsStraightFlush3() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 2));
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.C, 4));
		cards.add(new Card(SuitType.C, 5));
		cards.add(new Card(SuitType.C, 7));
		Hand hand = new Hand(cards);
		assertTrue(hand.isFlush());
		assertFalse(hand.isStraight());
		assertFalse(hand.isStraightFlush());
	}

	@Test
	public void testGetCards() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(SuitType.C, 4));
		cards.add(new Card(SuitType.C, 3));
		cards.add(new Card(SuitType.C, 6));
		cards.add(new Card(SuitType.C, 5));
		cards.add(new Card(SuitType.C, 2));
		Hand hand = new Hand(cards);

		List<Card> cardsOrdered = new ArrayList<>();
		cardsOrdered.add(new Card(SuitType.C, 2));
		cardsOrdered.add(new Card(SuitType.C, 3));
		cardsOrdered.add(new Card(SuitType.C, 4));
		cardsOrdered.add(new Card(SuitType.C, 5));
		cardsOrdered.add(new Card(SuitType.C, 6));
		assertEquals(cardsOrdered, hand.getCards());
	}


}
