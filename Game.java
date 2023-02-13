public class Game {
    public static final int FULL_DECK = 52;

    public static void main(String[] args) {
        Card card = new Card(Rank.ACE, Suit.CLUBS);
        System.out.println(card);

        Deck deck = new Deck();
        deck.addCard(card);
        System.out.println(deck);

        Deck allCards = new Deck(FULL_DECK);
        // System.out.println(allCards);
        allCards.sort();
        System.out.println(allCards);
        System.out.println(allCards.size());
    }
}
