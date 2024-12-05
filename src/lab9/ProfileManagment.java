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
    private final ContentDatabase contentDatabase=ContentDatabase.getInstance();

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
            contentDatabase.addRecord(post);
    }
    
    public void addStory(Stories story) {
            contentDatabase.addRecord(story);
    }
    
    public void removePost(Posts post) {
                 contentDatabase.deleteRecord(post);
    }
    
    public void removeStory(Stories story) {
                 contentDatabase.deleteRecord(story);
    }

}
