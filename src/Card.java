package src;

import java.util.Random;

public class Card {
    private Rank rank;
    private Suit suit;

    /**
     * Constructs a Card object given a rank and suit
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Gets rank of Card object
     * @return rank of Card object
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Gets suit of Card object
     * @return suit of Card object
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Creates String representation of a Card object
     * @return String representation of Card ({RANK}, {SUIT})
     */
    public String toString() {
        return "(" + rank.toString() + ", " + suit.toString() + ")";
    }

    /**
     * Checks equality of this Card object with other src.Card object
     * @param other - other card being compared for equality
     * @return true if rank and suit of both Card objects are the same
     */
    public boolean equals(Object other) {
        Card otherCard = (Card) other;
        return rank.equals(otherCard.rank) && suit.equals(otherCard.suit);
    }

    /**
     * Compares two card objects
     * @param other - second card being compared to this.Card
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

    /**
     * Generate and return a random Card object
     * @return a Card object with a random rank and suit
     */
    public static Card randomCard() {
        Random random = new Random();
        int randomRankIndex = random.nextInt(Rank.values().length);
        int randomSuitIndex = random.nextInt(Suit.values().length);
        Rank randomRank = Rank.values()[randomRankIndex];
        Suit randomSuit = Suit.values()[randomSuitIndex];

        return new Card(randomRank, randomSuit);
    }
}
