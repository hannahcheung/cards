public class Card {
    private Suit suit;
    private Rank rank;

    /**
     *
     * @param suit
     * @param rank
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     *
     * @return
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     *
     * @return
     */
    public Rank getRank() {
        return rank;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "(" + suit.toString() + ", " + rank.toString() + ")";
    }

    /**
     *
     * @param other
     * @return
     */
    public int compareTo(Card other) {
        return rank.ordinal() - other.rank.ordinal();
    }
}
