import java.io.IOException;
import java.util.Random;
import java.util.logging.*;
public final class CRRNG {
    private static final Logger LOGGER = Logger.getLogger(CRRNG.class.getName());
    public static void main(String[] args) throws IOException {
        setupLogger();
        Random random = new Random();
        logInfo("Press any key to stop the random number generator...\n");
        while (System.in.available() == 0) {
            long value = random.nextLong();
            logInfo(value + "\n");
        }
        logInfo("Stopped random number generator.\n");
    }
    private static void setupLogger() {
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
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
}
