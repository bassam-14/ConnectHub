/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import contentcreation.*;
import java.util.ArrayList;

/**
 *
 * @author Zeina
 */
public class Profile {
    private String pfpPath;
    private String cpPath;
    private String bio;

    public Profile(String pfpPath, String cpPath, String bio, ArrayList<ContentCreation> content) {
        this.pfpPath = pfpPath;
        this.cpPath = cpPath;
        this.bio = bio;
    }

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
