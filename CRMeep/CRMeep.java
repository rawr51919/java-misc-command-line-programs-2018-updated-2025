import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
public final class CRMeep {
    private static final Logger logger = Logger.getLogger(CRMeep.class.getName());
    public static final void main(String[] args) {
        // Setup logger to output to console immediately
        logger.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);  // avoid double logs in console
        Scanner k = new Scanner(System.in);
        String input = "";
        StringBuilder output = new StringBuilder();
        char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        char[] meep = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', '[', ']', ';', '.', '/', '+', '{',
                '}', ':', ',', '_', '(', ')' };
		// Log the input from the user
        logger.log(Level.INFO, "Type in whatever you wish to encode: ");
        input = k.nextLine().toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int index = -1;
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j] == c) {
                    index = j;
                    break;
                }
            }
            if (index >= 0) {
                output.append(meep[index]);
            } else {
                output.append(c);
            }
        }
        logger.log(Level.INFO, "The encoded string is: {0}", output);
        k.close();
    }
}
