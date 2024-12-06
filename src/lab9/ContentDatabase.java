/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import contentcreation.*;

/**
 *
 * @author bassam
 */
public class ContentDatabase extends FileHandling<ContentCreation> {
    private static ContentDatabase instance;
    private ContentDatabase(){
       super("content.json",new TypeReference<List<ContentCreation>>(){});
    }
    public static ContentDatabase getInstance(){
        if(instance==null)
            instance=new ContentDatabase();
        return instance;
    }
    @Override
    public ContentCreation getRecord(String contentId){
    for(ContentCreation c:records){
        if(c.getContentId().equals(contentId))
            return c;
    }
    return null;
}
     public List<Stories> getActiveStories() {
        List<Stories> activeStories = new ArrayList<>();
        for (ContentCreation content :records) {
            if (content instanceof Stories story) {
                if (!story.isExpired()) {
                    activeStories.add(story);
                }
            }
        }
        return activeStories;
    }
    public List<Posts> getPosts() {
        List<Posts> postsList = new ArrayList<>();
        for (ContentCreation content :records) {
            if (content instanceof Posts post) {
                postsList.add(post);
            }
        }
        return postsList;
    }
    public List<ContentCreation> getRecordsByAuthor(String authorId){
      List<ContentCreation>content=new ArrayList<>();
        for(ContentCreation c:records){
        if(c.getAuthorId().equals(authorId))
            content.add(c);
    }
    return content;
    }
    public List<Posts> getPostsByAuthor(String authorId){
        List<Posts>posts=new ArrayList<>();
         for(ContentCreation c:records){
        if(c.getAuthorId().equals(authorId) && c instanceof Posts)
            posts.add((Posts)c);
    }
         return posts;
}
    public List<Stories> getStoriesByAuthor(String authorId){
        List<Stories>stories=new ArrayList<>();
         for(ContentCreation c:records){
        if(c.getAuthorId().equals(authorId) && c instanceof Stories)
            stories.add((Stories)c);
    }
         return stories;
}
}
