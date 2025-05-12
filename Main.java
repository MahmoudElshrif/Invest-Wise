import UI.LoginPageUI;
import UI.SignUpPage;

import javax.swing.*;

/**
 * Main class for launching the Wealth Wise application.
 */
public class Main {

    /**
     * Application entry point.
     * Displays an initial dialog asking the user whether to log in or sign up.
     * Based on the selection, the corresponding UI is shown.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Run the GUI on the Swing thread
        SwingUtilities.invokeLater(() -> {
            ImageIcon icon = new ImageIcon("assets/icon.png");
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Welcome to Wealth Wise!\nWhat would you like to do?",
                    "Wealth Wise",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    icon,
                    new String[] { "Login", "Sign Up" },
                    "Login");

            if (choice == JOptionPane.YES_OPTION) {
                new LoginPageUI().setVisible(true);
            } else if (choice == JOptionPane.NO_OPTION) {
                new SignUpPage().setVisible(true);
            } else {
                System.exit(0); // closed window
            }
        });
    }
}
