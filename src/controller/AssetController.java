package controller;

import service.AssetService;
import java.util.List;

/**
 * Controller class responsible for handling asset-related operations.
 */
public class AssetController {
    private final AssetService assetService = new AssetService();

    /**
     * Adds an asset for a specific user.
     *
     * @param userEmail the email of the user
     * @param assetName the name of the asset
     * @param value     the value of the asset
     */
    public void addAsset(String userEmail, String assetName, double value) {
        assetService.addAsset(userEmail, assetName, value);
    }

    /**
     * Retrieves the list of assets for a specific user.
     *
     * @param userEmail the email of the user
     * @return a list of asset descriptions
     */
    public List<String> viewAssets(String userEmail) {
        return assetService.getUserAssets(userEmail);
    }

    /**
     * Removes an asset from a user's portfolio.
     *
     * @param userEmail the email of the user
     * @param asset     the name of the asset to remove
     */
    public void removeAsset(String userEmail, String asset) {
        assetService.removeAsset(userEmail, asset);
    }
}
