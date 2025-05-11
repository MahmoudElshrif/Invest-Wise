package db;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Handles saving and retrieving asset data from a JSON file.
 */
public class AssetDB {
    private static final String FILE_PATH = "data/assets.json";
    private final Gson gson = new Gson();

    /**
     * Saves a new asset to the database.
     *
     * @param assetDescription the description of the asset to save
     */
    public void saveAsset(String assetDescription) {
        List<String> assets = readAssets();
        assets.add(assetDescription);
        writeAssets(assets);
    }

    /**
     * Retrieves all saved assets.
     *
     * @return a list of asset descriptions
     */
    public List<String> getAssets() {
        return readAssets();
    }

    /**
     * Reads the list of assets from the JSON file.
     *
     * @return a list of asset descriptions
     */
    private List<String> readAssets() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<String>>() {}.getType();
            List<String> assets = gson.fromJson(reader, type);
            return assets != null ? assets : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Writes the given list of assets to the JSON file.
     *
     * @param assets the list of assets to write
     */
    private void writeAssets(List<String> assets) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(assets, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
