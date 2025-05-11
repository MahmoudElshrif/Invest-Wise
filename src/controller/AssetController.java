package controller;

import service.AssetService;

import java.util.List;

public class AssetController {
    private final AssetService assetService = new AssetService();

    public void addAsset(String userEmail, String assetName, double value) {
        assetService.addAsset(userEmail, assetName, value);
    }

    public List<String> viewAssets(String userEmail) {
        return assetService.getUserAssets(userEmail);
    }

    public void removeAsset(String userEmail, String asset) {
        assetService.removeAsset(userEmail, asset);
    }
}
