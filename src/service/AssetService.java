package service;

import db.AssetDB;

public class AssetService {
    private AssetDB assetDB = new AssetDB();

    public void saveAsset(String name, double value) {
        // TODO: Save logic
        assetDB.store(name, value);
    }
}