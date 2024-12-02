/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
/**
 *
 * @author bassam
 */
public class UserDatabase extends FileHandling<User> {
    private final List<User>users;
    public UserDatabase(){
        super("users.json",new TypeReference<List<User>>(){});
        users=readData();
    }
    public void addUser(User user){
        users.add(user);
        writeData(users);
    }
    public User findUser(String userId){
        for(User u:users){
            if(u.getUserId().equals(userId))
                return u;
        }
        return null;
    }
}