package service;

import db.AssetDB;
import db.PortfolioDB;

import java.util.List;

/**
 * Provides business logic for asset management, including
 * adding, viewing, and removing user assets.
 */
public class AssetService {
    private final AssetDB assetDB = new AssetDB();
    private final PortfolioDB portfolioDB = new PortfolioDB();

    /**
     * Adds an asset to both the global asset log and the user's portfolio.
     *
     * @param userEmail the email of the user
     * @param assetName the name of the asset
     * @param value     the value of the asset
     */
    public void addAsset(String userEmail, String assetName, double value) {
        String assetEntry = assetName + " - " + value;
        assetDB.saveAsset(assetEntry); // global asset log
        portfolioDB.addAsset(userEmail, assetEntry); // user-specific portfolio
        System.out.println("✅ Asset added for user: " + userEmail);
    }

    /**
     * Retrieves all assets for a specific user.
     *
     * @param userEmail the email of the user
     * @return a list of asset entries
     */
    public List<String> getUserAssets(String userEmail) {
        return portfolioDB.getAssets(userEmail);
    }

    /**
     * Removes an asset from a user's portfolio.
     *
     * @param userEmail the email of the user
     * @param asset     the asset to remove
     */
    public void removeAsset(String userEmail, String asset) {
        portfolioDB.removeAsset(userEmail, asset);
    }
}
