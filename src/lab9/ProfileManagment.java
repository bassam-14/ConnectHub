/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import contentcreation.*;

/**
 *
 * @author Zeina
 */
public class ProfileManagment {
    
    private final User user;

    public ProfileManagment(User user) {
        this.user=user;
    }
    
    public void updateBio(String newBio) {
        user.getProfile().setBio(newBio);
    }
    
    public void updatePfp(String newpfpPath) {
            user.getProfile().setPfpPath(newpfpPath);
    }
    
    public void updatecpPath(String newcpPath) {
            user.getProfile().setCpPath(newcpPath);
    }
    
    public void addPost(Posts post) {
            user.getProfile().getContent().add(post);
    }
    
    public void addStory(Stories story) {
            user.getProfile().getContent().add(story);
    }
    
    public void removePost(int userId, Posts post) {
                    user.getProfile().getContent().remove(post);
    }
    
    public void removeStory(int userId, Stories story) {
                    user.getProfile().getContent().remove(story);
    }

}
