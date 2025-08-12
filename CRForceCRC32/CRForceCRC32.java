import javax.swing.*;
import java.io.File;
import java.util.logging.*;
public class CRForceCRC32 {
	private static final Logger LOGGER = Logger.getLogger(CRForceCRC32.class.getName());
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				// Setup logger first
				setupLogger();
				// File chooser
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Select a file to patch CRC32");
				int result = chooser.showOpenDialog(null);
				if (result != JFileChooser.APPROVE_OPTION) {
					LOGGER.log(Level.INFO, () -> "No file selected, exiting.");
					return;
				}
				File file = chooser.getSelectedFile();
				// Ask for offset
				String offsetStr = JOptionPane.showInputDialog(null, "Enter byte offset to patch (decimal):", "0");
				if (offsetStr == null) {
					LOGGER.log(Level.INFO, () -> "No offset provided, exiting.");
					return;
				}
				long offset = Long.parseLong(offsetStr);
				if (offset < 0) {
					LOGGER.log(Level.INFO, () -> "Offset must be non-negative.");
					return;
				}
				// Ask for new CRC32 hex value
				String crcStr = JOptionPane.showInputDialog(null, "Enter new CRC32 value (8 hex digits):", "00000000");
				if (crcStr == null || crcStr.length() != 8) {
					LOGGER.log(Level.INFO, () -> "Invalid CRC32 value, exiting.");
					return;
				}
				// Parse CRC32 hex string into int reversed as in ForceCRC32
				long temp = Long.parseLong(crcStr, 16);
				if ((temp & 0xFFFFFFFFL) != temp) {
					LOGGER.log(Level.INFO, () -> "CRC32 hex value out of range.");
					return;
				}
				int newCrc = Integer.reverse((int) temp);
				// Call the patcher
				ForceCRC32.modifyFileCrc32(file, offset, newCrc, true);
				// Log that the patching was successful
				LOGGER.log(Level.INFO, () -> "File patched successfully.");
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, () -> "Error: " + e.getMessage());
				LOGGER.log(Level.SEVERE, "Exception stack trace:", e);
				JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	private static void setupLogger() {
		Logger logger = Logger.getLogger(CRForceCRC32.class.getName());
		logger.setLevel(Level.INFO);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.INFO);
		handler.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord logRecord) {
				return logRecord.getMessage();
			}
		});
		logger.setUseParentHandlers(false);
		logger.addHandler(handler);
	}
}
