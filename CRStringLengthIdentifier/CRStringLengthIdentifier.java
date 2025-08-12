import java.util.Scanner;
import java.util.logging.*;
public class CRStringLengthIdentifier {
    private static final Logger LOGGER = Logger.getLogger(CRStringLengthIdentifier.class.getName());
    public static void main(String[] args) {
        setupLogger();
        try (Scanner scanner = new Scanner(System.in)) {
            String theString = "The string ";
            String decision;
            do {
                logInfo("Type in the string you want to find the length of: ");
                String inputString = scanner.nextLine();
                long stringLength = inputString.length();
                if (stringLength == 1) {
                    logInfo(theString + inputString + " has " + stringLength + " character in it.");
                } else if (inputString.isEmpty()) {
                    logInfo(theString + inputString + " has no characters in it.");
                } else {
                    logInfo(theString + inputString + " has " + stringLength + " characters in it.");
                }
                logInfo("Want to find the length of another string? (y/n)");
                decision = scanner.nextLine();
            } while (decision.equalsIgnoreCase("y"));
            logInfo("Exiting the string length identifier...");
        }
        System.exit(0);
    }
    private static void setupLogger() {
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        LOGGER.addHandler(handler);
        LOGGER.setUseParentHandlers(false);
    }
    private static void logInfo(String message) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(message);
        }
    }
}
