/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SearchFunctionality;

import java.util.ArrayList;
import java.util.List;
import lab9.*;

/**
 *
 * @author mazen
 */
public class GroupSearch {

    private static final GroupDatabase groupdata = GroupDatabase.getInstance();

    public static ArrayList<Group> grSearch(String groupname) {
        // Retrieve all group records from the database
        List<Group> groups = groupdata.getAllRecords();

        // Result list to store matching groups
        ArrayList<Group> result = new ArrayList<>();

        // Loop through the list of groups and match based on the search criteria.
        for (Group group : groups) {
            if (group.getName().startsWith(groupname)) {
                result.add(group); // Add matching groups to the result list
            }
        }

        return result;
    }
}
