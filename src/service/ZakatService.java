package service;

import db.PortfolioDB;

import java.util.List;

/**
 * Provides logic to calculate zakat based on user assets.
 */
public class ZakatService {
    private final PortfolioDB portfolioDB = new PortfolioDB();
    private final double ZAKAT_RATE = 0.025;

    /**
     * Calculates the zakat amount owed by a user.
     *
     * @param userEmail the user's email
     * @return the zakat amount
     */
    public double calculateZakat(String userEmail) {
        List<String> assets = portfolioDB.getAssets(userEmail);
        double total = 0;

        for (String asset : assets) {
            // Expect format like: "Gold - 15000"
            String[] parts = asset.split(" - ");
            if (parts.length == 2) {
                try {
                    double value = Double.parseDouble(parts[1]);
                    total += value;
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Skipping invalid asset: " + asset);
                }
            }
        }

        double zakat = total * ZAKAT_RATE;
        System.out.println("📊 Total = " + total + ", Zakat = " + zakat);
        return zakat;
    }
}
