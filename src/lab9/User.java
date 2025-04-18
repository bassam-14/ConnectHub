/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author bassam
 */
public class User {
    private String userId="";
    private String email;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private String status="offline";
    private Profile profile;
    private final List<String>blockedUsers=new ArrayList<>();
    

    public User() {
        userId=UUID.randomUUID().toString();
    }

    public User(String email, String username, String password, LocalDate dateOfBirth, Profile profile) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.profile = profile;
    }

    public User(String email,String username,String password,LocalDate dateOfBirth) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        
    }
    public List<String> getBlockedUsers() {
        return blockedUsers;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
