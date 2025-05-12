package UI;

import controller.AuthController;
import model.Investor;

import javax.swing.*;
import java.awt.*;

/**
 * UI for user login using a Swing JFrame.
 */
public class LoginPageUI extends JFrame {
	private JTextField emailField;
	private JPasswordField passwordField;
	private final AuthController authController = new AuthController();

	/**
	 * Constructs the login page and initializes its components.
	 */
	public LoginPageUI() {
		setTitle("Wealth Wise - Login");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new BorderLayout());
		JPanel formPanel = new JPanel(new GridLayout(4, 1, 10, 10));

		// Logo
		JLabel logoLabel = new JLabel();
		ImageIcon logoIcon = new ImageIcon("assets/logo.png");
		Image scaledImage = logoIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		logoLabel.setIcon(new ImageIcon(scaledImage));
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(logoLabel, BorderLayout.NORTH);

		// Fields
		emailField = new JTextField();
		passwordField = new JPasswordField();

		formPanel.add(new JLabel("Email:"));
		formPanel.add(emailField);
		formPanel.add(new JLabel("Password:"));
		formPanel.add(passwordField);

		// Buttons
		JPanel buttonPanel = new JPanel(new FlowLayout());
		JButton loginButton = new JButton("Login");
		JButton goToSignUpButton = new JButton("Go to Sign Up");

		buttonPanel.add(loginButton);
		buttonPanel.add(goToSignUpButton);

		panel.add(formPanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		add(panel);

		// Listeners
		loginButton.addActionListener(e -> handleLogin());
		goToSignUpButton.addActionListener(e -> {
			dispose();
			new SignUpPage().setVisible(true);
		});
	}

	/**
	 * Handles the login button click and validates user credentials.
	 * On success, opens the Dashboard UI for the investor.
	 */
	private void handleLogin() {
		String email = emailField.getText();
		String password = new String(passwordField.getPassword());

		boolean success = authController.login(email, password);

		if (success) {
			JOptionPane.showMessageDialog(this, "✅ Login successful!");
			dispose();
			Investor investor = new Investor("User", email, password); // You may load name dynamically
			investor.openDashboard();
		} else {
			JOptionPane.showMessageDialog(this, "❌ Invalid credentials.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
