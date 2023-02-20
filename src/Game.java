package src;

import src.Card;
import src.Deck;

public class Game {
    public static final int FULL_DECK = 56;

    public static void main(String[] args) {
        Card card = new Card(Rank.ACE, Suit.CLUBS);
        System.out.println(card);

        Deck deck = new Deck();
        deck.addCard(card);
        System.out.println(deck);

        Deck allCards = new Deck(FULL_DECK);
        System.out.println(allCards);
        allCards.insertionSort();
        System.out.println(allCards);
        System.out.println(allCards.size());
    }
}
