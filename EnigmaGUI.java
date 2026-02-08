/**
 * The EnigmaGUI class serves as the entry point for the Enigma
 * Machine graphical application.
 *
 * It initializes and displays the EnigmaFrame, which contains
 * the full graphical user interface for encryption and decryption.
 */
public class EnigmaGUI {

    /**
     * Main method that launches the Enigma GUI application.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        EnigmaFrame u = new EnigmaFrame();        // Create the main GUI frame for the Enigma machine
        u.setVisible(true);        // Make the GUI visible to the user
    }
}
