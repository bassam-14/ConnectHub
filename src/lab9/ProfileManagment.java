/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import contentcreation.Posts;
import contentcreation.Stories;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zeina
 */
public class ProfileManagment {

    private Map<Integer, Profile> profiles = new HashMap<>();

    public void updateBio(int userId, String newBio) {
        Profile profile = profiles.get(userId);
        if (profile != null) {
            profile.setBio(newBio);
            profiles.put(userId, profile);
        } else {
            throw new IllegalArgumentException("Profile not found for userId: " + userId);
        }
    }

    public void updatePfp(int userId, String newpfpPath) {
        Profile profile = profiles.get(userId);
        if (profile != null) {
            profile.setPfpPath(newpfpPath);
            profiles.put(userId, profile);
        } else {
            throw new IllegalArgumentException("Profile not found for userId: " + userId);
        }
    }

    public void updatecpPath(int userId, String newcpPath) {
        Profile profile = profiles.get(userId);
        if (profile != null) {
            profile.setPfpPath(newcpPath);
            profiles.put(userId, profile);
        } else {
            throw new IllegalArgumentException("Profile not found for userId: " + userId);
        }
    }

    public void addPost(int userId, Posts post) {
        Profile profile = profiles.get(userId);
        if (profile != null) {
            profile.getPosts().add(post);
            profiles.put(userId, profile);
        } else {
            throw new IllegalArgumentException("Profile not found for userId: " + userId);
        }
    }

    public void addStory(int userId, Stories story) {
        Profile profile = profiles.get(userId);
        if (profile != null) {
            profile.getStories().add(story);
            profiles.put(userId, profile);
        } else {
            throw new IllegalArgumentException("Profile not found for userId: " + userId);
        }
    }

    public void removePost(int userId, Posts post) {
        Profile profile = profiles.get(userId);
        if (profile != null) {
            for (int i = 0; i < profile.getPosts().size(); i++) {
                if (profile.getPosts().get(i).equals(post)) {
                    profile.getPosts().remove(post);
                }
            }
            profiles.put(userId, profile);
        } else {
            throw new IllegalArgumentException("Profile not found for userId: " + userId);
        }
    }

    public void removeStory(int userId, Stories story) {
        Profile profile = profiles.get(userId);
        if (profile != null) {
            for (int i = 0; i < profile.getStories().size(); i++) {
                if (profile.getStories().get(i).equals(story)) {
                    profile.getPosts().remove(story);
                }
            }
            profiles.put(userId, profile);
        } else {
            throw new IllegalArgumentException("Profile not found for userId: " + userId);
        }
    }
    public void updatePassword(int userId,String Password){
    Profile profile = profiles.get(userId);
        if (profile != null) {
            profile.setPassword(Password);
            profiles.put(userId, profile);
        } else {
            throw new IllegalArgumentException("Profile not found for userId: " + userId);
        }
    }

}
