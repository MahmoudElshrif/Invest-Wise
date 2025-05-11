package DB;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Handles user's asset portfolio management using a JSON file.
 */
public class PortfolioDB {
    private static final String FILE_PATH = "data/portfolio.json";
    private final Gson gson = new Gson();

    /**
     * Adds an asset to a user's portfolio.
     *
     * @param userEmail the user's email
     * @param asset     the asset to add
     */
    public void addAsset(String userEmail, String asset) {
        Map<String, List<String>> portfolio = readPortfolio();
        portfolio.putIfAbsent(userEmail, new ArrayList<>());
        portfolio.get(userEmail).add(asset);
        writePortfolio(portfolio);
    }

    /**
     * Removes an asset from a user's portfolio.
     *
     * @param userEmail the user's email
     * @param asset     the asset to remove
     */
    public void removeAsset(String userEmail, String asset) {
        Map<String, List<String>> portfolio = readPortfolio();
        if (portfolio.containsKey(userEmail)) {
            List<String> assets = portfolio.get(userEmail);
            assets.remove(asset);
            if (assets.isEmpty()) {
                portfolio.remove(userEmail);
            } else {
                portfolio.put(userEmail, assets);
            }
            writePortfolio(portfolio);
        }
    }

    /**
     * Gets all assets associated with a user.
     *
     * @param userEmail the user's email
     * @return a list of asset names
     */
    public List<String> getAssets(String userEmail) {
        Map<String, List<String>> portfolio = readPortfolio();
        return portfolio.getOrDefault(userEmail, new ArrayList<>());
    }

    /**
     * Reads the portfolio data from the JSON file.
     *
     * @return a map of user emails to their asset lists
     */
    private Map<String, List<String>> readPortfolio() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<Map<String, List<String>>>() {}.getType();
            Map<String, List<String>> portfolio = gson.fromJson(reader, type);
            return portfolio != null ? portfolio : new HashMap<>();
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

    /**
     * Writes the portfolio data to the JSON file.
     *
     * @param portfolio the portfolio data to write
     */
    private void writePortfolio(Map<String, List<String>> portfolio) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(portfolio, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
