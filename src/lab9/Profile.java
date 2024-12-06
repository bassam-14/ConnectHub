/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

/**
 *
 * @author Zeina
 */
public class Profile {
    private String pfpPath="src/resources/default-avatar.png";
    private String cpPath="src/resources/default-ui-image-placeholder-wireframes-600nw-1037719192.jpg";
    private String bio="";
    public String getPfpPath() {
        return pfpPath;
    }

    public void setPfpPath(String pfpPath) {
        this.pfpPath = pfpPath;
    }

    public String getCpPath() {
        return cpPath;
    }

    public void setCpPath(String cpPath) {
        this.cpPath = cpPath;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }  
}