import java.io.IOException;
import java.util.logging.*;
public final class Screaming {
    private static final Logger LOGGER = Logger.getLogger(Screaming.class.getName());
    public static void main(String[] args) throws IOException {
        // Setup console handler with custom formatter
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                return logRecord.getMessage(); // no prefix, no newline
            }
        });
        LOGGER.setLevel(Level.INFO);
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(consoleHandler);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Press any key to stop screaming...\n");
        }
        // Loop until any key is pressed
        while (System.in.available() == 0) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("A");
            }
        }
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("\nScreaming stopped.\n");
        }
    }
}
