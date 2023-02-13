import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this(false);
    }

    public Deck(boolean fullDeck) {
        cards = new ArrayList<>();
        if (fullDeck) {
            for (Rank rank : Rank.values()) {
                for (Suit suit : Suit.values()) {
                    cards.add(new Card(rank, suit));
                }
            }
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }

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

    public void sort() {
    }
}
