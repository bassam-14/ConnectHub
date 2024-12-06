/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author belal
 */

public class AccountManagement {
   
    private final UserDatabase userDatabase;
    public AccountManagement(){
        this.userDatabase = UserDatabase.getInstance();
    }
    public boolean signup(String email, String username, String password, LocalDate dateOfBirth){
        if(userDatabase.getRecordByEmail(email)!= null){
            return false;
        }
        password=password.trim();
               PasswordHash passhash=new PasswordHash();
               password=passhash.hashPassword(password);
        userDatabase.addRecord(new UserBuilder(email,username,password,dateOfBirth).build());
        return true;
    }
    public boolean login(String email, String password){
        User user = userDatabase.getRecordByEmail(email);
        if(user == null){
            return false;
        }
        PasswordHash passhash = new PasswordHash();
        password=password.trim();
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
