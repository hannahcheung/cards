package test;

import org.junit.Before;
import org.junit.Test;
import src.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {

    private Random random;

    @Before
    public void init() {
        random = new Random();
    }

    /**
     * Asserts that sorting an empty list results in an empty list.
     */
    @Test
    public void emptyDeckSortTest() {
        Deck deck = new Deck();
        deck.sort();

        assertEquals(deck.getCards(), new ArrayList<>());
    }

    /**
     * Asserts that sorting a list with a single Card results in the
     * same list.
     */
    @Test
    public void oneCardDeckSortTest() {
        Deck deck = new Deck();
        Card card = Card.randomCard();
        deck.addCard(card);

        Deck sortedDeck = new Deck();
        sortedDeck.addCard(card);

        assertEquals(deck.getCards(), sortedDeck.getCards());
    }

    /**
     *
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
        deck.sort();

        assertEquals(deck.getCards(), sortedDeck.getCards());
    }

    /**
     *
     */
    @Test
    public void sameSuitSortTest() {
        Deck deck = new Deck();
        Deck sortedDeck = new Deck();
        List<Card> cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            cards.add(new Card(rank, Suit.HEARTS));
            sortedDeck.addCard(new Card(rank, Suit.HEARTS));
        }
        Collections.shuffle(cards);
        deck.addCards(cards);
        deck.sort();

        assertEquals(deck.getCards(), sortedDeck.getCards());
    }

    /**
     *
     */
    @Test
    public void fullDeckSortTest() {
        Deck deck = new Deck(56);
        Deck sortedDeck = new Deck();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                sortedDeck.addCard(new Card(rank, suit));
            }
        }
        deck.sort();

        assertEquals(deck.getCards(), sortedDeck.getCards());
    }
}
