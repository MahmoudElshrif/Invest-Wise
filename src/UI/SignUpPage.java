package UI;

import controller.AuthController;

import javax.swing.*;
import java.awt.*;

/**
 * UI class for user sign-up using a Swing JFrame.
 */
public class SignUpPage extends JFrame {
	private JTextField nameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private final AuthController authController = new AuthController();

	/**
	 * Constructs the sign-up page and initializes its components.
	 */
	public SignUpPage() {
		setTitle("Wealth Wise - Sign Up");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new BorderLayout());
		JPanel formPanel = new JPanel(new GridLayout(5, 1, 10, 10));

		// Logo section
		JLabel logoLabel = new JLabel();
		ImageIcon logoIcon = new ImageIcon("assets/logo.png");
		Image scaledImage = logoIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		logoLabel.setIcon(new ImageIcon(scaledImage));
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(logoLabel, BorderLayout.NORTH);

		// Input fields
		nameField = new JTextField();
		emailField = new JTextField();
		passwordField = new JPasswordField();

		formPanel.add(new JLabel("Name:"));
		formPanel.add(nameField);
		formPanel.add(new JLabel("Email:"));
		formPanel.add(emailField);
		formPanel.add(new JLabel("Password:"));
		formPanel.add(passwordField);

		// Buttons
		JPanel buttonPanel = new JPanel(new FlowLayout());
		JButton signUpButton = new JButton("Sign Up");
		JButton goToLoginButton = new JButton("Go to Login");

		buttonPanel.add(signUpButton);
		buttonPanel.add(goToLoginButton);

		panel.add(formPanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		add(panel);

		// Listeners
		signUpButton.addActionListener(e -> handleSignUp());
		goToLoginButton.addActionListener(e -> {
			dispose(); // close this window
			new LoginPageUI().setVisible(true);
		});

		setVisible(true);
	}

	/**
	 * Handles the sign-up process by validating and registering the user.
	 * Shows appropriate messages based on success or failure.
	 */
	private void handleSignUp() {
		String name = nameField.getText();
		String email = emailField.getText();
		String password = new String(passwordField.getPassword());

		boolean success = authController.signUp(email, password);

		if (success) {
			JOptionPane.showMessageDialog(this, "✅ Sign up successful! Please log in.");
			new LoginPageUI().setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "❌ Email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Entry point to run the sign-up page directly.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			SignUpPage signUpPage = new SignUpPage();
		});
	}
}
