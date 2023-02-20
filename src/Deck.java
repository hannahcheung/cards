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
     * Constructs a Deck of Cards with a given number
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
     * Searches for a given card in the Deck
     * @param target - Card to look for in Deck
     * @precondition Deck is sorted in ascending order
     * @return index of target Card if Card is found, -1 if not found
     */
    public int search(Card target) {
        return search(target, 0, cards.size() - 1);
    }

    private int search(Card target, int low, int high) {
        while (low < high) {
            // TODO: Avoid overflow?
            int mid = (low + high) / 2;
            Card curr = cards.get(mid);
            if (target.equals(curr)) {
                return mid;
            } else if (target.compareTo(curr) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Performs selection sort on the cards list
     */
    public void sort() {
        for (int i = 0; i < cards.size(); i++) {
            // set minimum card to be the greatest value card initially
            int minIndex = i;
            Card minCard = cards.get(i);
            for (int j = i + 1; j < cards.size(); j++) {
                Card currCard = cards.get(j);
                if (currCard.compareTo(minCard) < 0) {
                    minIndex = j;
                    minCard = currCard;
                }
            }
            swap(i, minIndex);
        }
    }

    /**
     * Performs insertion sort on the cards list
     */
    public void insertionSort() {
        for (int i = 0; i < cards.size(); i++) {
            int j = i;
            while (j > 0 && cards.get(j - 1).compareTo(cards.get(j)) > 0) {
                swap(j, j -1);
                j = j - 1;
            }
        }
    }

    /**
     * Swaps two Cards in the cards list
     * @param indexA index of first Card to be swapped
     * @param indexB index of second card to bee swapped
     */
    private void swap(int indexA, int indexB) {
        Card temp = cards.get(indexA);
        cards.set(indexA, cards.get(indexB));
        cards.set(indexB, temp);
    }
}
