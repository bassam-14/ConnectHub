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
public class ProfileDatabase extends FileHandling<Profile> {
    private final List <Profile>profiles;
    public ProfileDatabase(){
         super("profiles.json",new TypeReference<List<Profile>>(){});
        profiles=readData();
    }
    public void addProfile(Profile profile){
        profiles.add(profile);
        writeData(profiles);
    }
}
