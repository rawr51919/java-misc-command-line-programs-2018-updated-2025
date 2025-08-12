import java.util.Scanner;
import java.util.logging.*;
public final class NumberDisplayer {
    private static final Logger LOGGER = Logger.getLogger(NumberDisplayer.class.getName());
    public static void main(String[] args) {
        // Setup logger
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        LOGGER.addHandler(consoleHandler);
        LOGGER.setUseParentHandlers(false);
        try (Scanner scanner = new Scanner(System.in)) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("What number do you want to input?");
            }
            String value = scanner.nextLine().replaceAll("[^\\d]", ""); // remove all non-numeric characters
            if (value.isEmpty()) {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info("I can't show the value of literally nothing!");
                }
            } else {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info("You entered the number: " + value);
                }
            }
        }
    }
}
