package controller;

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
        return authService.registerUser(email, password);
    }
}
