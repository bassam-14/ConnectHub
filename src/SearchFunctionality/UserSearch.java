/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SearchFunctionality;

import java.util.ArrayList;
import java.util.List;
import lab9.User;
import lab9.UserDatabase;

/**
 *
 * @author mazen
 */
public class UserSearch {

    private static final UserDatabase userdata = UserDatabase.getInstance();

    public static ArrayList<User> search(String username, String currentname) {
        // Retrieve all user records from the database
        List<User> users = userdata.getAllRecords();

        // Result list to store matching users
        ArrayList<User> result = new ArrayList<>();

        // Loop through the list of users and match based on the search criteria exept the current username.
        for (User user : users) {
            if (!user.getUsername().equals(currentname) && user.getUsername().startsWith(username)) {
                result.add(user); // Add matching users to the result list
            }
        }

        // Return the list of matching users
        return result;
    }
}
