import java.util.Random;

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
        return "(" + rank.toString() + ", " + suit.toString() + ")";
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean equals(Object other) {
        Card otherCard = (Card) other;
        return rank.equals(otherCard.rank) && suit.equals(otherCard.suit);
    }

    /**
     * Compares two card objects
     * @param other is the second card being compared to this.Card
     * @return will return negative numbers if this.Card comes before other
     *         will return a positive number if this.Card comes after other
     *         will return 0 if the cards are identical
     */
    public int compareTo(Card other) {
        if (rank.ordinal() != other.rank.ordinal()) {
            return rank.ordinal() - other.rank.ordinal();
        } else {
            return (suit.ordinal() - other.suit.ordinal());
        }
    }

    public static Card randomCard() {
        Random random = new Random();
        int randomRankIndex = random.nextInt(Rank.values().length);
        int randomSuitIndex = random.nextInt(Suit.values().length);
        Rank randomRank = Rank.values()[randomRankIndex];
        Suit randomSuit = Suit.values() [randomSuitIndex];

        return new Card(randomRank, randomSuit);
    }
}
