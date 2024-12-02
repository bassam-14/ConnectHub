/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import contentcreation.Posts;
import contentcreation.Stories;
import java.util.ArrayList;

/**
 *
 * @author Zeina
 */
public class Profile {
    private String pfpPath;
    private String cpPath;
    private String bio;
    private String password;
    private int userId;
    private ArrayList<Posts> posts;
    private ArrayList<Stories> stories;

    public Profile(String pfpPath, String cpPath, String bio, String password, int userId,ArrayList<Posts> posts,ArrayList<Stories> stories) {
        this.pfpPath = pfpPath;
        this.cpPath = cpPath;
        this.bio = bio;
        this.password = password;
        this.userId = userId;
        this.posts=posts;
        this.stories=stories;
    }

    public String getPfpPath() {
        return pfpPath;
    }

    public ArrayList<Posts> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Posts> posts) {
        this.posts = posts;
    }

    public ArrayList<Stories> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Stories> stories) {
        this.stories = stories;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
