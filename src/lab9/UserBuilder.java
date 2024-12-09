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
public class UserBuilder {
private final User user;
    public UserBuilder(String email,String username,String password,LocalDate dateOfBirth) {
        user=new User(email,username,password,dateOfBirth);
        user.setUserId(UUID.randomUUID().toString());
        user.setProfile(new ProfileBuilder().build());
    }    
    public UserBuilder buildProfile(Profile profile){
        user.setProfile(profile);
        return this;
    }
        public UserBuilder buildStatus(String status){
        user.setStatus(status);
        return this;
    }
        public UserBuilder buildPfp(String pfp){
        user.getProfile().setPfpPath(pfp);
        return this;
    }
         public UserBuilder buildCp(String cp){
        user.getProfile().setCpPath(cp);
        return this;
    }
        public UserBuilder buildBio(String bio){
        user.getProfile().setBio(bio);
        return this;
    }
       
        public User build(){
            return user;
        }
    
}
