package db;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class UserDB {
    private static final String FILE_PATH = "data/users.json";
    private final Gson gson = new Gson();

    public boolean saveUser(String email, String password) {
        Map<String, String> users = readUsers();
        if (users.containsKey(email))
            return false;
        users.put(email, password);
        writeUsers(users);
        return true;
    }

    public boolean validateUser(String email, String password) {
        Map<String, String> users = readUsers();
        return users.containsKey(email) && users.get(email).equals(password);
    }

    private Map<String, String> readUsers() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            Map<String, String> users = gson.fromJson(reader, type);
            return users != null ? users : new HashMap<>();
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

    private void writeUsers(Map<String, String> users) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
