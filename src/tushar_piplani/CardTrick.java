import java.util.Scanner;

public class CardTrick {

    private Card[] hand;
    private static final String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};

    public static class Card {
        private int value;
        private String suit;

        public Card(int value, String suit) {
            this.value = value;
            this.suit = suit;
        }

        public int getValue() {
            return this.value;
        }

        public String getSuit() {
            return this.suit;
        }

        @Override
        public String toString() {
            return this.value + " of " + this.suit;
        }
    }

    public CardTrick() {
        hand = new Card[7];
        Random rand = new Random();

        for (int i = 0; i < hand.length; i++) {
            int value = rand.nextInt(13) + 1; // Random value between 1 and 13
            String suit = suits[rand.nextInt(suits.length)]; // Random suit
            hand[i] = new Card(value, suit);
        }
    }

    public void printInfo() {
        System.out.println("Author: Tushar Piplani");
        System.out.println("Date: 07/06/2023")
        // I'm done!
    }

    // Search for user's card
    public boolean searchCard(Card card) {
        for (Card c : hand) {
            if (c.getValue() == card.getValue() && c.getSuit().equals(card.getSuit())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CardTrick trick = new CardTrick();
        Scanner scanner = new Scanner(System.in);

        // Just for debugging purpose, print the cards
        for (Card c : trick.hand) {
            System.out.println(c);
        }

        System.out.println("Pick a card (any card!):");
        System.out.println("Enter the value (1-13):");
        int value = scanner.nextInt();
        System.out.println("Enter the suit (Spades, Hearts, Diamonds, Clubs):");
        String suit = scanner.next();

        Card chosenCard = new Card(value, suit);
        if (trick.searchCard(chosenCard)) {
            System.out.println("Your card is in the hand!");
            trick.printInfo();
        } else {
            System.out.println("Your card is not in the hand!");
        }
    }
}
