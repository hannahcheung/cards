import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String toString() {
        String str = "[";
        for (Card card : cards) {
            str += card;
        }
        str += "]";
        return str;
    }
}
