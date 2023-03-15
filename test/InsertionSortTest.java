package test;

import org.junit.Before;
import org.junit.Test;
import src.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortTest {

    public static final int TEST_SIZE = 20;
    private Random random;

    @Before
    public void init() {
        random = new Random();
    }

    /**
     * Asserts that sorting an empty Deck results in an empty Deck.
     */
    @Test
    public void emptyDeckSortTest() {
        Deck deck = new Deck();
        deck.insertionSort();

        assertEquals(new ArrayList<>(), deck.getCards());
    }

    /**
     * Asserts that sorting a Deck with a single Card results in the
     * same Deck.
     */
    @Test
    public void oneCardDeckSortTest() {
        Deck deck = new Deck();
        Card card = Card.randomCard();
        deck.addCard(card);

        Deck sortedDeck = new Deck();
        sortedDeck.addCard(card);

        deck.insertionSort();

        assertEquals(sortedDeck.getCards(), deck.getCards());
    }

    /**
     * Asserts that sorting a Deck which contains Cards of all
     * the same rank results in a Deck sorted by the suits.
     */
    @Test
    public void sameRankSortTest() {
        Deck deck = new Deck();
        Deck sortedDeck = new Deck();
        List<Card> cards = new ArrayList<>();
        Rank randomRank = Rank.values()[random.nextInt(Rank.values().length)];

        for (Suit suit : Suit.values()) {
            cards.add(new Card(randomRank, suit));
            sortedDeck.addCard(new Card(randomRank, suit));
        }

        Collections.shuffle(cards);
        deck.addCards(cards);
        deck.insertionSort();

        assertEquals(sortedDeck.getCards(), deck.getCards());
    }

    /**
     * Asserts that sorting a Deck which contains Cards of all
     * the same suits results in a Deck sorted by the ranks.
     */
    @Test
    public void sameSuitSortTest() {
        Deck deck = new Deck();
        Deck sortedDeck = new Deck();
        List<Card> cards = new ArrayList<>();
        Suit randomSuit = Suit.values()[random.nextInt(Suit.values().length)];

        for (Rank rank : Rank.values()) {
            cards.add(new Card(rank, randomSuit));
            sortedDeck.addCard(new Card(rank, randomSuit));
        }
        Collections.shuffle(cards);
        deck.addCards(cards);
        deck.insertionSort();

        assertEquals(sortedDeck.getCards(), deck.getCards());
    }

    /**
     * Assert that when given a non-full unsorted Deck that
     * consist of Cards with more than one rank and suit,
     * the Deck is sorted properly.
     */
    @Test
    public void unsortedDeckSortTest() {
        Deck sortedDeck = Deck.fullSortedDeck();
        List<Card> sortedCards = sortedDeck.getCards();

        while (sortedCards.size() > TEST_SIZE) {
            int randomIndex = random.nextInt(sortedCards.size());
            sortedCards.remove(randomIndex);
        }

        List<Card> unsortedCards = new ArrayList<>(sortedCards);
        Collections.shuffle(unsortedCards);

        Deck deck = new Deck();
        deck.addCards(unsortedCards);
        deck.insertionSort();

        assertEquals(sortedCards, deck.getCards());
    }

    /**
     * Assert that when given a sorted Deck that consist of
     * Cards with more than one rank and suit, sorting the
     * Deck results in the same Deck.
     */
    @Test
    public void sortedDeckSortTest() {
        Deck sortedDeck = Deck.fullSortedDeck();
        Deck testDeck = Deck.fullSortedDeck();

        testDeck.insertionSort();

        assertEquals(sortedDeck.getCards(), testDeck.getCards());
    }

    /**
     * Asserts that sorting an unsorted full Deck
     * results in all Cards first sorted by rank, then suit.
     */
    @Test
    public void unsortedFullDeckSortTest() {
        Deck deck = new Deck(56);
        Deck sortedDeck = Deck.fullSortedDeck();

        deck.insertionSort();

        assertEquals(sortedDeck.getCards(), deck.getCards());
    }

    /**
     * Asserts that sorting a sorted full Deck
     * results in the same Deck contents.
     */
    @Test
    public void sortedFullDeckSortTest() {
        Deck deck = Deck.fullSortedDeck();
        Deck sortedDeck = Deck.fullSortedDeck();

        deck.insertionSort();

        assertEquals(sortedDeck.getCards(), deck.getCards());
    }
}

