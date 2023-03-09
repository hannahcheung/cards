package test;

import org.junit.Test;
import src.*;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    /**
     * Assert that searching for any Card in an empty Deck returns -1.
     */
    @Test
    public void emptyListSearchTest() {
        Deck deck = new Deck();
        int index = deck.search(Card.randomCard());

        assertEquals(-1, index);
    }

    /**
     * Assert that searching for the Card contained in a one-card
     * Deck returns 0.
     */
    @Test
    public void singleElementListContainsSearchTest() {
        Deck deck = new Deck();
        Card card = Card.randomCard();

        deck.addCard(card);
        int index = deck.search(card);

        assertEquals(0, index);
    }

    /**
     * Assert that searching for a Card not contained in a one-card
     * Deck returns -1.
     */
    @Test
    public void singleElementListDoesNotContainSearchTest() {
        Deck deck = new Deck();
        Card deckCard = Card.randomCard();
        Card searchCard = Card.randomCard();

        while (deckCard.equals(searchCard)) {
            searchCard = Card.randomCard();
        }

        deck.addCard(deckCard);
        int index = deck.search(searchCard);

        assertEquals(-1, index);
    }
}
