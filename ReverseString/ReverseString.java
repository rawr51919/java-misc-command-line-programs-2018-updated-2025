import java.util.Scanner;
import java.util.logging.*;
public final class ReverseString {
    private static final Logger LOGGER = Logger.getLogger(ReverseString.class.getName());
    public static void main(String[] args) {
        // Setup logger
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        LOGGER.addHandler(consoleHandler);
        LOGGER.setUseParentHandlers(false);
        try (Scanner k = new Scanner(System.in)) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("What do you want me to reverse? ");
            }
            String inputString = k.nextLine();
            char[] stringArray = inputString.toCharArray();
            // Build reversed string using StringBuilder
            StringBuilder reversed = new StringBuilder();
            for (int i = stringArray.length - 1; i >= 0; i--) {
                reversed.append(stringArray[i]);
            }
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, "The string reversed is: {0}", reversed);
            }
        }
    }
}
