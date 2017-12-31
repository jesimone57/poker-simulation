import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class DeckTest {

	@Test
	public void testDeckConstructor() {
		Deck deck = new Deck();
		assertEquals(52, deck.getCards().size());
	}

	@Test
	public void testShuffle() {
		Deck deck = new Deck();
		deck.shuffle();
		assertEquals(52, deck.getCards().size());
		assertNotEquals(new Deck(), deck);
	}

	@Test
	public void testDealHand() {
		List<Card> expectedCards = new ArrayList<>();
		expectedCards.add(new Card(SuitType.H, 1));
		expectedCards.add(new Card(SuitType.H, 2));
		expectedCards.add(new Card(SuitType.H, 3));

		Deck deck = new Deck();
		assertEquals(expectedCards, deck.dealHand(3));
	}

	@Test
	public void testEquals1() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		assertTrue(deck1.equals(deck2));
	}

	@Test
	public void testEquals2() {
		Deck deck1 = new Deck();
		assertTrue(deck1.equals(deck1));
	}

	@Test
	public void testEquals3() {
		Deck deck1 = new Deck();
		assertFalse(deck1.equals(null));
	}

	@Test
	public void testEquals4() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		deck1.shuffle();
		assertFalse(deck1.equals(deck2));
	}

	@Test
	public void testEquals5() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		deck1.dealHand(1);  // deck1 will now be 1 card less
		assertFalse(deck1.equals(deck2));
	}

	@Test
	public void testEquals6() {
		Deck deck1 = new Deck();
		assertFalse(deck1.equals("string"));
	}

	@Test
	public void testDeckToString() {
		Deck deck = new Deck();
		deck.dealHand(50); // deck will only have 2 cards remaining
		assertEquals("Q-S K-S ", deck.toString());
	}

}
