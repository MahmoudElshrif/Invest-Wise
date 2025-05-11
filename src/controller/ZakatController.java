package controller;

import service.ZakatService;

public class ZakatController {
    private final ZakatService zakatService = new ZakatService();

    public double calculateZakat(String userEmail) {
        return zakatService.calculateZakat(userEmail);
    }
}
