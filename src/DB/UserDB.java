package db;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Manages user registration and authentication using a JSON file.
 */
public class UserDB {
    private static final String FILE_PATH = "data/users.json";
    private final Gson gson = new Gson();

    /**
     * Saves a new user if the email is not already registered.
     *
     * @param email    the user's email
     * @param password the user's password
     * @return true if the user is saved, false if email already exists
     */
    public boolean saveUser(String email, String password) {
        Map<String, String> users = readUsers();
        if (users.containsKey(email))
            return false;
        users.put(email, password);
        writeUsers(users);
        return true;
    }

    /**
     * Validates the login credentials for a user.
     *
     * @param email    the user's email
     * @param password the user's password
     * @return true if credentials match, false otherwise
     */
    public boolean validateUser(String email, String password) {
        Map<String, String> users = readUsers();
        return users.containsKey(email) && users.get(email).equals(password);
    }

    /**
     * Reads user data from the JSON file.
     *
     * @return a map of emails to passwords
     */
    private Map<String, String> readUsers() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            Map<String, String> users = gson.fromJson(reader, type);
            return users != null ? users : new HashMap<>();
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

    /**
     * Writes user data to the JSON file.
     *
     * @param users the user data to write
     */
    private void writeUsers(Map<String, String> users) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
