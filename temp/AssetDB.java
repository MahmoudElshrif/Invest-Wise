package db;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class AssetDB {
    private static final String FILE_PATH = "data/assets.json";
    private final Gson gson = new Gson();

    public void saveAsset(String assetDescription) {
        List<String> assets = readAssets();
        assets.add(assetDescription);
        writeAssets(assets);
    }

    public List<String> getAssets() {
        return readAssets();
    }

    private List<String> readAssets() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<String>>() {
            }.getType();
            List<String> assets = gson.fromJson(reader, type);
            return assets != null ? assets : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void writeAssets(List<String> assets) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(assets, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
