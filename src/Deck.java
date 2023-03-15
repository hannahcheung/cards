package src;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    /**
     * Constructs an empty Deck
     */
    public Deck() {
        this(0);
    }

    /**
     * Constructs a Deck of Cards with a given number. Deck
     * may consist of any combination of unique Cards in
     * any order.
     * @param numCards - given number of cards in new Deck
     * @precondition 0 <= numCards <= 52
     */
    public Deck(int numCards) {
        cards = new ArrayList<>();

        for (int i = 0; i < numCards; i++) {
            Card card = Card.randomCard();
            while (cards.contains(card)) {
                card = Card.randomCard();
            }
            cards.add(card);
        }
    }

    /**
     * Gets list of cards in Deck
     * @return List of Cards in Deck
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Adds a card to the Deck
     * @param card - card to be added to Deck
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Adds a list of cards to the Deck
     * @param cardsList list of cards to be added to Deck
     * @precondition cardsList contains at least one element
     */
    public void addCards(List<Card> cardsList) {
        cards.addAll(cardsList);
    }

    /**
     * Gets number of cards in Deck
     * @return number of cards in Deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * Creates String representation of a Deck
     * @return [{CARD1}, {CARD2}, {CARD3}...]
     */
    public String toString() {
        String str = "[";
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            str += card;
            if (i != cards.size() - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    /**
     * Performs linear search on cards in Deck
     * @param target - Card to look for in Deck
     * @return index of target Card if Card is found, -1 if not found
     */
    public int linearSearch(Card target) {
        // TODO: Implement linear search
        return -1;
    }

    /**
     * Performs binary search on cards in Deck
     * @param target - Card to look for in Deck
     * @precondition Deck is sorted in ascending order
     * @return index of target Card if Card is found, -1 if not found
     */
    public int binarySearch(Card target) {
        // BONUS: Implement binary search
        return -1;
    }

    /**
     * Performs selection sort on the cards in the Deck
     */
    public void selectionSort() {
        // TODO: Implement selection sort
    }

    /**
     * Performs insertion sort on the cards in the Deck
     */
    public void insertionSort() {
        // TODO: Implement insertion sort
    }

    /**
     * Creates and returns a full sorted Deck.
     * @return full sorted Deck
     */
    public static Deck fullSortedDeck() {
        Deck fullDeck = new Deck();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                fullDeck.addCard(new Card(rank, suit));
            }
        }
        return fullDeck;
    }
}
