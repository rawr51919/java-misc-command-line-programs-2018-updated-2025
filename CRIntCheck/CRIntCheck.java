import java.util.logging.*;
public final class CRIntCheck {
    private static final Logger LOGGER = Logger.getLogger(CRIntCheck.class.getName());
    public static void main(String[] args) {
        // Setup logger
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        LOGGER.addHandler(consoleHandler);
        LOGGER.setUseParentHandlers(false);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Max signed value of an integer is: " + Integer.MAX_VALUE);
        }
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Max unsigned value of an integer is: " + Integer.toUnsignedString(-1));
        }
    }
}
