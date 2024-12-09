/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contentcreation;

import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author mazen
 */
public abstract class ContentCreation {

    private String contentId;
    private String authorId;
    private Content content;
    private final LocalDateTime createdtime;

    public ContentCreation() {
        createdtime=LocalDateTime.now();
    }

    public ContentCreation(String authorId, Content content) {
        contentId=UUID.randomUUID().toString();
        this.authorId = authorId;
        this.content = content;
        this.createdtime = LocalDateTime.now();
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
    public abstract boolean isExpired();
}
