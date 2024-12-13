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
    private static UserDatabase instance;
    public UserDatabase(){
        super("users.json",new TypeReference<List<User>>(){});
    }
     public static UserDatabase getInstance(){
        if(instance==null)
            instance=new UserDatabase();
        return instance;
    }
    @Override
    public User getRecord(String userId){
        for(User u:records){
            if(u.getUserId().equals(userId))
                return u;
        }
        return null;
    }
    public User getRecordByEmail(String email){
        for(User u:records){
            if(u.getEmail().equals(email))
                return u;
        }
        return null;
    }
        public User getRecordByName(String name){
        for(User u:records){
            if(u.getUsername().equals(name))
                return u;
        }
        return null;
    }
}