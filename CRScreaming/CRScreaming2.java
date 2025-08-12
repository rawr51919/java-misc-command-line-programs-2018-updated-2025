import java.io.IOException;
import java.util.logging.*;
public final class CRScreaming2 {
    private static final Logger LOGGER = Logger.getLogger(CRScreaming2.class.getName());
    public static void main(String[] args) throws IOException {
        // Setup console handler with custom formatter (no metadata, no newline)
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                return logRecord.getMessage();  // no prefix, no newline
            }
        });
        LOGGER.setLevel(Level.SEVERE);
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(consoleHandler);
        if (LOGGER.isLoggable(Level.SEVERE)) {
            LOGGER.severe("Press any key to stop screaming...\n");
        }
        // Loop until any key is pressed
        while (System.in.available() == 0) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.severe("A");
            }
        }
        if (LOGGER.isLoggable(Level.SEVERE)) {
            LOGGER.severe("\nScreaming stopped.\n");
        }
    }
}
