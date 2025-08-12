import java.util.logging.*;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public final class CountTo1Million {
    private static final Logger LOGGER = Logger.getLogger(CountTo1Million.class.getName());
    public static void main(String[] args) {
        setupLogger();
        try (PrintWriter numbers = new PrintWriter("break1mil.txt")) {
            for (int value = 0; value <= 1_000_000; value++) {
                numbers.println(value);
            }
            logInfo("Number writing complete. Exiting...");
            System.exit(0);
        } catch (FileNotFoundException e) {
            logSevere("File not found. Exiting due to critical error...");
            System.exit(1);
        }
    }
    private static void setupLogger() {
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        // Use a simple formatter with no extra metadata or newlines
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                return logRecord.getMessage() + System.lineSeparator();
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
    private static void logSevere(String message) {
        if (LOGGER.isLoggable(Level.SEVERE)) {
            LOGGER.severe(message);
        }
    }
}
