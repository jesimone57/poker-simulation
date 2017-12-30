import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCardConstructorException1() {
		new Card('H', 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCardConstructorException2() {
		new Card('H', 15);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCardConstructorException3() {
		new Card('X', 4);
	}

	@Test
	public void testCard1() {
		Card card = new Card('H', 2);
		assertEquals('H', card.suit());
		assertEquals(2, card.rank());
	}

	@Test
	public void testCardToString() {
		Card card = new Card('H', 2);
		assertEquals("2-H", card.toString());

		card = new Card('H', 11);
		assertEquals("J-H", card.toString());

		card = new Card('H', 12);
		assertEquals("Q-H", card.toString());

		card = new Card('H', 13);
		assertEquals("K-H", card.toString());

		card = new Card('H', 14);
		assertEquals("A-H", card.toString());

		card = new Card('H', 1);
		assertEquals("A-H", card.toString());
	}

	@Test
	public void testisAceLow() {
		Card card = new Card('H', 1);
		assertTrue(card.isAceRankLow());
		assertFalse(card.isAceRankHigh());
	}

	@Test
	public void testisAceHigh() {
		Card card = new Card('H', 14);
		assertTrue(card.isAceRankHigh());
		assertFalse(card.isAceRankLow());
	}

	@Test
	public void testisAce() {
		Card card = new Card('H', 14);
		assertTrue(card.isAce());

		card = new Card('H', 1);
		assertTrue(card.isAce());

		card = new Card('H', 2);
		assertFalse(card.isAce());
	}

	@Test
	public void testCompareTo() {
		Card card1 = new Card('H', 1);
		Card card2 = new Card('H', 2);
		assertEquals(-1, card1.compareTo(card2));
		assertEquals(1, card2.compareTo(card1));

		Card card3 = new Card('H', 2);
		assertEquals(0, card2.compareTo(card3));
		assertEquals(0, card3.compareTo(card2));
	}

	@Test
	public void testSwapTheRankOfHowAceIsPlayed() {
		Card card = new Card('H', 1);
		assertEquals(1, card.rank());

		card.swapTheRankOfHowAceIsPlayed();
		assertEquals(14, card.rank());

		card.swapTheRankOfHowAceIsPlayed();
		assertEquals(1, card.rank());
	}
}
