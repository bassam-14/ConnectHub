/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SearchFunctionality;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import lab9.User;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mazen
 */
public class UserSearch {

    public static ArrayList<User> search(String username) {
        ArrayList<User> users = readUsers();
        ArrayList<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getUsername().startsWith(username)) {
                result.add(user);
            }
        }
        return result;
    }

    public static ArrayList<User> readUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            String json = new String(Files.readAllBytes(Paths.get("users.json")));
            JSONArray usersArray = new JSONArray(json);

            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject userJson = usersArray.getJSONObject(i);
                String email = userJson.getString("email");
                String name = userJson.getString("name");
                int id = userJson.getInt("userid");
                LocalDate dob = LocalDate.parse(userJson.getString("dob"), formatter);
                String password = userJson.getString("password");
                users.add());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
