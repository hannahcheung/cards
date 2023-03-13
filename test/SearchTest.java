package test;

import org.junit.Test;
import src.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SearchTest {

    public static final int FULL_DECK = 56;

    /**
     * Assert that searching for any Card in an empty Deck returns -1.
     */
    @Test
    public void emptyDeckSearchTest() {
        Deck deck = new Deck();
        int index = deck.linearSearch(Card.randomCard());

        assertEquals(-1, index);
    }

    /**
     * Assert that searching for the Card contained in a one-card
     * Deck returns 0.
     */
    @Test
    public void singleCardDeckContainsSearchTest() {
        Deck deck = new Deck();
        Card card = Card.randomCard();

        deck.addCard(card);
        int index = deck.linearSearch(card);

        assertEquals(0, index);
    }

    /**
     * Assert that searching for a Card not contained in a one-card
     * Deck returns -1.
     */
    @Test
    public void singleCardDeckDoesNotContainSearchTest() {
        Deck deck = new Deck();
        Card deckCard = Card.randomCard();
        Card searchCard = Card.randomCard();

        while (deckCard.equals(searchCard)) {
            searchCard = Card.randomCard();
        }

        deck.addCard(deckCard);
        int index = deck.linearSearch(searchCard);

        assertEquals(-1, index);
    }

    /**
     * Assert that searching for a Card in a full unsorted
     * 56-card Deck returns the correct position of the
     * Card, which is a non-zero integer.
     */
    @Test
    public void fullUnsortedDeckContainsSearchTest() {
        Deck fullDeck = new Deck(FULL_DECK);
        System.out.println(fullDeck);
        Card card = Card.randomCard();
        System.out.println(card);

        int index = fullDeck.linearSearch(card);

        assertNotEquals(-1, index);
        assertEquals(fullDeck.getCards().indexOf(card), index);
    }

    /**
     * Assert that searching for a Card in a full sorted
     * 56-card Deck returns the correct position of the
     * Card, which is a non-zero integer.
     */
    @Test
    public void fullSortedDeckContainsSearchTest() {
        Deck fullDeck = new Deck();
        Card card = Card.randomCard();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                fullDeck.addCard(new Card(rank, suit));
            }
        }
        int index = fullDeck.linearSearch(card);

        assertNotEquals(-1, index);
        assertEquals(fullDeck.getCards().indexOf(card), index);
    }
}
