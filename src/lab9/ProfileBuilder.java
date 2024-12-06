/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

/**
 *
 * @author bassam
 */
   public class ProfileBuilder {
    private final Profile profile;
    public ProfileBuilder(){
        profile=new Profile();
    }
    public ProfileBuilder buildPfp(String pfp){
        profile.setPfpPath(pfp);
        return this;
    }
    public ProfileBuilder buildCp(String cp){
        profile.setCpPath(cp);
        return this;
    }
    public ProfileBuilder buildBio(String bio){
        profile.setBio(bio);
        return this;
    }
    public Profile build(){
        return profile;
    }
}
