package isc;

import java.io.InputStream;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        this(System.in);
    }

    public Menu(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // TODO (students):
    // Expand menu text/options if the paper brief asks for more actions.
    public void displayMenu() {
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
    }

    // TODO (students):
    // Add name validation rules from the paper handout if needed.
    public String getPlayerName() {
        return getUserInput("Enter your name: ");
    }

    // TODO (students):
    // Keep this robust: reject invalid and out-of-range input safely.
    public int getUserChoice() {
        throw new UnsupportedOperationException("TODO: implement Menu.getUserChoice");
    }

    // TODO (students):
    // Keep this as a blocking prompt between turns.
    public void continueGame() {
        System.out.println("Press Enter to continue...");
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    // TODO (students):
    // Validate replay response based on paper instructions.
    public boolean askToPlayAgain() {
        throw new UnsupportedOperationException("TODO: implement Menu.askToPlayAgain");
    }
}
