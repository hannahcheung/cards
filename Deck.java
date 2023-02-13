import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private final List<Card> cards;

    /**
     *
     */
    public Deck() {
        this(0);
    }

    /**
     *
     * @param numCards
     */
    public Deck(int numCards) {
        cards = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numCards; i++) {
            Card card = Card.randomCard();
            while (cards.contains(card)) {
                card = Card.randomCard();
            }
            cards.add(card);
        }
    }

    /**
     *
     * @param card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    /**
     *
     * @return
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
     * Perfoms selection sort on the cards list.
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
