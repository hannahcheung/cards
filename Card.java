public class Card {
    private Rank rank;
    private Suit suit;

    /**
     *
     * @param suit
     * @param rank
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
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
    public Suit getSuit() {
        return suit;
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
