import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return symbol + " " + value;
    }
}

public class CardCollection {
    private static List<Card> cards = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    findCardsBySymbol();
                    break;
                case 3:
                    displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter Card Symbol: ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Card Value: ");
        String value = scanner.nextLine();

        cards.add(new Card(symbol, value));
        System.out.println("Card added successfully!");
    }

    private static void findCardsBySymbol() {
        System.out.print("Enter Symbol to search: ");
        String symbol = scanner.nextLine();

        List<Card> foundCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                foundCards.add(card);
            }
        }

        if (foundCards.isEmpty()) {
            System.out.println("No cards found with symbol " + symbol);
        } else {
            System.out.println("Cards with symbol " + symbol + ":");
            for (Card card : foundCards) {
                System.out.println(card);
            }
        }
    }

    private static void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards found.");
        } else {
            System.out.println("All Cards:");
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }
}