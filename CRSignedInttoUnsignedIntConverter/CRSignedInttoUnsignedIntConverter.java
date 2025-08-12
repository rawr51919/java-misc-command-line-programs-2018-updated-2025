import java.util.Scanner;
import java.util.logging.*;
public final class CRSignedInttoUnsignedIntConverter {
    private static final Logger LOGGER = Logger.getLogger(CRSignedInttoUnsignedIntConverter.class.getName());
    public static void main(String[] args) {
        // Configure logger
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        LOGGER.addHandler(handler);
        LOGGER.setUseParentHandlers(false);
        try (Scanner k = new Scanner(System.in)) {
            int signedint;
            String decision;
            do {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info("Welcome to the signed integer to unsigned integer converter.");
                    LOGGER.info("Which signed integer would you like to convert today?");
                }
                signedint = k.nextInt();
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info(String.format(
                        "The unsigned integer equivalent of this signed integer is: %s",
                        Integer.toUnsignedString(signedint)
                    ));
                    LOGGER.info("Do you want to convert another unsigned integer? (y/n)");
                }
                decision = k.next();
            } while (decision.equalsIgnoreCase("y"));
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Exiting the signed integer to unsigned integer converter...");
            }
        }
    }
}
