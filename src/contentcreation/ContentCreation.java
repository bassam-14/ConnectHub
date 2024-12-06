/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contentcreation;

import java.time.LocalDateTime;

/**
 *
 * @author mazen
 */
public abstract class ContentCreation {

    private static String id="0";
    private String contentId;
    private String authorId;
    private Content content;
    private final LocalDateTime createdtime;

    public ContentCreation(String authorId, Content content) {
        incrementString();
        contentId=id;
        this.authorId = authorId;
        this.content = content;
        this.createdtime = LocalDateTime.now();
    }
    private static void incrementString() {
        try {
            int num = Integer.parseInt(id);
            num++;
            id=Integer.toString(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The string is not a valid number", e);
        }
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
