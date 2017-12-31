import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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


}
