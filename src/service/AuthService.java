package service;

import db.UserDB;

public class AuthService {
    private UserDB userDB = new UserDB();

    public boolean validateCredentials(String email, String password) {
        // TODO: add real validation
        return userDB.getUser(email) != null;
    }
}