package controller;

import javax.swing.JOptionPane;

import service.AuthService;

/**
 * Controller class responsible for user authentication operations.
 */
public class AuthController {
	private final AuthService authService = new AuthService();

	/**
	 * Validates user login credentials.
	 *
	 * @param email    the user's email
	 * @param password the user's password
	 * @return true if login is successful, false otherwise
	 */
	public boolean login(String email, String password) {
		return authService.validateLogin(email, password);
	}

	/**
	 * Registers a new user with the given credentials.
	 *
	 * @param email    the user's email
	 * @param password the user's password
	 * @return true if registration is successful, false otherwise
	 */
	public boolean signUp(String email, String password) {
		if (!validateCredentials(email, password)) {
			return false;
		}
		if (!authService.registerUser(email, password)) {
			JOptionPane.showMessageDialog(null, "❌ Email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean validateCredentials(String email, String password) {
		if (email == null || password == null) {
			JOptionPane.showMessageDialog(null, "❌ Email or password cannot be empty", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!email.endsWith("@gmail.com")) {
			JOptionPane.showMessageDialog(null, "❌ Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (password.length() < 6) {
			JOptionPane.showMessageDialog(null, "❌ Password must be at least 6 characters long", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}
}
