package controller;

import service.ZakatService;

/**
 * Controller class responsible for Zakat calculations.
 */
public class ZakatController {
    private final ZakatService zakatService = new ZakatService();

    /**
     * Calculates the Zakat amount for the specified user.
     *
     * @param userEmail the email of the user
     * @return the calculated Zakat amount
     */
    public double calculateZakat(String userEmail) {
        return zakatService.calculateZakat(userEmail);
    }
}
