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
    public UserDatabase(){
        super("users.json",new TypeReference<List<User>>(){});
    }
    @Override
    public User getRecord(String userId){
        for(User u:records){
            if(u.getUserId().equals(userId))
                return u;
        }
        return null;
    }
}