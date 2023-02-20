package test;

import org.junit.Test;
import src.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {
    @Test
    public void emptyDeckSortTest() {
        Deck deck = new Deck();
        deck.sort();

        assertEquals(deck.getCards(), new ArrayList<>());
    }

    @Test
    public void oneCardDeckSortTest() {
        Deck deck = new Deck();
        deck.addCard(new Card(Rank.JACK, Suit.DIAMONDS));

        Deck sortedDeck = new Deck();
        sortedDeck.addCard(new Card(Rank.JACK, Suit.DIAMONDS));

        assertEquals(deck.getCards(), sortedDeck.getCards());
    }

    @Test
    public void sameRankSortTest() {
        Deck deck = new Deck();
        Deck sortedDeck = new Deck();
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            cards.add(new Card(Rank.FOUR, suit));
            sortedDeck.addCard(new Card(Rank.FOUR, suit));
        }
        Collections.shuffle(cards);
        deck.addCards(cards);
        deck.sort();

        assertEquals(deck.getCards(), sortedDeck.getCards());
    }

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
