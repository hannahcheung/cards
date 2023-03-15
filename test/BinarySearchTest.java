package test;

import org.junit.Before;
import org.junit.Test;
import src.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BinarySearchTest {

    public static final int FULL_DECK = 56;
    public static final int TEST_SIZE = 20;
    private Random random;

    @Before
    public void init() {
        random = new Random();
    }

    /**
     * Assert that searching for any Card in an empty Deck returns -1.
     */
    @Test
    public void emptyDeckSearchTest() {
        Deck deck = new Deck();
        int index = deck.binarySearch(Card.randomCard());

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
        int index = deck.binarySearch(card);

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
        int index = deck.binarySearch(searchCard);

        assertEquals(-1, index);
    }

    /**
     * Assert that searching for a Card that appears at the beginning
     * of a non-full sorted Deck returns the correct position
     * of the Card at index 0.
     */
    @Test
    public void sortedDeckContainsBeginningSearchTest() {
        Deck fullDeck = Deck.fullSortedDeck();
        List<Card> cards = fullDeck.getCards();

        while (cards.size() > TEST_SIZE) {
            int randomIndex = random.nextInt(cards.size());
            cards.remove(randomIndex);
        }

        Deck searchDeck = new Deck();
        searchDeck.addCards(cards);

        Card card = searchDeck.getCards().get(0);
        int index = searchDeck.binarySearch(card);

        assertEquals(0, index);
    }

    /**
     * Assert that searching for a Card that appears at the middle
     * of a non-full sorted Deck returns the correct position
     * of the Card.
     */
    @Test
    public void sortedDeckContainsMiddleSearchTest() {
        Deck fullDeck = Deck.fullSortedDeck();
        List<Card> cards = fullDeck.getCards();

        while (cards.size() > TEST_SIZE) {
            int randomIndex = random.nextInt(cards.size());
            cards.remove(randomIndex);
        }

        Deck searchDeck = new Deck();
        searchDeck.addCards(cards);

        Card card = searchDeck.getCards().get(TEST_SIZE / 2);
        int index = searchDeck.binarySearch(card);

        assertEquals(TEST_SIZE / 2, index);
    }

    /**
     * Assert that searching for a Card that appears at the end
     * of a non-full sorted Deck returns the correct position
     * of the Card.
     */
    @Test
    public void sortedDeckContainsEndSearchTest() {
        Deck fullDeck = Deck.fullSortedDeck();
        List<Card> cards = fullDeck.getCards();

        while (cards.size() > TEST_SIZE) {
            int randomIndex = random.nextInt(cards.size());
            cards.remove(randomIndex);
        }

        Deck searchDeck = new Deck();
        searchDeck.addCards(cards);

        Card card = searchDeck.getCards().get(TEST_SIZE - 1);
        int index = searchDeck.binarySearch(card);

        assertEquals(TEST_SIZE - 1, index);
    }
    /**
     * Assert that searching for a Card that does not appear in
     * a non-full sorted Deck returns -1.
     */
    @Test
    public void sortedDeckDoesNotContainSearchTest() {
        Deck fullDeck = Deck.fullSortedDeck();
        List<Card> cards = fullDeck.getCards();

        while (cards.size() > TEST_SIZE) {
            int randomIndex = random.nextInt(cards.size());
            cards.remove(randomIndex);
        }

        Deck searchDeck = new Deck();
        searchDeck.addCards(cards);

        Card card = Card.randomCard();
        while (searchDeck.getCards().contains(card)) {
            card = Card.randomCard();
        }

        int index = searchDeck.binarySearch(card);

        assertEquals(-1, index);
    }

    /**
     * Assert that searching for a Card in a full sorted
     * 56-card Deck returns the correct position of the
     * Card, which is a non-zero integer.
     */
    @Test
    public void fullSortedDeckContainsSearchTest() {
        Deck fullDeck = Deck.fullSortedDeck();
        Card card = Card.randomCard();

        int index = fullDeck.binarySearch(card);

        assertNotEquals(-1, index);
        assertEquals(fullDeck.getCards().indexOf(card), index);
    }
}
