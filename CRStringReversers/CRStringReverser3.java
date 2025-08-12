import java.util.Scanner;
import java.util.logging.*;
public final class CRStringReverser3 {
    private static final Logger LOGGER = Logger.getLogger(CRStringReverser3.class.getName());
    public static void main(String[] args) {
        setupLogger();
        try (Scanner scanner = new Scanner(System.in)) {
            char decisionLetter;
            do {
                logInfo("Welcome to the string reverser.\n");
                logInfo("What string do you want to reverse?\n");
                String inputString = scanner.nextLine();
                char[] chars = inputString.toCharArray();
                logInfo("The reverse of the input string is ");
                // Log reversed characters continuously, no newline
                for (int i = chars.length - 1; i >= 0; i--) {
                    logInfoNoNewline(String.valueOf(chars[i]));
                }
                logInfoNoNewline(".\n");
                logInfo("Do you want to reverse another string? (y/n)\n");
                String decision = scanner.nextLine().toUpperCase();
                decisionLetter = decision.isEmpty() ? ' ' : decision.charAt(0);
                while (decisionLetter != 'Y' && decisionLetter != 'N') {
                    logInfo("Invalid option. Please use either y or n.\n");
                    decision = scanner.nextLine().toUpperCase();
                    decisionLetter = decision.isEmpty() ? ' ' : decision.charAt(0);
                }
            } while (decisionLetter == 'Y');
            logInfo("Exiting the string reverser...\n");
        }
    }
    private static void setupLogger() {
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        // Custom formatter that does NOT add a newline or metadata
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                return logRecord.getMessage();
            }
        });
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(handler);
    }
    private static void logInfo(String message) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(message);
        }
    }
    // Log without newline by sending message as is (our formatter prevents auto newlines)
    private static void logInfoNoNewline(String message) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(message);
        }
    }
}
