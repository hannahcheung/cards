public class Game {
    public static void main(String[] args) {
        Card card = new Card(Rank.ACE, Suit.CLUBS);
        System.out.println(card);

        Deck deck = new Deck();
        deck.addCard(card);
        System.out.println(deck);

        Deck fullDeck = new Deck(true);
        System.out.println(fullDeck);
    }
}
