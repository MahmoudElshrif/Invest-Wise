package service;

import db.AssetDB;
import db.PortfolioDB;

import java.util.List;

public class AssetService {
    private final AssetDB assetDB = new AssetDB();
    private final PortfolioDB portfolioDB = new PortfolioDB();

    public void addAsset(String userEmail, String assetName, double value) {
        String assetEntry = assetName + " - " + value;
        assetDB.saveAsset(assetEntry); // global asset log
        portfolioDB.addAsset(userEmail, assetEntry); // user-specific portfolio
        System.out.println("✅ Asset added for user: " + userEmail);
    }

    public List<String> getUserAssets(String userEmail) {
        return portfolioDB.getAssets(userEmail);
    }

    public void removeAsset(String userEmail, String asset) {
        portfolioDB.removeAsset(userEmail, asset);
    }
}