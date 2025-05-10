package controller;

import service.AuthService;

public class AuthController {
    private AuthService authService = new AuthService();

    public boolean login(String email, String password) {
        return authService.validateCredentials(email, password);
    }
}