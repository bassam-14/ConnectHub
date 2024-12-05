/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author belal
 */

public class AccountManagement {
   
    private final UserDatabase userDatabase;
    private static String userId="0";
    public static void incrementString() {
        try {
            int num = Integer.parseInt(userId);
            num++;
            userId=Integer.toString(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The string is not a valid number", e);
        }
    }
    public AccountManagement(){
        this.userDatabase = UserDatabase.getInstance();
    }
    public boolean signup(String email, String username, String password, LocalDate dateOfBirth){
        if(userDatabase.getRecordByEmail(email)!= null){
            return false;
        }
        incrementString();
        Profile defaultProfile = new Profile("default_pfp.jpg","default_cp.jpg","",new ArrayList<>());
               PasswordHash passhash=new PasswordHash();
               password=passhash.hashPassword(password);
        User user= new User( userId, email, username, password, dateOfBirth, "offline", defaultProfile);
        userDatabase.addRecord(user);
        return true;
    }
    public boolean login(String email, String password){
        User user = userDatabase.getRecordByEmail(email);
        if(user == null){
            return false;
        }
        PasswordHash passhash = new PasswordHash();
        String hashedPassword = passhash.hashPassword(password);
        if(!user.getPassword().equals(hashedPassword)){
            return false;
        }
        if("online".equals(user.getStatus())){
            return false;
        }
        user.setStatus("online");
        return true;
    }
    public boolean logout(User user){
        if(user == null || "offline".equals(user.getStatus())){
            return false;
        }
        user.setStatus("offline");
        userDatabase.saveData();
        return true;
    }
}
