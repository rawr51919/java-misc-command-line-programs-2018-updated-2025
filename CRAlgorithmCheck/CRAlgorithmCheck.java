import java.util.*;
import java.security.*;
import java.util.logging.*;
public final class CRAlgorithmCheck {
    private static final Logger LOGGER = Logger.getLogger(CRAlgorithmCheck.class.getName());
    public static void main(String[] args) {
        // Optional: configure logger to show INFO-level messages in console
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        LOGGER.addHandler(handler);
        LOGGER.setUseParentHandlers(false); // Prevent duplicate output
        // Use a set so we don't list duplicates
        Set<String> algorithms = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (Provider provider : Security.getProviders()) {
            for (Provider.Service service : provider.getServices()) {
                algorithms.add(service.getAlgorithm());
            }
        }
        LOGGER.info("Algorithms installed on this machine:");
        for (String algorithm : algorithms) {
            LOGGER.info(algorithm);
        }
    }
}
