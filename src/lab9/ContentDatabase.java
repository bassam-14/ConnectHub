/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import contentcreation.*;
import java.util.ArrayList;

/**
 *
 * @author bassam
 */
public class ContentDatabase extends FileHandling<ContentCreation> {

    private final List<ContentCreation> contents;

    public ContentDatabase() {
        super("content.json", new TypeReference<List<ContentCreation>>() {
        });
        contents = readData();
    }

    public void addContent(ContentCreation content) {
        contents.add(content);
        writeData(contents);
    }

    public List<Stories> getActiveStories() {
        List<Stories> activeStories = new ArrayList<>();
        for (ContentCreation content : contents) {
            if (content instanceof Stories) {
                Stories story = (Stories) content;
                if (!story.isExpired()) {
                    activeStories.add(story);
                }
            }
        }
        return activeStories;
    }

    public List<Posts> getPosts() {
        List<Posts> postsList = new ArrayList<>();
        for (ContentCreation content : contents) {
            if (content instanceof Posts) {
                Posts post = (Posts) content;
                postsList.add(post);
            }
        }
        return postsList;
    }

    public void removeExpiredStories() {
        List<ContentCreation> updatedContents = new ArrayList<>();

        for (ContentCreation content : contents) {
            if (content instanceof Stories) {
                Stories story = (Stories) content;
                if (!story.isExpired()) {
                    updatedContents.add(story);
                }
            } else {
                updatedContents.add(content);
            }
        }
        contents.clear();
        contents.addAll(updatedContents);
        writeData(contents);
    }
}
