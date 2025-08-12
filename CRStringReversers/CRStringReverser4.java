import java.util.Scanner;
import java.util.logging.*;
public final class CRStringReverser4 {
    private static final Logger LOGGER = Logger.getLogger(CRStringReverser4.class.getName());
    public static void main(String[] args) {
        setupLogger();
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                greetUser();
                String inputString = promptInput(scanner);
                String reversed = reverseString(inputString);
                displayReversedString(reversed);

            } while (shouldContinue(scanner));

            logInfo("Exiting the string reverser...");
        }
    }
    private static void setupLogger() {
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        LOGGER.addHandler(consoleHandler);
        LOGGER.setUseParentHandlers(false);
    }
    private static void greetUser() {
        logInfo("Welcome to the string reverser.");
        logInfo("What string do you want to reverse?");
    }
    private static String promptInput(Scanner scanner) {
        return scanner.nextLine();
    }
    private static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed.append(chars[i]);
        }
        return reversed.toString();
    }
    private static void displayReversedString(String reversed) {
        logInfo("The reverse of the input string is " + reversed);
        logInfo("Do you want to reverse another string? (y/n)");
    }
    private static boolean shouldContinue(Scanner scanner) {
        String decision;
        char decisionLetter;
        do {
            decision = scanner.nextLine().toUpperCase();
            decisionLetter = decision.isEmpty() ? ' ' : decision.charAt(0);
            if (decisionLetter != 'Y' && decisionLetter != 'N') {
                logInfo("Invalid option. Please use either y or n.");
            }
        } while (decisionLetter != 'Y' && decisionLetter != 'N');

        return decisionLetter == 'Y';
    }
    private static void logInfo(String message) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(message);
        }
    }
}
