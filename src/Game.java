package src;

import java.util.Collections;
import java.util.Scanner;

public class Game {
    // Feel free to change this value. Maximum value of DECK_SIZE must be 56.
    public static final int DECK_SIZE = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck(DECK_SIZE);

        System.out.println("Welcome to Alice in Borderland.");
        System.out.println();
        System.out.println("Deck: " + deck);

        int choice;

        do {
            System.out.println("What would you like to do with the deck?");
            System.out.println();
            System.out.println("1: Search for a card");
            System.out.println("2: Sort the deck");
            System.out.println("3: Shuffle the deck");
            System.out.println("4: Quit the game");
            System.out.println();
            System.out.print("Please enter your choice, a number between 1 and 4: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    search(scanner, deck);
                    break;
                case 2:
                    sort(scanner, deck);
                    break;
                case 3:
                    Collections.shuffle(deck.getCards());
                    System.out.println("Shuffled deck: " + deck);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again: ");
                    break;
            }

        } while (choice != 4);

        System.out.println("Thank you for playing.");
    }

    public static void search(Scanner scanner, Deck deck) {
        System.out.println();
        System.out.println("What is the rank of the card to search for?");
        System.out.print("Choose one rank - ACE, ONE, TWO, THREE, FOUR, FIVE, " +
                           "SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING: ");
        String choice = scanner.next();

        Rank rank;
        while (true) {
            try {
                rank = Rank.valueOf(choice.toUpperCase());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.print("Invalid rank choice. Please choose again: ");
                choice = scanner.next();
            }
        }

        System.out.println();
        System.out.println("What is the suit of the target card to search for?");
        System.out.print("Choose one suit - CLUBS, DIAMONDS, HEARTS, SPADES: ");
        choice = scanner.next();

        Suit suit;
        while (true) {
            try {
                suit = Suit.valueOf(choice.toUpperCase());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.print("Invalid suit choice. Please choose again: ");
                choice = scanner.next();
            }
        }

        int index = deck.linearSearch(new Card(rank, suit));
        if (index == -1) {
            System.out.println();
            System.out.println("Could not find card with rank " + rank +
                               " and suit " + suit + ".\nLooks like you'll " +
                               "need to collect this card in another Game.");
        } else {
            System.out.println();
            System.out.println("Found card with rank " + rank +
                               " and suit " + suit + " at index " + index + "!");
        }
        System.out.println();
    }

    public static void sort(Scanner scanner, Deck deck) {
        System.out.println();
        System.out.print("What method of sorting would you like to use? " +
                         "1 for selection sort, 2 for insertion sort: ");
        int choice = scanner.nextInt();

        while (true) {
            if (choice == 1) {
                deck.selectionSort();
                System.out.println();
                System.out.println("Sorted deck using selection sort.");
                System.out.println("Sorted deck: " + deck);
                System.out.println();
                break;
            }
            else if (choice == 2) {
                deck.insertionSort();
                System.out.println();
                System.out.println("Sorted deck using insertion sort.");
                System.out.println("Sorted deck: " + deck);
                System.out.println();
                break;
            } else {
                System.out.print("Invalid choice. Please choose again: ");
                choice = scanner.nextInt();
            }
        }
    }
}
