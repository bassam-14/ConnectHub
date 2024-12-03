/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import contentcreation.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zeina
 */
public class ProfileManagment {
    
    private User user;

    public ProfileManagment(Profile profile) {
        this.user = profile;
    }
    
    public void updateBio(String newBio) {
        user.setBio(newBio);
    }
    
    public void updatePfp(String newpfpPath) {
            user.setPfpPath(newpfpPath);
    }
    
    public void updatecpPath(String newcpPath) {
            user.setCpPath(newcpPath);
    }
    
    public void addPost(Posts post) {
            user.getContent().add(post);
    }
    
    public void addStory(Stories story) {
            user.getContent().add(story);
    }
    
    public void removePost(int userId, Posts post) {
                    user.getContent().remove(post);
    }
    
    public void removeStory(int userId, Stories story) {
                    user.getContent().remove(story);
    }

}
