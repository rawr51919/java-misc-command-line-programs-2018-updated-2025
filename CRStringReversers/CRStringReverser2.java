import java.util.Scanner;
import java.util.logging.*;
public final class CRStringReverser2 {
    private static final Logger LOGGER = Logger.getLogger(CRStringReverser2.class.getName());
    public static void main(String[] args) {
        setupLogger();
        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();
            char decisionLetter;
            do {
                sb.setLength(0); // clear StringBuilder
                logInfo("Welcome to the string reverser.\n");
                logInfo("What string do you want to reverse?\n");
                String inputString = scanner.nextLine();
                sb.append(inputString);
                String reversedString = sb.reverse().toString();
                logInfo("The reverse of the input string is ");
                logInfoNoNewline(reversedString);
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
        System.exit(0);
    }
    private static void setupLogger() {
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        // Custom formatter without metadata and no newline appended
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
    private static void logInfoNoNewline(String message) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(message);
        }
    }
}
