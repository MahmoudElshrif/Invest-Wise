package service;

import db.UserDB;

public class AuthService {
    private UserDB userDB = new UserDB();

    public boolean validateLogin(String email, String password) {
        return userDB.validateUser(email, password);
    }

    public boolean registerUser(String email, String password) {
        return userDB.saveUser(email, password);
    }
}