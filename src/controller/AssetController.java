package controller;

import service.AssetService;

public class AssetController {
    private AssetService assetService = new AssetService();

    public void addAsset(String name, double amount) {
        assetService.saveAsset(name, amount);
    }
}