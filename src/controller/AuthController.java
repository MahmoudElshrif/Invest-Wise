package controller;

import service.AuthService;

public class AuthController {
    private final AuthService authService = new AuthService();

    public boolean login(String email, String password) {
        return authService.validateLogin(email, password);
    }

    public boolean signUp(String email, String password) {
        return authService.registerUser(email, password);
    }
}