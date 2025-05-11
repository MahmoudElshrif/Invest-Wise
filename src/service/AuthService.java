package service;

import db.UserDB;

/**
 * Provides authentication services for login and registration.
 */
public class AuthService {
    private UserDB userDB = new UserDB();

    /**
     * Validates user login credentials.
     *
     * @param email    the user's email
     * @param password the user's password
     * @return true if the credentials are correct, false otherwise
     */
    public boolean validateLogin(String email, String password) {
        return userDB.validateUser(email, password);
    }

    /**
     * Registers a new user if the email is not already taken.
     *
     * @param email    the user's email
     * @param password the user's password
     * @return true if registration is successful, false otherwise
     */
    public boolean registerUser(String email, String password) {
        return userDB.saveUser(email, password);
    }
}
